import java.util.ArrayList;
import java.util.Scanner;

import clases.Estudiante;
import clases.ValidarEstudiante;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Estudiante> estudiante = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Estudiantes ===");
            System.out.println("1. Agregar un estudiante");
            System.out.println("2. Mostrar informacion de estudiantes");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = sc.nextInt();

            if (opcion == 3) {
                break;
            }

            if (opcion < 1 || opcion > 3) {
                System.out.println("Opcion no valida.");
                continue;
            }

            switch (opcion) {
                case 1:
                    sc.nextLine(); 
                    System.out.print("\nIngrese el nombre del estudiante: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese la edad del estudiante: ");
                    int edad = sc.nextInt();

                    System.out.print("Ingrese el indice académico del estudiante: ");
                    double indiceAcademico = sc.nextDouble();

                    try {
                        ValidarEstudiante.validarEstudiante(nombre, edad, indiceAcademico);
                        
                        estudiante.add(new Estudiante(nombre, edad, indiceAcademico));
                        System.out.println("Estudiante registrado correctamente.");

                    } catch (Exception e) {

                        System.out.println(e.getMessage());

                    } finally {
                        System.out.println("Proceso finalizado.");
                    }
                    break;

                case 2:
                    if (estudiante.isEmpty()) {
                        System.out.println("\nNo hay ningun estudiante registrado.");
                    } else {
                        System.out.println("\n=== Informacion de todos los estudiantes ===");
                        for (Estudiante e : estudiante) {
                            e.mostrarInformacion();
                        }
                    }
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }
        sc.close(); 
    }
}