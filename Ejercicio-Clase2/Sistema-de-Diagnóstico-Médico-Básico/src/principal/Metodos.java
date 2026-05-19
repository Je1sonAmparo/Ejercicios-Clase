package principal;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Pacientes;

public class Metodos {

    public static void agregarPaciente(ArrayList<Pacientes> pacientes) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n=== REGISTRO DE PACIENTE ===");

        System.out.print("Ingrese el nombre completo: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese la fecha de nacimiento (DD/MM/AAAA): ");
        String fechaNacimiento = sc.nextLine();

        System.out.print("Ingrese la edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese la cédula: ");
        String cedula = sc.nextLine();

        System.out.print("Ingrese el sexo: ");
        String sexo = sc.nextLine();

        System.out.print("Ingrese el genero: ");
        String genero = sc.nextLine();

        System.out.print("Ingrese el numero de telefono: ");
        String numeroTelefono = sc.nextLine();

        System.out.print("Ingrese la direccion: ");
        String direccion = sc.nextLine();

        System.out.print("¿Tiene seguro medico? Ingrese: (1. Si / 2. No): ");
        int opcion = sc.nextInt();
        boolean seguro = (opcion == 1);

        System.out.print("Ingrese el peso (en kg, ej. 70.5): ");
        double peso = sc.nextDouble();

        System.out.print("Ingrese la altura (en metros, ej. 1.75): ");
        double altura = sc.nextDouble();
        sc.nextLine();

        Pacientes nuevoPaciente = new Pacientes(nombre, fechaNacimiento, edad, cedula,
                sexo, genero, numeroTelefono, direccion, seguro, peso, altura);

        pacientes.add(nuevoPaciente);

        System.out.println("\n¡Paciente registrado con exito!");
    }
}
