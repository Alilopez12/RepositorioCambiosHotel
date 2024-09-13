package co.edu.uniquindio.model;

public class ServicioSpa extends Servicio {

    private String elemento;

    public ServicioSpa(String nombre, double precio, Habitacion habitacionAsociada, Cliente clienteAsociado, String elemento) {
        super(nombre, precio, habitacionAsociada, clienteAsociado);
        this.elemento = elemento;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    @Override
    public void consumir() {

    }
}
