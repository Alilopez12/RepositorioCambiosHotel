package co.edu.uniquindio.services;
import co.edu.uniquindio.model.Habitacion;
import co.edu.uniquindio.model.Reserva;
import co.edu.uniquindio.model.Servicio;
import co.edu.uniquindio.model.TipoHabitacion;

import java.util.Collection;

public interface ICrudHabitacion {

    boolean crearHabitacion(int numero, double precio, Reserva reservaAsociada, Collection<Servicio> serviciosAsociados);
    Habitacion getHabitacion(int numero);
    boolean modificarHabitacion(int numero, double precio, Reserva reservaAsociada, Collection<Servicio> ServiciosAsociados);
    boolean eliminarHabitacion(int numero);

    Collection<Habitacion> getHabitaciones();

    Collection<Habitacion> obtenerTodasHabitaciones();
}
