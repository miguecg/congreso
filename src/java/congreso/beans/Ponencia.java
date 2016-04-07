/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

public class Ponencia implements Serializable {
    
    private Long ponePonencia;
    private String poneUsuario;
    private String poneArchivo;
    private String poneDictamen;
    private Date poneFechaD;
    private Date poneFecha;
    private Long poneParticipante;
    private String poneTipo;

    private String error;
    
    public String getPoneArchivo() {
        return poneArchivo;
    }

    public String getPoneDictamen() {
        return poneDictamen;
    }

    public Date getPoneFecha() {
        return poneFecha;
    }

    public Date getPoneFechaD() {
        return poneFechaD;
    }

    public Long getPoneParticipante() {
        return poneParticipante;
    }

    public Long getPonePonencia() {
        return ponePonencia;
    }

    public String getPoneTipo() {
        return poneTipo;
    }

    public String getPoneUsuario() {
        return poneUsuario;
    }

    public void setPoneArchivo(String poneArchivo) {
        this.poneArchivo = poneArchivo;
    }

    public void setPoneDictamen(String poneDictamen) {
        this.poneDictamen = poneDictamen;
    }

    public void setPoneFecha(Date poneFecha) {
        this.poneFecha = poneFecha;
    }

    public void setPoneFechaD(Date poneFechaD) {
        this.poneFechaD = poneFechaD;
    }

    public void setPoneParticipante(Long poneParticipante) {
        this.poneParticipante = poneParticipante;
    }

    public void setPonePonencia(Long ponePonencia) {
        this.ponePonencia = ponePonencia;
    }

    public void setPoneTipo(String poneTipo) {
        this.poneTipo = poneTipo;
    }

    public void setPoneUsuario(String poneUsuario) {
        this.poneUsuario = poneUsuario;
    }
    
    public String getError() {
        return this.error;
    }
    
    
    public Ponencia selPonencia(Long pone) {
        
        Ponencia pon = null;
        
        try {
            
            Dao dao = new Dao();
            ResultSet rst = dao.consultar("Select * From Ponencia Where pone_ponencia = '"+pone+"' ");
            
            while (rst != null && rst.next()) {
                pon = new Ponencia();
                pon.setPonePonencia(rst.getLong("pone_ponencia"));
                pon.setPoneArchivo(rst.getString("pone_archivo"));
                pon.setPoneDictamen(rst.getString("pone_dictamen"));
                pon.setPoneFecha(rst.getDate("pone_fecha"));
                pon.setPoneFechaD(rst.getDate("ponde_fechad"));
                pon.setPoneParticipante(rst.getLong("pone_participante"));
                pon.setPoneTipo(rst.getString("pone_tipo"));
                pon.setPoneUsuario(rst.getString("pone_usuario"));
            }
            
            dao.desconectar();
            
        } catch (SQLException e) {
            error = e.getMessage();
        } catch (IOException e) {
            error = e.getMessage();
        }
        
     return pon;   
    }
     
    
    public List<Ponencia> selPonencias(String condicion) {
        
        List<Ponencia> lista = new ArrayList();
        
        try {
            
            Dao dao = new Dao();
            ResultSet rst = dao.consultar("Select * From Ponencia "+condicion);
            
            while (rst != null && rst.next()) {
                Ponencia pon = new Ponencia();
                pon.setPonePonencia(rst.getLong("pone_ponencia"));
                pon.setPoneArchivo(rst.getString("pone_archivo"));
                pon.setPoneDictamen(rst.getString("pone_dictamen"));
                pon.setPoneFecha(rst.getDate("pone_fecha"));
                pon.setPoneFechaD(rst.getDate("ponde_fechad"));
                pon.setPoneParticipante(rst.getLong("pone_participante"));
                pon.setPoneTipo(rst.getString("pone_tipo"));
                pon.setPoneUsuario(rst.getString("pone_usuario"));
                lista.add(pon);
                
            }
            
            dao.desconectar();
            
        } catch (SQLException e) {
            error = e.getMessage();
        } catch (IOException e) {
            error = e.getMessage();
        }
        
     return lista;   
    }
    
    
    public int agregar(Ponencia pone) {
        int renglones = 0;
        
        try {
            
            Dao dao = new Dao();
            renglones = dao.insertar("Insert into Ponencia "
                    + "(pone_ponencia,pone_usuario,pone_archivo,pone_dictamen,pone_fecha,pone_participante,pone_tipo) "
                    + "VALUES ('"+pone.getPonePonencia()+"',"
                    + "'"+pone.getPoneUsuario()+"',"
                    + "'"+pone.getPoneArchivo()+"','"+pone.getPoneDictamen()+"',now(),'"+pone.getPoneParticipante()+"','"+pone.getPoneTipo()+"')");
            
            dao.desconectar();
            
        } catch (SQLException e) {
            error = e.getMessage();
        } catch (IOException e) {
            error = e.getMessage();
        }
        
      return renglones;  
    }
    
    public int actualizar(Ponencia pone) {
        
        int renglones = 0;
        
        try {
            
            Dao dao = new Dao();
            renglones = dao.actualizar("Update Ponencia "
                    + " Set pone_usuario = '"+pone.getPonePonencia()+"',pone_archivo = '"+pone.getPoneArchivo()+"',"
                    + "pone_dictamen = '"+pone.getPoneDictamen()+"',pone_fecha = now(),pone_participante = '"+pone.getPoneParticipante()+"',pone_tipo= '"+pone.getPoneTipo()+"', "
                    + "Where pone_ponencia = '"+pone.getPonePonencia()+"' "
                    );
            
            dao.desconectar();
            
        } catch (SQLException e) {
            error = e.getMessage();
        } catch (IOException e) {
            error = e.getMessage();
        }
        
      return renglones;          
    }
    
    
    public int dictaminar(Long pone,String dictamen) {
        
        int renglones = 0;
        
        try {
            
            Dao dao = new Dao();
            renglones = dao.actualizar("Update Ponencia Set pone_dictamen = '"+dictamen+"' Where pone_ponencia = '"+pone+"'");
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
         ResultSet rst = dao.consultar("Select max(part_participante)+1 From Ponencia ");
       
         if (rst != null && rst.next()) {
           rst.next();
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
