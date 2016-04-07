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
import java.sql.SQLException;
import java.sql.ResultSet;
import mx.mig.dbc.Dao;

public class Tipodeuda implements Serializable {
    
    private Long tideTipo;
    private String tideDescrip;
    private Float tideMonto;
    
    private String error;

    public Float getTideMonto() {
        return tideMonto;
    }

    public void setTideMonto(Float tideMonto) {
        this.tideMonto = tideMonto;
    }

    
    
    
    public String getTideDescrip() {
        return tideDescrip;
    }

    public Long getTideTipo() {
        return tideTipo;
    }

    public void setTideDescrip(String tideDescrip) {
        this.tideDescrip = tideDescrip;
    }

    public void setTideTipo(Long tideTipo) {
        this.tideTipo = tideTipo;
    }
    
    public String getError() {
        return error;
    }
    
    
    public Tipodeuda selTipodeuda(Long tipo) {
        
        Tipodeuda tde = null;
        
        try {
            
            Dao dao = new Dao();            
            ResultSet rst = dao.consultar("Select * From TipoDeuda Where tide_tipo = '"+tipo+"'");
            
            while (rst != null && rst.next()) {
                tde = new Tipodeuda();
                tde.setTideTipo(rst.getLong("tide_tipo"));
                tde.setTideDescrip(rst.getString("tide_descrip"));
                tde.setTideMonto(rst.getFloat("tide_monto"));
            }
            
            dao.desconectar();
            
        } catch (SQLException e) {
            error = e.getMessage();
        } catch (IOException e) {
            error = e.getMessage();
        }
        
      return tde;  
    }
    
    
    public List<Tipodeuda> selTipodeudas(String condicion) {
        
        Tipodeuda tde = null;
        List<Tipodeuda> lista = new ArrayList();
        
        try {
            
            Dao dao = new Dao();            
            ResultSet rst = dao.consultar("Select * From TipoDeuda "+condicion);
            
            while (rst != null && rst.next()) {
                tde = new Tipodeuda();
                tde.setTideTipo(rst.getLong("tide_tipo"));
                tde.setTideDescrip(rst.getString("tide_descrip"));
                tde.setTideMonto(rst.getFloat("tide_monto"));
                lista.add(tde);
            }
            
            dao.desconectar();
            
        } catch (SQLException e) {
            error = e.getMessage();
        } catch (IOException e) {
            error = e.getMessage();
        }
        
      return lista;  
    }
    
    
    
   
            
    
    
}
