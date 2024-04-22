package co.edu.poli.proyecto.modelo;
import java.time.LocalTime;
import java.io.Serializable;

public class TiempoReserva implements Serializable {

    public TiempoReserva() {
    }

    private int dia;
    private int mes;
    private LocalTime horaInicio;

    public TiempoReserva(int dia, int mes, LocalTime horaInicio) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.horaInicio = horaInicio;
	}

	public LocalTime calcularHoraFin(LocalTime horaInicio) {
		 return horaInicio.plusHours(2);
    }

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	@Override
	public String toString() {
		return "TiempoReserva [dia=" + dia + ", mes=" + mes + ", horaInicio=" + horaInicio + "]";
	}
	
}