<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page pageEncoding="UTF-8" contentType="text/html" />

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado</title>
        <link rel="stylesheet" type="text/css" href="${estilo}" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    </head>
    <body>
        <br>
        <h2>Eliminar Modulo</h2>
        <div class="row justify-content-center" >
                
            <form method="post" action="control">
                
           <input type="hidden" name="op" value="deleteModulo">
            <table class="table table-striped" style="width: 500px">
                 <tr>
                   
                    <th>Modulo</th>
                     <c:forEach var="modulo" items="${listado}">
                        <tr>
                            <td> <input type="radio" name="registro" value="${modulo.id}" checked/>
                                ${modulo.titulo}</td> 
                        </tr>
                    </c:forEach>
                    
                 </tr>
                    
                    
                    <td colspan="2"><input type="submit" name="enviar" value="Eliminar" class="btn-primary" /></td>
            </table> 
            
            </form>
        </div>
        <p class="boton"><a href="${contexto}/" class="enlace">Men&uacute; inicial</a></p>
    </body>
</html>