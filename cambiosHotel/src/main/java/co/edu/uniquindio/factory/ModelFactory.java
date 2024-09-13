package co.edu.uniquindio.factory;

import co.edu.uniquindio.model.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import co.edu.uniquindio.services.*;

public class ModelFactory implements ICrudCliente, ICrudHabitacion, ICrudReserva, ICrudServicioSpa, ICrudServicioHabitacion, ICrudServicioRestaurante, ICrudServicioLimpieza {

    private static ModelFactory instance;
    private static Hotel hotel;

    public ModelFactory(){
        inicializarDatos();
    }

    public static ModelFactory getInstance(){
        if(instance == null){
            instance = new ModelFactory();
        }
        return instance;
    }

    private void inicializarDatos() {
        Collection<Reserva> listaReservas = new ArrayList<>();
        Collection<Habitacion> listaHabitaciones = new ArrayList<>();
        Collection<Cliente> listaClientes = new ArrayList<>();
        Collection<Servicio> listaServicios = new ArrayList<>();

        hotel = new Hotel("El aventurero", listaReservas, listaHabitaciones, listaClientes, listaServicios);


        // CLIENTES
        Cliente cliente1 = Cliente.builder()
                .nombre("Maria")
                .dni("123")
                .build();
        Cliente cliente2 = Cliente.builder()
                .nombre("Mateo")
                .dni("5687")
                .build();
        Cliente cliente3 = Cliente.builder()
                .nombre("Enrique")
                .dni("9875")
                .build();
        Cliente cliente4 = Cliente.builder()
                .nombre("Mariana")
                .dni("8875")
                .build();

        // Añadir clientes al hotel
        hotel.getListaClientes().add(cliente1);
        hotel.getListaClientes().add(cliente2);
        hotel.getListaClientes().add(cliente3);
        hotel.getListaClientes().add(cliente4);

        // HABITACIONES
        Habitacion habitacion1 = Habitacion.builder()
                .numero(100)
                .precio(32.45)
                .tipoHabitacion(TipoHabitacion.SUITE)
                .build();

        Habitacion habitacion2 = Habitacion.builder()
                .numero(101)
                .precio(85.68)
                .tipoHabitacion(TipoHabitacion.SIMPLE)
                .build();

        Habitacion habitacion3 = Habitacion.builder()
                .numero(102)
                .precio(45.55)
                .tipoHabitacion(TipoHabitacion.DOBLE)
                .build();

        Habitacion habitacion4 = Habitacion.builder()
                .numero(103)
                .precio(988554.26)
                .tipoHabitacion(TipoHabitacion.DOBLE)
                .build();

        // Añadir habitaciones al hotel
        hotel.getListaHabitaciones().add(habitacion1);
        hotel.getListaHabitaciones().add(habitacion2);
        hotel.getListaHabitaciones().add(habitacion3);
        hotel.getListaHabitaciones().add(habitacion4);

        // SERVICIOS
        Servicio servicio1 = new ServicioHabitacion("WiFi", 10.0, habitacion1, cliente1);
        Servicio servicio2 = new ServicioLimpieza("Limpieza diaria", 20.0, habitacion2, cliente2, "Limpieza profunda");
        Servicio servicio3 = new ServicioRestaurante("Cena especial", 50.0, habitacion3, cliente3, "Plato gourmet");
        Servicio servicio4 = new ServicioSpa("Masaje relajante", 70.0, habitacion4, cliente4, "Aceite de lavanda");

        // Añadir servicios al hotel
        hotel.getListaServicios().add(servicio1);
        hotel.getListaServicios().add(servicio2);
        hotel.getListaServicios().add(servicio3);
        hotel.getListaServicios().add(servicio4);

        // RESERVAS
        Reserva reserva1 = new Reserva(LocalDate.of(2024, 9, 1), LocalDate.of(2024, 9, 7), cliente1, habitacion1);
        Reserva reserva2 = new Reserva(LocalDate.of(2024, 9, 10), LocalDate.of(2024, 9, 15), cliente2, habitacion2);
        Reserva reserva3 = new Reserva(LocalDate.of(2024, 9, 20), LocalDate.of(2024, 9, 25), cliente3, habitacion3);
        Reserva reserva4 = new Reserva(LocalDate.of(2024, 9, 30), LocalDate.of(2024, 10, 5), cliente4, habitacion4);

        // Añadir reservas al hotel
        hotel.getListaReservas().add(reserva1);
        hotel.getListaReservas().add(reserva2);
        hotel.getListaReservas().add(reserva3);
        hotel.getListaReservas().add(reserva4);

        // Asignar reservas a habitaciones
        habitacion1.setReservaAsociada(reserva1);
        habitacion2.setReservaAsociada(reserva2);
        habitacion3.setReservaAsociada(reserva3);
        habitacion4.setReservaAsociada(reserva4);

        // Asignar servicios a clientes y habitaciones
        cliente1.setListaServicios(new ArrayList<>(List.of(servicio1)));
        cliente2.setListaServicios(new ArrayList<>(List.of(servicio2)));
        cliente3.setListaServicios(new ArrayList<>(List.of(servicio3)));
        cliente4.setListaServicios(new ArrayList<>(List.of(servicio4)));
        habitacion1.setListaServicios(new ArrayList<>(List.of(servicio1)));
        habitacion2.setListaServicios(new ArrayList<>(List.of(servicio2)));
        habitacion3.setListaServicios(new ArrayList<>(List.of(servicio3)));
        habitacion4.setListaServicios(new ArrayList<>(List.of(servicio4)));
    }



