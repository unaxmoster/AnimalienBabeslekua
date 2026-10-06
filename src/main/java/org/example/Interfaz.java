package org.example;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Interfaz {

    private TabPane lehioak;
    private Babeslekua babeslekua;
    private VBox animalienPanela;

    public void erakutsi(Stage stage) {

        //metodo honetan stage stage erabiltzen dut, beraz ez daukat main-etik
        //deitu beharrik stage.show(), eta hemen bertatik egin dezaket.

        stage.setTitle("Animalien Babeslekua");

        babeslekua = new Babeslekua();

        lehioak = new TabPane(); //TabPane erabilita scene aldatzen egotea bakoitzeko
        // sahiesten dut, eta pestañak aldatzen joaten naiz, beti scene eta stage
        // berdinean lan egiten.



        Tab nagusia = new Tab(
                "Animalien Babeslekua",
                sortuPestanaNagusia()
        );

        Tab gehitu = new Tab(
                "GEHITU",
                sortuPestanaGehitu()
        );

        Tab erakutsi = new Tab(
                "ERAKUTSI",
                sortuPestanaErakutsi()
        );

        nagusia.setClosable(false);
        gehitu.setClosable(false);
        erakutsi.setClosable(false);

        lehioak.getTabs().add(nagusia);
        lehioak.getTabs().add(gehitu);
        lehioak.getTabs().add(erakutsi);

        Scene scene = new Scene(lehioak, 800, 600);

        stage.setScene(scene);
        stage.show();
    }

    private VBox sortuPestanaNagusia() {

        VBox panela = new VBox(15);

        panela.setPadding(new Insets(20));

        Button gehitu = new Button("GEHITU");
        Button erakutsi = new Button("ERAKUTSI");
        Button irten = new Button("IRTEN");

        panela.getChildren().addAll(
                gehitu,
                erakutsi,
                irten
        );

        gehitu.setOnAction(e -> {
            lehioak.getSelectionModel().select(1);
        });

        erakutsi.setOnAction(e -> {
            lehioak.getSelectionModel().select(2);
        });

        irten.setOnAction(e -> {
            System.exit(0);
        });

        return panela;
    }

    private VBox sortuPestanaGehitu() {

        VBox panela = new VBox(10);

        panela.setPadding(new Insets(20));

        Label izenaLabel = new Label("Izena:");
        TextField izenaField = new TextField();

        Label adinaLabel = new Label("Adina:");
        TextField adinaField = new TextField();

        Label pisuaLabel = new Label("Pisua:");
        TextField pisuaField = new TextField();

        Label motaLabel = new Label("Mota:");

        ComboBox<String> motaBox = new ComboBox<>();

        motaBox.getItems().addAll(
                "Txakurra",
                "Katua",
                "Untxia"
        );

        motaBox.setValue("Txakurra");

        Button gehitu = new Button("GEHITU");

        gehitu.setOnAction(e -> {

            try {

                String izena = izenaField.getText();

                int adina = Integer.parseInt(
                        adinaField.getText()
                );

                double pisua = Double.parseDouble(
                        pisuaField.getText().replace(",", ".")
                );

                String mota = motaBox.getValue();

                Animalia animalia;

                if (mota.equals("Txakurra")) {

                    animalia = new Txakurra(
                            izena,
                            adina,
                            pisua
                    );

                } else if (mota.equals("Katua")) {

                    animalia = new Katua(
                            izena,
                            adina,
                            pisua
                    );

                } else {

                    animalia = new Untxia(
                            izena,
                            adina,
                            pisua
                    );
                }

                babeslekua.gehituAnimalia(animalia);

                eguneratuAnimaliak();

                Alert alerta = new Alert(
                        Alert.AlertType.INFORMATION
                );

                alerta.setTitle("Animalien Babeslekua");
                alerta.setHeaderText(null);
                alerta.setContentText(
                        "Animalia gehitu da!"
                );

                alerta.showAndWait();

                izenaField.clear();
                adinaField.clear();
                pisuaField.clear();

            } catch (NumberFormatException ex) {

                Alert alerta = new Alert(
                        Alert.AlertType.ERROR
                );

                alerta.setTitle("Errorea");
                alerta.setHeaderText(null);
                alerta.setContentText(
                        "Sartu zenbaki baliodunak."
                );

                alerta.showAndWait();
            }
        });

        panela.getChildren().addAll(

                izenaLabel,
                izenaField,

                adinaLabel,
                adinaField,

                pisuaLabel,
                pisuaField,

                motaLabel,
                motaBox,

                gehitu
        );

        return panela;
    }

    private VBox sortuPestanaErakutsi() {

        animalienPanela = new VBox(10);

        animalienPanela.setPadding(
                new Insets(20)
        );

        eguneratuAnimaliak();

        return animalienPanela;
    }

    private void eguneratuAnimaliak() {

        if (animalienPanela == null) {
            return;
        }

        animalienPanela.getChildren().clear();

        for (Animalia animalia : babeslekua.getAnimaliak()) {

            HBox animaliaPanela = new HBox(10);

            Label izena = new Label(
                    animalia.getIzena()
            );

            Label adina = new Label(
                    "Adina: " + animalia.getAdina()
            );

            Label pisua = new Label(
                    "Pisua: " + animalia.getPisua()
            );

            Button soinua = new Button(
                    "SOINUA EGIN"
            );

            soinua.setOnAction(e -> {

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);

                alerta.setTitle("Animalien soinua");
                alerta.setHeaderText(animalia.getIzena());
                alerta.setContentText(animalia.getSoinua());

                alerta.showAndWait();
            });

            Button ezabatu = new Button(
                    "EZABATU"
            );

            ezabatu.setOnAction(e -> {

                babeslekua.ezabatuAnimalia(
                        animalia.getIzena()
                );

                eguneratuAnimaliak();
            });

            Button adoptatu = new Button(
                    "ADOPTATU"
            );

            adoptatu.setOnAction(e -> {

                boolean adoptatua =
                        babeslekua.adoptatuAnimalia(
                                animalia.getIzena()
                        );

                Alert alerta = new Alert(
                        Alert.AlertType.INFORMATION
                );

                alerta.setTitle(
                        "Animalien Babeslekua"
                );

                alerta.setHeaderText(null);

                if (adoptatua) {

                    alerta.setContentText(
                            animalia.getIzena()
                                    + " adoptatua izan da!"
                    );

                } else {

                    alerta.setContentText(
                            "Animalia hau dagoeneko adoptatua dago."
                    );
                }

                alerta.showAndWait();

                eguneratuAnimaliak();
            });

            animaliaPanela.getChildren().addAll(
                    izena,
                    adina,
                    pisua,
                    soinua,
                    adoptatu,
                    ezabatu
            );

            animalienPanela.getChildren().add(
                    animaliaPanela
            );
        }
    }
}