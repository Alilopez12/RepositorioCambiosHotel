package co.edu.uniquindio.model.builder;
import co.edu.uniquindio.model.Reserva;
import java.time.LocalDate;

public class ReservaBuilder {
    protected LocalDate fechaEntrada;
    protected LocalDate fechaSalida;

    public Reserva build() {
        return new Reserva(fechaEntrada, fechaSalida, null, null);
    }

    public ReservaBuilder fechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
        return this;
    }

    public ReservaBuilder fechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }
}
