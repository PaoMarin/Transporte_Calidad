package datos;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.*;


public class RecorridoD {
	private AccesoDatosPostgres conexion;
    private boolean error;
    private String errorMsg;
    
    
    private void limpiarError() {
        this.error = false;
        this.errorMsg = "";
    }
     
     public RecorridoD() {
        this.conexion = AccesoDatosPostgres.getInstance();
        this.limpiarError();
    }
     
     public boolean agregarRecorrido(RecorridoE pRecorridoE){
         this.limpiarError();
         
                 
         try{
             String sql = "INSERT INTO schtransporte.recorridos(codigo, numero_bus, descripcion_recorrido, tiempo_demora, zona_recorrido,cantidad_recorridos, estado) " +
                          "VALUES (?, ?, ?, ?, ?, ?, ?)";
             
             
             Parametro[] parametros = new Parametro[7];
             parametros[0] = new Parametro(Parametro.STRING, pRecorridoE.getCodigo());
             parametros[1] = new Parametro(Parametro.STRING, pRecorridoE.getNumeroBus());
             parametros[2] = new Parametro(Parametro.STRING, pRecorridoE.getDescripcionRecorrido());             
             parametros[3] = new Parametro(Parametro.TIME, pRecorridoE.getTiempoDemora());
             parametros[4] = new Parametro(Parametro.STRING, pRecorridoE.getZonaRecorrido());
             parametros[5] = new Parametro(Parametro.INT, pRecorridoE.getCantidadRecorrido());
             parametros[6] = new Parametro(Parametro.BOOLEAN, pRecorridoE.getEstado());
            
             this.conexion.ejecutarSQL(sql, parametros);
             
             if(this.conexion.isError()){
                 this.error = true;
                 this.errorMsg = this.conexion.getErrorMsg();
                 
             }
             
         }catch(Exception e){
             this.error = true;
             this.errorMsg = e.getMessage();
             
         }
         
         return this.error;
         
         
     }
     
 public RecorridoE buscarRecorrido(String pCodigo) {
    	 
    	 this.limpiarError(); 
         RecorridoE oRecorridoE = new RecorridoE();
         Parametro[] parametros = new Parametro[2];
         parametros[0] = new Parametro(Parametro.STRING, pCodigo);
         parametros[1] = new Parametro(Parametro.BOOLEAN, true);
         try{
             ResultSet rs = this.conexion.ejecutarConsultaSQL(
                 "SELECT r.* " +
                       
                 "FROM schtransporte.recorridos r " +
         
                 "WHERE r.codigo = ? " +
                 "AND r.estado = ? ", parametros); 
             
             if(!this.conexion.isError()){
                 while(rs.next()){
                	 RecorridoE oR = new RecorridoE(
                			 					rs.getString("codigo"),
                			 					rs.getString("numero_bus"),
                			 					rs.getString("descripcion_recorrido"),
                			 					rs.getString("tiempo_demora"),
                			 					rs.getString("zona_recorrido"),
                			 					rs.getInt("cantidad_recorridos"),
                			 					rs.getBoolean("estado")
                			 );
                     oRecorridoE = oR;                  
                 }
                 rs.close();
             }else{
                 this.error = true;
                 this.errorMsg = this.conexion.getErrorMsg();
             }     
             
         }catch (Exception e) {
             this.error = true;
             this.errorMsg = e.getMessage();                    
         }
         return oRecorridoE;
    	 
     }//buscarRecorrido
 
	 public RecorridoE busquedaParaModificar(String pCodigo) {
		 
		 this.limpiarError();
	     RecorridoE oRecorridoE = new RecorridoE();
	     Parametro[] parametros = new Parametro[1];
	     parametros[0] = new Parametro(Parametro.STRING, pCodigo);
	
	     try{
	         ResultSet rs = this.conexion.ejecutarConsultaSQL(
	             "SELECT r.* " +
	                   
	             "FROM schtransporte.recorridos r " +
	     
	             "WHERE r.codigo = ? ", parametros); 
	         
	         if(!this.conexion.isError()){
	             while(rs.next()){
	            	 
	            	 RecorridoE oR = new RecorridoE(
	 					rs.getString("codigo"),
	 					rs.getString("numero_bus"),
	 					rs.getString("descripcion_recorrido"),
	 					rs.getString("tiempo_demora"),
	 					rs.getString("zona_recorrido"),
	 					rs.getInt("cantidad_recorridos"),
	 					rs.getBoolean("estado")
	 				);
	 					oRecorridoE = oR;           
	             }
	             rs.close();
	         }else{
	             this.error = true;
	             this.errorMsg = this.conexion.getErrorMsg();
	         }     
	         
	     }catch (Exception e) {
	         this.error = true;
	         this.errorMsg = e.getMessage();                    
	     }
	     return oRecorridoE;
		 
	 }//busquedaParaModificar
	
