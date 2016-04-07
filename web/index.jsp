<%-- 
    Document   : index
    Created on : 19-jun-2014, 12:37:43
    Author     : miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="/congreso/css/estilos-rev.css"  type="text/css" rel="stylesheet"/>
        <script type="text/javascript" src="/congreso/js/jquery.js"></script>
        <script type="text/javascript" src="/congreso/js/jquery.validaFormulario.js"></script>
        <script type="text/javascript">

            function envia() {
    
                    if ($.validaFormulario({nform: 'forma'})) {
                        alert('Hay errores en sus campos');
                    } else {
                        $.ajax({
                            url: '/congreso/registraDatos.do',
                            data: $('form[name="forma"]').serialize(),
                            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                            type: 'POST',
                            success: function(html) {
                                $('#principal').html(html);
                                $('#msg').html('');
                            }
                        });

                        $('#error').ajaxError(function(event, request, settings) {
                            $('#error').html(request.responseText);
                            $('#aniRPC').html('');
                            $('#aniRPC').fadeOut('slow');
                        });
                    }
                
            }

        </script>


    </head>
    <body>

        <div id="error"></div>
        <div id="aniRPC" style="display:none">

        </div>

        <div id="principal">   
        <form name="forma" method="POST">

            Nombre:
            <div id="ca-nombre">
                <input type="text" name="nombre" maxlength="35" size="35" class="requerido"/>
                <div id="msg-nombre"></div>
            </div>
            <br/>
            
            Primer Apellido:
            <div id="ca-apepat">
                 <input type="text" name="apepat" maxlength="35" size="35" class="requerido"/>
                <div id="msg-apepat"></div>
            </div>
            <br/>
            Segundo Apellido:
            <div id="ca-apemat">
                 <input type="text" name="apemat" maxlength="35" size="35" class="requerido"/>
                <div id="msg-apemat"></div>
            </div>
            <br/>
            Email:
            <div id="ca-email">
                 <input type="text" name="email" maxlength="35" size="35" class="req-email"/>
                <div id="msg-email"></div>
            </div>
            <br/>
            Calle:
            <div id="ca-calle">
                 <input type="text" name="calle" maxlength="35" size="35" class="requerido"/>
                <div id="msg-calle"></div>
            </div>
            <br/>
            Colonia:
            <div id="ca-colonia">
                 <input type="text" name="colonia" maxlength="35" size="35" class="requerido"/>
                <div id="msg-colonia"></div>
            </div>
            <br/>
            Numero:
            <div id="ca-numero">
                 <input type="text" name="numero" maxlength="35" size="35" class="requerido"/>
                <div id="msg-numero"></div>
            </div>
            <br/>
            Pais:
            <div id="ca-Pais">
                 <input type="text" name="Pais" maxlength="35" size="35" class="requerido"/>
                <div id="msg-Pais"></div>
            </div>
            <br/>
            Estado:
            <div id="ca-Estado">
                 <input type="text" name="Estado" maxlength="35" size="35" class="requerido"/>
                <div id="msg-Estado"></div>
            </div>
            <br/>
            Municipio:
            <div id="ca-Mpo">
                 <input type="text" name="Mpo" maxlength="35" size="35" class="requerido"/>
                <div id="msg-Mpo"></div>
            </div>
            <br/>
            C.P.:
            <div id="ca-cp">
                 <input type="text" name="cp" maxlength="35" size="35" class="req-numero"/>
                <div id="msg-cp"></div>
            </div>
            <br/>
            Tipo de inscripci&oacute;n: 
            <%@taglib prefix="ins" uri="/WEB-INF/tlds/inscrip.tld" %>
            
            <div id="ca-inscrip">  
            <ins:inscrip nombre="inscrip"/>
            <div id="msg-inscrip"></div>
            </div>
            <%--
            <div id="" style="display:none">
            <h2>Datos de ponente</h2>
            
            T&oacute;picos: <input type="radio" name="topico" value="P"/>Potencia<br/>
                         <input type="radio" name="topico" value="E"/>Electr&oacute;nica<br/>
                         <input type="radio" name="topico" value="S"/>Sistemas<br/>
                         <input type="file" name="archivo"/>
            
            </div>
            
            <input type="radio" name="fact" value="S"/> Facturar <input type="radio" name="fact" value="N"/> No facturar
            --%>
            <input type="hidden" name="opcion" value="registrar_datos"/>
            <input id="btn" type="button" value="Aceptar" onclick="envia();"/>

        </form>
        </div>
    </body>
</html>
