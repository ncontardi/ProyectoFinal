package controlador;

import dao.ReservasDAO;
import modelo.Reserva;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/RegistroReserva")
public class RegistroReserva extends HttpServlet {   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Iniciando ReservaServlet...");

        // Obtener datos del formulario
        String nombreReserva = request.getParameter("nombreReserva");
        String apellidoReserva = request.getParameter("apellidoReserva");
        

        // Crear un objeto Reserva con los datos
        Reserva reserva = new Reserva();
        reserva.setNombreReserva(nombreReserva);
        reserva.setApellidoReserva(apellidoReserva);
        
        // Obtener la fecha actual
        java.util.Date fechaActual = new java.util.Date(); //es una forma de utilizar la clase sin necesitar una declaracion 'import'
        reserva.setHoraReserva(new Date(fechaActual.getTime()));

        // Agregar la reserva a la base de datos (ajustar según la lógica de tu aplicación)
        ReservasDAO reservasDAO = new ReservasDAO();
        reservasDAO.agregarReserva(reserva);
        // Redireccionar a la página de visualización de reservas
        response.sendRedirect(request.getContextPath() + "/vistas/mostrar_reservas.jsp");
    }
}
