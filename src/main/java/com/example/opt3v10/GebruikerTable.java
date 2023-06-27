package com.example.opt3v10;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GebruikerTable  {

    private TableView<Gebruiker> tableView;
    private ObservableList<Gebruiker> tableData = FXCollections.observableArrayList();

    private final Stage stage;
    private final List<Gebruiker> gebruikers;

    private StoelenData stoelenData;

    public GebruikerTable(Stage stage, List<Gebruiker> gebruikers, StoelenData stoelenData) {
        this.stage = stage;
        this.gebruikers = gebruikers;
        this.stoelenData = stoelenData;
        show();
    }

    public void show() {
        BorderPane root = new BorderPane();
        GridPane gridPane = new GridPane();

        tableView = new TableView<>();
        tableData = tableView.getItems();

        tableView.columnResizePolicyProperty().set(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Gebruiker, String> naamGebruiker = new TableColumn<>("Gebuikers");
        naamGebruiker.setCellValueFactory(data -> data.getValue().naamProperty());

        Platform.runLater(() -> {
            tableView.getColumns().addAll(naamGebruiker);
        });

        tableView.setOnMouseClicked(e -> {
            Gebruiker user = tableView.getSelectionModel().getSelectedItem();
            if (user == null) return;
            GebruikerView gebruikerView = new GebruikerView(new Stage(), user, stoelenData);
        });

        getData();

        root.setBottom(gridPane);

        root.setCenter(tableView);
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }


    public void getData(){
        tableData.clear();
        for(Gebruiker gebruiker : gebruikers) {
            tableData.add(gebruiker);
        }
    }
}
