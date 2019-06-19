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

import java.util.List;

@Service
public class LigaService {

    @Autowired
    LigaRepository repository;

    public ResultResponseList search(int page,int size) {
        PageRequest pageRequest = PageRequest.of(page,size);

        List<LigasModel> list = repository.search(pageRequest);

        ResultResponseList resultResponseList = new ResultResponseList();

        resultResponseList.setTotal(pageRequest.getPageSize());

        resultResponseList.setData(list);

        return resultResponseList;
    }

    public Page<LigasModel> findAll() {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
            page,
            size,
            Sort.Direction.ASC);

        return new PageImpl<>(
            repository.findAll(),
            pageRequest, size);
    }

}
