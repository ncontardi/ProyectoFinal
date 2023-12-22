<%@page import="modelo.Reserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Actualizar Registro</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <div class="container mt-5">
            <h2>Actualizar Orador</h2>
            <form action="GestionReservaServlet" method="post">
                <input type="hidden" name="accion" value="confirmarActualizacion">
                <input type="hidden" name="id" value="${reserva.usuarioId}">

                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombreReserva" name="nombreReserva" value="${reserva.nombreReserva}" required>
                </div>

                <div class="form-group">
                    <label for="apellido">Apellido:</label>
                    <input type="text" class="form-control" id="apellidoReserva" name="apellidoReserva" value="${reserva.apellidoReserva}" required>
                </div>

                <div class="form-group">
                    <label for="fechaAlta">Fecha Alta:</label>
                    <input type="date" name="horaReserva" /> 
                </div>


                <button type="submit" class="btn btn-primary">Actualizar</button>
                <a href="gestionReservas.jsp" class="btn btn-success">Volver</a>

            </form>
        </div>
    </body>
</html>
