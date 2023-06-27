package com.example.opt3v10;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    StoelenData stoelenData = new StoelenData();
    List<Gebruiker> gebruikers = new ArrayList<>();
    @FXML
    private Button registreer;

    @FXML
    private TextField gebruiker;

    @FXML
    private Button lijst;

    @FXML
    private MenuButton voorkeur;

    @FXML
    private Button aantal;

    @FXML
    private TextField aantalStoelen;

    private StoelVoorkeur voorkeurGebruiker = StoelVoorkeur.ALTIJD;

    public void registreerGebruiker(String gebruikersnaam, StoelVoorkeur voorkeur) {
        Gebruiker nieuweGebruiker;
        if (voorkeur == StoelVoorkeur.ALTIJD) {
            nieuweGebruiker = new AltijdMeldenGebruiker(gebruikersnaam);
        } else {
            nieuweGebruiker = new BereikMeldenGebruiker(gebruikersnaam);
        }

        if (gebruikers.contains(nieuweGebruiker)) {
            System.out.println("Gebruiker bestaat al!");
            return;
        }

        if (gebruikersnaam == null || gebruikersnaam.isEmpty()) {
            System.out.println("Gebruikersnaam mag niet leeg zijn!");
            return;
        }

        gebruikers.add(nieuweGebruiker);
        stoelenData.registreerWaarnemer(nieuweGebruiker);
        stoelenData.setBeschikbareStoelen(stoelenData.getBeschikbareStoelen() -1);
        nieuweGebruiker.registreer(); // Gebruiker registreren
        gebruiker.clear();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Registreer een gebruiker

        registreer.setOnAction(e -> {
            registreerGebruiker(gebruiker.getText(), voorkeurGebruiker);
        });

        lijst.setOnAction(e -> {
            GebruikerTable gebruikerTable = new GebruikerTable(new Stage(), gebruikers, stoelenData);
        });

        voorkeur.getItems().get(0).setOnAction(e -> {
            voorkeurGebruiker = StoelVoorkeur.ALTIJD;
            voorkeur.setText("Altijd");
        });

        voorkeur.getItems().get(1).setOnAction(e -> {
            voorkeurGebruiker = StoelVoorkeur.BEREIK;
            voorkeur.setText("Bereik");
        });

        aantal.setOnAction(e -> {
            stoelenData.setBeschikbareStoelen(Integer.parseInt(aantalStoelen.getText()));
        });

    }
}
