package br.ufc.trainning1.author;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;


/**
 * Created by Mauricio Oliveira on 17/07/2017.
 */

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorRepository repository;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Author>> queryAllAuthors(){
        return ResponseEntity.ok(repository.findAll());
    }

    @RequestMapping(method  = RequestMethod.POST)
    public ResponseEntity<Void> createAuthor(@RequestBody Author author) throws MalformedURLException, URISyntaxException{
        repository.save(author);
        URL createURL = new URL("http://localhost:8080/authors/" + author.getId().toString());

        return ResponseEntity.created(createURL.toURI()).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Author> queryAuthor(@PathVariable Integer id){
        Author authorFounder = repository.findOne(id);
        return ResponseEntity.ok(authorFounder);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Author> deleteAuthor(@PathVariable Integer id){
        Author authorToRemove = repository.findOne(id);
        if(authorToRemove!=null){
            repository.delete(authorToRemove.getId());
            return new ResponseEntity<Author>(HttpStatus.OK);
        }
        else return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
    }


}
