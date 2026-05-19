package principal;

import java.util.Scanner;

import clases.Pacientes;

import java.util.ArrayList;

public class Menu {

    public void mostrarMenu() {
        ArrayList<Pacientes> listaDePacientes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=== SISTEMA DE DIAGNoSTICO MeDICO BaSICO ===");
            System.out.println("1. Registrar un paciente");
            System.out.println("2. Mostrar todos los pacientes registrados");
            System.out.println("3. Calcular IMC de un paciente");
            System.out.println("4. Salir del sistema");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        Metodos.agregarPaciente(listaDePacientes);
                        break;
                    case 2:
                        Metodos.mostrarPacientes(listaDePacientes);
                        break;
                    case 3:
                        Metodos.calcularIMC(listaDePacientes);
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema médico... ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione un número del 1 al 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Entrada no válida. Debe ingresar un número.");
            }

        } while (opcion != 4);

        sc.close();
    }

}
