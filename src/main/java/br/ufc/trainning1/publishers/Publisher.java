package br.ufc.trainning1.publishers;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.ufc.trainning1.pubs.Pub;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;



    @OneToMany(mappedBy = "publisher")
    @JsonIgnore
    private Collection<Pub> pubs;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    public Publisher(String name, Collection<Pub> pubs, Date createdAt) {
        this.name = name;
        this.pubs = pubs;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Pub> getPubs() {
        return pubs;
    }

    public void setPubs(Collection<Pub> pubs) {
        this.pubs = pubs;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
