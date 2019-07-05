package br.com.robsonlangkammer.services;

import br.com.robsonlangkammer.bean.ResultResponseList;
import br.com.robsonlangkammer.model.GruposModel;
import br.com.robsonlangkammer.model.LigasModel;
import br.com.robsonlangkammer.repository.GrupoRepository;
import br.com.robsonlangkammer.repository.LigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GrupoService {

    @Autowired
    GrupoRepository repository;

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

}
