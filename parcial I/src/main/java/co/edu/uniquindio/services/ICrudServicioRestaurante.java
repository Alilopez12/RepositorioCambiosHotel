package co.edu.uniquindio.services;
import co.edu.uniquindio.model.Cliente;
import co.edu.uniquindio.model.Habitacion;
import co.edu.uniquindio.model.ServicioRestaurante;
import java.util.Collection;

public interface ICrudServicioRestaurante {

    boolean crearServicioRestaurante(String nombre, double precio, Habitacion habitacionAsociada, Cliente clienteAsociado, String plato);
    ServicioRestaurante getServicioRestaurante(String nombre);
    boolean modificarServicioRestaurante(String nuevoNombre, double nuevoPrecio, Habitacion nuevaHabitacionAsociada, Cliente nuevoClienteAsociado, String nuevoPlato);
    boolean eliminarServicioRestaurante(String nombre);
    Collection<ServicioRestaurante> getServiciosRestaurante();
}
