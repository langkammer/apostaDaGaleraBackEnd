package br.com.robsonlangkammer.services;

import br.com.robsonlangkammer.bean.ResultResponseList;
import br.com.robsonlangkammer.model.LigasModel;
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

    public ResultResponseList search(String campo,  int page,   int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC,  "nome");
        ResultResponseList resultResponseList = new ResultResponseList();

        resultResponseList.setTotal(repository.count());

        Page<LigasModel>  listPage = repository.search(campo.toLowerCase(), pageRequest).getContent()

        if(repository.search(campo.toLowerCase(), pageRequest).getContent()!=null)
            resultResponseList.setData((List<Object>) (List) listPage.getContent());

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

}
