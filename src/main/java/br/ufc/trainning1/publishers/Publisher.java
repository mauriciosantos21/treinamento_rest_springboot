package br.ufc.trainning1.publishers;

/**
 * Created by Mauricio Oliveira on 18/07/2017.
 */
public class Publisher {

    private Integer id;
    private String nome;
    private Integer anoFundacao;

    public Publisher(){

    }

    public Publisher(Integer id, String nome, Integer anoFundacao) {
        this.id = id;
        this.nome = nome;
        this.anoFundacao = anoFundacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(Integer anoFundacao) {
        this.anoFundacao = anoFundacao;
    }
}
