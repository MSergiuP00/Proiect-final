package com.mycompany.proiectfacultate;

public abstract class User {
    protected String nume;
    protected String pozitie;
    protected String email;
    
    public User(String nume,String pozitie,String email) {
        this.nume = nume;
        this.pozitie = pozitie;
        this.email = email;
    }
}
