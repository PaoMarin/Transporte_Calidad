package datos;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.*;


public class HorarioD {
	
	private AccesoDatosPostgres conexion;
    private boolean error;
    private String errorMsg;
    
    
    private void limpiarError() {
        this.error = false;
        this.errorMsg = "";
    }
     
     public HorarioD() {
        this.conexion = AccesoDatosPostgres.getInstance();
        this.limpiarError();
    }
     
     
     public void agregarHorario(HorarioE pHorarioE){
         this.limpiarError();
         //java.sql.Timestamp fechaSQL = new java.sql.Timestamp(pEmpleadoE.getFechaNacimiento().getTime());
                 
         try{
             String sql = "INSERT INTO horarios(codigo, numero_bus, descripcion_horario, tiempo_salida, tiempo_llegada, estado) " +
                          "VALUES (?, ?, ?, ?, ?, ?)";
             
             
             Parametro[] parametros = new Parametro[6];
             parametros[0] = new Parametro(Parametro.STRING, pHorarioE.getCodigo());
             parametros[1] = new Parametro(Parametro.STRING, pHorarioE.getNumeroBus());
             parametros[2] = new Parametro(Parametro.STRING, pHorarioE.getDescripcionHorario());             
             parametros[3] = new Parametro(Parametro.TIME, pHorarioE.getTiempoSalida());
             parametros[4] = new Parametro(Parametro.TIME, pHorarioE.getTiempoLlegada());
             parametros[5] = new Parametro(Parametro.BOOLEAN, pHorarioE.getEstado());
            
             this.conexion.ejecutarSQL(sql, parametros);
             
             if(this.conexion.isError()){
                 this.error = true;
                 this.errorMsg = this.conexion.getErrorMsg();
                 
             }
             
         }catch(Exception e){
             this.error = true;
             this.errorMsg = e.getMessage();
             
         }
         
         
     }
     
     public HorarioE buscarHorario(String pCodigo) {
    	 
    	 this.limpiarError();
         HorarioE oHorarioE = new HorarioE();
         Parametro[] parametros = new Parametro[2];
         parametros[0] = new Parametro(Parametro.STRING, pCodigo);
         parametros[1] = new Parametro(Parametro.BOOLEAN, true);
         try{
             ResultSet rs = this.conexion.ejecutarConsultaSQL(
                 "SELECT h.* " +
                       
                 "FROM horarios h " +
         
                 "WHERE h.codigo = ? " +
                 "AND h.estado = ? ", parametros); 
             
             if(!this.conexion.isError()){
                 while(rs.next()){
                	 
                	 HorarioE oH = new HorarioE(
                			 					rs.getString("codigo"),
                			 					rs.getString("numero_bus"),
                			 					rs.getString("descripcion_horario"),
                			 					rs.getString("tiempo_salida"),
                			 					rs.getString("tiempo_llegada"),
                			 					rs.getBoolean("estado")
                			 );
                     oHorarioE = oH;                  
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
         return oHorarioE;
    	 
     }//buscarHorario
     
     
     public void eliminarHorario(String pCodigo) {
    	 this.limpiarError();
              
         try{
             String sql = "UPDATE horarios SET estado = ? " +
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
    	 
    	 
     }//eliminarHorario
     
     
 public HorarioE busquedaParaModificar(String pCodigo) {
    	 
    	 this.limpiarError();
         HorarioE oHorarioE = new HorarioE();
         Parametro[] parametros = new Parametro[1];
         parametros[0] = new Parametro(Parametro.STRING, pCodigo);

         try{
             ResultSet rs = this.conexion.ejecutarConsultaSQL(
                 "SELECT h.* " +
                       
                 "FROM horarios h " +
         
                 "WHERE h.codigo = ? ", parametros); 
             
             if(!this.conexion.isError()){
                 while(rs.next()){
                	 
                	 HorarioE oH = new HorarioE(
                			 					rs.getString("codigo"),
                			 					rs.getString("numero_bus"),
                			 					rs.getString("descripcion_horario"),
                			 					rs.getString("tiempo_salida"),
                			 					rs.getString("tiempo_llegada"),
                			 					rs.getBoolean("estado")
                			 );
                     oHorarioE = oH;                  
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
         return oHorarioE;
    	 
     }//busquedaParaModificar
 
 	public void modificarHorario(HorarioE pHorarioModificar) {
 		this.limpiarError();
        
        try{
            String sql = "UPDATE horarios SET numero_bus = ? , descripcion_horario = ? ,  tiempo_salida = ? , tiempo_llegada = ? , estado = ? " +
                         "WHERE codigo = ?";
            
            Parametro[] parametros = new Parametro[6];
            parametros[0] = new Parametro(Parametro.STRING, pHorarioModificar.getNumeroBus());
            parametros[1] = new Parametro(Parametro.STRING, pHorarioModificar.getDescripcionHorario());
            parametros[2] = new Parametro(Parametro.TIME, pHorarioModificar.getTiempoSalida());
            parametros[3] = new Parametro(Parametro.TIME, pHorarioModificar.getTiempoLlegada());
            parametros[4] = new Parametro(Parametro.BOOLEAN, pHorarioModificar.getEstado());
            parametros[5] = new Parametro(Parametro.STRING, pHorarioModificar.getCodigo());
           
            
            this.conexion.ejecutarSQL(sql, parametros);
            
            if(this.conexion.isError()){
                this.error = true;
                this.errorMsg = this.conexion.getErrorMsg();
                
            }
            
        }catch(Exception e){
            this.error = true;
            this.errorMsg = e.getMessage();
            
        }
 	}//modificarHorario
 
 
 	public ArrayList<HorarioE> reporteHorariosPorUnidadBus(String pNumeroBus) {
 		this.limpiarError();
        //List<MyObject> list = new ArrayList<MyObject>();
        ArrayList<HorarioE> horariosPorUnidad = new ArrayList<HorarioE>();
        Parametro[] parametros = new Parametro[1];
        parametros[0] = new Parametro(Parametro.STRING, pNumeroBus);
      
        try{
            ResultSet rs = this.conexion.ejecutarConsultaSQL(
                "SELECT h.* " +
                "FROM horarios h " +
                "WHERE h.numero_bus = ? " +        
                "ORDER BY h.tiempo_salida" , parametros);
            
            if(!this.conexion.isError()){
                while(rs.next()){
                    
                	HorarioE oH = new HorarioE(
		 					rs.getString("codigo"),
		 					rs.getString("numero_bus"),
		 					rs.getString("descripcion_horario"),
		 					rs.getString("tiempo_salida"),
		 					rs.getString("tiempo_llegada"),
		 					rs.getBoolean("estado")
                			);
                	
                	horariosPorUnidad.add(oH);   
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
        return horariosPorUnidad;
 		
 	}//reporteHorariosPorUnidadBus 
 	
 	public void limpiarTabla() {
 	   	 this.limpiarError();
 	             
 	        try{
 	            String sql = "DELETE FROM horarios";           
 	            
 	            this.conexion.ejecutarSQL(sql);
 	            
 	            if(this.conexion.isError()){
 	                this.error = true;
 	                this.errorMsg = this.conexion.getErrorMsg();
 	                
 	            }
 	            
 	        }catch(Exception e){
 	            this.error = true;
 	            this.errorMsg = e.getMessage();
 	            
 	        }
 	   	 
 	   	 
 	    }//limpiarTablaHorario
 
 
     
	
	
	

}//class HorarioD
