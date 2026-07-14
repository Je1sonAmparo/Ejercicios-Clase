package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AlertaController {
    @FXML
    private Label lblMensaje;

    @FXML
    private Button btnAceptar;

    public void setMensaje(String mensaje) {
        lblMensaje.setText(mensaje);
    }

    @FXML
    private void cerrarVentana() {
        Stage stage = (Stage) btnAceptar.getScene().getWindow();
        stage.close();
    }
}
