package com.mycompany.proiectfacultate;

public class NewUser extends User {
    private String parola;
    
    public NewUser(String nume,String pozitie,String email, String parola) {
        super(nume, pozitie, email);
        this.parola = parola;
    }
    
    public String getNume() {
        return super.nume;
    }
    
    public String getPozitie() {
        return super.pozitie;
    }
        
    public String getEmail() {
        return super.email;
    }
            
    public String getParola() {
        return this.parola;
    }
    
    @Override
    public String toString() {
        return "<html>Date utilizator logat: <br/>Nume: "+this.nume+"<br/>Pozitie: "+ this.pozitie +"<br/>Email: " + this.email;
    }
}
