package co.edu.uniquindio.model.builder;

import co.edu.uniquindio.model.ServicioLimpieza;

public class ServicioLimpiezaBuilder extends ServicioBuilder<ServicioLimpiezaBuilder> {

    @Override
    public ServicioLimpieza build(){
        return new ServicioLimpieza(nombre, precio, null, null, "detalle");
        }

        @Override
    protected ServicioLimpiezaBuilder self(){
        return this;
        }
    }
