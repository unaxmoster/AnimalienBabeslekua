
package org.example.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.controller.AnimaliaController;

public class GUI {

    private AnimaliaController controller;
    private VBox contenido;

    public void erakutsi(Stage stage) {
        controller = new AnimaliaController();

        Label titulua = new Label("ANIMALIEN BABESLEKUA");

        Button gehitu = new Button("GEHITU");
        Button ezabatu = new Button("EZABATU");
        Button erakutsi = new Button("ERAKUTSI");
        Button irten = new Button("IRTEN");

        HBox menua = new HBox(10);
        menua.getChildren().addAll(gehitu, ezabatu, erakutsi, irten);

        contenido = new VBox(10);
        contenido.setPadding(new Insets(20));

        gehitu.setOnAction(e -> mostrarGehitu());
        ezabatu.setOnAction(e -> mostrarEzabatu());
        erakutsi.setOnAction(e -> mostrarAnimaliak());
        irten.setOnAction(e -> stage.close());

        mostrarAnimaliak();

        VBox raiz = new VBox(15);
        raiz.setPadding(new Insets(20));
        raiz.getChildren().addAll(titulua, menua, contenido);

        Scene scene = new Scene(raiz, 800, 500);

        stage.setTitle("Animalien Babeslekua");
        stage.setScene(scene);
        stage.show();
    }

    private void mostrarGehitu() {
        contenido.getChildren().clear();
        contenido.getChildren().add(
                new GehituView(controller, this::mostrarAnimaliak)
        );
    }

    private void mostrarEzabatu() {
        contenido.getChildren().clear();
        contenido.getChildren().add(
                new EzabatuView(controller, this::mostrarAnimaliak)
        );
    }

    private void mostrarAnimaliak() {
        contenido.getChildren().clear();
        contenido.getChildren().add(
                new AnimaliakView(controller)
        );
    }
}
