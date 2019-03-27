package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class Controller {
    public TextArea recenicaField;
    public Button dugmić;
    public ListView najduzaVelikim;

    public void initialize() {
        recenicaField.getStyleClass().add("poljeNijeIspravno");
        recenicaField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String o, String n) {
                if (n.isEmpty()) {
                    recenicaField.getStyleClass().add("poljeNijeIspravno");
                    recenicaField.setPromptText("Unesite rečenicu");
                } else {
                    recenicaField.getStyleClass().removeAll("poljeNijeIspravno");
                }
            }
        });
    }

    public void extract(ActionEvent actionEvent) {
        try {
            najduzaVelikim.getItems().clear();
            String recenica = recenicaField.getText();
            String najduza = "";

            for (String rijec : recenica.split(" "))
                if (rijec.length() > najduza.length())
                    najduza = rijec;
            najduzaVelikim.getItems().add(najduza.toUpperCase());
        } catch (Throwable throwable) {
            System.exit(0);
        }
    }
}

