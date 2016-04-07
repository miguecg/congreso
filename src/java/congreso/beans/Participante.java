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
import java.sql.ResultSet;
import java.sql.SQLException;
import mx.mig.dbc.Dao;


public class Participante implements Serializable {
    
    private Long partParticipante;
    private String partNombre;
    private String partApepat;
    private String partApemat;
    private String partEmail;
    private String partCalle;
    private String partColonia;
    private String partNumero;
    private String partCp;
    private String partPais;
    private String partEdo;
    private String partMpo;
    private String partAsistencia;
    private Date partFecha;
    
    private String error;

    public String getPartApemat() {
        return partApemat;
    }

    public String getPartApepat() {
        return partApepat;
    }

    public String getPartAsistencia() {
        return partAsistencia;
    }

    public String getPartCalle() {
        return partCalle;
    }

    public String getPartColonia() {
        return partColonia;
    }

    public String getPartCp() {
        return partCp;
    }

    public String getPartEdo() {
        return partEdo;
    }

    public String getPartEmail() {
        return partEmail;
    }

    public Date getPartFecha() {
        return partFecha;
    }

    public String getPartMpo() {
        return partMpo;
    }

    public String getPartNombre() {
        return partNombre;
    }

    public String getPartNumero() {
        return partNumero;
    }

    public String getPartPais() {
        return partPais;
    }

    public Long getPartParticipante() {
        return partParticipante;
    }

    public void setPartApemat(String partApemat) {
        this.partApemat = partApemat;
    }

    public void setPartApepat(String partApepat) {
        this.partApepat = partApepat;
    }

    public void setPartAsistencia(String partAsistencia) {
        this.partAsistencia = partAsistencia;
    }

    public void setPartCalle(String partCalle) {
        this.partCalle = partCalle;
    }

    public void setPartColonia(String partColonia) {
        this.partColonia = partColonia;
    }

    public void setPartCp(String partCp) {
        this.partCp = partCp;
    }

    public void setPartEdo(String partEdo) {
        this.partEdo = partEdo;
    }

    public void setPartEmail(String partEmail) {
        this.partEmail = partEmail;
    }

    public void setPartFecha(Date partFecha) {
        this.partFecha = partFecha;
    }

    public void setPartMpo(String partMpo) {
        this.partMpo = partMpo;
    }

    public void setPartNombre(String partNombre) {
        this.partNombre = partNombre;
    }

    public void setPartNumero(String partNumero) {
        this.partNumero = partNumero;
    }

    public void setPartPais(String partPais) {
        this.partPais = partPais;
    }

    public void setPartParticipante(Long partParticipante) {
        this.partParticipante = partParticipante;
    }
    
    public Participante selParticipante(Long id) {
        
        Participante part = null;
        
        try {
            
            Dao dao = new Dao();
            ResultSet rst = dao.consultar("Select * From "
                    + "Participante Where part_participante = '"+id+"'");
            
            while (rst != null && rst.next()) {
                part = new Participante();
                part.setPartParticipante(rst.getLong("part_participante"));
                part.setPartNombre(rst.getString("part_nombre"));
                part.setPartApepat(rst.getString("part_apepat"));
                part.setPartApemat(rst.getString("part_apemat"));
                part.setPartCalle(rst.getString("part_calle"));
                part.setPartColonia(rst.getString("part_colonia"));
                part.setPartNumero(rst.getString("part_numero"));                     
                part.setPartCp(rst.getString("part_cp"));
                part.setPartEmail(rst.getString("part_email"));
                part.setPartPais(rst.getString("part_pais"));
                part.setPartEdo(rst.getString("part_edo"));
                part.setPartMpo(rst.getString("part_mpo"));
                part.setPartAsistencia(rst.getString("part_asistencia"));
                part.setPartFecha(rst.getDate("part_fecha"));
            }
            
            dao.desconectar();
            
        } catch (SQLException e) {
            error = e.getMessage();
        } catch (IOException ex) {
            error = ex.getMessage();
        }
        
      return part;
    }
    
