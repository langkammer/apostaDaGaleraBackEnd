package br.com.robsonlangkammer.services;

import br.com.robsonlangkammer.bean.LigaBean;
import br.com.robsonlangkammer.bean.ResultResponseList;
import br.com.robsonlangkammer.model.*;
import br.com.robsonlangkammer.repository.GrupoRepository;
import br.com.robsonlangkammer.repository.LigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LigaService {

    @Autowired
    LigaRepository repository;
    @Autowired
    GrupoRepository grupoRepository;
    @Autowired
    TimeFutebolService timeFutebolService;
    @Autowired
    RodadaService rodadaService;

    public ResultResponseList search(int page, int size, String campo) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC,  "tipoLiga");
        ResultResponseList resultResponseList = new ResultResponseList();

        Page<LigasModel>  listPage = repository.findByTipoLigaContaining(campo, pageRequest);

        if(campo.isEmpty()){
            resultResponseList.setTotalElements(repository.count());
            resultResponseList.setTotalPages(listPage.getTotalPages());
        }
        else{
            resultResponseList.setTotalElements(listPage.getTotalElements());
            resultResponseList.setTotalPages(listPage.getTotalPages());

        }

        if(listPage.getContent()!=null)
            resultResponseList.setData((List<Object>) (List) listPage.getContent());
        else
            resultResponseList.setData(null);

        return resultResponseList;
    }

    public Page<LigasModel> findAll() {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
            page,
            size,
            Sort.Direction.ASC,
            "nome");
        return new PageImpl<>(
            repository.findAll(),
            pageRequest, size);
    }


    public LigasModel salvarLiga(LigaBean liga){
        if(liga.getTipoLiga().equals("BRASILEIRAO"))
          return   criaLigaBrasileirao(liga);
        else if(liga.getTipoLiga() == "COPA_BRASIL")
          return   criaLigaCopaBrasil(liga);

        return null;
    }

    public LigasModel criaLigaBrasileirao(LigaBean liga){

        LigasModel ligasModel = new LigasModel(liga);

        ligasModel.setQtdRodadas(liga.getQtdRodadas());
        ligasModel.setRodadaAtual(liga.getRodadaAtual());
        ligasModel.setFormatoLiga("TABELA");
        ligasModel.setStatus(true);
        List<TimeFutebolModel> times = timeFutebolService.createOrFindTimesModel(liga.getTimes());
        ligasModel.setTimes(times);
        List<RodadaModel> rodada = rodadaService.criaRodadas(liga.getRodadas());
        ligasModel.setRodadas(rodada);

        repository.saveAndFlush(ligasModel);

        return repository.save(ligasModel);
    }

    public LigasModel criaLigaCopaBrasil(LigaBean liga){
        LigasModel ligasModel = new LigasModel(liga);

        ligasModel.setQtdRodadas(8);
        ligasModel.setFormatoLiga("MATA-MATA");
        ligasModel.setStatus(true);
        List<TimeFutebolModel> times = timeFutebolService.createOrFindTimesModel(liga.getTimes());
        ligasModel.setTimes(times);

        repository.saveAndFlush(ligasModel);

        return repository.save(ligasModel);

    }



    public LigaBean  carregarResultados(Long idGrupo, Integer rodada){
        LigaBean ligaBean = new LigaBean();
        GruposModel g = grupoRepository.findById(idGrupo).get();
        if(g!=null){
            LigasModel l =  repository.getLigaByRodada(g.getLigaModel().getId(), rodada);
            ligaBean = new LigaBean(l);

        }
        return ligaBean;
    }


    public LigaBean  carregaligaBeanById(Long idLiga){
        LigasModel l = repository.findById(idLiga).get();
        LigaBean ligaBean = new LigaBean();
        if(l!=null)
            ligaBean = new LigaBean(l);
        return ligaBean;
    }


}
