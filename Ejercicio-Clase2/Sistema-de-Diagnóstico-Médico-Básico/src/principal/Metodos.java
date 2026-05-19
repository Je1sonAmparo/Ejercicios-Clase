package principal;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Pacientes;

public class Metodos {

    public static void agregarPaciente(ArrayList<Pacientes> pacientes) {
        Pacientes nuevoPaciente = Pacientes.agregarPaciente();
        pacientes.add(nuevoPaciente);
        System.out.println("\n¡Paciente registrado con éxito!");
    }

    public static void mostrarPacientes(ArrayList<Pacientes> pacientes) {
        System.out.println("\n=== LISTA DE PACIENTES REGISTRADOS ===");
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados en el sistema.");
            return;
        }

        for (int i = 0; i < pacientes.size(); i++) {
            System.out.print("Paciente #" + (i + 1) + " -> ");
            pacientes.get(i).mostrarPaciente();
        }
    }
}
