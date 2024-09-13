package co.edu.uniquindio.model.builder;

import co.edu.uniquindio.model.Cliente;

public class ClienteBuilder {
    protected String nombre;
    protected String dni;

    public Cliente build (){
        return new Cliente(nombre, dni, null, null);
    }

    public ClienteBuilder nombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public ClienteBuilder dni(String dni){
        this.dni = dni;
        return this;
    }

}
