package co.edu.uniquindio.services;
import co.edu.uniquindio.model.Cliente;
import co.edu.uniquindio.model.Habitacion;
import co.edu.uniquindio.model.ServicioHabitacion;
import java.util.Collection;

public interface ICrudServicioHabitacion {

    boolean crearServicioHabitacion(String nombre, double precio, Habitacion habitacionAsociada, Cliente clienteAsociado);
    ServicioHabitacion getServicioHabitacion(String nombre);
    boolean modificarServicioHabitacion(String nuevoNombre, double nuevoPrecio, Habitacion nuevaHabitacionAsociada, Cliente nuevoClienteAsociado);
    boolean eliminarServicioHabitacion(String nombre);
    Collection<ServicioHabitacion> getServiciosHabitacion();
}
