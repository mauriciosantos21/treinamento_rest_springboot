package br.ufc.trainning1.pubs;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mauricio Oliveira on 18/07/2017.
 */

@Repository
public interface PubRepository extends CrudRepository<Pub, Integer>{



}
