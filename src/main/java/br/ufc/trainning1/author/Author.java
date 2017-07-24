package br.ufc.trainning1.author;

import br.ufc.trainning1.publication.Publication;
import com.fasterxml.jackson.annotation.JsonIgnore;


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

    private String email;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private Collection<Publication> publications;

    public Author(){

    }

    public Author(String firstName, String lastName, String email, Collection<Publication> publications) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.publications = publications;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Publication> getPublications() {
        return publications;
    }

    public void setPublications(Collection<Publication> publications) {
        this.publications = publications;
    }
}

