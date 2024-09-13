package co.edu.uniquindio.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Hotel {
    private String nombre;
    private Collection<Reserva> listaReservas;
    private Collection<Habitacion> listaHabitaciones;
    private Collection<Cliente> listaClientes;
    private Collection<Servicio> listaServicios;

    public Hotel(String nombre, Collection<Reserva> listaReservas, Collection<Habitacion> listaHabitaciones, Collection<Cliente> listaClientes, Collection<Servicio> listaServicios) {
        this.nombre = nombre;
        this.listaReservas = listaReservas;
        this.listaHabitaciones = listaHabitaciones;
        this.listaClientes = listaClientes;
        this.listaServicios = listaServicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(Collection<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public Collection<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(Collection<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    public Collection<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Collection<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Collection<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(Collection<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }


    //CRUD USUARIO
    public boolean crearCliente(String dni, String nombre) {

        Cliente newCliente = new Cliente(dni, nombre, null, null);
        Cliente clienteExistente = verificarCliente(dni);

        if (clienteExistente == null) {
            newCliente.setDni(dni);
            newCliente.setNombre(nombre);
            listaClientes.add(newCliente);

            return true;
        }

        return false;
    }

    private Cliente verificarCliente(String dni) {
        Cliente clienteExistente = null;

        for (Cliente cliente : listaClientes) {
            if (cliente.getDni().equals(dni)) {
                clienteExistente = cliente;
                break;
            }
        }

        return clienteExistente;
    }

    public boolean eliminarCliente(String dni) {

        for (Cliente cliente : listaClientes) {
            if (cliente.getDni().equals(dni)) {
                listaClientes.remove(cliente);
                return true;
            }
        }

        return false;
    }

    public boolean modificarCliente(String dni, String nuevoNombre) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getDni().equals(dni)) {
                cliente.setNombre(nuevoNombre);
                return true;
            }
        }
        return false;
    }

    public Cliente getCliente(String dni) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    public Collection<Cliente> getClientes() {
        return listaClientes;
    }

    //CRUD HABITACIÓN
    public boolean crearHabitacion(int numero, double precio, Reserva reservaAsociada, Collection<Servicio> serviciosAsociados) {

        Habitacion newHabitacion = new Habitacion(numero, precio, reservaAsociada, serviciosAsociados);
        Habitacion habitacionExistente = verificarHabitacion(numero);

        if (habitacionExistente == null) {
            newHabitacion.setNumero(numero);
            newHabitacion.setPrecio(precio);
            newHabitacion.setReservaAsociada(reservaAsociada);
            newHabitacion.setListaServicios(serviciosAsociados);
            listaHabitaciones.add(newHabitacion);

            return true;
        }

        return false;
    }

    private Habitacion verificarHabitacion(int numero) {
        Habitacion habitacionExistente = null;

        for (Habitacion habitacion : listaHabitaciones) {
            if (Integer.valueOf(numero).equals(habitacion.getNumero())) {
                habitacionExistente = habitacion;
                break;
            }
        }

        return habitacionExistente;
    }

    public boolean eliminarHabitacion(int numero) {

        for (Habitacion habitacion : listaHabitaciones) {
            if (Integer.valueOf(numero).equals(habitacion.getNumero())) {
                listaHabitaciones.remove(habitacion);
                return true;
            }
        }

        return false;
    }

    public boolean modificarHabitacion(int numero, double precio, Reserva reservaAsociada, Collection<Servicio> ServiciosAsociados) {
        for (Habitacion habitacion : listaHabitaciones) {
            if (Integer.valueOf(numero).equals(habitacion.getNumero())) {
                habitacion.setNumero(numero);
                return true;
            }
        }
        return false;
    }

    public Habitacion getHabitacion(int numero) {
        for (Habitacion habitacion : listaHabitaciones) {
            if (Integer.valueOf(numero).equals(habitacion.getNumero())) {
                return habitacion;
            }
        }
        return null;
    }

    public Collection<Habitacion> getHabitaciones() {
        return listaHabitaciones;
    }

    //CRUD RESERVA
    public boolean crearReserva(LocalDate fechaEntrada, LocalDate fechaSalida, Cliente clienteAsociado, Habitacion habitacionAsociada) {

        Reserva newReserva = new Reserva(fechaEntrada, fechaSalida, clienteAsociado, habitacionAsociada);
        Reserva reservaExistente = verificarReserva(fechaEntrada, fechaSalida);


        if (reservaExistente == null) {
            listaReservas.add(newReserva);
            return true;
        }

        return false;
    }

    private Reserva verificarReserva(LocalDate fechaEntrada, LocalDate fechaSalida) {
        Reserva reservaExistente = null;

        for (Reserva reserva : listaReservas) {
            LocalDate reservaFechaEntrada = reserva.getFechaEntrada();
            LocalDate reservaFechaSalida = reserva.getFechaSalida();
            if ((fechaEntrada.isBefore(reservaFechaSalida) || fechaEntrada.isEqual(reservaFechaSalida)) &&
                    (fechaSalida.isAfter(reservaFechaEntrada) || fechaSalida.isEqual(reservaFechaEntrada))) {
                reservaExistente = reserva;
                break;
            }
        }

        return reservaExistente;
    }

    public boolean eliminarReserva(LocalDate fechaEntrada, LocalDate fechaSalida) {

        for (Reserva reserva : listaReservas) {

            if (reserva.getFechaEntrada().equals(fechaEntrada) &&
                    reserva.getFechaSalida().equals(fechaSalida)) {
                listaReservas.remove(reserva);
                return true;
            }
        }
        return false;
    }

    public boolean modificarReserva(LocalDate fechaEntrada, LocalDate fechaSalida, Cliente nuevoCliente, Habitacion nuevaHabitacion) {

        for (Reserva reserva : listaReservas) {
            if (reserva.getFechaEntrada().equals(fechaEntrada) && reserva.getFechaSalida().equals(fechaSalida)) {
                reserva.setClienteAsociado(nuevoCliente);
                reserva.setHabitacionAsociada(nuevaHabitacion);
                return true;
            }
        }
        return false;
    }

    public Reserva getReserva(LocalDate fechaEntrada, LocalDate fechaSalida) {
        for (Reserva reserva : listaReservas) {
            if (reserva.getFechaEntrada().equals(fechaEntrada) && reserva.getFechaSalida().equals(fechaSalida)) {
                return reserva;
            }
        }
        return null;
    }

    public Collection<Reserva> getReservas() {
        return listaReservas;
    }

    //CRUD SERVICIOSPA

    public boolean crearServicioSpa(String nombre, double nuevoPrecio, String elemento, Habitacion nuevaHabitacionAsociada, Cliente nuevoClienteAsociado) {

        ServicioSpa servicioSpaExistente = verificarServicioSpa(nombre);

        if (servicioSpaExistente == null) {
            ServicioSpa newServicioSpa = new ServicioSpa(nombre, nuevoPrecio, nuevaHabitacionAsociada, nuevoClienteAsociado, elemento);
            listaServicios.add(newServicioSpa);
            return true;
        }

        return false;
    }
    private ServicioSpa verificarServicioSpa(String nombre) {
        for (Servicio servicio : listaServicios) {
            if (servicio instanceof ServicioSpa && servicio.getNombre().equals(nombre)) {
                return (ServicioSpa) servicio;
            }
        }
        return null;
    }

    public boolean eliminarServicioSpa(String nombre) {
        ServicioSpa servicio = verificarServicioSpa(nombre);

        if (servicio != null) {
            listaServicios.remove(servicio);
            return true;
        }
        return false;
    }

    public boolean modificarServicioSpa(String nombre, double nuevoPrecio, String elemento, Habitacion nuevaHabitacionAsociada, Cliente nuevoClienteAsociado){
        ServicioSpa servicio = verificarServicioSpa(nombre);

        if (servicio != null){
            servicio.setPrecio(nuevoPrecio);
            servicio.setElemento(elemento);
            servicio.setHabitacionAsociada(nuevaHabitacionAsociada);
            servicio.setClienteAsociado(nuevoClienteAsociado);
            return true;
        }
        return false;
    }
    public ServicioSpa getServicioSpa(String nombre){
        return verificarServicioSpa(nombre);
    }

    public Collection<ServicioSpa> getServiciosSpa(){
            Collection<ServicioSpa> servicioSpa = new ArrayList<>();

            for (Servicio servicio : listaServicios){
                if(servicio instanceof ServicioSpa){
                    servicioSpa.add((ServicioSpa) servicio);
                }
            }
            return servicioSpa;
    }

    //CRUD SERVICIOHABITACION

    public boolean crearServicioHabitacion(String nombre, double precio, Habitacion habitacionAsociada, Cliente clienteAsociado) {

        ServicioHabitacion servicioHabitacionExistente = verificarServicioHabitacion(nombre);

        if (servicioHabitacionExistente == null) {
            ServicioHabitacion newServicioHabitacion = new ServicioHabitacion(nombre, precio, habitacionAsociada, clienteAsociado);
            listaServicios.add(newServicioHabitacion);
            return true;
        }

        return false;
    }
    private ServicioHabitacion verificarServicioHabitacion(String nombre) {
        for (Servicio servicio : listaServicios) {
            if (servicio instanceof ServicioHabitacion && servicio.getNombre().equals(nombre)) {
                return (ServicioHabitacion) servicio;
            }
        }
        return null;
    }

    public boolean eliminarServicioHabitacion(String nombre) {
        ServicioHabitacion servicio = verificarServicioHabitacion(nombre);

        if (servicio != null) {
            listaServicios.remove(servicio);
            return true;
        }
        return false;
    }

    public boolean modificarServicioHabitacion(String nuevoNombre, double nuevoPrecio, Habitacion nuevaHabitacionAsociada, Cliente nuevoClienteAsociado){
        ServicioHabitacion servicio = verificarServicioHabitacion(nombre);

        if (servicio != null){
            servicio.setPrecio(nuevoPrecio);
            servicio.setHabitacionAsociada(nuevaHabitacionAsociada);
            servicio.setClienteAsociado(nuevoClienteAsociado);
            return true;
        }
        return false;
    }
    public ServicioHabitacion getServicioHabitacion(String nombre){
        return verificarServicioHabitacion(nombre);
    }

    public Collection<ServicioHabitacion> getServiciosHabitacion(){
        Collection<ServicioHabitacion> servicioHabitacion = new ArrayList<>();

        for (Servicio servicio : listaServicios){
            if(servicio instanceof ServicioHabitacion){
                servicioHabitacion.add((ServicioHabitacion) servicio);
            }
        }
        return servicioHabitacion;
    }


    //CRUD SERVICIOLIMPIEZA

    public boolean crearServicioLimpieza(String nombre, double precio, Habitacion habitacionAsociada, Cliente clienteAsociado, String detalle ){

        ServicioLimpieza servicioLimpiezaExistente = verificarServicioLimpieza(nombre);

        if (servicioLimpiezaExistente == null) {
            ServicioLimpieza newServicioLimpieza = new ServicioLimpieza(nombre, precio, habitacionAsociada, clienteAsociado, detalle);
            listaServicios.add(newServicioLimpieza);
            return true;
        }

        return false;
    }
    private ServicioLimpieza verificarServicioLimpieza(String nombre) {
        for (Servicio servicio : listaServicios) {
            if (servicio instanceof ServicioLimpieza && servicio.getNombre().equals(nombre)) {
                return (ServicioLimpieza) servicio;
            }
        }
        return null;
    }

    public boolean eliminarServicioLimpieza(String nombre) {
        ServicioLimpieza servicio = verificarServicioLimpieza(nombre);

        if (servicio != null) {
            listaServicios.remove(servicio);
            return true;
        }
        return false;
    }

    public boolean modificarServicioLimpieza(String nuevoNombre, double nuevoPrecio, Habitacion nuevaHabitacionAsociada, Cliente nuevoClienteAsociado, String nuevoDetalle){
        ServicioLimpieza servicio = verificarServicioLimpieza(nombre);

        if (servicio != null){
            servicio.setPrecio(nuevoPrecio);
            servicio.setHabitacionAsociada(nuevaHabitacionAsociada);
            servicio.setClienteAsociado(nuevoClienteAsociado);
            servicio.setDetalle(nuevoDetalle);
            return true;
        }
        return false;
    }
    public ServicioLimpieza getServicioLimpieza(String nombre){
        return verificarServicioLimpieza(nombre);
    }

    public Collection<ServicioLimpieza> getServiciosLimpieza(){
        Collection<ServicioLimpieza> servicioLimpieza = new ArrayList<>();

        for (Servicio servicio : listaServicios){
            if(servicio instanceof ServicioLimpieza){
                servicioLimpieza.add((ServicioLimpieza) servicio);
            }
        }
        return servicioLimpieza;
    }

    // Métodos CRUD de SERVICIO DE RESTAURANTE

    public boolean crearServicioRestaurante(String nombre, double precio, Habitacion habitacionAsociada, Cliente clienteAsociado, String plato) {
        ServicioRestaurante servicioRestauranteExistente = verificarServicioRestaurante(nombre);

        if (servicioRestauranteExistente == null) {
            ServicioRestaurante newServicioRestaurante = new ServicioRestaurante(nombre, precio, habitacionAsociada, clienteAsociado, plato);
            listaServicios.add(newServicioRestaurante);
            return true;
        }
        return false;
    }

    private ServicioRestaurante verificarServicioRestaurante(String nombre) {
        for (Servicio servicio : listaServicios) {
            if (servicio instanceof ServicioRestaurante && servicio.getNombre().equals(nombre)) {
                return (ServicioRestaurante) servicio;
            }
        }
        return null;
    }

    public boolean eliminarServicioRestaurante(String nombre) {
        ServicioRestaurante servicio = verificarServicioRestaurante(nombre);

        if (servicio != null) {
            listaServicios.remove(servicio);
            return true;
        }
        return false;
    }

    public boolean modificarServicioRestaurante(String nombre, double nuevoPrecio, Habitacion nuevaHabitacionAsociada, Cliente nuevoClienteAsociado, String nuevoPlato) {
        ServicioRestaurante servicio = verificarServicioRestaurante(nombre);

        if (servicio != null) {
            servicio.setPrecio(nuevoPrecio);
            servicio.setHabitacionAsociada(nuevaHabitacionAsociada);
            servicio.setClienteAsociado(nuevoClienteAsociado);
            servicio.setPlato(nuevoPlato);
            return true;
        }
        return false;
    }

    public ServicioRestaurante getServicioRestaurante(String nombre) {
        return verificarServicioRestaurante(nombre);
    }

    public Collection<ServicioRestaurante> getServiciosRestaurante() {
        Collection<ServicioRestaurante> serviciosRestaurante = new ArrayList<>();

        for (Servicio servicio : listaServicios) {
            if (servicio instanceof ServicioRestaurante) {
                serviciosRestaurante.add((ServicioRestaurante) servicio);
            }
        }
        return serviciosRestaurante;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nombre='" + nombre + '\'' +
                ", listaReservas=" + listaReservas +
                ", listaHabitaciones=" + listaHabitaciones +
                ", listaClientes=" + listaClientes +
                ", listaServicios=" + listaServicios +
                '}';
    }
}