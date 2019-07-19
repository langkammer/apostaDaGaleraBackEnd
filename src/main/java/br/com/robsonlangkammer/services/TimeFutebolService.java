package br.com.robsonlangkammer.services;

import br.com.robsonlangkammer.bean.ResultResponseList;
import br.com.robsonlangkammer.bean.TimeBean;
import br.com.robsonlangkammer.model.LigasModel;
import br.com.robsonlangkammer.model.TimeFutebolModel;
import br.com.robsonlangkammer.repository.TimeFutebolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TimeFutebolService {

    @Autowired
    TimeFutebolRepository repository;

    public ResultResponseList search(int page, int size, String campo) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC,  "nomeCompleto");
        ResultResponseList resultResponseList = new ResultResponseList();

        Page<TimeFutebolModel> listPage = repository.findByNomeCompletoContaining(campo, pageRequest);

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

    public List<TimeFutebolModel> createOrFindTimesModel(List<TimeBean> times){

        List<TimeFutebolModel> list = new ArrayList<TimeFutebolModel>();

        times.forEach(timeBean -> {
            TimeFutebolModel time = repository.findBySigla(timeBean.getSigla());
            if(time!=null)
                list.add(time);
            else
                list.add(repository.save(new TimeFutebolModel(timeBean)));
        });

        return list;
    }


}
