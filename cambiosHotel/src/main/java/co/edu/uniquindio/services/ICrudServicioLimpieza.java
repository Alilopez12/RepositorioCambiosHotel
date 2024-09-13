package co.edu.uniquindio.services;
import co.edu.uniquindio.model.Cliente;
import co.edu.uniquindio.model.Habitacion;
import co.edu.uniquindio.model.ServicioLimpieza;
import java.util.Collection;

public interface ICrudServicioLimpieza {

    boolean crearServicioLimpieza(String nombre, double precio, Habitacion habitacionAsociada, Cliente clienteAsociado, String detalle);
    ServicioLimpieza getServicioLimpieza(String nombre);
    boolean modificarServicioLimpieza(String nuevoNombre, double nuevoPrecio, Habitacion nuevaHabitacionAsociada, Cliente nuevoClienteAsociado, String nuevoDetalle);
    boolean eliminarServicioLimpieza(String nombre);
    Collection<ServicioLimpieza> getServiciosLimpieza();
}