		public void modificarRecorrido(RecorridoE pRecorridoModificar, String pCodigo) {
			this.limpiarError();
	    
			try{
	        String sql = "UPDATE schtransporte.recorridos SET numero_bus = ? , descripcion_recorrido = ? ,  tiempo_demora = ? , zona_recorrido = ? , cantidad_recorridos = ? , estado = ? " +
		                     "WHERE codigo = ?";
		        
		        Parametro[] parametros = new Parametro[7];
	            parametros[6] = new Parametro(Parametro.STRING, pRecorridoModificar.getCodigo());
	            parametros[0] = new Parametro(Parametro.STRING, pRecorridoModificar.getNumeroBus());
	            parametros[1] = new Parametro(Parametro.STRING, pRecorridoModificar.getDescripcionRecorrido());             
	            parametros[2] = new Parametro(Parametro.TIME, pRecorridoModificar.getTiempoDemora());
	            parametros[3] = new Parametro(Parametro.STRING, pRecorridoModificar.getZonaRecorrido());
	            parametros[4] = new Parametro(Parametro.INT, pRecorridoModificar.getCantidadRecorrido());
	            parametros[5] = new Parametro(Parametro.BOOLEAN, pRecorridoModificar.getEstado());
		       
		        
		        this.conexion.ejecutarSQL(sql, parametros);
		        
		        if(this.conexion.isError()){
		            this.error = true;
		            this.errorMsg = this.conexion.getErrorMsg();
		            
		        }
	        
			}catch(Exception e){
	        this.error = true;
	        this.errorMsg = e.getMessage();
	        
			}
		}//modificarRecorrido
		
		public boolean modificarCodigoRecorrido(RecorridoE pRecorridoModificar, String pCodigo) {
			this.limpiarError();
	    
			try{
	        String sql = "UPDATE schtransporte.recorridos SET codigo = ? , numero_bus = ? , descripcion_recorrido = ? ,  tiempo_demora = ? , zona_recorrido = ? , cantidad_recorridos = ? , estado = ? " +
		                     "WHERE codigo = ?";
		        
		        Parametro[] parametros = new Parametro[8];
		        parametros[0] = new Parametro(Parametro.STRING, pRecorridoModificar.getCodigo());
	            parametros[1] = new Parametro(Parametro.STRING, pRecorridoModificar.getNumeroBus());
	            parametros[2] = new Parametro(Parametro.STRING, pRecorridoModificar.getDescripcionRecorrido());             
	            parametros[3] = new Parametro(Parametro.TIME, pRecorridoModificar.getTiempoDemora());
	            parametros[4] = new Parametro(Parametro.STRING, pRecorridoModificar.getZonaRecorrido());
	            parametros[5] = new Parametro(Parametro.INT, pRecorridoModificar.getCantidadRecorrido());
	            parametros[6] = new Parametro(Parametro.BOOLEAN, pRecorridoModificar.getEstado());
	            parametros[7] = new Parametro(Parametro.STRING, pRecorridoModificar.getCodigo());
		       
		        
		        this.conexion.ejecutarSQL(sql, parametros);
		        
		        if(this.conexion.isError()){
		            this.error = true;
		            this.errorMsg = this.conexion.getErrorMsg();
		            
		        }
	        
			}catch(Exception e){
	        this.error = true;
	        this.errorMsg = e.getMessage();
	        
			}
			return this.error;
		}//modificarRecorrido
		
		 public void eliminarRecorrido(String pCodigo) {
	    	 this.limpiarError();
	              
	         try{
	             String sql = "UPDATE schtransporte.recorridos SET estado = ? " +
	                          "WHERE codigo = ?";
	             
	             Parametro[] parametros = new Parametro[2];
	             parametros[0] = new Parametro(Parametro.BOOLEAN, false);
	             parametros[1] = new Parametro(Parametro.STRING, pCodigo);
	            
	             
	             this.conexion.ejecutarSQL(sql, parametros);
	             
	             if(this.conexion.isError()){
	                 this.error = true;
	                 this.errorMsg = this.conexion.getErrorMsg();
	                 
	             }
	             
	         }catch(Exception e){
	             this.error = true;
	             this.errorMsg = e.getMessage();
	             
	         }
	    	 
	    	 
	     }//eliminarRecorrido
		 
		 public ArrayList<RecorridoE> reporteRecorridosPorUnidadBus(String pNumeroBus) {
		 		this.limpiarError();
		        //List<MyObject> list = new ArrayList<MyObject>();
		        ArrayList<RecorridoE> recorridosPorUnidad = new ArrayList<RecorridoE>();
		        Parametro[] parametros = new Parametro[1];
		        parametros[0] = new Parametro(Parametro.STRING, pNumeroBus);
		      
		        try{
		            ResultSet rs = this.conexion.ejecutarConsultaSQL(
		                "SELECT r.* " +
		                "FROM schtransporte.recorridos r " +
		                "WHERE r.numero_bus = ? " +        
		                "ORDER BY h.tiempo_demora" , parametros);
		            
		            if(!this.conexion.isError()){
		                while(rs.next()){
		                    
		                	RecorridoE oR = new RecorridoE(
		                			rs.getString("codigo"),
		    	 					rs.getString("numero_bus"),
		    	 					rs.getString("descripcion_recorrido"),
		    	 					rs.getString("tiempo_demora"),
		    	 					rs.getString("zona_recorrido"),
		    	 					rs.getInt("cantidad_recorridos"),
		    	 					rs.getBoolean("estado")
		                			);
		                	
		                	
		                	recorridosPorUnidad.add(oR);   
		                }
		                rs.close();
		            }else{
		                this.error = true;
		                this.errorMsg = this.conexion.getErrorMsg();
		            }     
		            
		        }catch (Exception e) {
		            this.error = true;
		            this.errorMsg = e.getMessage();                    
		        }
		        return recorridosPorUnidad;
		 		
		 	}//reporteRecorridosPorUnidadBus 
	

}
