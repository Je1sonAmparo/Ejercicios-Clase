package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PrincipalController {

    @FXML
    private TextField txtMonto;

    @FXML
    private ComboBox<String> cbMoneda;

    @FXML
    private Button btnConvertir;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Label lblResultado;

    @FXML
    private Label lblMensaje;

    private final double TASA_USD = 59.00;
    private final double TASA_EUR = 64.00;

    @FXML
    public void initialize() {
        cbMoneda.getItems().addAll("Dolar estadounidense", "Euro");
    }

    @FXML
    void convertir(ActionEvent event) {
        realizarConversion();
    }

    @FXML
    void limpiar(ActionEvent event) {
        txtMonto.clear();
        cbMoneda.getSelectionModel().clearSelection();
        lblResultado.setText("Esperando información...");
        lblMensaje.setText("Bienvenido al conversor");
    }

    @FXML
    void manejarKeyEvent(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            realizarConversion();
        }
    }

    @FXML
    void mouseEntraBoton(MouseEvent event) {
        lblMensaje.setText("Presione para realizar la conversión.");
    }

    @FXML
    void mouseSaleBoton(MouseEvent event) {
        lblMensaje.setText("Esperando información...");
    }

    private void realizarConversion() {
        String textoMonto = txtMonto.getText().trim();
        String monedaSeleccionada = cbMoneda.getValue();

        if (!entradasSonValidas(textoMonto, monedaSeleccionada)) {
            return;
        }

        double montoPesos = Double.parseDouble(textoMonto);
        double resultado = 0.0;
        String simbolo = "";

        if (monedaSeleccionada.equals("Dolar estadounidense")) {
            resultado = montoPesos / TASA_USD;
            simbolo = "USD";
        } else if (monedaSeleccionada.equals("Euro")) {
            resultado = montoPesos / TASA_EUR;
            simbolo = "EUR";
        }

        String textoResultado = String.format("RD$ %,.2f equivale a %,.2f %s", montoPesos, resultado, simbolo);
        lblResultado.setText(textoResultado);
        lblMensaje.setText("¡Conversión exitosa!");
    }

    private boolean entradasSonValidas(String textoMonto, String monedaSeleccionada) {
        if (textoMonto.isEmpty()) {
            mostrarError("Por favor, ingrese un monto.");
            return false;
        }

        if (monedaSeleccionada == null) {
            mostrarError("Por favor, seleccione una moneda destino.");
            return false;
        }

        return validarFormatoNumerico(textoMonto);
    }

    private boolean validarFormatoNumerico(String texto) {
        try {
            double monto = Double.parseDouble(texto);
            if (monto < 0) {
                mostrarError("El monto no puede ser negativo.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            mostrarError("El monto debe ser un valor numerico valido.");
            return false;
        }
    }

    private void mostrarError(String mensaje) {
        lblResultado.setText("Error");
        lblMensaje.setText(mensaje);
    }
}