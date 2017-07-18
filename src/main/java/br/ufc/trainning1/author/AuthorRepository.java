package br.ufc.trainning1.author;

/**
 * Created by Mauricio Oliveira on 17/07/2017.
 */
public interface AuthorRepository {

    Iterable<Author> findAll();
    void save(Author author);
    void delete(Author author);
    Author findOne(Integer id);

}
