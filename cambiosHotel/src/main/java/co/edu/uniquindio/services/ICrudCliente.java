package co.edu.uniquindio.services;
import co.edu.uniquindio.model.Cliente;
import java.util.Collection;

public interface ICrudCliente {

    boolean crearCliente(String dni, String nombre);
    Cliente getCliente(String idni);
    boolean modificarCliente(String dni, String nuevoNombre);
    boolean eliminarCliente(String dni);
    Collection<Cliente> obtenerTodosClientes();
    Collection<Cliente> getCliente();

    Collection<Cliente> getClientes();
}
