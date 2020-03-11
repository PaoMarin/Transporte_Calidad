package app;
import java.util.ArrayList;

import datos.*;
import logica.*;
import utils.*;

public class Main {
	
	public static void main(String args[]) {
		/*SocioE(String pCodigo, String pNombre, String pApellidos, String pLinea, String pNumeroBus,
				int pCapacidadBus, String pAyudante, String pChofer, boolean pEstado)*/
		//AGREGANDO SOCIOS
		SocioE oSocioE = new SocioE("S3", "Armandi", "Rojas Lara", "Thomas", "T2", 45, "Luis", "Ricardo", true);
		System.out.print(oSocioE.toString());
		SocioD oSocioD = new SocioD();
		//oSocioD.agregarSocio(oSocioE);
		
		/*HorarioE(String pCodigo, String pNumeroBus, String pDescripcionHorario, String pTiempoSalida,
				String pTiempoLlegada, boolean pEstado)*/
		//AGREGANDO HORARIOS
		HorarioE oHorarioEAgregar = new HorarioE("H5", "T1", "Horario 5", "06:30:00", "07:45:00", true);
		System.out.print(oHorarioEAgregar.toString());
		HorarioD oHorarioDAgregar = new HorarioD();
		//oHorarioDAgregar.agregarHorario(oHorarioEAgregar);
		
		//BUSCAR HORARIO POR CODIGO
		HorarioE oHorarioEBusqueda = new HorarioE();
		HorarioD oHorarioDBusqueda = new HorarioD();
		oHorarioEBusqueda = oHorarioDBusqueda.buscarHorario("H1");
		System.out.print(oHorarioEBusqueda.toString());
		
		//ELIMINAR HORARIO (DESACTIVAR)
		/*HorarioD oHorarioDEliminar = new HorarioD();
		oHorarioDEliminar.eliminarHorario("H1");
		HorarioE oHorarioEliminado = new HorarioE();
		oHorarioEliminado = oHorarioDEliminar.buscarHorario("H1");
		System.out.print(oHorarioEliminado.toString());*/
		
		//MODIFICAR HORARIO
		HorarioE oHorarioEModificar = new HorarioE();
		HorarioD oHorarioDModificar = new HorarioD();
		//Se busca el horario que se desea modificar  para revisar sus datos
		oHorarioEModificar = oHorarioDModificar.busquedaParaModificar("H1");
		//Se modifican sus datos
		oHorarioEModificar.setNumeroBus("V1");
		oHorarioEModificar.setDescripcionHorario("primero");
		oHorarioEModificar.setTiempoSalida("04:25:00");
		oHorarioEModificar.setTiempoLlegada("05:40:00");
		oHorarioEModificar.setEstado(true);
		//Se envia a modificar sus datos
		oHorarioDModificar.modificarHorario(oHorarioEModificar);
		oHorarioEModificar = oHorarioDModificar.busquedaParaModificar("H1");
		System.out.print(oHorarioEModificar.toString());

		//REPORTE DE HORARIOS POR UNIDAD (BUS)
		ArrayList<HorarioE> horariosPorUnidad = new ArrayList<HorarioE>();
		HorarioD oHorarioDHorariosPorUnidad = new HorarioD();
		horariosPorUnidad = oHorarioDHorariosPorUnidad.reporteHorariosPorUnidadBus("V1");
		for(HorarioE obj : horariosPorUnidad){
			System.out.print("----FOR----");
			System.out.print(obj.toString());
		}				
		
		
		System.out.println("Hello World!!!");
		
		
	}	
				/*RecorridoE(String pCodigo, String pNumeroBus, String pDescripcionRecorrido, String pTiempoDemora,
				String pZonaRecorrido, String pCantidadRecorrido, boolean pEstado)*/
			//AGREGANDO RECORRIDOS
			RecorridoE oRecorridoEAgregar = new RecorridoE("H5", "T1", "Recorrdido A1", "00:25:00", "San Pedro-Desamparados", "6.4", true);
			System.out.print(oRecorridoEAgregar.toString());
			RecorridoD oRecorridoDAgregar = new RecorridoD();
			//oRecorrdioDAgregar.agregarRecorrido(oRecorridoEAgregar);
			
			//BUSCAR RECORRIDO POR CODIGO
			RecorridoE oRecorridoEBusqueda = new RecorridoE();
			RecorridoD oRecorridoDBusqueda = new RecorridoD();
			oRecorridoEBusqueda = oRecorridoDBusqueda.buscarRecorrido("H2");
			System.out.print(oRecorridoEBusqueda.toString());
			
			//ELIMINAR HORARIO (DESACTIVAR)
			/*HorarioD oHorarioDEliminar = new HorarioD();
			oHorarioDEliminar.eliminarHorario("H1");
			HorarioE oHorarioEliminado = new HorarioE();
			oHorarioEliminado = oHorarioDEliminar.buscarHorario("H1");
			System.out.print(oHorarioEliminado.toString());*/
			
			//MODIFICAR HORARIO
			RecorridoE oRecorridoEModificar = new RecorridoE();
			RecorridoD oRecorridoDModificar = new RecorridoD();
			//Se busca el horario que se desea modificar  para revisar sus datos
			oRecorridoEModificar = oRecorridoDModificar.busquedaParaModificar("H2");
			//Se modifican sus datos
			oRecorridoEModificar.setNumeroBus("V1");
			oRecorridoEModificar.setDescripcionHorario("primero");
			oRecorridoEModificar.setTiempoSalida("04:25:00");
			oRecorridoEModificar.setTiempoLlegada("05:40:00");
			oRecorridoEModificar.setEstado(true);
			//Se envia a modificar sus datos
			oRecorridoDModificar.modificarRecorrido(oRecorridoEModificar);
			oRecorridoEModificar = oRecorridoDModificar.busquedaParaModificar("H1");
			System.out.print(oRecorridoEModificar.toString());
			
			//REPORTE DE HORARIOS POR UNIDAD (BUS)
			ArrayList<RecorridoE> recorridosPorUnidad = new ArrayList<RecorridoE>();
			RecorridoD oRecorridoDRecorridosPorUnidad = new HorarioD();
			horariosPorUnidad = oHorarioDHorariosPorUnidad.reporteHorariosPorUnidadBus("V1");
			for(HorarioE obj : horariosPorUnidad){
			System.out.print("----FOR----");
			System.out.print(obj.toString());
			}				
			
			
			System.out.println("Hello World!!!");
			
			
			}	
	

}//class Main
