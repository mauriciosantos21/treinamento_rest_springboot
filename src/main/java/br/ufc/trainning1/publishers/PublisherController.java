package br.ufc.trainning1.publishers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Mauricio Oliveira on 18/07/2017.
 */

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private static final Logger logger = LoggerFactory.getLogger(PublisherController.class);


    @Autowired
    public PublisherRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Publisher>> queryAllPublishers(){
        return ResponseEntity.ok(repository.findAll());
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher) throws MalformedURLException, URISyntaxException{
        repository.save(publisher);

        URL createURL = new URL("http://localhost:8080/publishers/"+publisher.getId().toString());
        return ResponseEntity.created(createURL.toURI()).build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Publisher> queryPublisher(@PathVariable Integer id){
        Publisher publisherFounded = repository.findOne(id);
        return ResponseEntity.ok(publisherFounded);

    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removePublisher(@PathVariable Integer id){
        logger.info("Nao foi possivel deletar a publisher com id: {}", id);
        Publisher publisherToDelete = repository.findOne(id);
        if(publisherToDelete == null){
            logger.info("Nao foi possivel deletar algum autor com o id {}", id);

            return new ResponseEntity<Publisher>(HttpStatus.NOT_FOUND);
        }


        logger.info("Publisher removida"+ publisherToDelete.getNome());
        repository.delete(publisherToDelete);

        return new ResponseEntity<Publisher>(HttpStatus.NO_CONTENT);

    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePublisher(@PathVariable Integer id, @RequestBody Publisher publisher){
        logger.info("ATUALIZANDO PUBLICACAO COM O ID" + id);

        logger.info("DADOS PARA ATUALIZAR A PUBLICACAO" + publisher.getNome() + " " +
                publisher.getNome() + " " + publisher.getId());

        Publisher publisherToUpdate = repository.findOne(id);


        if(publisherToUpdate == null) {
            logger.info("NAO FOI ENCONTRADO NENHUMA PUBLICACAO COM O ID" + id);

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.delete(repository.findOne(id));

        publisherToUpdate.setId(publisher.getId());
        publisherToUpdate.setNome(publisher.getNome());
        publisherToUpdate.setAnoFundacao(publisher.getAnoFundacao());

        repository.save(publisherToUpdate);

        logger.info("DADOS ATUALIZADOS" + publisherToUpdate.getNome() + " " +
                publisherToUpdate.getNome() + " " + publisherToUpdate.getId());

        return new ResponseEntity<Publisher>(publisherToUpdate, HttpStatus.OK);
    }


}