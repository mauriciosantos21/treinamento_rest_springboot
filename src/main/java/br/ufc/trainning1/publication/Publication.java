package br.ufc.trainning1.publication;

import br.ufc.trainning1.author.Author;
import br.ufc.trainning1.publishers.Publisher;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mauricio Oliveira on 18/07/2017.
 */

@Entity
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;

    @Enumerated(EnumType.STRING)
    private PublicationType publicationType;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date pubDate;

    public Publication(){

    }

    public Publication(String title, Author author, Publisher publisher, PublicationType publicationType, Date pubDate) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationType = publicationType;
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

    public PublicationType getPublicationType() {
        return publicationType;
    }

    public void setPublicationType(PublicationType publicationType) {
        this.publicationType = publicationType;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
}
