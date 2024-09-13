package co.edu.uniquindio.model.builder;
import co.edu.uniquindio.model.ServicioSpa;

public class ServicioSpaBuilder extends ServicioBuilder<ServicioSpaBuilder>{

    @Override
    public ServicioSpa build(){
        return new ServicioSpa(nombre, precio, null, null, "detalle");
    }

    @Override
    protected ServicioSpaBuilder self(){
        return this;
    }
}
