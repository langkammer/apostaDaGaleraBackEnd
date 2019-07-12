package br.com.robsonlangkammer.util;

import br.com.robsonlangkammer.bean.EvenlopResponse;
import br.com.robsonlangkammer.enums.StatusResponseEnum;

public class ResponseFactory  {

    public EvenlopResponse returnEnvelopSucesso(Object o,String msg){
        return new EvenlopResponse(StatusResponseEnum.SUCESSO,msg,o);
    }

    public EvenlopResponse returnEnvelopSucessoList(Object o,long totalPages,long totalElements,String msg){
        return new EvenlopResponse(StatusResponseEnum.SUCESSO,totalPages,totalElements,msg,o);
    }

    public EvenlopResponse returnEnvelopError(String msg){
        return new EvenlopResponse(StatusResponseEnum.ERRO,msg);
    }

}
