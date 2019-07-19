package br.com.robsonlangkammer.controller;

import br.com.robsonlangkammer.bean.*;
import br.com.robsonlangkammer.model.LigasModel;
import br.com.robsonlangkammer.repository.LigaRepository;
import br.com.robsonlangkammer.services.LigaService;
import br.com.robsonlangkammer.util.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        @RequestParam(value = "size", required = false, defaultValue = "10") int size,
        @RequestParam(value = "nome", required = false, defaultValue = "") String nome) {

        try{
            ResultResponseList r = service.search(page, size,nome);
            return returnEnvelopSucessoList(r.getData(),r.getTotalPages(),r.getTotalElements(),"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operação " + e.getMessage());

        }

    }

    @GetMapping("/liga/listAtiva")
    public EvenlopResponse listAtiva() {

        List<LigasModel> ligasAtivas = ligaRepository.findByStatus(true);

        return returnEnvelopSucesso(ligasAtivas, "Operação Realizada com Sucesso");
    }

    @GetMapping("/liga/all")
    public EvenlopResponse getAll() {
        return returnEnvelopSucesso(service.findAll(),"Operação Realizada com Sucesso");
    }

    @PostMapping(path = "/liga/create")
    public EvenlopResponse save(@RequestBody LigaBean liga){
        try{
            return returnEnvelopSucesso(service.salvarLiga(liga),"Operação Realizada com Sucesso");

        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operação " + e.getMessage());

        }
    }


    @PostMapping(path = "/liga/delete")
    public EvenlopResponse delete(@RequestBody LigasModel liga){
        try{
            ligaRepository.delete(liga);
            return returnEnvelopSucesso("","Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }


    @GetMapping(path = "/liga/getByID")
    public EvenlopResponse getByID(@RequestParam  Long id){
        try{

            return returnEnvelopSucesso(service.carregaligaBeanById(id),"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }



}
