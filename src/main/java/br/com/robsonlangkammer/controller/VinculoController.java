package br.com.robsonlangkammer.controller;

import br.com.robsonlangkammer.bean.EvenlopResponse;
import br.com.robsonlangkammer.bean.ResultResponseList;
import br.com.robsonlangkammer.dao.VinculoDao;
import br.com.robsonlangkammer.model.VinculosModel;
import br.com.robsonlangkammer.repository.VinculoRepository;
import br.com.robsonlangkammer.services.LigaService;
import br.com.robsonlangkammer.services.VinculoService;
import br.com.robsonlangkammer.util.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin("*")
public class VinculoController extends ResponseFactory {

    @Autowired
    VinculoService service;

    private final VinculoRepository vinculoRepository;

    private final VinculoDao vinculoDao;

    VinculoController(VinculoRepository vinculoRepository,VinculoDao vinculoDao) {
        this.vinculoRepository = vinculoRepository;
        this.vinculoDao = vinculoDao;

    }

    @GetMapping(path = "user/list")
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



    @PostMapping(path = "user/create")
    public EvenlopResponse create(@Valid @RequestBody VinculosModel vinculo){
        try{
            vinculo.setPermissaoAdmin(false);
            return returnEnvelopSucesso(vinculoDao.salvarVincuo(vinculo),"Operação Realizada com sucesso!");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a operacao " + e.getMessage());

        }

    }

    @PostMapping(path = "user/getUserByAuthID")
    public EvenlopResponse getUserByAuthID(@RequestBody String uid){
        try{
            return returnEnvelopSucesso(vinculoDao.getUserByUid(uid),"Operação Realizada com sucesso!");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a operacao " + e.getMessage());

        }

    }

    @PostMapping(path = "user/getUserByEmail")
    public EvenlopResponse getUserByEmail(@RequestBody String uid){
        try{
            return returnEnvelopSucesso(vinculoDao.getUserByUid(uid),"Operação Realizada com sucesso!");
        }
        catch (Exception e){
            return returnEnvelopError("Erro ao realizar a operacao " + e.getMessage());

        }

    }





}
