package br.com.robsonlangkammer.controller;

import br.com.robsonlangkammer.bean.EvenlopResponse;
import br.com.robsonlangkammer.bean.ResultResponseList;
import br.com.robsonlangkammer.model.GruposModel;
import br.com.robsonlangkammer.model.LigasModel;
import br.com.robsonlangkammer.repository.GrupoRepository;
import br.com.robsonlangkammer.repository.LigaRepository;
import br.com.robsonlangkammer.services.LigaService;
import br.com.robsonlangkammer.util.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class LigaController extends ResponseFactory {

    @Autowired
    LigaService service;

    private final LigaRepository ligaRepository;

    LigaController(LigaRepository ligaRepository) {
        this.ligaRepository = ligaRepository;

    }

    @GetMapping("/liga/list")
    public EvenlopResponse search(
        @RequestParam(value = "page", required = false, defaultValue = "0") int page,
        @RequestParam(value = "size", required = false, defaultValue = "10") int size) {

        ResultResponseList r = service.search(page, size);

        return returnEnvelopSucessoList(r.getData(),r.getTotal(),"Operação Realizada com Sucesso");


    }

    @GetMapping("/liga/all")
    public EvenlopResponse getAll() {
        return returnEnvelopSucesso(service.findAll(),"Operação Realizada com Sucesso");
    }

    @PostMapping(path = "/liga/create")
    public EvenlopResponse save(@RequestBody LigasModel liga){
        try{
            return returnEnvelopSucesso(ligaRepository.save(liga),"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }


    @DeleteMapping(path = "/liga/delete")
    public EvenlopResponse delete(@RequestBody LigasModel liga){
        try{
            ligaRepository.delete(liga);
            return returnEnvelopSucesso("","Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }

}
