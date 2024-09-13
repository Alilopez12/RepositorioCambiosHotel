package co.edu.uniquindio.model;

public class ServicioRestaurante extends Servicio {
    private String plato;

    public ServicioRestaurante(String nombre, double precio, Habitacion habitacionAsociada, Cliente clienteAsociado, String plato) {
        super(nombre, precio, habitacionAsociada, clienteAsociado);
        this.plato = plato;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }
    @Override
    public void consumir() {

    }
}
