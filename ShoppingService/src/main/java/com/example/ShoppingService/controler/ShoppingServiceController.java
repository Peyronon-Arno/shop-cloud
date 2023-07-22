package com.example.ShoppingService.controler;

import com.example.ShoppingService.Configuration;
import com.example.ShoppingService.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController(value = "/")
public class ShoppingServiceController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Va être l'équivalent du getOne
     *
     * @param isbn du livre demandé par le client
     * @return le livre demandé par le client
     */
    @GetMapping(value = "/get/{isbn}")
    public Book bookReq(@PathVariable("isbn") long isbn) {
        // Rest template va faire une requête avec id l'isbn du livre
        return restTemplate.getForObject(Configuration.URL_STOCK_SERVICE + "/{id}", Book.class, isbn);
    }

    /**
     * @param nbBookAsked nombre de livres demandé
     * @param name        nom du livre demandé
     * @return la nouvelle liste de livres updated grâce au whole saler
     */
    @GetMapping(value = "/get/buyBook")
    public List<Book> buyReq(int nbBookAsked, String name) {
        List<Book> books = new ArrayList<>();
        try {
            ResponseEntity<List<Book>> responseEntity = restTemplate.exchange(Configuration.URL_WHOLE_SALER_SERVICE, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
            }, name, nbBookAsked);
            books = responseEntity.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return books;
    }
}
