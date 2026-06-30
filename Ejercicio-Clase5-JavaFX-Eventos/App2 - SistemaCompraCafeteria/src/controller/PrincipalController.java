package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PrincipalController {

    @FXML
    private TextField txtCliente;

    @FXML
    private ComboBox<String> cbBebida;

    @FXML
    private TextField txtCantidad;

    @FXML
    private CheckBox chkPostre;

    @FXML
    private Button btnCalcular;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Label lblResumen;

    @FXML
    private Label lblMensaje;

    private final double PRECIO_POSTRE = 75.00;

    @FXML
    public void initialize() {
        cbBebida.getItems().addAll("Café americano", "Cappuccino", "Chocolate caliente", "Jugo natural");
    }

    @FXML
    void calcular(ActionEvent event) {
        procesarCompra();
    }

    @FXML
    void limpiar(ActionEvent event) {
        txtCliente.clear();
        cbBebida.getSelectionModel().clearSelection();
        txtCantidad.clear();
        chkPostre.setSelected(false);
        lblResumen.setText("Esperando datos de la compra...");
        lblMensaje.setText("Bienvenido a la cafetería");
    }

    @FXML
    void manejarKeyEvent(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            procesarCompra();
        }
    }

    @FXML
    void mouseEntraBoton(MouseEvent event) {
        lblMensaje.setText("Presione para calcular el total de la compra.");
    }

    @FXML
    void mouseSaleBoton(MouseEvent event) {
        lblMensaje.setText("Esperando datos de la compra...");
    }

    private void procesarCompra() {
        String nombre = txtCliente.getText().trim();
        String bebida = cbBebida.getValue();
        String textoCantidad = txtCantidad.getText().trim();

        if (!entradasSonValidas(nombre, bebida, textoCantidad)) {
            return; 
        }

        int cantidad = Integer.parseInt(textoCantidad);
        double precioBebida = obtenerPrecioBebida(bebida);
        double subtotal = precioBebida * cantidad;
        
        double costoPostre = 0.0;
        String textoPostre = "No";

        if (chkPostre.isSelected()) {
            costoPostre = PRECIO_POSTRE;
            textoPostre = "Sí";
        }

        double total = subtotal + costoPostre;

        String resumen = String.format(
            "Cliente: %s\nProducto: %s\nCantidad: %d\nSubtotal: RD$ %.2f\nPostre: %s\nTotal: RD$ %.2f",
            nombre, bebida, cantidad, subtotal, textoPostre, total
        );

        lblResumen.setText(resumen);
        lblMensaje.setText("¡Cálculo realizado con éxito!");
    }

    private boolean entradasSonValidas(String nombre, String bebida, String textoCantidad) {
        if (nombre.isEmpty()) {
            mostrarError("Por favor, ingrese el nombre del cliente.");
            return false;
        }

        if (bebida == null) {
            mostrarError("Por favor, seleccione una bebida.");
            return false;
        }

        if (textoCantidad.isEmpty()) {
            mostrarError("Por favor, ingrese la cantidad.");
            return false;
        }

        return validarCantidadNumerica(textoCantidad);
    }

    private boolean validarCantidadNumerica(String texto) {
        try {
            int cantidad = Integer.parseInt(texto);
            if (cantidad <= 0) {
                mostrarError("La cantidad debe ser mayor a cero.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            mostrarError("La cantidad debe ser un número entero válido.");
            return false;
        }
    }

    private double obtenerPrecioBebida(String bebida) {
        switch (bebida) {
            case "Café americano": return 100.0;
            case "Cappuccino": return 150.0;
            case "Chocolate caliente": return 130.0;
            case "Jugo natural": return 120.0;
            default: return 0.0;
        }
    }

    private void mostrarError(String mensaje) {
        lblResumen.setText("Error");
        lblMensaje.setText(mensaje);
    }
}