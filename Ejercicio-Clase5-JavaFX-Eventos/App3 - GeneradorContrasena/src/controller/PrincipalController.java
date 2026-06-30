package controller;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PrincipalController {

    @FXML
    private TextField txtLongitud;

    @FXML
    private CheckBox chkMayusculas;

    @FXML
    private CheckBox chkNumeros;

    @FXML
    private CheckBox chkSimbolos;

    @FXML
    private Button btnGenerar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Label lblContrasena;

    @FXML
    private Label lblMensaje;

    private final String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private final String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String NUMEROS = "0123456789";
    private final String SIMBOLOS = "!@#$%&*?";

    @FXML
    void generar(ActionEvent event) {
        procesarGeneracion();
    }

    @FXML
    void limpiar(ActionEvent event) {
        txtLongitud.clear();
        chkMayusculas.setSelected(false);
        chkNumeros.setSelected(false);
        chkSimbolos.setSelected(false);
        lblContrasena.setText("Esperando configuración...");
        lblMensaje.setText("Bienvenido al generador");
    }

    @FXML
    void manejarKeyEvent(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            procesarGeneracion();
        }
    }

    @FXML
    void mouseEntraBoton(MouseEvent event) {
        lblMensaje.setText("Presione para generar una nueva contraseña.");
    }

    @FXML
    void mouseSaleBoton(MouseEvent event) {
        lblMensaje.setText("Esperando configuración...");
    }

    private void procesarGeneracion() {
        String textoLongitud = txtLongitud.getText().trim();

        if (!entradasSonValidas(textoLongitud)) {
            return;
        }

        int longitud = Integer.parseInt(textoLongitud);
        String caracteresDisponibles = MINUSCULAS;

        if (chkMayusculas.isSelected()) {
            caracteresDisponibles += MAYUSCULAS;
        }
        if (chkNumeros.isSelected()) {
            caracteresDisponibles += NUMEROS;
        }
        if (chkSimbolos.isSelected()) {
            caracteresDisponibles += SIMBOLOS;
        }

        String contrasena = construirContrasena(longitud, caracteresDisponibles);

        lblContrasena.setText(contrasena);
        lblMensaje.setText("¡Contraseña generada con éxito!");
    }

    private String construirContrasena(int longitud, String conjuntoCaracteres) {
        StringBuilder generador = new StringBuilder();
        Random random = new Random();
        int totalCaracteres = conjuntoCaracteres.length();

        for (int i = 0; i < longitud; i++) {
            int indiceAleatorio = random.nextInt(totalCaracteres);
            generador.append(conjuntoCaracteres.charAt(indiceAleatorio));
        }

        return generador.toString();
    }

    private boolean entradasSonValidas(String textoLongitud) {
        if (textoLongitud.isEmpty()) {
            mostrarError("Por favor, ingrese la longitud.");
            return false;
        }

        return validarLongitudNumerica(textoLongitud);
    }

    private boolean validarLongitudNumerica(String texto) {
        try {
            int longitud = Integer.parseInt(texto);
            if (longitud < 6) {
                mostrarError("La longitud debe ser mayor o igual a 6.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            mostrarError("La longitud debe ser un valor numérico válido.");
            return false;
        }
    }

    private void mostrarError(String mensaje) {
        lblContrasena.setText("Error");
        lblMensaje.setText(mensaje);
    }
}