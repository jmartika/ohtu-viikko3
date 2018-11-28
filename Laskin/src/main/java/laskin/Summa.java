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
public class Summa implements Komento {
    private Sovelluslogiikka sovellus;
    private int laskunTulos;
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private int arvo;
    
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
        this.nollaa = nollaa;
        this.undo = undo;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;


    }
    
    
    @Override
    public void suorita() {
        
        this.arvo = Integer.parseInt(this.syotekentta.getText());
        this.sovellus.plus(this.arvo);
        this.laskunTulos = this.sovellus.tulos();
    
        this.syotekentta.setText("");
        this.tuloskentta.setText("" + this.laskunTulos);
        
        if ( this.laskunTulos==0) {
            this.nollaa.disableProperty().set(true);
        } else {
            this.nollaa.disableProperty().set(false);
        }

        
    }
    @Override
    public void peru() {
 
    }
}
