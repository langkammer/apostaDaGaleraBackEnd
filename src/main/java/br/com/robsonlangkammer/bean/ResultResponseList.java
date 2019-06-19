package br.com.robsonlangkammer.bean;

import java.util.List;

/**
 * Created by robson on 19/06/19.
 */
public class ResultResponseList {
    private List<Object> data;

    private int total;
    public ResultResponseList() {

    }
    public ResultResponseList(List<Object> data, int total) {
        this.data = data;
        this.total = total;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
