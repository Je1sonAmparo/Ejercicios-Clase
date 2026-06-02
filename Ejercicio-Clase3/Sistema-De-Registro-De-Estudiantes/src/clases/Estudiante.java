package clases;

public class Estudiante {
    private String nombre;
    private int edad;
    private double indice;

    public Estudiante() {
        setNombre("");
        setEdad(0);
        setIndice(0.0);
    }

    public Estudiante(String nombre, int edad, double indice) {
        this.nombre = nombre;
        this.edad = edad;
        this.indice = indice;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getIndice() {
        return indice;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setIndice(double indice) {
        this.indice = indice;
    }

    public void mostrarInformacion() {

        System.out.println("\n--- INFORMACION DEL ESTUDIANTE ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Indice: " + indice);
    }
}
