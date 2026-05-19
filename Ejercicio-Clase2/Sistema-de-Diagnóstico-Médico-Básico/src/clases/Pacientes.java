package clases;

import java.util.Scanner;

public class Pacientes {
    private String nombre;
    private String fechaNacimiento;
    private int edad;
    private String cedula;
    private String sexo;
    private String numeroTelefono;
    private String direccion;
    private boolean seguro;
    private double peso;
    private double altura;

    public Pacientes() {
    }

    public Pacientes(String nombre, String fechaNacimiento, int edad, String cedula, String sexo,
            String numeroTelefono, String direccion, boolean seguro, double peso, double altura) {
        setNombre(nombre);
        setFechaNacimiento(fechaNacimiento);
        setEdad(edad);
        setCedula(cedula);
        setSexo(sexo);
        setNumeroTelefono(numeroTelefono);
        setDireccion(direccion);
        setSeguro(seguro);
        setPeso(peso);
        setAltura(altura);
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public static Pacientes agregarPaciente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n=== REGISTRO DE PACIENTE ===");

        System.out.print("Ingrese el nombre completo: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese la fecha de nacimiento (DD/MM/AAAA): ");
        String fechaNacimiento = sc.nextLine();

        System.out.print("Ingrese la edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese la cedula: ");
        String cedula = sc.nextLine();

        System.out.print("Ingrese el sexo: ");
        String sexo = sc.nextLine();

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

        return new Pacientes(nombre, fechaNacimiento, edad, cedula, sexo,
                numeroTelefono, direccion, seguro, peso, altura);
    }

    public void mostrarPaciente() {
        System.out.println("\n--- Ficha del Paciente ---");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Cédula: " + getCedula());
        System.out.println("Fecha de Nacimiento: " + getFechaNacimiento());
        System.out.println("Edad: " + getEdad() + " años");
        System.out.println("Sexo: " + getSexo());
        System.out.println("Teléfono: " + getNumeroTelefono());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Seguro Médico: " + (isSeguro() ? "Sí" : "No"));
        System.out.println("Peso: " + getPeso() + " kg");
        System.out.println("Altura: " + getAltura() + " m");
        System.out.println("--------------------------");
    }

    public void calcularIMC() {
        double imc = getPeso() / Math.pow(getAltura(), 2);

        System.out.printf("\nEl paciente %s tiene un IMC de: %.2f\n", getNombre(), imc);
        System.out.print("Diagnóstico: ");

        estadoPaciente(imc);    
    }

    public void estadoPaciente(double imc) {
        if (imc < 18.5) {
            System.out.println("Tiene peso bajo.");
        } else if (imc >= 18.5 && imc <= 24.9) {
            System.out.println("Peso normal.");
        } else {
            System.out.println("Sobrepeso.");
        }
    }
}
