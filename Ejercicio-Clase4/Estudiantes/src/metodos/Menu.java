package metodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static void menu() {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Mostrar Estudiantes");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            if (opcion == 3) {
                System.out.println("\nGracias por usar el sistema.\n");
                System.out.println("\nCreado por Jeison Amparo Abreu ;) ...\n");
                break;
            }

            switch (opcion) {
                case 1:
                    try {
                        FileWriter fw = new FileWriter("estudiante.txt", true);
                        BufferedWriter bufWriter = new BufferedWriter(fw);

                        sc.nextLine();
                        System.out.print("\nIngrese el nombre del estudiante: ");
                        String nombre = sc.nextLine();

                        System.out.print("\nIngrese la edad del estudiante: ");
                        int edad = sc.nextInt();
                        sc.nextLine();

                        System.out.print("\nIngrese la matricula del estudiante: ");
                        String matricula = sc.nextLine();

                        bufWriter.write("Nombre: " + nombre);
                        bufWriter.newLine();
                        bufWriter.write("Edad: " + edad);
                        bufWriter.newLine();
                        bufWriter.write("Matricula: " + matricula);
                        bufWriter.write("--------------------------------");
                        bufWriter.newLine();
                        bufWriter.close();
                    } catch (IOException e) {
                        System.out.println("Error al guardar los estudiantes.");
                    }
                    break;
                case 2:
                    try {
                        FileReader read = new FileReader("estudiante.txt");
                        String linea;

                        System.out.println("\n=== Los estudiantes Registrados son los siguientes ===\n");

                        BufferedReader bufWritter = new BufferedReader(read);
                        while ((linea = bufWritter.readLine()) != null) {
                            System.out.println(linea);
                        }
                        bufWritter.close();

                    } catch (IOException e) {
                        System.out.println("Error al mostrar los estudiantes.");
                    }

                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (opcion != 3);
        sc.close();
    }
}