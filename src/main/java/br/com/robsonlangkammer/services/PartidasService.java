package br.com.robsonlangkammer.services;

import br.com.robsonlangkammer.bean.PartidaBean;
import br.com.robsonlangkammer.model.PartidaModel;
import br.com.robsonlangkammer.model.TimeFutebolModel;
import br.com.robsonlangkammer.repository.PartidaRepository;
import br.com.robsonlangkammer.repository.TimeFutebolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PartidasService {

    @Autowired
    PartidaRepository repository;
    @Autowired
    TimeFutebolRepository timeFutebolRepository;

    public List<PartidaModel> createOrFindPartidasModel(List<PartidaBean> partidas){

        List<PartidaModel> list = new ArrayList<PartidaModel>();

        partidas.forEach(partidaBean -> {
            TimeFutebolModel time1 = new TimeFutebolModel();
            TimeFutebolModel time2 = new TimeFutebolModel();

            if(partidaBean.getTime1()!=null)
                time1 = timeFutebolRepository.findBySigla(partidaBean.getTime1().getSigla());
            if(partidaBean.getTime2()!=null)
                time2 = timeFutebolRepository.findBySigla(partidaBean.getTime2().getSigla());

            list.add(repository.save(new PartidaModel(partidaBean,time1, time2)));
        });

        return list;
    }


}
