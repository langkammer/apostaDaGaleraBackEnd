package br.com.robsonlangkammer.services;

import br.com.robsonlangkammer.bean.TimeBean;
import br.com.robsonlangkammer.model.TimeFutebolModel;
import br.com.robsonlangkammer.repository.TimeFutebolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TimeFutebolService {

    @Autowired
    TimeFutebolRepository repository;


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
