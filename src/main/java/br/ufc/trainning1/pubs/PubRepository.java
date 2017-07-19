package br.ufc.trainning1.pubs;

/**
 * Created by Mauricio Oliveira on 18/07/2017.
 */
public interface PubRepository {

    Iterable<Pub> findAll();
    void save(Pub pub);
    void delete(Pub pub);
    Pub findOne(Integer id);

}
