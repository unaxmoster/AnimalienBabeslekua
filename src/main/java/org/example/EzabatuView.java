package org.example;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class EzabatuView extends VBox {

    public EzabatuView(Babeslekua babeslekua, Runnable onAnimaliaEzabatuta) {
        super(10);
        this.setPadding(new Insets(20));

        Label titulo = new Label("EZABATU ANIMALIA");
        TextField izena = new TextField();
        izena.setPromptText("Animaliaren izena");

        Button ezabatu = new Button("EZABATU");
        ezabatu.setOnAction(e -> {
            if (!izena.getText().isEmpty()) {
                babeslekua.ezabatuAnimalia(izena.getText());
                onAnimaliaEzabatuta.run();
            }
        });

        this.getChildren().addAll(titulo, izena, ezabatu);
    }
}