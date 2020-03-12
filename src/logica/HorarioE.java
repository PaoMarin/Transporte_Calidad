package logica;
import java.sql.Time;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HorarioE {
	private int id;
	private String codigo;
	private String numeroBus;
	private String descripcionHorario;
	private Time tiempoSalida;
	private Time tiempoLlegada;
	private boolean estado;
	/*
	 * LocalTime now = LocalTime.now();
 
        Time time = Time.valueOf( now );
         
        System.out.println(time);
	 * */
	
	public HorarioE() {
	    this.codigo = "";
		this.numeroBus = "";
		this.descripcionHorario = "";
		this.tiempoSalida = Time.valueOf(LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss")));
		this.tiempoLlegada = Time.valueOf(LocalTime.parse("00:00:00", DateTimeFormatter.ofPattern("HH:mm:ss")));
		this.estado = false;
	}
	
	public HorarioE(String pCodigo, String pNumeroBus, String pDescripcionHorario, String pTiempoSalida,
			String pTiempoLlegada, boolean pEstado) {
		this.codigo = pCodigo;
		this.numeroBus = pNumeroBus;
		this.descripcionHorario = pDescripcionHorario;
		this.tiempoSalida = Time.valueOf(LocalTime.parse(pTiempoSalida, DateTimeFormatter.ofPattern("HH:mm:ss")));
		this.tiempoLlegada = Time.valueOf(LocalTime.parse(pTiempoLlegada, DateTimeFormatter.ofPattern("HH:mm:ss")));
		this.estado = pEstado;	
	}
	
	public HorarioE(int pId, String pCodigo, String pNumeroBus, String pDescripcionHorario, String pTiempoSalida,
			String pTiempoLlegada, boolean pEstado) {
		this.id = pId;
		this.codigo = pCodigo;
		this.numeroBus = pNumeroBus;
		this.descripcionHorario = pDescripcionHorario;
		this.tiempoSalida = Time.valueOf(LocalTime.parse(pTiempoSalida, DateTimeFormatter.ofPattern("HH:mm:ss")));
		this.tiempoLlegada = Time.valueOf(LocalTime.parse(pTiempoLlegada, DateTimeFormatter.ofPattern("HH:mm:ss")));
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
	
	public void setDescripcionHorario(String pDescripcionHorario) {
		this.descripcionHorario = pDescripcionHorario;
	}
	public String getDescripcionHorario() {
		return this.descripcionHorario;
	}
	
	public void setTiempoSalida(String pTiempoSalida) {
		this.tiempoSalida = Time.valueOf(LocalTime.parse(pTiempoSalida, DateTimeFormatter.ofPattern("HH:mm:ss")));
	}
	public Time getTiempoSalida() {
		return this.tiempoSalida;
	}
	
	public void setTiempoLlegada(String pTiempoLlegada) {
		this.tiempoLlegada = Time.valueOf(LocalTime.parse(pTiempoLlegada, DateTimeFormatter.ofPattern("HH:mm:ss")));
	}
	public Time getTiempoLlegada() {
		return this.tiempoLlegada;
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
				"C�digo: " + this.codigo + "\n" +
				"N�mero Bus: " + this.numeroBus + "\n" +
				"Descripci�n Horario: " + this.descripcionHorario + "\n" +
				"Tiempo Salida: " + this.tiempoSalida + "\n" +
				"Tiempo Llegada: " + this.tiempoLlegada + "\n" +
				"Estado: " + this.estado 
				+ "\n\n";
		
		return datosTexto;
	}
	
	

	
	
	

}//class HorarioE
