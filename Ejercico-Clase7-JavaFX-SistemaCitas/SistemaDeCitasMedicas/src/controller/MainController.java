package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import excepciones.HorarioOcupadoException;
import excepciones.ManejadorValidaciones;
import excepciones.ValidacionException;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Cita;
import utils.ManejadorArchivos;
import utils.Navegacion;

public class MainController {

    @FXML
    private TextField txtCodigo;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private TextField txtPaciente;

    @FXML
    private TextField txtHora;

    @FXML
    private TextField txtCedula;

    @FXML
    private ComboBox<String> cmbMedico;

    @FXML
    private TextField txtTelefono;

    @FXML
    private ComboBox<String> cmbEspecialidad;

    @FXML
    private ComboBox<String> cmbEstado;

    @FXML
    private TextArea txtMotivo;

    @FXML
    private TableView<Cita> tblCitas;

    @FXML
    private TableColumn<Cita, String> colCodigo;

    @FXML
    private TableColumn<Cita, String> colPaciente;

    @FXML
    private TableColumn<Cita, String> colMedico;

    @FXML
    private TableColumn<Cita, String> colEspecialidad;

    @FXML
    private TableColumn<Cita, String> colFecha;

    @FXML
    private TableColumn<Cita, String> colHora;

    @FXML
    private TableColumn<Cita, String> colEstado;

    private ArrayList<Cita> listaCita = new ArrayList<>();

    @FXML
    private void registrarCita() {

        try {
            String codigo = txtCodigo.getText().trim();
            String paciente = txtPaciente.getText().trim();
            String cedulaTxt = txtCedula.getText().trim();
            String telefonoTxt = txtTelefono.getText().trim();
            String hora = txtHora.getText().trim();
            String motivo = txtMotivo.getText().trim();
            String medico = cmbMedico.getValue();
            String especialidad = cmbEspecialidad.getValue();
            String estado = cmbEstado.getValue();
            LocalDate fecha = dpFecha.getValue();

            ManejadorValidaciones.validarCamposVacios(codigo, paciente, cedulaTxt, telefonoTxt, hora, motivo, medico,
                    especialidad, estado, fecha);

            int cedula;
            int telefono;
            try {
                cedula = Integer.parseInt(cedulaTxt);
                telefono = Integer.parseInt(telefonoTxt);
            } catch (NumberFormatException e) {
                throw new ValidacionException("La cédula y el teléfono deben contener solamente números.");
            }

            if (fecha.isBefore(LocalDate.now())) {
                throw new ValidacionException("La fecha de la cita no puede ser anterior a la fecha actual.");
            }

            for (Cita c : listaCita) {
                if (c.getCodigo().equalsIgnoreCase(codigo)) {
                    throw new ValidacionException("El codigo de la cita ya se encuentra registrado.");
                }

                if (c.getMedico().equals(medico) && c.getFecha().equals(fecha) &&
                        c.getHora().equals(hora) && !c.getEstado().equals("Cancelada")) {
                    throw new HorarioOcupadoException(
                            "Ya existe una cita programada para este medico en la misma fecha y hora.");
                }
            }

            Cita nuevaCita = new Cita(codigo, paciente, cedula, telefono, medico, especialidad, fecha, hora, motivo,
                    estado);

            listaCita.add(nuevaCita);
            mostrarAlerta("Exito", "Cita registrada de manera exitosa.");
            mostrarEntabla();
            limpiarCampos();

        } catch (ValidacionException | HorarioOcupadoException e) {
            mostrarAlerta("Advertencia de Validación", e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: La cédula y el teléfono deben contener solo números sin guiones ni letras.");
        }

    }

    @FXML
    private void mostrarEntabla() {
        try {
            ObservableList<Cita> cita = FXCollections.observableArrayList(listaCita);
            tblCitas.setItems(cita);
        } catch (Exception e) {

        }
    }

    @FXML
    private void cancelarCita() {

        Cita seleccionada = tblCitas.getSelectionModel().getSelectedItem();

        if (seleccionada == null) {
            mostrarAlerta("Selección Invalida", "Por favor, seleccione una cita del listado de la tabla.");
            return;
        }

        if (seleccionada.getEstado().equals("Cancelada")) {
            mostrarAlerta("Información", "La cita seleccionada ya se encuentra en estado Cancelada.");
            return;
        }

        try {
            ManejadorArchivos.actualizarEstadoEnArchivo(seleccionada.getCodigo(), "Cancelada");

            seleccionada.setEstado("Cancelada");
            tblCitas.refresh();

            mostrarAlerta("Exito", "El estado de la cita ha cambiado a Cancelada.");

        } catch (IOException e) {
            mostrarAlerta("Error de Archivo", "No se pudo actualizar el registro en el archivo: " + e.getMessage());
        }
    }

    @FXML
    private void limpiarFormulario() {
        limpiarCampos();
    }

    @FXML
    private void cargarArchivo() {
        try {
            listaCita.clear();
            listaCita.addAll(ManejadorArchivos.cargarCitas());
            mostrarEntabla();
            mostrarAlerta("Exito", "Datos leidos e indexados en la tabla correctamente.");
        } catch (Exception e) {
            mostrarAlerta("Error", "Error al intentar leer el archivo físico: " + e.getMessage());
        }
    }

    @FXML
    private void guardarArchivo() {

        try {
            if (listaCita.isEmpty()) {
                mostrarAlerta("Aviso", "No hay registros en la colección actual para guardar.");
                return;
            }
            ManejadorArchivos.guardarCitas(listaCita);
            mostrarAlerta("Exito", "Datos de las citas almacenados correctamente en el archivo.");
        } catch (Exception e) {
            mostrarAlerta("Error", "Error al intentar guardar el archivo físico: " + e.getMessage());
        }
    }

    @FXML
    private void mostrarAlerta(String titulo, String mensaje) {
        try {
            AlertaController controller = Navegacion.abrirVentana("/view/Alerta.fxml", titulo);
            controller.setMensaje(mensaje);
        } catch (Exception e) {
            System.out.println("Error al desplegar la ventana de alerta: " + e.getMessage());
        }
    }

    @FXML
    private void initialize() {

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colPaciente.setCellValueFactory(new PropertyValueFactory<>("paciente"));
        colMedico.setCellValueFactory(new PropertyValueFactory<>("medico"));
        colEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        cmbMedico.getItems().addAll("DR. Jeison Amparo Abreu", "DR. Dionicio Hernandez Pujols",
                "DR. Dharianny Sime Maria");
        cmbEspecialidad.getItems().addAll("Cardiologo", "Neurocirujano");
        cmbEstado.getItems().addAll("Programada", "Atendida", "Cancelada");
    }

    @FXML
    private void limpiarCampos() {
        txtCodigo.clear();
        txtPaciente.clear();
        txtCedula.clear();
        txtTelefono.clear();
        txtHora.clear();
        txtMotivo.clear();
        dpFecha.setValue(null);
        cmbMedico.setValue(null);
        cmbEspecialidad.setValue(null);
        cmbEstado.setValue(null);
    }
}
