package co.edu.uniquindio.model.builder;
import co.edu.uniquindio.model.ServicioHabitacion;


public class ServicioHabitacionBuilder extends ServicioBuilder<ServicioHabitacionBuilder>{

    @Override
    public ServicioHabitacion build(){
        return new ServicioHabitacion(nombre, precio, null, null);
    }

    @Override
    protected ServicioHabitacionBuilder self(){
        return this;
    }
}

