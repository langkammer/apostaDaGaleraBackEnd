package br.com.robsonlangkammer.controller;

import br.com.robsonlangkammer.bean.EvenlopResponse;
import br.com.robsonlangkammer.bean.ResultResponseList;
import br.com.robsonlangkammer.model.TimeFutebolModel;
import br.com.robsonlangkammer.repository.TimeFutebolRepository;
import br.com.robsonlangkammer.services.TimeFutebolService;
import br.com.robsonlangkammer.util.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin("*")
public class EquipeController extends ResponseFactory {


    @Autowired
    TimeFutebolService service;

    private final TimeFutebolRepository repository;

    EquipeController(TimeFutebolRepository repository) {
        this.repository = repository;

    }

    @GetMapping(path = "equipe/list")
    public EvenlopResponse list(
        @RequestParam(value = "page", required = false, defaultValue = "0") int page,
        @RequestParam(value = "size", required = false, defaultValue = "10") int size,
        @RequestParam(value = "nome", required = false, defaultValue = "") String nome){
        try{
            ResultResponseList r = service.search(page, size,nome);

            return returnEnvelopSucessoList(r.getData(),r.getTotalPages(),r.getTotalElements(),"Operação Realizada com Sucesso");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a Operaçãp " + e.getMessage());

        }
    }



    @PostMapping(path = "equipe/create")
    public EvenlopResponse create(@RequestBody @Valid TimeFutebolModel time){
        try{
            return returnEnvelopSucesso(repository.save(time),"Operação Realizada com sucesso!");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a operacao " + e.getMessage());

        }

    }

    @PostMapping(path = "equipe/delete")
    public EvenlopResponse delete(@RequestBody TimeFutebolModel time){
        try{
            repository.delete(time);
            return returnEnvelopSucesso(null,"Operação Realizada com sucesso!");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a operacao " + e.getMessage());

        }

    }






}