    public List<Participante> selParticipantes(String condicion) {
        
        Participante part = null;
        List<Participante> parts = new ArrayList();
        try {
            
            Dao dao = new Dao();
            ResultSet rst = dao.consultar("Select * From "
                    + "Participante "+condicion);
            
            while (rst != null && rst.next()) {
                part = new Participante();
                part.setPartParticipante(rst.getLong("part_participante"));
                part.setPartNombre(rst.getString("part_nombre"));
                part.setPartApepat(rst.getString("part_apepat"));
                part.setPartApemat(rst.getString("part_apemat"));
                part.setPartCalle(rst.getString("part_calle"));
                part.setPartColonia(rst.getString("part_colonia"));
                part.setPartNumero(rst.getString("part_numero"));                
                part.setPartCp(rst.getString("part_cp"));
                part.setPartEmail(rst.getString("part_email"));
                part.setPartPais(rst.getString("part_pais"));
                part.setPartEdo(rst.getString("part_edo"));
                part.setPartMpo(rst.getString("part_mpo"));
                part.setPartAsistencia(rst.getString("part_asistencia"));
                part.setPartFecha(rst.getDate("part_fecha"));
                parts.add(part);
            }
            
            dao.desconectar();
            
        } catch (SQLException e) {
            error = e.getMessage();
        } catch (IOException ex) {
            error = ex.getMessage();
        }
        
      return parts;
    }
    
    
    public int agregar(Participante part) {
        
        int renglones = 0;
        
        try {            
            Dao dao = new Dao();
            renglones = dao.insertar("Insert into Participante "
                                    + "(part_participante,"
                                    + "part_nombre,part_apepat,part_apemat,part_email,"
                                    + "part_pais,part_edo,part_mpo,part_calle,part_colonia,"
                                    + "part_numero,part_cp,part_asistencia,part_fecha) "
                                    + "VALUES ('"+part.getPartParticipante()+"','"+part.getPartNombre()+"',"
                                            + "'"+part.getPartApepat()+"',"
                                            + "'"+part.getPartApemat()+"',"
                                            + "'"+part.getPartEmail()+"',"
                                            + "'"+part.getPartPais()+"',"
                                            + "'"+part.getPartEdo()+"',"
                                            + "'"+part.getPartMpo()+"',"
                                            + "'"+part.getPartCalle()+"',"
                                            + "'"+part.getPartColonia()+"','"+part.getPartNumero()+"',"
                                            + "'"+part.getPartCp()+"',"
                                            + "'N',now())");
            dao.desconectar();
        } catch (SQLException e) {
            error = e.getMessage();
        } catch (IOException ex) {
            error = ex.getMessage();
        }
      return renglones;
    }
    
    
    public int actualizar(Participante part) {
        
        int renglones = 0;
        
        try {
            
           Dao dao = new Dao();
           renglones = dao.actualizar("Update Participante "
                                    + "Set part_nombre = '"+part.getPartNombre()+"',"
                                    + "part_apepat = '"+part.getPartApepat()+"',"
                                    + "part_apemat = '"+part.getPartApemat()+"', "
                                    + "part_email = '"+part.getPartEmail()+"', "
                                    + "part_edo = '"+part.getPartEdo()+"', "
                                    + "part_pais = '"+part.getPartPais()+"', part_mpo = '"+part.getPartMpo()+"',"
                                    + "part_calle = '"+part.getPartCalle()+"', part_colonia = '"+part.getPartColonia()+"',"
                                    + "part_numero = '"+part.getPartNumero()+"', "
                                    + "part_cp = '"+part.getPartCp()+"', part_asistencia = '"+part.getPartAsistencia()+"' "
                                    + "Where part_participante = '"+part.getPartParticipante()+"' "
                                    );
            dao.desconectar();
            
        } catch (SQLException e) {
            error = e.getMessage();
        } catch (IOException ex) {
            error = ex.getMessage();
        }
        
        
      return renglones;  
    }
    
    
    public String getError() {
        return error;
    }
    
    
    public Long secuencia() throws IOException,SQLException {       
       Long seq = 0L;
       
       try {
         Dao dao = new Dao();
         ResultSet rst = dao.consultar("Select max(part_participante)+1 From Participante ");
       
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
