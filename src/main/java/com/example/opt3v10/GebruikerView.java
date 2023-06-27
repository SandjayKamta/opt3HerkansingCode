package com.example.opt3v10;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.List;

public class GebruikerView implements Waarnemer {

    private Gebruiker gebruiker;
    private Stage stage;

    private StoelenData stoelenData;

    Label aantalStoelen;

    public GebruikerView(Stage stage, Gebruiker gebruiker, StoelenData stoelenData) {
        this.stage = stage;
        this.gebruiker = gebruiker;
        this.stoelenData = stoelenData;
        show();
    }


    public void show() {
        BorderPane root = new BorderPane();
        GridPane gridPane = new GridPane();

        Label naamLabel = new Label("Naam: " + gebruiker.getNaam());
        aantalStoelen = new Label("Aantal stoelen: " + stoelenData.getBeschikbareStoelen());

        stoelenData.registreerWaarnemer(this);

//        Waarnemer waarnemer = StoelenData.waarnemers.get(gebruiker.gebruikerId);


        root.setBottom(gridPane);
        root.setCenter(naamLabel);
        root.setBottom(aantalStoelen);
        Scene scene = new Scene(root, 500, 350);
        stage.setTitle(gebruiker.getNaam());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void update(int beschikbareStoelen) {

        if (gebruiker.moetMelden(beschikbareStoelen)) {
            aantalStoelen.setText("Aantal stoelen: " + beschikbareStoelen);
        } else {
            aantalStoelen.setText("Er zijn geen beschikbare stoelen meer");
        }
    }
}
