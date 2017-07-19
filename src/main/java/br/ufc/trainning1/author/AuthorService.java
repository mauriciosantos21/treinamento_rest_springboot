package br.ufc.trainning1.author;

import org.springframework.stereotype.Service;

/**
 * Created by Mauricio Oliveira on 19/07/2017.
 */


@Service
public class AuthorService{

    private AuthorRepository repository;

    public Iterable<Author> findALL(){
        return repository.findAll();
    }

    public Author findOne(Integer id){
        return repository.findOne(id);
    }


    public void save(Author author){
        repository.save(author);
    }

    public void update(Author author){
        repository.save(author);
    }

    public void delete(Author author){
        repository.delete(author);
    }


}
