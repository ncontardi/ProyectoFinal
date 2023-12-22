package controlador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import modelo.Reserva;
import dao.ReservasDAO;

@WebServlet("/vistas/GestionReservaServlet")
public class GestionReservaServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        ReservasDAO reservasDAO = new ReservasDAO();
        
    int usuarioId = Integer.parseInt(request.getParameter("id"));
        
        switch (accion) {
            case "actualizar":
                Reserva reserva = reservasDAO.obtenerPorId(usuarioId);
                request.setAttribute("reserva", reserva); //Esto permite pasar datos del servlet a una vista (como un archivo JSP) o a otro servlet al que se redirige o se reenvía la solicitud
                request.getRequestDispatcher("actualizar.jsp").forward(request, response);
                break;
            case "confirmarActualizacion":
                Reserva reservaActualizado = new Reserva();
                reservaActualizado.setUsuarioId(usuarioId);
                reservaActualizado.setNombreReserva(request.getParameter("nombreReserva"));
                reservaActualizado.setApellidoReserva(request.getParameter("apellidoReserva"));
                // Asume que el método setFechaAlta acepta un java.sql.Date
                reservaActualizado.setHoraReserva(java.sql.Date.valueOf(request.getParameter("horaReserva")));

                reservasDAO.actualizarReserva(reservaActualizado);
                response.sendRedirect("gestionReservas.jsp");
                break;
            case "eliminar":
                reservasDAO.eliminarReserva(usuarioId);
                response.sendRedirect("gestionReservas.jsp");
                break;
            default:
                response.sendRedirect("gestionReservas.jsp");
                break;
        }
    }
}
