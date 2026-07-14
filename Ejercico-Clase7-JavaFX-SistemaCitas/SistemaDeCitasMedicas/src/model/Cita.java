package model;

import java.time.LocalDate;

public class Cita {

    private String codigo;
    private String paciente;
    private int cedula;
    private int telefono;
    private String medico;
    private String especialidad;
    private LocalDate fecha;
    private String hora;
    private String motivo;
    private String estado;

    public Cita() {
    }

    public Cita(String codigo, String paciente, int cedula, int telefono, 
                String medico, String especialidad, LocalDate fecha, 
                String hora, String motivo, String estado) {
        this.codigo = codigo;
        this.paciente = paciente;
        this.cedula = cedula;
        this.telefono = telefono;
        this.medico = medico;
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}