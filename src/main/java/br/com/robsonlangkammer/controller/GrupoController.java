package br.com.robsonlangkammer.controller;

import br.com.robsonlangkammer.bean.EvenlopResponse;
import br.com.robsonlangkammer.bean.LigaByGrupoAndRodadaBean;
import br.com.robsonlangkammer.bean.MembroBean;
import br.com.robsonlangkammer.bean.ResultResponseList;
import br.com.robsonlangkammer.model.GruposModel;
import br.com.robsonlangkammer.model.MembroGruposModel;
import br.com.robsonlangkammer.repository.GrupoRepository;
import br.com.robsonlangkammer.services.GrupoService;
import br.com.robsonlangkammer.services.LigaService;
import br.com.robsonlangkammer.util.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class GrupoController extends ResponseFactory {


    @Autowired
    GrupoService service;


    private final GrupoRepository grupoRepository;

    GrupoController(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;

    }

    @GetMapping(path = "/grupo/list")
    public EvenlopResponse search(
        @RequestParam(value = "page", required = false, defaultValue = "0") int page,
        @RequestParam(value = "size", required = false, defaultValue = "10") int size,
        @RequestParam(value = "nome", required = false, defaultValue = "") String nome){

        try{
            ResultResponseList r = service.search(page, size,nome);

            return returnEnvelopSucessoList(r.getData(), r.getTotalPages(), r.getTotalElements(), "Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }

    @PostMapping(path = "/grupo/create")
    public EvenlopResponse save(@RequestBody GruposModel g){
        try{
            return returnEnvelopSucesso(service.salvarGrupo(g),"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }

    @GetMapping(path = "/grupo/getById")
    public EvenlopResponse save(@RequestParam long idGrupo){
        try{
            return returnEnvelopSucesso(grupoRepository.findById(idGrupo),"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }

    @DeleteMapping(path = "/grupo/delete")
    public EvenlopResponse delete(@RequestBody GruposModel g){
        try{
            grupoRepository.delete(g);
            return returnEnvelopSucesso("","Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }

    @PostMapping(path = "/grupo/entrarNoGrupo")
    public EvenlopResponse entrarNoGrupo(@RequestBody MembroBean m){
        try{
            return returnEnvelopSucesso(service.entrarNoGrupo(m.getId(),m.getEmail()),"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }

    @PostMapping(path = "/grupo/sairNoGrupo")
    public EvenlopResponse sairNoGrupo(@RequestBody MembroGruposModel g){
        try{
            return returnEnvelopSucesso(service.sairDoGrupo(g),"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }

    @PostMapping(path = "/grupo/getMembroGrupo")
    public EvenlopResponse getMembroGrupo(@RequestBody MembroBean m){
        try{
            return returnEnvelopSucesso(service.getMembroGrupo(m.getId(), m.getEmail()),"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }

    @GetMapping(path = "/grupo/getMembrosGrupoBy")
    public EvenlopResponse getMembrosGrupoBy(
        @RequestParam(value = "page", required = false, defaultValue = "0") int page,
        @RequestParam(value = "size", required = false, defaultValue = "10") int size,
        @RequestParam(value = "idGrupo", required = false, defaultValue = "") Long idGrupo){
        try{
            ResultResponseList r = service.getMembrosGrupoBy(page, size,idGrupo);
            return returnEnvelopSucessoList(r.getData(), r.getTotalPages(), r.getTotalElements(), "Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }


//    @PostMapping(path = "/grupo/grupoByRodada")
//    public EvenlopResponse grupoByRodada(@RequestBody LigaByGrupoAndRodadaBean rodada){
//        try{
//            grupoRepository.delete(liga);
//            return returnEnvelopSucesso("","Operação Realizada com Sucesso");
//        }
//        catch (Exception e){
//            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());
//
//        }
//    }

}
