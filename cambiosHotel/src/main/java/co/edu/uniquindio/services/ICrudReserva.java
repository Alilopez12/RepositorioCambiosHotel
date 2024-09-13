package co.edu.uniquindio.services;

import co.edu.uniquindio.model.Cliente;
import co.edu.uniquindio.model.Habitacion;
import co.edu.uniquindio.model.Reserva;

import java.time.LocalDate;
import java.util.Collection;

public interface ICrudReserva {

        boolean crearReserva( LocalDate fechaEntrada, LocalDate fechaSalida, Cliente clienteAsociado, Habitacion habitacionAsociada);
        Reserva getReserva(LocalDate fechaEntrada, LocalDate fechaSalida);
        boolean modificarReserva(LocalDate fechaEntrada, LocalDate fechaSalida, Cliente ClienteAsociado, Habitacion HabitacionAsociada);
        boolean eliminarReserva(LocalDate fechaEntrada, LocalDate fechaSalida);
        Collection<Reserva> obtenerTodasReservas();
    }
