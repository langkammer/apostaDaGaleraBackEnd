package br.com.robsonlangkammer.bean;

import java.util.List;

/**
 * Created by robson on 19/06/19.
 */
public class ResultResponseList {
    private List<Object> data;

    private long total;
    public ResultResponseList() {

    }
    public ResultResponseList(List<Object> data, long total) {
        this.data = data;
        this.total = total;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
