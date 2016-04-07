/*
 * Autor: Miguel Angel Cedeno Garciduenas
 * miguecg@gmail.com
 * 
 */

package congreso.serv;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import congreso.beans.Participante;
import congreso.beans.Deuda;
import congreso.beans.Tipodeuda;

/**
 *
 * @author miguel
 */
public class ServRegDatos extends HttpServlet {
   
       @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
           if (request.getParameter("opcion") != null && request.getParameter("opcion").equals("registrar_datos")) {
            
               // Recupero datos...
               // Armo objetos
               String nombre = request.getParameter("nombre");
               String apepat = request.getParameter("apepat");
               String apemat = request.getParameter("apemat");
               String calle = request.getParameter("calle");
               String colonia = request.getParameter("colonia");
               String numero = request.getParameter("numero");
               String pais = request.getParameter("Pais");
               String estado = request.getParameter("Estado");
               String mpo = request.getParameter("Mpo");
               String cp = request.getParameter("cp");
               String email = request.getParameter("email");
               String inscrip = request.getParameter("inscrip");
               
              String msg = null; 
              Long idp = 0L;
             try {  
                 
               // Agregamos el participante  
               Participante part = new Participante();              
               idp = part.secuencia();
               part.setPartParticipante(idp);
               part.setPartNombre(nombre);
               part.setPartApepat(apepat);
               part.setPartApemat(apemat);
               part.setPartCalle(calle);
               part.setPartColonia(colonia);
               part.setPartCp(cp);
               part.setPartMpo(mpo);
               part.setPartEmail(email);
               part.setPartPais(pais);
               part.setPartEdo(estado);
               part.setPartNumero(numero);
               part.agregar(part);
               
               // Revisamos que no haya errores
               msg = part.getError();
               if (msg != null) System.out.println(msg); 
               // agregamos deuda
               //
               Deuda deu = new Deuda();
               Long seqd = deu.secuencia();
               deu.setDeudaDeuda(seqd);
               deu.setDeudTipo(Long.valueOf(inscrip));
               deu.setDeudParticipante(idp);
               
               int rt = deu.agregar(deu);
               
               msg = deu.getError();
               // Si es ponente agregamoxs ponencia
               
               // Si requiere factura
               
             } catch (SQLException e) {
                 msg = e.getMessage();
             } 
               
             // Redirigimos el flujo a la vista que muestra los datos
             if (msg == null) {
                 System.out.println(String.valueOf(idp));
                 this.VeaPagina("/datos_de_registro.jsp?part="+String.valueOf(idp), request, response);
             } else { /// Redirigimos el flujo a que muestre un error
                 request.getSession().setAttribute("error", msg);
                 response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
                 this.VeaPagina("/error.jsp", request, response);
             }
             
               
           } else {
               response.setStatus(HttpServletResponse.SC_NOT_FOUND);
               this.VeaPagina("/error.jsp", request, response);
           }
           
           
    }

  

    private void VeaPagina (String direccion, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(direccion);
            dispatcher.forward(request, response);
    }
}
