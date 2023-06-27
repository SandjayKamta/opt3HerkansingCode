package com.example.opt3v10;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// Klasse Gebruiker implementeert de Waarnemer interface
abstract class Gebruiker implements Waarnemer {
    private String naam;
    private int aantalStoelen;

    public Gebruiker(String naam) {
        this.naam = naam;
        aantalGebruikers++;
        gebruikerId = aantalGebruikers;
    }

    public int gebruikerId;
    private static int aantalGebruikers = 0;

    public void registreer() {
        valideer();
        voerVoorkeurenUit();
        voerRegistratieUit();
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public int getAantalStoelen() {
        return aantalStoelen;
    }

    protected abstract void valideer();

    protected abstract void voerVoorkeurenUit();

    protected abstract void voerRegistratieUit();

    @Override
    public void update(int beschikbareStoelen) {
        this.aantalStoelen = beschikbareStoelen;

        if (moetMelden(beschikbareStoelen)) {
            System.out.println(naam + ": Aantal beschikbare stoelen gewijzigd naar " + aantalStoelen);
        }
    }

    protected abstract boolean moetMelden(int beschikbareStoelen);

    public StringProperty naamProperty() {
        return new SimpleStringProperty(naam);
    }
}
