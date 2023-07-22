package com.example.ShoppingService.model;

public class Book {

    private String nom;
    private long isbn;


    public Book(String nom, long isbn) {
        this.nom = nom;
        this.isbn = isbn;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
}
