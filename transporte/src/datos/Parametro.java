package datos;
import java.sql.Date;
import java.sql.Timestamp;
import java.sql.Time;


public class Parametro {
    public static final int STRING = 1;
    public static final int DOUBLE = 2;
    public static final int INT = 3;
    public static final int DATETIME = 4;
    public static final int TIMESTAMP = 5;
    public static final int BOOLEAN = 6;
    public static final int TIME = 7;
    
    private int tipo;
    private Object valor;
    
    public Parametro(int pTipo, Object pValor)
    {
        this.tipo = pTipo;
        this.valor = pValor;
    }
    
    public int getTipo()
    {
        return this.tipo;
    }
    
    public String getValorString()
    {
        return String.valueOf(this.valor);
    }
    
    public int getValorInt()
    {
        return Integer.parseInt(this.valor.toString());
    }
    
    public double getValorDouble()
    {
        return Double.parseDouble(this.valor.toString());
    }
    
    public Date getValorDate()
    {
        return (Date)this.valor;
    }
    
    public Timestamp getValorTimeStamp()
    {
        return (Timestamp)this.valor;
    }
    
    public Boolean getValorBoolean()
    {
        return (Boolean)this.valor;
    }
    
    public Time getValorTime()
    {
        return (Time)this.valor;
    }
}
