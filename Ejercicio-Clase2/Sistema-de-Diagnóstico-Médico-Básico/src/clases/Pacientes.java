package clases;

import java.util.Scanner;

public class Pacientes {
    private String nombre;
    private String fechaNacimiento;
    private int edad;
    private String cedula;
    private String sexo;
    private String genero;
    private String numeroTelefono;
    private String direccion;
    private boolean seguro;
    private double peso;
    private double altura;

    public Pacientes() {
    }

    public Pacientes(String nombre, String fechaNacimiento, int edad, String cedula, String sexo, String genero,
            String numeroTelefono, String direccion, boolean seguro, double peso, double altura) {
        setNombre(nombre);
        setFechaNacimiento(fechaNacimiento);
        setEdad(edad);
        setCedula(cedula);
        setSexo(sexo);
        setGenero(genero);
        setNumeroTelefono(numeroTelefono);
        setDireccion(direccion);
        setSeguro(seguro);
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

        return new Pacientes(nombre, fechaNacimiento, edad, cedula, sexo, genero,
                numeroTelefono, direccion, seguro, peso, altura);
    }

    public void mostrarPaciente() {
        System.out.println("Nombre: " + this.nombre +
                " | Fecha de Nac.: " + this.fechaNacimiento +
                " | Edad: " + this.edad +
                " | Cédula: " + this.cedula +
                " | Sexo: " + this.sexo +
                " | Género: " + this.genero +
                " | Teléfono: " + this.numeroTelefono +
                " | Dirección: " + this.direccion +
                " | Seguro: " + (this.seguro ? "Sí" : "No") +
                " | Peso: " + this.peso + "kg" +
                " | Altura: " + this.altura + "m");
    }
}
