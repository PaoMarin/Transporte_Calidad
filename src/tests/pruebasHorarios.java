package tests;

import java.util.ArrayList;

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
	HorarioE horarioPrueba;
	HorarioE horarioPrueba1;
	HorarioE horarioPrueba2;
	HorarioE horarioObtenido;
	HorarioE horarioModificar;
	ArrayList<HorarioE> horariosPorUnidad;
	SocioD socioDatos = new SocioD();
	HorarioD horarioDatos = new HorarioD();	
	
	@BeforeMethod
	// Setear las variables antes de iniciar los test.
	public void setup() {
		System.out.print("-------------------Preparando las variables para la prueba------------------\n");
		socioPrueba = new SocioE("S3", "Armandi", "Rojas Lara", "Thomas", "T2", 45, "Luis", "Ricardo", true);
		socioDatos.agregarSocio(socioPrueba);
		nuevoHorario = new HorarioE("H5", socioPrueba.getNumeroBus(), "Horario 5","06:30:00", "07:45:00", true);				
		horarioDatos.agregarHorario(horarioPrueba = new HorarioE("H10", socioPrueba.getNumeroBus(), "Horario 10","09:30:00", "10:45:00", true));
		horarioDatos.agregarHorario(horarioPrueba = new HorarioE("H11", socioPrueba.getNumeroBus(), "Horario 11","10:30:00", "11:45:00", true));
		horarioDatos.agregarHorario(horarioPrueba = new HorarioE("H12", socioPrueba.getNumeroBus(), "Horario 12","06:30:00", "08:45:00", true));
		horariosPorUnidad = new ArrayList<HorarioE>();
		horarioModificar = new HorarioE();		
	}	
	
	// Rec-01 Verificar que se registre el horario de un recorrido
	@Test
	public void guardarHorario() {		
		
		// Act		
		horarioDatos.agregarHorario(nuevoHorario);
		horarioObtenido = horarioDatos.buscarHorario(nuevoHorario.getCodigo());
		
		// Assert
		Assert.assertEquals(nuevoHorario.getCodigo(), horarioObtenido.getCodigo());		
	}
	
	// Rec-02 - Verificar que el sistema no agregue horarios, si existen campos en blanco
	@Test
	public void falloGuardarHorario() {		
		
		nuevoHorario.setDescripcionHorario("");
		
		// Act		
		horarioDatos.agregarHorario(nuevoHorario);
		horarioObtenido = horarioDatos.buscarHorario(nuevoHorario.getCodigo());
		
		// Assert
		Assert.assertTrue(horarioObtenido.getCodigo().equals(""));
		
	}
	
	// Rec-03 - Filtrar el horario por código
	@Test 
	public void buscarHorarioPorCódigo() {
		
		// Act
		horarioObtenido = horarioDatos.buscarHorario("H10");
		
		// Assert
		Assert.assertNotNull(horarioObtenido, "El horario obtenido es: " + horarioObtenido.toString());
	
	}
	
	// Rec-04 - Verificar que el sistema no muestre los horarios si no ingresa el código por parámetro.	
	@Test
	public void falloBuscarHorarioPorCódigo() {
		
		// Act
		horarioObtenido = horarioDatos.buscarHorario("");
		
		// Assert
		Assert.assertTrue(horarioObtenido.getCodigo().equals(""));
	}
	
	// Rec-05 - Verificar que el sistema modifique el horario realizando la busqueda por código.	
	@Test
	public void modificarHorario() {
			
		horarioPrueba = horarioDatos.buscarHorario("H10");
		horarioModificar = horarioDatos.buscarHorario("H10");		
		
		// Act		
		horarioModificar.setDescripcionHorario("Horario Nocturno");			
		horarioDatos.modificarHorario(horarioModificar, horarioPrueba.getCodigo());
		horarioModificar = horarioDatos.buscarHorario(horarioPrueba.getCodigo());
		
		// Assert
		Assert.assertNotEquals(horarioPrueba.getDescripcionHorario(), horarioModificar.getDescripcionHorario());
		
	}
	
	// Rec-06 - Verificar que el sistema no modifique el código del horario
	@Test
	public void falloModificarHorario() {
		
		horarioPrueba = horarioDatos.buscarHorario("H10");
		horarioModificar = horarioDatos.buscarHorario("H10");		
		
		// Act
		horarioModificar.setCodigo("15494");
		horarioModificar.setDescripcionHorario("Horario Nocturno");			
		horarioDatos.modificarHorario(horarioModificar, horarioPrueba.getCodigo());
		horarioModificar = horarioDatos.buscarHorario(horarioPrueba.getCodigo());
		
		// Assert
		Assert.assertEquals(horarioPrueba.getDescripcionHorario(), horarioModificar.getDescripcionHorario());
		
	}
	
	// Rec-07 - Verificar que el sistema elimine los horarios	
	@Test
	public void eliminarHorario() {
		
		// Act
		horarioDatos.eliminarHorario(horarioPrueba.getCodigo());
		horarioPrueba = horarioDatos.buscarHorario(horarioPrueba.getCodigo());
				
		// Assert
		Assert.assertEquals(horarioPrueba.getCodigo(), "");
		//Assert.assertNull(horarioPrueba);
	}	
	
	// Rec-08 - Verificar que el sistema no borre datos si no ingresa código.	
	@Test
	public void falloEliminarHorario() {
		
		// Act
		horarioDatos.eliminarHorario("");
		horarioObtenido = horarioDatos.buscarHorario(horarioPrueba.getCodigo());
				
		// Assert
		Assert.assertNotEquals(horarioObtenido.getCodigo(), "");
		System.out.print(horarioObtenido.toString());
		//Assert.assertNull(horarioPrueba);
	}
	
	// Rec-09 - Verificar que muestre todos los horarios generados por bus
	@Test
	public void buscarPorUnidad() {
		
		// Act		
		horariosPorUnidad = horarioDatos.reporteHorariosPorUnidadBus(socioPrueba.getNumeroBus());
			
		// Assert
		Assert.assertTrue(horariosPorUnidad.size()>0);
		
	}
		
	
	// Rec-10 - Verificar que no realice búsquedas sin el número de bus
	@Test
	public void falloBuscarPorUnidad() {
		// Act		
		horariosPorUnidad = horarioDatos.reporteHorariosPorUnidadBus("12345");
					
		// Assert
		Assert.assertTrue(horariosPorUnidad.size()==0);
	}	
	
	@AfterMethod
	public void limpiarBaseDatos() {
		System.out.print("-------------------Limpiando la Base de Datos------------------\n");
		horarioDatos.limpiarTabla();
		socioDatos.limpiarTabla();		
	} 
  
  
  
  
  
  
}
