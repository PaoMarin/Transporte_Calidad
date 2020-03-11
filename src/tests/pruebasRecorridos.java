package tests;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import datos.HorarioD;
import datos.SocioD;
import datos.RecorridoD;
import logica.HorarioE;
import logica.SocioE;
import logica.RecorridoE;;

public class pruebasRecorridos {
  

	SocioE socioPrueba;
	HorarioE nuevoHorario;		
	HorarioE horarioObtenido;
	SocioD socioDatos = new SocioD();
	HorarioD horarioDatos = new HorarioD();	
	
	
	@Test
	public void guardaRecorrido()
	{
		//Act
		RecorridoE oRecorridoE = new RecorridoE("R6", "T2", "Ciudad Quesada Centro", "00:30:00",
				"C.Q", 8, true);
		RecorridoD oRecorridoD = new RecorridoD();
		//Quiere decir que n hay error en la transaccion
		//cada vez que se quiere probar uno nuevo hay que modificar el primer parametro
		boolean resultadoEsperado = false;
		boolean resultadoObtenido;
		resultadoObtenido = oRecorridoD.agregarRecorrido(oRecorridoE);
		
		//Assert regreso de true = exito insertando
		Assert.assertEquals(resultadoEsperado, resultadoObtenido);	
		
	}
	
	@Test
	public void noGuardaRecorridoCamposEnBlanco()
	{
		//Act
		RecorridoE oRecorridoE = new RecorridoE("", "", "Ciudad Quesada Centro", "00:30:00",
				"C.Q", 8, true);
		RecorridoD oRecorridoD = new RecorridoD();
		//Quiere decir que devuelve errores por espacios en blanco en campos criticos
		boolean resultadoEsperado = true;
		boolean resultadoObtenido;
		resultadoObtenido = oRecorridoD.agregarRecorrido(oRecorridoE);
		
		//Assert regreso de true = exito porque se espera el error
		Assert.assertEquals(resultadoEsperado, resultadoObtenido);	
		
	}
	
	@Test
	public void filtrarRecorridoCodigo()
	{
		//Act
		RecorridoD oRecorridoD = new RecorridoD();
		RecorridoE oRecorridoE = new RecorridoE();
		
		String resultadoEsperado = "R1";
		String resultadoObtenido;
		oRecorridoE = oRecorridoD.buscarRecorrido("R1");
		resultadoObtenido = oRecorridoE.getCodigo();			
		
		//Assert si el recorrido existe debe devolver el codigo del mismo para ser exitoso
		Assert.assertEquals(resultadoEsperado, resultadoObtenido);	
		
	}
	

	@Test
	public void modificarRecorrido()
	{
		//Act
		RecorridoD oRecorridoD = new RecorridoD();
		RecorridoE oRecorridoE = new RecorridoE("R2", "T2", "Ciudad Quesada Centro", "00:30:00",
				"C.Q", 15, true);
		String cordigoRecorrido = "R2";
		//Modificamos la cantidad de recorridos
		oRecorridoD.modificarRecorrido(oRecorridoE, cordigoRecorrido);
		//Buscamos el rrecorrido recientemente modificado
		oRecorridoE = oRecorridoD.buscarRecorrido("R2");
		int resultadoEsperado = 15;
		int resultadoObtenido = oRecorridoE.getCantidadRecorrido();		
		
		//Assert modifica, busca modificado y compara si realmente fue modificado
		Assert.assertEquals(resultadoEsperado, resultadoObtenido);	
		
	}
	
	
	@Test
	public void noModificaCodigoRecorrido()
	{
		//Act
		RecorridoD oRecorridoD = new RecorridoD();
		RecorridoE oRecorridoE = new RecorridoE("R25", "T2", "Ciudad Quesada Centro", "00:30:00",
				"C.Q", 15, true);
		String cordigoRecorrido = "R2";
		String resultadoEsperado = "R25";
		oRecorridoD.modificarCodigoRecorrido(oRecorridoE, cordigoRecorrido); 	
		oRecorridoE = oRecorridoD.buscarRecorrido("25");
		
		//Assert no se puede modificar el codigo de un rrecorrido por lo tanto deben ser diferentes
		//para tener éxito
		Assert.assertNotEquals(resultadoEsperado, oRecorridoE.getCodigo());	
		
	}
	
	
	@Test
	public void verificarElimine()
	{
		//Act
		RecorridoD oRecorridoD = new RecorridoD();
		String codigoEliminar = "R6";
		oRecorridoD.eliminarRecorrido(codigoEliminar);
		RecorridoE oRecorridoE = new RecorridoE();
		oRecorridoE = oRecorridoD.buscarRecorrido("R6");
		boolean esperado = false;
		boolean obtenido = oRecorridoE.getEstado();
		//Assert se elimina de forma logica(estado false), cuando se trata de bsucar el dato eliminar
		//debe aparece en false
		Assert.assertEquals(esperado, obtenido);	
			
	}
	
	@Test
	public void verificarNoElimineSinCodigo()
	{
		//Act
		RecorridoD oRecorridoD = new RecorridoD();
		String codigoEliminar = "";
		oRecorridoD.eliminarRecorrido(codigoEliminar);
		RecorridoE oRecorridoE = new RecorridoE();
		oRecorridoE = oRecorridoD.buscarRecorrido("R5");
		boolean esperado = false;
		boolean obtenido = oRecorridoE.getEstado();
		Assert.assertNotEquals(esperado, obtenido);
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
