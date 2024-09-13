package co.edu.uniquindio.model.builder;

import co.edu.uniquindio.model.ServicioLimpieza;
import co.edu.uniquindio.model.ServicioRestaurante;

public class ServicioRestauranteBuilder extends ServicioBuilder<ServicioRestauranteBuilder>{

    @Override
    public ServicioRestaurante build(){
        return new ServicioRestaurante(nombre, precio, null, null, "detalle");
    }

    @Override
    protected ServicioRestauranteBuilder self(){
        return this;
    }
}
