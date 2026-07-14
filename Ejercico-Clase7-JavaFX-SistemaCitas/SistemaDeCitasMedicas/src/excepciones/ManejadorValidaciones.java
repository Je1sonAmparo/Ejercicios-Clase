package excepciones;

import java.time.LocalDate;

public class ManejadorValidaciones {

    public static void validarCamposVacios(String codigo, String paciente, String cedula,
            String telefono, String hora, String motivo,
            String medico, String especialidad, String estado,
            LocalDate fecha) throws ValidacionException {

        if (codigo == null || codigo.isEmpty() ||
                paciente == null || paciente.isEmpty() ||
                cedula == null || cedula.trim().isEmpty() ||
                telefono == null || telefono.trim().isEmpty() ||
                hora == null || hora.isEmpty() ||
                motivo == null || motivo.isEmpty() ||
                medico == null || especialidad == null ||
                estado == null || fecha == null) {

            throw new ValidacionException("Todos los campos obligatorios deben tener un valor.");
        }
    }
}