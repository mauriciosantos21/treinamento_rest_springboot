package br.ufc.trainning1.publishers;

import org.springframework.stereotype.Service;

/**
 * Created by Mauricio Oliveira on 19/07/2017.
 */

@Service
public class PublisherService {
    private PublisherRepository repository;

    public Iterable<Publisher> findAll(){
        return repository.findAll();
    }

    public Publisher findOne(Integer id){
        return repository.findOne(id);
    }

    public void save(Publisher publisher){
        repository.save(publisher);
    }

    public void update(Publisher publisher){
        repository.save(publisher);
    }

    public void delete(Publisher publisher){
        repository.delete(publisher);
    }

}
