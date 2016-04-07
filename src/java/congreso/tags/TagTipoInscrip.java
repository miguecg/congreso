/*
 * Autor: Miguel Angel Cedeno Garciduenas
 * miguecg@gmail.com
 * 
 */


package congreso.tags;

/**
 *
 * @author miguel
 */
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import congreso.beans.Tipodeuda;


public class TagTipoInscrip extends BodyTagSupport {
    
    private String nombre;
    private Long tipo;
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public void setSelect(Long tipo) {
        this.tipo = tipo;
    }
    
    
    @Override
    public int doStartTag() throws JspException {
        
        JspWriter out = pageContext.getOut();
        
        try {
            
            Tipodeuda td = new Tipodeuda();
            List<Tipodeuda> tl = td.selTipodeudas(" Order by tide_tipo ");
            
            
            out.println("<ul>");
            
            for (Tipodeuda t : tl) {
                
              if (tipo != null && t.getTideTipo().intValue() == tipo.intValue()) {   
                out.println("<input type=\"radio\" name=\""+nombre+"\" value=\""+t.getTideTipo()+"\" checked/> "+t.getTideDescrip()+" $"+t.getTideMonto());
              } else {
                out.println("<input type=\"radio\" name=\""+nombre+"\" value=\""+t.getTideTipo()+"\"/> "+t.getTideDescrip()+" $"+t.getTideMonto());  
              }  
            }
            
            
            out.println("</ul>");
            
            
        } catch (IOException e) {
            throw new JspException(e);
        }
        
        
      return SKIP_BODY;  
    }
    
    
    
}
