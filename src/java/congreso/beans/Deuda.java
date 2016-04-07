/*
 * Autor: Miguel Angel Cedeno Garciduenas
 * miguecg@gmail.com
 * 
 */


package congreso.beans;

/**
 *
 * @author miguel
 */
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.ResultSet;
import mx.mig.dbc.Dao;

public class Deuda implements Serializable {
    
    private Long deudaDeuda;
    private Long deudParticipante;
    private Long deudTipo;    
    private Date deudFecha;
    private String deudPagada;
    private Date deudFechap;
    private Date deudFechac;
    
    private String error;
    
    public String getError() {
        return this.error;
    }
    

    public Date getDeudFecha() {
        return deudFecha;
    }

    public Date getDeudFechac() {
        return deudFechac;
    }

    public Date getDeudFechap() {
        return deudFechap;
    }

    public String getDeudPagada() {
        return deudPagada;
    }

    public Long getDeudParticipante() {
        return deudParticipante;
    }

    public Long getDeudTipo() {
        return deudTipo;
    }

    public Long getDeudaDeuda() {
        return deudaDeuda;
    }

    public void setDeudFecha(Date deudFecha) {
        this.deudFecha = deudFecha;
    }

    public void setDeudFechac(Date deudFechac) {
        this.deudFechac = deudFechac;
    }

    public void setDeudFechap(Date deudFechap) {
        this.deudFechap = deudFechap;
    }

    public void setDeudPagada(String deudPagada) {
        this.deudPagada = deudPagada;
    }

    public void setDeudParticipante(Long deudParticipante) {
        this.deudParticipante = deudParticipante;
    }

    public void setDeudTipo(Long deudTipo) {
        this.deudTipo = deudTipo;
    }

    public void setDeudaDeuda(Long deudaDeuda) {
        this.deudaDeuda = deudaDeuda;
    }
    
    
    public Deuda selDeuda(Long deu) {
        
        Deuda deuda = null;
        
        try {
            
            Dao dao = new Dao();
            ResultSet rst = dao.consultar("Select * From Deuda Where deud_deuda = '"+deu+"'");
            
            while (rst != null && rst.next()) {
                deuda = new Deuda();
                deuda.setDeudaDeuda(rst.getLong("deud_deuda"));
                deuda.setDeudParticipante(rst.getLong("deud_participante"));
                deuda.setDeudPagada(rst.getString("deud_pagada"));
                deuda.setDeudTipo(rst.getLong("deud_tipo"));
                deuda.setDeudFecha(rst.getDate("deud_fecha"));
                deuda.setDeudFechac(rst.getDate("deud_fechac"));
                deuda.setDeudFechap(rst.getDate("deud_fechap"));                
            }
            
            dao.desconectar();
            
        } catch (SQLException e) {
            
        } catch (IOException e) {
            
        }
      return deuda;  
    }
    
    
    public List<Deuda> selDeudas(String condicion) {
        
        Deuda deuda = null;
        List<Deuda> lista = new ArrayList();
        try {
            
            Dao dao = new Dao();
            ResultSet rst = dao.consultar("Select * From Deuda "+condicion);
            
            while (rst != null && rst.next()) {
                deuda = new Deuda();
                deuda.setDeudaDeuda(rst.getLong("deud_deuda"));
                deuda.setDeudParticipante(rst.getLong("deud_participante"));
                deuda.setDeudPagada(rst.getString("deud_pagada"));
                deuda.setDeudTipo(rst.getLong("deud_tipo"));
                deuda.setDeudFecha(rst.getDate("deud_fecha"));
                deuda.setDeudFechac(rst.getDate("deud_fechac"));
                deuda.setDeudFechap(rst.getDate("deud_fechap"));   
                lista.add(deuda);
            }
            
            dao.desconectar();
            
        } catch (SQLException e) {
            error = e.getMessage();
        } catch (IOException e) {
            error = e.getMessage();
        }
      return lista;  
    }
    
    
    public int agregar(Deuda deu) {
        
        int renglones = 0;
        
        try {
            
            Dao dao = new Dao();
            renglones = dao.insertar("Insert into Deuda (deud_deuda,deud_participante,deud_tipo,deud_fecha,deud_pagada) "
                    + "Values ('"+deu.getDeudaDeuda()+"','"+deu.getDeudParticipante()+"','"+deu.getDeudTipo()+"',now(),'N')");
            
            dao.desconectar();
            
        } catch (SQLException e) {
            error = e.getMessage();
        } catch (IOException e) {
            error = e.getMessage();
        }
        
     return renglones;   
    }
    
    public int saldar(Long deuda) {
        int renglones = 0;
        
        try {
            
            Dao dao = new Dao();
            renglones = dao.actualizar("Update Deuda Set deud_pagada = 'S', deud_fechap = now() Where deud_deuda = '"+deuda+"'");
            
            dao.desconectar();
            
        } catch (SQLException e) {
            error = e.getMessage();
        } catch (IOException e) {
            error = e.getMessage();
        }
        
      return renglones;  
    }
    
    public int cancelar(Long deuda) {
        int renglones = 0;
        
        try {
            
            Dao dao = new Dao();
            renglones = dao.actualizar("Update Deuda Set deud_pagada = 'C', deud_fechac = now() Where deud_deuda = '"+deuda+"'");
            
            dao.desconectar();
            
        } catch (SQLException e) {
            error = e.getMessage();
        } catch (IOException e) {
            error = e.getMessage();
        }
        
      return renglones;  
    }
    
    
    public Long secuencia() throws IOException,SQLException {       
       Long seq = 0L;
       
       try {
         Dao dao = new Dao();
         ResultSet rst = dao.consultar("Select max(deud_deuda)+1 From Deuda ");
       
         while (rst != null && rst.next()) {
           seq = rst.getLong(1);
         }
         
         dao.desconectar();
         
       } catch (SQLException e) {
           error = e.getMessage();
       } catch (IOException ex) {
           error = ex.getMessage();
       }
        
       
     return seq;      
    }
    
    
}
