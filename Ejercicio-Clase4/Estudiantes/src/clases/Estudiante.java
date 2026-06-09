package clases;

public class Estudiante {
    private String nombre;
    private int edad;
    private String matricula;
    private double promedio;

    public Estudiante() {
        setNombre("");
        setEdad(0);
        setMatricula("");
        setPromedio(0);
    }

    public Estudiante(String nombre, int edad, String matricula, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = matricula;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public void mostrarInformacion() {

        System.out.println("\n--- INFORMACION DEL ESTUDIANTE ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Matricula: " + matricula);
        System.out.println("Promedio: " + promedio);
    }
}
