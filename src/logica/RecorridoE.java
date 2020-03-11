package logica;
import java.sql.Time;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RecorridoE {
		
	private int id;
	private String codigo;
	private String numeroBus;
	private String descripcionRecorrido;
	private Time tiempoDemora;
	private String zona_recorrido;
	private int cantidad_recorrido;
	private boolean estado;
	
	public RecorridoE() {
	    this.codigo = "No existe o se encuentra deshabilitado";
		this.numeroBus = "";
		this.descripcionRecorrido = "";
		this.tiempoDemora = Time.valueOf(LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss")));
		this.zona_recorrido = "";
		this.cantidad_recorrido = 0;
		this.estado = false;
	}
	
	public RecorridoE(String pCodigo, String pNumeroBus, String pDescripcionRecorrido, String pTiempoDemora,
			String pZonaRecorrido, int pCantidadRecorrido, boolean pEstado) {
		this.codigo = pCodigo;
		this.numeroBus = pNumeroBus;
		this.descripcionRecorrido = pDescripcionRecorrido;
		this.tiempoDemora = Time.valueOf(LocalTime.parse(pTiempoDemora, DateTimeFormatter.ofPattern("HH:mm:ss")));
		this.zona_recorrido = pZonaRecorrido;
		this.cantidad_recorrido = pCantidadRecorrido;
		this.estado = pEstado;	
	}
	
	public RecorridoE(int pId, String pCodigo, String pNumeroBus, String pDescripcionRecorrido, String pTiempoDemora,
			String pZonaRecorrido, int pCantidadRecorrido, boolean pEstado) {
		this.id = pId;
		this.codigo = pCodigo;
		this.numeroBus = pNumeroBus;
		this.descripcionRecorrido = pDescripcionRecorrido;
		this.tiempoDemora = Time.valueOf(LocalTime.parse(pTiempoDemora, DateTimeFormatter.ofPattern("HH:mm:ss")));
		this.zona_recorrido = pZonaRecorrido;
		this.cantidad_recorrido = pCantidadRecorrido;
		this.estado = pEstado;	
	}
	
	public void setCodigo(String pCodigo) {
		this.codigo = pCodigo;
	}
	public String getCodigo() {
		return this.codigo;
	}
	
	public void setNumeroBus(String pNumeroBus) {
		this.numeroBus = pNumeroBus;
	}
	public String getNumeroBus() {
		return this.numeroBus;
	}
	
	public void setDescripcionRecorrido(String pDescripcionRecorrido) {
		this.descripcionRecorrido = pDescripcionRecorrido;
	}
	public String getDescripcionRecorrido() {
		return this.descripcionRecorrido;
	}
	
	public void setTiempoDemora(String pTiempoDemora) {
		this.tiempoDemora = Time.valueOf(LocalTime.parse(pTiempoDemora, DateTimeFormatter.ofPattern("HH:mm:ss")));
	}
	public Time getTiempoDemora() {
		return this.tiempoDemora;
	}
	
	public void setZonaRecorrido(String pZonaRecorrido) {
		this.zona_recorrido = pZonaRecorrido;
	}
	
	public String getZonaRecorrido() {
		return this.zona_recorrido;
	}
	
	public void setCantidadRecorrido(int pCantidadRecorrido) {
		this.cantidad_recorrido = pCantidadRecorrido;
	}
	public int getCantidadRecorrido() {
		return this.cantidad_recorrido;
	}

	
	public void setEstado(boolean pEstado) {
		this.estado = pEstado;
	}
	public boolean getEstado() {
		return this.estado;
	}

	
	public String toString() {
		String datosTexto = "";
		
		datosTexto += "\n" +
				"Código: " + this.codigo + "\n" +
				"Número Bus: " + this.numeroBus + "\n" +
				"Descripción Recorrido: " + this.descripcionRecorrido + "\n" +
				"Tiempo Demora: " + this.tiempoDemora + "\n" +
				"Zona Recorrido: " + this.zona_recorrido + "\n" +
				"Cantidad Recorrido: " + this.cantidad_recorrido + "\n" +
				"Estado: " + this.estado 
				+ "\n\n";
		
		return datosTexto;
	}
	
	

}
