/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author juliamar
 */
public class Erotus implements Komento {
    
    private Sovelluslogiikka sovellus;
    private int arvo;
    private int laskunTulos;
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Edelliset edellinen;

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
        this.nollaa = nollaa;
        this.undo = undo;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;


  


    }
    
    @Override
    public void suorita() {
        
        try {
            this.arvo = Integer.parseInt(this.syotekentta.getText());
        } catch (Exception e) {
        }

        this.sovellus.miinus(this.arvo);
        this.edellinen = new Edelliset(this.arvo);
        
        this.laskunTulos = this.sovellus.tulos();
    
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + this.laskunTulos);
        if ( this.laskunTulos==0) {
            this.nollaa.disableProperty().set(true);
        } else {
            this.nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }
    
     @Override
    public void peru() {
        this.laskunTulos = sovellus.tulos()+this.edellinen.getEdellinen();
        this.sovellus.setTulos(this.laskunTulos);
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + this.laskunTulos);
        if ( this.laskunTulos==0) {
            this.nollaa.disableProperty().set(true);
        } else {
            this.nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(true);
    }
    
}
