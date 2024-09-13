package co.edu.uniquindio.services;
import co.edu.uniquindio.model.Cliente;
import co.edu.uniquindio.model.Habitacion;
import co.edu.uniquindio.model.ServicioSpa;
import java.util.Collection;

public interface ICrudServicioSpa {

    boolean crearServicioSpa(String nombre, double nuevoPrecio, String elemento, Habitacion nuevaHabitacionAsociada, Cliente nuevoClienteAsociado);
    ServicioSpa getServicioSpa(String nombre);
    boolean modificarServicioSpa(String nombre, double nuevoPrecio, String elemento, Habitacion nuevaHabitacionAsociada, Cliente nuevoClienteAsociado );
    boolean eliminarServicioSpa(String nombre);
    Collection<ServicioSpa> getServiciosSpa();
}
