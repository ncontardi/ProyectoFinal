<%@page import="dao.ReservasDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Reserva"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Reservas</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Lista de Reservas</h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Hora Reserva</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Crear una instancia de ReservasDAO para acceder a la base de datos
                        ReservasDAO reservasDAO = new ReservasDAO();

                        // Obtener la lista de reservas desde la base de datos
                        List<Reserva> reservas = reservasDAO.obtenerTodos();

                        if (reservas != null && !reservas.isEmpty()) {
                            // Iterar sobre la lista de reservas y mostrar sus datos en la tabla
                            for (Reserva reserva : reservas) {
                    %>
                    <tr>
                        <td><%= reserva.getUsuarioId()%></td>
                        <td><%= reserva.getNombreReserva()%></td>
                        <td><%= reserva.getApellidoReserva()%></td>                      
                        <td><%= reserva.getHoraReserva()%></td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="5"> No hay reservas registradas.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <!-- Botón para volver al índice -->
            <a href="../" class="btn btn-success">Volver</a>   
        </div>
    </body>
</html>