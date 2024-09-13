package co.edu.uniquindio;

import co.edu.uniquindio.factory.ModelFactory;
import co.edu.uniquindio.model.Cliente;
import co.edu.uniquindio.model.Habitacion;
import co.edu.uniquindio.model.Reserva;
import co.edu.uniquindio.model.Servicio;
import co.edu.uniquindio.model.ServicioHabitacion;
import co.edu.uniquindio.model.ServicioLimpieza;
import co.edu.uniquindio.model.ServicioRestaurante;
import co.edu.uniquindio.model.ServicioSpa;
import co.edu.uniquindio.model.TipoHabitacion;

import java.time.LocalDate;
import java.util.Collection;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        ModelFactory modelFactory = ModelFactory.getInstance();

        crudCliente(modelFactory);
        crudHabitacion(modelFactory);
        crudReserva(modelFactory);
        crudServicioHabitacion(modelFactory);
        crudServicioLimpieza(modelFactory);
        crudServicioSpa(modelFactory);
    }

    public static void crudCliente(ModelFactory modelFactory) {
        crearCliente(modelFactory);
        eliminarCliente(modelFactory);
        obtenerTodosClientes(modelFactory);
        modificarCliente(modelFactory);
    }

    private static void modificarCliente(ModelFactory modelFactory) {
        boolean modificado = modelFactory.modificarCliente("123", "Vanessa");
        System.out.println("El proceso de modificacion del Cliente finalizó con un estado de: " + modificado);
    }


    public static void crearCliente(ModelFactory modelFactory) {
        boolean response = modelFactory.crearCliente("123", "Maria");
        System.out.println("El proceso de eliminacion ha finalizado con un estado de: " + response);
    }

    public static void eliminarCliente(ModelFactory modelFactory) {
        boolean eliminado = modelFactory.eliminarCliente("123");
        System.out.println("El proceso de eliminacion ha finalizado con un estado de: " + eliminado);
    }

    public static void obtenerTodosClientes(ModelFactory modelFactory) {
        Collection<Cliente> clientes = modelFactory.getClientes();
        System.out.println("Clientes en el sistema:");
        for (Cliente cliente : clientes) {
            System.out.println("Nombre: " + cliente.getNombre() + ", DNI: " + cliente.getDni());
        }


    }

    // CRUD Habitacion


    public static void crudHabitacion(ModelFactory modelFactory) {
        crearHabitacion(modelFactory);
        eliminarHabitacion(modelFactory);
        obtenerTodasHabitaciones(modelFactory);
        modificarHabitacion(modelFactory);
    }

    public static void crearHabitacion(ModelFactory modelFactory) {
        boolean response = modelFactory.crearHabitacion(101, 850.265, null, null);
        System.out.println("El proceso de creación de habitación ha finalizado con un estado de: " + response);
    }

    public static void eliminarHabitacion(ModelFactory modelFactory) {
        boolean eliminado = modelFactory.eliminarHabitacion(102);
        System.out.println("El proceso de eliminación de habitación ha finalizado con un estado de: " + eliminado);
    }

    public static void modificarHabitacion(ModelFactory modelFactory) {
        boolean modificado = modelFactory.modificarHabitacion(101, 220.36, null, null);
        System.out.println("El proceso de modificación de habitación ha finalizado con un estado de: " + modificado);
    }

    public static void obtenerTodasHabitaciones(ModelFactory modelFactory) {
        Collection<Habitacion> habitaciones = modelFactory.getHabitaciones();
        System.out.println("Habitaciones en el sistema:");
        if (habitaciones == null || habitaciones.isEmpty()) {
            System.out.println("No se encontraron habitaciones.");
        } else {
            for (Habitacion habitacion : habitaciones) {
                System.out.println("Nombre: " + habitacion.getNumero() + ", numero: ");
            }
        }
    }


    // CRUD Reserva
    public static void crudReserva(ModelFactory modelFactory) {
        crearReserva(modelFactory);
        eliminarReserva(modelFactory);
        obtenerTodasReservas(modelFactory);
        modificarReserva(modelFactory);
    }

    public static void crearReserva(ModelFactory modelFactory) {
        boolean response = modelFactory.crearReserva(LocalDate.now(), LocalDate.now(), null, null);
        System.out.println("El proceso de creación de reserva ha finalizado con un estado de: " + response);
    }

    public static void eliminarReserva(ModelFactory modelFactory) {

        boolean eliminado = modelFactory.eliminarReserva(LocalDate.of(2024, 9, 10), LocalDate.of(2024, 9, 15));
        System.out.println("El proceso de eliminación de reserva ha finalizado con un estado de: " + eliminado);
    }

    public static void modificarReserva(ModelFactory modelFactory) {

        boolean modificado = modelFactory.modificarReserva(LocalDate.of(2024, 9, 10), LocalDate.of(2024, 9, 15), modelFactory.getCliente("Mateo"), null);
        System.out.println("El proceso de modificación de reserva ha finalizado con un estado de: " + modificado);
    }

    public static void obtenerTodasReservas(ModelFactory modelFactory) {
        Collection<Reserva> reservas = modelFactory.obtenerTodasReservas();
        System.out.println("Reservas en el sistema:");
        if (reservas == null || reservas.isEmpty()) {
            System.out.println("No se encontraron reservas.");
        } else {
            for (Reserva reserva : reservas) {
                System.out.println("Reserva desde: " + reserva.getFechaEntrada() + " hasta: " + reserva.getFechaSalida());
            }
        }
    }

    // CRUD SERVICIOHABITACION

    public static void crudServicioHabitacion(ModelFactory modelFactory) {
        crearServicioHabitacion(modelFactory);
        eliminarServicioHabitacion(modelFactory);
        obtenerServiciosHabitacion(modelFactory);
        modificarServicioHabitacion(modelFactory);
    }

    public static void crearServicioHabitacion(ModelFactory modelFactory) {
        boolean creado = modelFactory.crearServicioHabitacion("Servicio de alarma", 65.8, null, null);
        System.out.println("El proceso de creación del servicio de habitación finalizó con un estado de:" + creado);
    }

    private static void eliminarServicioHabitacion(ModelFactory modelFactory) {
        boolean eliminado = modelFactory.eliminarServicioHabitacion("Toallas");
        System.out.println("El proceso de eliminación del servicio de habitación finalizó con un estado de:" + eliminado);
    }

    private static void modificarServicioHabitacion(ModelFactory modelFactory) {
        boolean modificado = modelFactory.modificarServicioHabitacion("Sabanas", 89.42, modelFactory.getHabitacion(102), null);
        System.out.println("El proceso de modificación del servicio de habitación finalizó con un estado de:" + modificado);


    }

    public static void obtenerServiciosHabitacion(ModelFactory modelFactory) {

        Collection<ServicioHabitacion> serviciosHabitacion = modelFactory.getServiciosHabitacion();
        System.out.println("Servicios de habitación en el sistema:");
        if (serviciosHabitacion == null || serviciosHabitacion.isEmpty()) {
            System.out.println("No se encontraron servicios de habitación.");
        } else {
            for (ServicioHabitacion servicioHabitacion : serviciosHabitacion) {
                System.out.println("Nombre: " + servicioHabitacion.getNombre() + ", Precio: " + servicioHabitacion.getPrecio());
            }
        }
    }

    // CRUD SERVICIOSPA

    public static void crudServicioSpa(ModelFactory modelFactory) {
        crearServicioSpa(modelFactory);
        eliminarServicioSpa(modelFactory);
        obtenerServiciosSpa(modelFactory);
        modificarServicioSpa(modelFactory);
    }

    public static void crearServicioSpa(ModelFactory modelFactory) {
        boolean creado = modelFactory.crearServicioSpa("Facial",75.600, "Extracción granos", modelFactory.getHabitacion(102),null);
        System.out.println("El proceso de creación del servicio de spa finalizó con un estado de:" + creado);
    }

    private static void eliminarServicioSpa(ModelFactory modelFactory) {
        boolean eliminado = modelFactory.eliminarServicioSpa("Masaje relajante");
        System.out.println("El proceso de eliminación del servicio de spa finalizó con un estado de:" + eliminado);
    }

    private static void modificarServicioSpa(ModelFactory modelFactory) {
        boolean modificado = modelFactory.modificarServicioSpa("Masaje relajante", 89.42, "Aceite de almendras", modelFactory.getHabitacion(101),null);
        System.out.println("El proceso de modificación del servicio de spafinalizó con un estado de:" + modificado);


    }

    public static void obtenerServiciosSpa(ModelFactory modelFactory) {

        Collection<ServicioSpa> serviciosSpa = modelFactory.getServiciosSpa();
        System.out.println("Servicios de spa en el sistema:");

        if (serviciosSpa == null || serviciosSpa.isEmpty()) {
            System.out.println("No se encontraron servicios de spa.");
        } else {
            for (ServicioSpa servicioSpa : serviciosSpa) {
                System.out.println("Nombre: " + servicioSpa.getNombre() + ", Precio: " + servicioSpa.getPrecio() + ", Elemento: " + servicioSpa.getElemento());
            }
        }
    }
    // CRUD SERVICIOSLIMPIEZA

    public static void crudServicioLimpieza(ModelFactory modelFactory) {
        crearServicioLimpieza(modelFactory);
        eliminarServicioLimpieza(modelFactory);
        obtenerServicioLimpieza(modelFactory);
        modificarServicioLimpieza(modelFactory);
    }
    public static void crearServicioLimpieza(ModelFactory modelFactory) {
        boolean creado = modelFactory.crearServicioLimpieza("Facial",75.600, modelFactory.getHabitacion(103), null, "limpieza profunda");
        System.out.println("El proceso de creación del servicio de lim´pieza finalizó con un estado de:" + creado);
    }

    private static void eliminarServicioLimpieza(ModelFactory modelFactory) {
        boolean eliminado = modelFactory.eliminarServicioLimpieza("Facial");
        System.out.println("El proceso de eliminación del servicio de limpieza finalizó con un estado de:" + eliminado);
    }

    private static void modificarServicioLimpieza(ModelFactory modelFactory) {
        boolean modificado = modelFactory.modificarServicioLimpieza("recoger basura", 89.42, modelFactory.getHabitacion(102),null,"Reciclaje");
        System.out.println("El proceso de modificación del servicio de spafinalizó con un estado de:" + modificado);


    }

    public static void obtenerServicioLimpieza(ModelFactory modelFactory) {
        Collection<ServicioLimpieza> serviciosLimpieza = modelFactory.getServiciosLimpieza();
        System.out.println("Servicios de limpieza en el sistema:");
        if (serviciosLimpieza == null || serviciosLimpieza.isEmpty()) {
            System.out.println("No se encontraron servicios de limpieza.");
        } else {
            for (ServicioLimpieza servicioLimpieza : serviciosLimpieza) {
                System.out.println("Nombre: " + servicioLimpieza.getNombre() + ", Precio: " + servicioLimpieza.getPrecio() + ", Detalle: " + servicioLimpieza.getDetalle());
            }
        }
    }


}

