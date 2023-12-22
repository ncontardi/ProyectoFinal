<%@page import="dao.ReservasDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Reserva"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Gestión de Reservas</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Gestión de Reservas</h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Hora Reserva</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ReservasDAO reservasDAO = new ReservasDAO();
                        List<Reserva> reservas = reservasDAO.obtenerTodos();

                        if (reservas != null && !reservas.isEmpty()) {
                            for (Reserva reserva : reservas) {
                    %>
                    <tr>
                        <td><%= reserva.getUsuarioId()%></td>
                        <td><%= reserva.getNombreReserva()%></td>
                        <td><%= reserva.getApellidoReserva()%></td>                      
                        <td><%= reserva.getHoraReserva()%></td>
                        <td>
                            <div class="d-flex">
                                <!-- Formulario para actualizar -->
                                <form action="GestionReservaServlet" method="post" class="mr-2">
                                    <input type="hidden" name="accion" value="actualizar">
                                    <input type="hidden" name="id" value="<%= reserva.getUsuarioId()%>">
                                    <button type="submit" class="btn btn-warning btn-block">Actualizar</button>
                                </form>

                                <!-- Formulario para eliminar -->
                                <form action="GestionReservaServlet" method="post">
                                    <input type="hidden" name="accion" value="eliminar">
                                    <input type="hidden" name="id" value="<%= reserva.getUsuarioId()%>">
                                    <button type="submit" class="btn btn-danger btn-block">Eliminar</button>
                                </form>
                            </div>
                        </td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="6">No hay reservas registrados.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <a href="../" class="btn btn-success">Volver</a>   
        </div>
    </body>
</html>

