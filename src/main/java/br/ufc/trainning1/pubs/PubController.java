package br.ufc.trainning1.pubs;

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
@RequestMapping("/pubs")
public class PubController {

    private static final Logger logger = LoggerFactory.getLogger(PubController.class);

    @Autowired
    public PubRepository repository;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Pub>> queryPubAll(){
        return ResponseEntity.ok(repository.findAll());
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Pub> createPub(@RequestBody Pub pub) throws MalformedURLException, URISyntaxException {
        repository.save(pub);

        URL createURL = new URL("http://localhost:8080/publishers/"+pub.getId().toString());
        return ResponseEntity.created(createURL.toURI()).build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Pub> queryPub(@PathVariable Integer id){
        Pub pubFounded = repository.findOne(id);
        return ResponseEntity.ok(pubFounded);

    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removePub(@PathVariable Integer id){
        logger.info("Nao foi possivel deletar a publisher com id: {}", id);
        Pub pubToDelete = repository.findOne(id);
        if(pubToDelete == null){
            logger.info("Nao foi possivel deletar nenhuma publicacao com o id {}", id);

            return new ResponseEntity<Pub>(HttpStatus.NOT_FOUND);
        }


        logger.info("Publicacao removida"+ pubToDelete.getTitulo());
        repository.delete(pubToDelete);

        return new ResponseEntity<Pub>(HttpStatus.NO_CONTENT);

    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePub(@PathVariable Integer id, @RequestBody Pub pub){
        logger.info("ATUALIZANDO PUBLICACAO COM O ID" + id);

        logger.info("DADOS PARA ATUALIZAR A PUBLICACAO" + pub.getTitulo() + " " +
                pub.getTitulo() + " " + pub.getId());

        Pub pubToUpdate = repository.findOne(id);


        if(pubToUpdate == null) {
            logger.info("NAO FOI ENCONTRADO NENHUMA PUBLICACAO COM O ID" + id);

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.delete(repository.findOne(id));

        pubToUpdate.setId(pub.getId());
        pubToUpdate.setTitulo(pub.getTitulo());
        pubToUpdate.setAuthor(pub.getAuthor());
        pubToUpdate.setTipo(pub.getTipo());


        repository.save(pubToUpdate);

        logger.info("DADOS ATUALIZADOS" + pubToUpdate.getTitulo() + " " +
                pubToUpdate.getTitulo() + " " + pubToUpdate.getId());

        return new ResponseEntity<Pub>(pubToUpdate, HttpStatus.OK);
    }

}
