package co.edu.uniquindio.model.builder;
import co.edu.uniquindio.model.Habitacion;
import co.edu.uniquindio.model.TipoHabitacion;

public class HabitacionBuilder  {
    protected int numero;
    protected double precio;
    protected TipoHabitacion tipoHabitacion;

    public Habitacion build (){
        return new Habitacion(numero, precio, null, null);
    }
    public HabitacionBuilder tipoHabitacion(TipoHabitacion tipoHabitacion){
        this.tipoHabitacion = tipoHabitacion;
        return this;

    }

    public HabitacionBuilder numero(int numero){
        this.numero = numero;
        return this;
    }
    public HabitacionBuilder precio(double precio){
        this.precio = precio;
        return this;
    }
}
