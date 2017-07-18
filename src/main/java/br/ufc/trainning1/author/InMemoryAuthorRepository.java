package br.ufc.trainning1.author;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


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


    public void update(Author author) {
        for (Author a : AUTHORS) {
            if(a.getId()==author.getId()){
                a.setFirstName(author.getFirstName());
                a.setLastName(author.getLastName());
            }
        }
    }


    public void delete(Integer id) {
        AUTHORS.remove(id);
    }


    public Author findOne(Integer id) {
        return AUTHORS.get(id-1);
    }


}