    //Implementación de ICrudCliente

    @Override
    public boolean crearCliente(String dni, String nombre){
        return hotel.crearCliente(dni,nombre);
    }

    @Override
    public Cliente getCliente(String nombre) {
        return hotel.getCliente(nombre);
    }


    @Override
    public boolean modificarCliente(String dni, String nuevoNombre) {
        return hotel.modificarCliente(dni, nuevoNombre);
    }

    @Override
    public boolean eliminarCliente(String dni) {
        return hotel.eliminarCliente(dni);
    }

    @Override
    public Collection<Cliente> obtenerTodosClientes() {
        return List.of();
    }

    @Override
    public Collection<Cliente> getCliente() {
        return List.of();
    }

    @Override
    public Collection<Cliente> getClientes() {
        return hotel.getClientes();
    }




    //IMPLEMENTACION CRUD HABITACION
    @Override
    public boolean crearHabitacion(int numero, double precio, Reserva reservaAsociada, Collection<Servicio> serviciosAsociados){
        return hotel.crearHabitacion(numero, precio, reservaAsociada, serviciosAsociados);
    }

    @Override
    public Habitacion getHabitacion(int numero) {
        return hotel.getHabitacion(numero);
    }


    @Override
    public boolean modificarHabitacion(int numero, double precio, Reserva reservaAsociada, Collection<Servicio> serviciosAsociados) {
        return hotel.modificarHabitacion(numero, precio, reservaAsociada, serviciosAsociados);
    }

    @Override
    public boolean eliminarHabitacion(int numero) {
        return hotel.eliminarHabitacion(numero);
    }
    @Override
    public Collection<Habitacion> getHabitaciones() {
        return hotel.getHabitaciones();
    }

    @Override
    public Collection<Habitacion> obtenerTodasHabitaciones() {
        return List.of();
    }



    //IMPLEMENTACION CRUD RESERVA
    @Override
    public boolean crearReserva(LocalDate fechaEntrada, LocalDate fechaSalida, Cliente clienteAsociado, Habitacion habitacionAsociada){
        return hotel.crearReserva(fechaEntrada, fechaSalida, clienteAsociado, habitacionAsociada);
    }

    @Override
    public Reserva getReserva(LocalDate fechaEntrada, LocalDate fechaSalida) {
        return hotel.getReserva(fechaEntrada, fechaSalida);
    }


    @Override
    public boolean modificarReserva(LocalDate fechaEntrada, LocalDate fechaSalida, Cliente ClienteAsociado, Habitacion HabitacionAsociada) {
        return hotel.modificarReserva(fechaEntrada, fechaSalida, ClienteAsociado,  HabitacionAsociada);
    }

    @Override
    public boolean eliminarReserva(LocalDate fechaEntrada, LocalDate fechaSalida) {
        return hotel.eliminarReserva(fechaEntrada, fechaSalida);
    }

    @Override
    public Collection<Reserva> obtenerTodasReservas() {
        return List.of();
    }

