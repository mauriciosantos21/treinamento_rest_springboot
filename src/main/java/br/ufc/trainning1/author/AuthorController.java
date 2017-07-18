package br.ufc.trainning1.author;

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
@RequestMapping("/authors")
public class AuthorController {

    public static final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private AuthorRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Author>> queryAllAuthors(){
        return ResponseEntity.ok(repository.findAll());
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createAuthor(@RequestBody Author author) throws MalformedURLException, URISyntaxException {
        repository.save(author);

        URL createdURL = new URL("http://localhost:8080/authors/" + author.getId().toString());

        return ResponseEntity
                .created(createdURL.toURI())
                .build();
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Author> queryAuthor(@PathVariable Integer id){

        Author authorFounded = repository.findOne(id);

        return ResponseEntity.ok(authorFounded);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeAuthor(@PathVariable Integer id) {
        logger.info("Pegando e deletando o author com id {}", id);

        Author authorToRemove = repository.findOne(id);

        if(authorToRemove == null){
            logger.info("Nao foi possivel deletar algum autor com o id {}", id);

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        logger.info("Vou remover o autor: " + authorToRemove.getFirstName());
        repository.delete(authorToRemove);

        return new ResponseEntity<Author>(HttpStatus.NO_CONTENT);

    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAuthor(@PathVariable Integer id, @RequestBody Author author){
        logger.info("ATUALIZANDO AUTOR COM O ID" + id);

        logger.info("DADOS PARA ATUALIZAR O AUTOR" + author.getFirstName() + " " +
                author.getLastName() + " " + author.getId());

        Author authorToUpdate = repository.findOne(id);


        if(authorToUpdate == null) {
            logger.info("NAO FOI ENCONTRADO NENHUM AUTOR COM O ID" + id);

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.delete(repository.findOne(id));

        authorToUpdate.setId(author.getId());
        authorToUpdate.setFirstName(author.getFirstName());
        authorToUpdate.setLastName(author.getLastName());

        repository.save(authorToUpdate);

        logger.info("DADOS ATUALIZADOS" + authorToUpdate.getFirstName() + " " +
                authorToUpdate.getLastName() + " " + authorToUpdate.getId());

        return new ResponseEntity<Author>(authorToUpdate, HttpStatus.OK);

    }


}
