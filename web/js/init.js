/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 $(function () {


         $('input:button').addClass('ui-state-default ui-corner-all');
         $('input:button').hover(
                                  function() {
                                      $(this).addClass('ui-state-hover');
                                  },
                                  function() {
                                      $(this).removeClass('ui-state-hover');
                                  }
                                );
         $('input:submit').addClass('ui-state-default ui-corner-all');
         $('input:submit').hover(
                                  function() {
                                      $(this).addClass('ui-state-hover');
                                  },
                                  function() {
                                      $(this).removeClass('ui-state-hover');
                                  }
                                );

         $('form').submit(function() { return false; })

         $.ajaxSetup(
                               {
                                 beforeSend: function() {
                                 $('#msg').dialog(
                                        {
                                         resizable:false,
                                         draggable:false,
                                         modal:true,
                                         closeOnScape:false
                                        }
                                   )
                                   .html('<span style="text-align:center,font-size:14px;font-weight:bold;margin:auto">Cargando, espere...</span><br/><p style=\"text-align:center\"><img src="/evento/app/css/cargando.gif"/></p>')
                                 },
                                 error: function(html) {
                                   $('#msg').dialog(
                                     {
                                       resizable: false,
                                       draggable: false,
                                       modal: true,
                                       closeOnScape: false,
                                       buttons: {'Aceptar': function(){
                                                  $(this).dialog('close');
                                                }
                                       }
                                      }
                                      ).html(html);
                                 },
                                 stop: function() {
                                    $('#msg').dialog('destroy').fadeOut(1000);
                                 }
                               }
                     );
 });