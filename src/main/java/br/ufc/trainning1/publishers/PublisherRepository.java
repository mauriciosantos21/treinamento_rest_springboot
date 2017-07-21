package br.ufc.trainning1.publishers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mauricio Oliveira on 18/07/2017.
 */

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Integer> {


}
