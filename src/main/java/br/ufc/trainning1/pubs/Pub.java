package br.ufc.trainning1.pubs;

import br.ufc.trainning1.author.Author;
import br.ufc.trainning1.publishers.Publisher;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mauricio Oliveira on 18/07/2017.
 */

@Entity
public class Pub {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date pubDate;

    public Pub(){

    }

    public Pub(String title, Author author, Publisher publisher, Date pubDate) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pubDate = pubDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
}
