package co.edu.uniquindio.model.builder;
import co.edu.uniquindio.model.Servicio;

public abstract class ServicioBuilder<T extends ServicioBuilder<T>> {
    protected String nombre;
    protected double precio;

    public T nombre(String nombre) {
        this.nombre = nombre;
        return self();
    }

    public T precio(double precio) {
        this.precio = precio;
        return self();
    }

    @SuppressWarnings("uncheked")
    protected T self(){
        return (T) this;
    }

    public abstract Servicio build();
}
