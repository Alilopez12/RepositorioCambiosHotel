package co.edu.uniquindio.model;
import co.edu.uniquindio.model.builder.ClienteBuilder;
import co.edu.uniquindio.model.builder.ReservaBuilder;

import java.time.LocalDate;

public class Reserva {

    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Cliente clienteAsociado;
    private Habitacion habitacionAsociada;

    public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida, Cliente clienteAsociado, Habitacion habitacionAsociada) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.clienteAsociado = clienteAsociado;
        this.habitacionAsociada = habitacionAsociada;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate horaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate horaSalida) {
        this.fechaSalida = horaSalida;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    public Habitacion getHabitacionAsociada() {
        return habitacionAsociada;
    }

    public void setHabitacionAsociada(Habitacion habitacionAsociada) {
        this.habitacionAsociada = habitacionAsociada;
    }

    public static ReservaBuilder builder(){
        return new ReservaBuilder();
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                ", clienteAsociado=" + clienteAsociado +
                ", habitacionAsociada=" + habitacionAsociada +
                '}';
    }
}
