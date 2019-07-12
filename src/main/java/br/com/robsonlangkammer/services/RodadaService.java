package br.com.robsonlangkammer.services;

import br.com.robsonlangkammer.bean.RodadaBean;
import br.com.robsonlangkammer.model.PartidaModel;
import br.com.robsonlangkammer.model.RodadaModel;
import br.com.robsonlangkammer.repository.PartidaRepository;
import br.com.robsonlangkammer.repository.TimeFutebolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class RodadaService {

    @Autowired
    PartidaRepository repository;
    @Autowired
    PartidasService partidasService;

    public List<RodadaModel> criaRodadas(List<RodadaBean> rodadas){

        List<RodadaModel> list = new ArrayList<RodadaModel>();

        rodadas.forEach(rodadaBean -> {
            List<PartidaModel> pList = partidasService.createOrFindPartidasModel(rodadaBean.getPartidas());
            RodadaModel rodadaModel = new RodadaModel();
            rodadaModel.setPartidas(pList);
            rodadaModel.setRodada(rodadaBean.getRodada());
            list.add(rodadaModel);
        });

        return list;
    }


}
