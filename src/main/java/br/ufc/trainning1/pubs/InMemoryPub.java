package br.ufc.trainning1.pubs;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mauricio Oliveira on 18/07/2017.
 */
@Component
public class InMemoryPub implements PubRepository {

    private static  final List<Pub> PUBS = new ArrayList<>();

    @Override
    public Iterable<Pub> findAll() {
        return Collections.unmodifiableList(PUBS);
    }

    @Override
    public void save(Pub pub) {
        PUBS.add(pub);
    }



    @Override
    public void delete(Pub pub) {
        PUBS.remove(pub);
    }

    @Override
    public Pub findOnde(Integer id) {
        return PUBS.get(id-1);
    }
}
