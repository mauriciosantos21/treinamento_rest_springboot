package br.ufc.trainning1.pubs;

import org.springframework.stereotype.Service;

/**
 * Created by Mauricio Oliveira on 19/07/2017.
 */

@Service
public class PubService {
    private PubRepository repository;


    public Iterable<Pub> findAll(){
        return repository.findAll();
    }

    public Pub findOne(Integer id){
        return repository.findOne(id);
    }

    public void save(Pub pub){
        repository.save(pub);
    }

    public void update(Pub pub){
        repository.save(pub);
    }

    public void delete(Pub pub){
        repository.delete(pub);
    }
}


