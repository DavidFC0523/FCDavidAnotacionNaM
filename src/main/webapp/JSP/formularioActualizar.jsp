<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page pageEncoding="UTF-8" contentType="text/html" />

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar</title>
        <link rel="stylesheet" type="text/css" href="${estilo}" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    </head>
    <body>
        <h2>Actualizaci&oacute;n de datos</h2>
        <br>
        <div class="row justify-content-center" >
            <form method="post" action="conclusion">
                <input type="hidden" name="op" value="update">
                <table  class="table table-striped" style="width: 500px" id="formulario">

                    <input type="hidden" name="id" value="${profesor.id}">

                    <tr>
                        <td>Nombre Profesor</td>
                        <td><input type="text" name="nombre" value="${profesor.nombre}" required/></td>
                    </tr>
                    <c:forEach var="modulos" items="${profesor.modulos}">
                        <tr>
                            <td>Nombre Modulo</td>
                        <input type="hidden" name="idModulo" value="${modulos.id}"">
                        <td><input type="text" name="nombreModulo" value="${modulos.titulo}"/></td>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td>Modulo</td>
                        <td>
                            <select name="modulosExistentes">

                                <option value="-1">Seleccione</option>

                                <c:forEach var="modulos" items="${listado}">

                                    <option value="${modulos.id}">${modulos.titulo}</option>
                                </c:forEach>

                            </select> 

                        </td>
                        <td><input type="text" name="titulo" /></td>
                    </tr>

                    <tr>
                        <td>Modulo</td>
                        <td>
                            <select name="modulosExistentes">

                                <option value="-1">Seleccione</option>

                                <c:forEach var="modulos" items="${listado}">

                                    <option value="${modulos.id}">${modulos.titulo}</option>
                                </c:forEach>

                            </select> 

                        </td>
                        <td><input type="text" name="titulo" /></td>
                    </tr>

                    <tr>
                        <td>Modulo</td>
                        <td>
                            <select name="modulosExistentes">

                                <option value="-1">Seleccione</option>

                                <c:forEach var="modulos" items="${listado}">

                                    <option value="${modulos.id}">${modulos.titulo}</option>
                                </c:forEach>

                            </select> 

                        </td>
                        <td><input type="text" name="titulo" /></td>
                    </tr>






                </table> 

                <tr>
                    <td colspan="2"><input type="submit" name="enviar" value="Enviar" class="btn-primary" /></td>
                </tr> 

            </form>
        </div>
    </body>


</html>
