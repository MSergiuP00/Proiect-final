package com.mycompany.proiectfacultate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator implements IInputValidator  {
    private static InputValidator single_instance = null;
    private String erori;
    private InputValidator()
    {
    erori = "<html>";
    }
    
    private void setErori(String eroare) {
        erori = erori + eroare + "<br/>";
    }
    
    @Override
    public String getErori() {
        return erori;
    }
    
    @Override
    public boolean hasErori() {
        return !"<html>".equals(erori);
    }
    
    @Override
    public void cleanErori() {
        erori = "<html>";
    }
    
    public void validateName(String name) {
        if(name == null || name.isEmpty()) setErori("Campul pentru nume este obligatoriu");
    }
    
    public void validatePozitie(String pozitie) {
        if(pozitie == null || pozitie.isEmpty()) setErori("Campul pentru pozitie este obligatoriu");
    }
    
    public void validateEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()) setErori("Campul pentru email este invalid");
    }
    
    public void validateAgreement(boolean agreement) {
        if(!agreement) setErori("Este obligatoriu sa acceptati termenii si conditiile");
    }
    
        public void validateParola(String parola, String confirmParola) {
        if(parola == null || parola.isEmpty())setErori("Campul pentru parola este obligatoriu");
        if(!parola.equals(confirmParola)) setErori("Parolele nu coincid");
    }
 
    // Static method
    // Static method to create instance of Singleton class
    public static InputValidator getInstance()
    {
        if (single_instance == null)
            single_instance = new InputValidator();
 
        return single_instance;
    }
}
