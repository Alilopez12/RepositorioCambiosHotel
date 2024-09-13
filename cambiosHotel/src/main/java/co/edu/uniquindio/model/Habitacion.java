package co.edu.uniquindio.model;
import co.edu.uniquindio.model.builder.HabitacionBuilder;

import java.util.Collection;

public class Habitacion {

    private int numero;
    private double precio;
    private Reserva reservaAsociada;
    private Collection<Servicio> listaServicios;

    public Habitacion(int numero, double precio, Reserva reservaAsociada, Collection<Servicio> listaServicios) {
        this.numero = numero;
        this.precio = precio;
        this.reservaAsociada = reservaAsociada;
        this.listaServicios = listaServicios;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Reserva getReservaAsociada() {
        return reservaAsociada;
    }

    public void setReservaAsociada(Reserva reservaAsociada) {
        this.reservaAsociada = reservaAsociada;
    }

    public Collection<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(Collection<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public static HabitacionBuilder builder(){
        return new HabitacionBuilder();
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numero=" + numero +
                ", precio=" + precio +
                ", reservaAsociada=" + reservaAsociada +
                ", listaServicios=" + listaServicios +
                '}';
    }
}
