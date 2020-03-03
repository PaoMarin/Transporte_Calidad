package logica;
import java.util.*;
import java.sql.Time;

public class RecorridoE {
	
	private int id;
	private String codigo;
	private String numeroBus;
	private String descripcionRecorrido;
	private Time tiempoDemora;
	private String zona_recorrido;
	private String cantidad_recorrido;
	private boolean estado;

	
	
	public RecorridoE() {
	    this.codigo = "No existe o se encuentra deshabilitado";
		this.numeroBus = "";
		this.descripcionRecorrido = "";
		this.tiempoDedmora = Time.valueOf(LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss")));
		this.zonaRecorrido = "";
		this.cantidadRecorrido = "";
		this.estado = false;
	}
	
	public RecorridoE(String pCodigo, String pNumeroBus, String pDescripcionRecorrido, String pTiempoDemora,
			String pZaonaRecorrido, String pCantidadRecorrido, boolean pEstado) {
		this.codigo = pCodigo;
		this.numeroBus = pNumeroBus;
		this.descripcionRecorrido = pDescripcionRecorrido;
		this.tiempoDemora = Time.valueOf(LocalTime.parse(pTiempoDemora, DateTimeFormatter.ofPattern("HH:mm:ss")));
		this.zonaRecorrido = pZonaRecorrido;
		this.cantidadRecorrido = pCantidadRecorrido;
		this.estado = pEstado;	
	}
	
	public RecorridoE(int pId, String pCodigo, String pNumeroBus, String pDescripcionRecorrido, String pTiempoDemora,
			String pZaonaRecorrido, String pCantidadRecorrido, boolean pEstado) {
		this.id = pId;
		this.codigo = pCodigo;
		this.numeroBus = pNumeroBus;
		this.descripcionRecorrido = pDescripcionRecorrido;
		this.tiempoDemora = Time.valueOf(LocalTime.parse(pTiempoDemora, DateTimeFormatter.ofPattern("HH:mm:ss")));
		this.zonaRecorrido = pZonaRecorrido;
		this.cantidadRecorrido = pCantidadRecorrido;
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
		this.zonaRecorrido = pZonaRecorrido;
	}
	
	public String getZonaRecorrido() {
		return this.zonaRecorrido;
	}
	
	public void setCantidadRecorrido(String pCantidadRecorrido) {
		this.cantidadRecorrido = pCantidadRecorrido;
	}
	public String getCantidadRecorrido() {
		return this.cantidadRecorrido;
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
				"Zona Recorrido: " + this.zonaRecorrido + "\n" +
				"Cantidad Recorrido: " + this.cantidadRecorrido + "\n" +
				"Estado: " + this.estado 
				+ "\n\n";
		
		return datosTexto;
	}
	

}// class RecorridoE
