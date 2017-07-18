package br.ufc.trainning1.author;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Component
public class InMemoryAuthorRepository implements AuthorRepository{

    private static final List<Author> AUTHORS  = new ArrayList<>();

    static{
        AUTHORS.addAll(Arrays.asList(
           new Author(1,"Glauco","Aquino"),
           new Author(2,"Joao","Santana")
        ));
    }

    public Iterable<Author> findAll(){
        return Collections.unmodifiableList(AUTHORS);
    }

    public void save(Author author){
        AUTHORS.add(author);
    }

    public void delete(Author author) {
        AUTHORS.remove(author);
    }


    public Author findOne(Integer id) {
        return AUTHORS.get(id-1);
    }


}
