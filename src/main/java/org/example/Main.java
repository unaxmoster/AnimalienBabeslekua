package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.view.GUI;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        GUI interfaz = new GUI();

        interfaz.erakutsi(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
