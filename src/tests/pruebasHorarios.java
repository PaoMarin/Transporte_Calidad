package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import datos.HorarioD;
import datos.SocioD;
import logica.HorarioE;
import logica.SocioE;

import org.testng.annotations.Test;

public class pruebasHorarios {
 
  
    SocioE socioPrueba;
	HorarioE nuevoHorario;		
	HorarioE horarioObtenido;
	SocioD socioDatos = new SocioD();
	HorarioD horarioDatos = new HorarioD();	
	
	@BeforeMethod
	// Setear las variables antes de iniciar los test.
	public void setup() {
		socioPrueba = new SocioE("S3", "Armandi", "Rojas Lara", "Thomas", "T2", 45, "Luis", "Ricardo", true);
		socioDatos.agregarSocio(socioPrueba);
		nuevoHorario = new HorarioE("H5", socioPrueba.getNumeroBus(), "Horario 5","06:30:00", "07:45:00", true);				
		System.out.print("Hello");
	}	
	
	@Test
	public void guardarHorario() {		
		
		// Act		
		horarioDatos.agregarHorario(nuevoHorario);
		horarioObtenido = horarioDatos.buscarHorario(nuevoHorario.getCodigo());
		
		// Assert
		Assert.assertEquals(nuevoHorario.getCodigo(), horarioObtenido.getCodigo());		
	}	
	
	@Test 
	public void buscarHorario() {
		
		// Act
		horarioObtenido = horarioDatos.buscarHorario(nuevoHorario.getCodigo());
		
		// Assert
		Assert.assertNotNull(horarioObtenido, "El horario obtenido es: " + horarioObtenido.toString());
	
	}
	
	@Test
	public void modificarHorario() {
		
	}
	
	@AfterMethod
	public void limpiarBaseDatos() {
		horarioDatos.limpiarTabla();
		socioDatos.limpiarTabla();		
	} 
  
  
  
  
  
  
}