    // IMPLEMENTACION CRUD SERVICIOSPA
    @Override
    public boolean crearServicioSpa(String nombre, double nuevoPrecio, String elemento, Habitacion nuevaHabitacionAsociada, Cliente nuevoClienteAsociado) {
        return hotel.crearServicioSpa(nombre, nuevoPrecio, elemento, nuevaHabitacionAsociada, nuevoClienteAsociado);
    }

    @Override
    public ServicioSpa getServicioSpa(String nombre) {
        return hotel.getServicioSpa(nombre);
    }

    @Override
    public boolean modificarServicioSpa(String nombre, double nuevoPrecio, String elemento, Habitacion nuevaHabitacionAsociada, Cliente nuevoClienteAsociado) {
        return hotel.modificarServicioSpa(nombre, nuevoPrecio, elemento, nuevaHabitacionAsociada, nuevoClienteAsociado);
    }

    @Override
    public boolean eliminarServicioSpa(String nombre) {
        return hotel.eliminarServicioSpa(nombre);
    }


    @Override
    public Collection<ServicioSpa> getServiciosSpa() {
        return hotel.getServiciosSpa();
    }

    // IMPLEMENTACION CRUD SERVICIOHABITACION
    @Override
    public boolean crearServicioHabitacion(String nombre, double precio, Habitacion habitacionAsociada, Cliente clienteAsociado) {
        return hotel.crearServicioHabitacion(nombre, precio, habitacionAsociada, clienteAsociado);
    }

    @Override
    public ServicioHabitacion getServicioHabitacion(String nombre) {
        return hotel.getServicioHabitacion(nombre);
    }

    @Override
    public boolean modificarServicioHabitacion(String nuevoNombre, double nuevoPrecio, Habitacion nuevaHabitacionAsociada, Cliente nuevoClienteAsociado) {
        return hotel.modificarServicioHabitacion(nuevoNombre,nuevoPrecio,nuevaHabitacionAsociada,nuevoClienteAsociado);
    }

    @Override
    public boolean eliminarServicioHabitacion(String nombre) {
        return hotel.eliminarServicioHabitacion(nombre);
    }
    @Override
    public Collection<ServicioHabitacion> getServiciosHabitacion() {
        return hotel.getServiciosHabitacion();
    }

    // Implementacion ICrudServicioLimpieza

    @Override
    public boolean crearServicioLimpieza(String nombre, double precio, Habitacion habitacionAsociada, Cliente clienteAsociado, String detalle) {
        return hotel.crearServicioLimpieza(nombre, precio, habitacionAsociada, clienteAsociado, detalle);
    }

    @Override
    public ServicioLimpieza getServicioLimpieza(String nombre) {
        return hotel.getServicioLimpieza(nombre);
    }

    @Override
    public boolean modificarServicioLimpieza(String nombre, double nuevoPrecio, Habitacion nuevaHabitacionAsociada, Cliente nuevoClienteAsociado, String nuevoDetalle) {
        return hotel.modificarServicioLimpieza(nombre, nuevoPrecio, nuevaHabitacionAsociada, nuevoClienteAsociado, nuevoDetalle);
    }

    @Override
    public boolean eliminarServicioLimpieza(String nombre) {
        return hotel.eliminarServicioLimpieza(nombre);
    }

    @Override
    public Collection<ServicioLimpieza> getServiciosLimpieza() {
        return hotel.getServiciosLimpieza();
    }

    // Implementacion de ICrudServicioRestaurante

    @Override
    public boolean crearServicioRestaurante(String nombre, double precio, Habitacion habitacionAsociada, Cliente clienteAsociado, String plato) {
        return hotel.crearServicioRestaurante(nombre, precio, habitacionAsociada, clienteAsociado, plato);
    }

    @Override
    public ServicioRestaurante getServicioRestaurante(String nombre) {
        return hotel.getServicioRestaurante(nombre);
    }

    @Override
    public boolean modificarServicioRestaurante(String nombre, double nuevoPrecio, Habitacion nuevaHabitacionAsociada, Cliente nuevoClienteAsociado, String nuevoPlato) {
        return hotel.modificarServicioRestaurante(nombre, nuevoPrecio, nuevaHabitacionAsociada, nuevoClienteAsociado, nuevoPlato);
    }

    @Override
    public boolean eliminarServicioRestaurante(String nombre) {
        return hotel.eliminarServicioRestaurante(nombre);
    }

    @Override
    public Collection<ServicioRestaurante> getServiciosRestaurante() {
        return hotel.getServiciosRestaurante();
    }










}