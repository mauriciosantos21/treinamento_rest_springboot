package br.ufc.trainning1.author;

import br.ufc.trainning1.pubs.Pub;


import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Mauricio Oliveira on 18/07/2017.
 */


@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "author")
    private Collection<Pub> pubs;

    public Author(){

    }

    public Author(String firstName, String lastName, Collection<Pub> pubs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pubs = pubs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

