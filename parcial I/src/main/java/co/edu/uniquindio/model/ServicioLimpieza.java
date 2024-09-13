package co.edu.uniquindio.model;

public class ServicioLimpieza extends Servicio {
    private String detalle;

    public ServicioLimpieza(String nombre, double precio, Habitacion habitacionAsociada, Cliente clienteAsociado, String detalle) {
        super(nombre, precio, habitacionAsociada, clienteAsociado);
        this.detalle = detalle;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    @Override
    public void consumir() {

    }
}
