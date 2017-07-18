package br.ufc.trainning1.publishers;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mauricio Oliveira on 18/07/2017.
 */

@Component
public class InMemoryPublisherRepository implements PublisherRepository {

    private  static  final List<Publisher> PUBLISHERS =  new ArrayList<>();

    static{
        PUBLISHERS.addAll(Arrays.asList(
                new Publisher(1,"Globo",1972),
                new  Publisher(1, "Abril", 1999)
        ));
    }

    @Override
    public Iterable<Publisher> findAll() {
        return Collections.unmodifiableList(PUBLISHERS);
    }

    @Override
    public void save(Publisher publisher) {
        PUBLISHERS.add(publisher);
    }



    @Override
    public void delete(Publisher publisher) {
        PUBLISHERS.remove(publisher);
    }

    @Override
    public Publisher findOne(Integer id) {
        return PUBLISHERS.get(id-1);
    }
}
