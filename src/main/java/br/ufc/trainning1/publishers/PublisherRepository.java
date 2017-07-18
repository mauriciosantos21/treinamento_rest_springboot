package br.ufc.trainning1.publishers;

/**
 * Created by Mauricio Oliveira on 18/07/2017.
 */
public interface PublisherRepository {

    Iterable<Publisher> findAll();
    void save(Publisher publisher);
    void delete(Publisher publisher);
    Publisher findOne(Integer id);
}
