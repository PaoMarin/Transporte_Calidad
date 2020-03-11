package logica;
import java.util.*;

public class SocioE {
	
	//id serial
	private String codigo;
	private String nombre;
	private String apellidos;
	private String linea;
	private String numeroBus;
	private int capacidadBus;
	private String ayudante;
	private String chofer;
	private boolean estado;
	
	public SocioE() {
		this.codigo = "";
		this.nombre = "";
		this.apellidos = "";
		this.linea = "";
		this.numeroBus = "";
		this.capacidadBus = 0;
		this.ayudante = "";
		this.chofer = "";
		this.estado = false;		
	}
	
	public SocioE(String pCodigo, String pNombre, String pApellidos, String pLinea, String pNumeroBus,
			int pCapacidadBus, String pAyudante, String pChofer, boolean pEstado) {
		this.codigo = pCodigo;
		this.nombre = pNombre;
		this.apellidos = pApellidos;
		this.linea = pLinea;
		this.numeroBus = pNumeroBus;
		this.capacidadBus = pCapacidadBus;
		this.ayudante = pAyudante;
		this.chofer = pChofer;
		this.estado = pEstado;
	}
	
	public void setCodigo(String pCodigo) {
		this.codigo = pCodigo;	
	}
	public String getCodigo() {
		return this.codigo;
	}
	
	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}
	public String getNombre() {
		return this.nombre;
	}
	
	public void setApellidos(String pApellidos) {
		this.apellidos = pApellidos;
	}
	public String getApellidos() {
		return this.apellidos;
	}
	
	public void setLinea(String pLinea) {
		this.linea = pLinea;
	}
	public String getLinea() {
		return this.linea;
	}
	
	public void setNumeroBus(String pNumeroBus) {
		this.numeroBus = pNumeroBus;
	}
	public String getNumeroBus() {
		return this.numeroBus;
	}
	
	public void setCapacidadBus(int pCapacidadBus) {
		this.capacidadBus = pCapacidadBus;
	}
	public int getCapacidadBus() {
		return this.capacidadBus;
	}
	
	public void setAyudante(String pAyudante) {
		this.ayudante = pAyudante;
	}
	public String getAyudante() {
		return this.ayudante;
	}
	
	public void setChofer(String pChofer) {
		this.chofer = pChofer;
	}
	public String getChofer() {
		return this.chofer;
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
				"Nombre: " + this.nombre + "\n" +
				"Apellidos: " + this.apellidos + "\n" +
				"Linea: " + this.linea + "\n" +
				"Número Bus: " + this.numeroBus + "\n" +
				"Capacidad Bus: " + this.capacidadBus + "\n" +
				"Ayudante: " + this.ayudante + "\n" +
				"Chofer: " + this.chofer + "\n" +
				"Estado: " + this.estado
				+ "\n\n";
		
		return datosTexto;
	}
	
	

}//Class SocioE



