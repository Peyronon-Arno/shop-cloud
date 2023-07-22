package com.example.StockService.controler;

import com.example.StockService.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/stock")
public class StockServiceControlleur {


    /**
     * Équivalent à un getOne
     *
     * @param id = isbn du livre demandé
     */
    @GetMapping(value = "/{id}")
    public void bookReq(@PathVariable String id) {
        // Stockage en bdd a gerer
        // return bdd.getBook(id);

    }

    @GetMapping(value = "/get")
    public void getStockReq() {

    }
}
