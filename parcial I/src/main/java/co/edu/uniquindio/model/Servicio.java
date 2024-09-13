package co.edu.uniquindio.model;
import co.edu.uniquindio.services.IConsumible;

public abstract class Servicio implements IConsumible {

    private String nombre;
    private double precio;
    private Habitacion habitacionAsociada;
    private Cliente clienteAsociado;

    public Servicio(String nombre, double precio,Habitacion habitacionAsociada, Cliente clienteAsociado) {
        this.nombre = nombre;
        this.precio = precio;
        this.habitacionAsociada = habitacionAsociada;
        this.clienteAsociado = clienteAsociado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Habitacion getHabitacionAsociada() {
        return habitacionAsociada;
    }

    public void setHabitacionAsociada(Habitacion habitacionAsociada) {
        this.habitacionAsociada = habitacionAsociada;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    @Override
    public abstract void consumir();

    @Override
    public String toString() {
        return "Servicio{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", habitacionAsociada=" + habitacionAsociada +
                ", clienteAsociado=" + clienteAsociado +
                '}';
    }
}
