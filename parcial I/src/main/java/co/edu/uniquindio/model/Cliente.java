package co.edu.uniquindio.model;
import co.edu.uniquindio.model.builder.ClienteBuilder;

import java.util.Collection;

public class Cliente {

    private String nombre;
    private String dni;
    private Collection<Servicio> listaServicios;
    private Collection<Reserva> listaReservas;

    public Cliente(String nombre, String dni, Collection<Servicio> listaServicios, Collection<Reserva> listaReservas) {
        this.nombre = nombre;
        this.dni = dni;
        this.listaServicios = listaServicios;
        this.listaReservas = listaReservas;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Collection<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(Collection<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public Collection<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(Collection<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public static  ClienteBuilder builder(){
        return new ClienteBuilder();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", listaServicios=" + listaServicios +
                ", listaReservas=" + listaReservas +
                '}';
    }
}
