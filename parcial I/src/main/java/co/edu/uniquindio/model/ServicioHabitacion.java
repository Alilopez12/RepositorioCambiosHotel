package co.edu.uniquindio.model;

public class ServicioHabitacion extends Servicio {

    public ServicioHabitacion(String nombre, double precio, Habitacion habitacionAsociada, Cliente clienteAsociado) {
        super(nombre, precio, habitacionAsociada, clienteAsociado);
    }
    @Override
    public void consumir() {

    }

}
