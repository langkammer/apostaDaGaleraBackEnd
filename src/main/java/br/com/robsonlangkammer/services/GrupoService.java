package br.com.robsonlangkammer.services;

import br.com.robsonlangkammer.bean.ResultResponseList;
import br.com.robsonlangkammer.model.CriterioModel;
import br.com.robsonlangkammer.model.GruposModel;
import br.com.robsonlangkammer.model.MembroGruposModel;
import br.com.robsonlangkammer.repository.CriterioRepository;
import br.com.robsonlangkammer.repository.GrupoRepository;
import br.com.robsonlangkammer.repository.MembroGrupoRepository;
import br.com.robsonlangkammer.repository.VinculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class GrupoService {

    @Autowired
    GrupoRepository repository;
    @Autowired
    CriterioRepository criterioRepository;
    @Autowired
    MembroGrupoRepository membroGrupoRepository;
    @Autowired
    VinculoRepository vinculoRepository;

    public ResultResponseList search(int page, int size, String campo) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC,  "nome");
        ResultResponseList resultResponseList = new ResultResponseList();

        Page<GruposModel>  listPage = repository.findByNomeContaining(campo, pageRequest);

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

    public Page<GruposModel> findAll() {
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


    public GruposModel salvarGrupo(GruposModel g){

        if(g.getCriterioPrincipal()!=null){
            CriterioModel c1 =  criterioRepository.save(g.getCriterioPrincipal());
            g.setCriterioPrincipal(c1);
        }
        if(g.getCriterioSecundario()!=null){
            CriterioModel c2 =  criterioRepository.save(g.getCriterioSecundario());
            g.setCriterioSecundario(c2);
        }

        return  repository.saveAndFlush(g);
    }

    public Boolean entrarNoGrupo(Long id,String email){
        if(id!=null && email !=null){
            MembroGruposModel m = membroGrupoRepository.findByGrupoIdAndVinculoEmail(id,email);
            if(m!=null){
                return true;
            }
            else{
                MembroGruposModel membroGruposModel = new MembroGruposModel();
                membroGruposModel.setDataEntrada(new Date());
                Optional<GruposModel> g = repository.findById(id);
                membroGruposModel.setGrupo(g.get());
                membroGruposModel.setVinculo(vinculoRepository.findByEmail(email));
                membroGrupoRepository.saveAndFlush(membroGruposModel);
                return true;
            }
        }
        return false;

    }

    public Boolean sairDoGrupo(MembroGruposModel g){
        if(g!=null){
           membroGrupoRepository.delete(g);
            return true;
        }
        return false;
    }

    public MembroGruposModel getMembroGrupo(Long id,String email){
        if(id!=null && email !=null){
            MembroGruposModel m = membroGrupoRepository.findByGrupoIdAndVinculoEmail(id,email);
            if(m!=null){
                return m;
            }
            else{
              return null;
            }
        }
        return null;
    }

    public ResultResponseList getMembrosGrupoBy(int page, int size, Long idGrupo){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC,  "vinculo.nome");
        ResultResponseList resultResponseList = new ResultResponseList();

        Page<MembroGruposModel>  listPage = membroGrupoRepository.findByGrupoId(idGrupo, pageRequest);

        if(idGrupo!=null){
            resultResponseList.setTotalElements(membroGrupoRepository.count());
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

}
