package br.com.robsonlangkammer.controller;

import br.com.robsonlangkammer.bean.EvenlopResponse;
import br.com.robsonlangkammer.bean.ResultResponseList;
import br.com.robsonlangkammer.model.GruposModel;
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
            return returnEnvelopSucesso(grupoRepository.save(g),"Operação Realizada com Sucesso");
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

}
