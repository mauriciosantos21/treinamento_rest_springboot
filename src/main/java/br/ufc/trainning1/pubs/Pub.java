package br.ufc.trainning1.pubs;

import br.ufc.trainning1.author.Author;

/**
 * Created by Mauricio Oliveira on 18/07/2017.
 */
public class Pub {

    private Integer id;


    private String titulo;
    private String author;
    private Integer tipo;

    public Pub(){

    }
    public Pub(String titulo, String author, Integer tipo) {
        this.titulo = titulo;
        this.author = author;
        this.tipo = tipo;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
