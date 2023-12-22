// Reserva.java
package modelo;


import java.sql.Date;

public class Reserva {
    private int usuarioId;
    private String nombreReserva;
    private String apellidoReserva;
    private Date horaReserva;

    // Constructor
    public Reserva() {
        
    }

    // Getters y Setters (puedes generarlos automáticamente en tu IDE)
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreReserva() {
        return nombreReserva;
    }

    public void setNombreReserva(String nombreReserva) {
        this.nombreReserva = nombreReserva;
    }

    public String getApellidoReserva() {
        return apellidoReserva;
    }

    public void setApellidoReserva(String apellidoReserva) {
        this.apellidoReserva = apellidoReserva;
    }

    public Date getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(Date horaReserva) {
        this.horaReserva = horaReserva;
    }


}

