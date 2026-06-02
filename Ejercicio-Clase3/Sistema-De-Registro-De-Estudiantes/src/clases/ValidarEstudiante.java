package clases;

public class ValidarEstudiante {

    public static class EstudianteInvalidoException extends Exception {
        public EstudianteInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    public static void validarEstudiante(String nombre, int edad, double indice) throws Exception {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new EstudianteInvalidoException("Error: El nombre no puede estar vacío.");
        }

        if (edad < 18 || edad > 100) {
            throw new EstudianteInvalidoException("Error: La edad debe ser mayor o igual a 18 años.");
        }

        if (indice < 0.0 || indice > 4.0) {
            throw new EstudianteInvalidoException("Error: El índice debe estar entre 0 y 4.");
        }
    }
}