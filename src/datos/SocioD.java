package datos;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.*;

public class SocioD {
	private AccesoDatosPostgres conexion;
    private boolean error;
    private String errorMsg;
    
    
    private void limpiarError() {
        this.error = false;
        this.errorMsg = "";
    }
     
     public SocioD() {
        this.conexion = AccesoDatosPostgres.getInstance();
        this.limpiarError();
    }
     
     
     public void agregarSocio(SocioE pSocioE){
         this.limpiarError();
         //java.sql.Timestamp fechaSQL = new java.sql.Timestamp(pEmpleadoE.getFechaNacimiento().getTime());
         
         try{
             String sql = "INSERT INTO socios(codigo, nombre, apellidos, linea, numero_bus, capacidad_bus, ayudante, chofer, estado) " +
                          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
             
             
             Parametro[] parametros = new Parametro[9];
             parametros[0] = new Parametro(Parametro.STRING, pSocioE.getCodigo());
             parametros[1] = new Parametro(Parametro.STRING, pSocioE.getNombre());
             parametros[2] = new Parametro(Parametro.STRING, pSocioE.getApellidos());
             parametros[3] = new Parametro(Parametro.STRING, pSocioE.getLinea());
             parametros[4] = new Parametro(Parametro.STRING, pSocioE.getNumeroBus());
             parametros[5] = new Parametro(Parametro.INT, pSocioE.getCapacidadBus());
             parametros[6] = new Parametro(Parametro.STRING, pSocioE.getAyudante());
             parametros[7] = new Parametro(Parametro.STRING, pSocioE.getChofer());
             parametros[8] = new Parametro(Parametro.BOOLEAN, pSocioE.getEstado());
            
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
     
     public void limpiarTabla() {
       	 this.limpiarError();
                 
            try{
                String sql = "DELETE FROM socios";           
                
                this.conexion.ejecutarSQL(sql);
                
                if(this.conexion.isError()){
                    this.error = true;
                    this.errorMsg = this.conexion.getErrorMsg();
                    
                }
                
            }catch(Exception e){
                this.error = true;
                this.errorMsg = e.getMessage();
                
            }
       	 
       	 
        }//limpiarTablaSocio
     
     
	

}//class SocioD
