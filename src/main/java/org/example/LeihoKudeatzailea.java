package org.example;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LeihoKudeatzailea {

    private Stage stage;

    public LeihoKudeatzailea(Stage stage) {
        this.stage = stage;
    }

    public void aldatuLeihoa(Pane pane) {

        Scene scene = new Scene(pane, 700, 500);

        stage.setScene(scene);
        stage.show();
    }
}
