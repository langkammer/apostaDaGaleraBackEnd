package br.com.robsonlangkammer.bean;

/**
 * Created by robson on 04/07/19.
 */
public class TimeBean {

    private String nomeAbrev;
    private String nomeCompleto;
    private String escudoPathString;
    private String sigla;

    public String getNomeAbrev() {
        return nomeAbrev;
    }

    public void setNomeAbrev(String nomeAbrev) {
        this.nomeAbrev = nomeAbrev;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEscudoPathString() {
        return escudoPathString;
    }

    public void setEscudoPathString(String escudoPathString) {
        this.escudoPathString = escudoPathString;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
