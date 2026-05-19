package clases;

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
}
