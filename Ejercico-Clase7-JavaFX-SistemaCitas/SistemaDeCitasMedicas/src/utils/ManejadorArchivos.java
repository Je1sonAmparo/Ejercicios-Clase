package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Cita;

public class ManejadorArchivos {
    private static final String RUTA_CITAS = "src/files/citas.txt";

    public static void guardarCitas(List<Cita> citas) throws IOException {
        File file = new File(RUTA_CITAS);

        try (FileWriter archivo = new FileWriter(RUTA_CITAS, false)) {
            for (Cita cita : citas) {
                String linea = cita.getCodigo() + ";" +
                        cita.getPaciente() + ";" +
                        cita.getCedula() + ";" +
                        cita.getTelefono() + ";" +
                        cita.getMedico() + ";" +
                        cita.getEspecialidad() + ";" +
                        cita.getFecha().toString() + ";" +
                        cita.getHora() + ";" +
                        cita.getMotivo() + ";" +
                        cita.getEstado();
                archivo.write(linea + "\n");
            }
        }
    }

    public static ArrayList<Cita> cargarCitas() throws IOException {

        ArrayList<Cita> citas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_CITAS))) {

            String linea;

            while ((linea = reader.readLine()) != null) {

                String[] partes = linea.split(";");

                if (partes.length == 10) {

                    Cita cita = new Cita(
                            partes[0],
                            partes[1],
                            Integer.parseInt(partes[2]),
                            Integer.parseInt(partes[3]),
                            partes[4],
                            partes[5],
                            LocalDate.parse(partes[6]),
                            partes[7],
                            partes[8],
                            partes[9]);
                    citas.add(cita);
                }
            }
        }
        return citas;
    }

    public static void actualizarEstadoEnArchivo(String codigo, String nuevoEstado) throws IOException {
       
        ArrayList<Cita> citas = cargarCitas();

       
        for (Cita cita : citas) {
            if (cita.getCodigo().equalsIgnoreCase(codigo)) {
                cita.setEstado(nuevoEstado); 
                break; 
            }
        }

       
        guardarCitas(citas);
    }
}
