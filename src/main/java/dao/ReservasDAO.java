package dao;

import ConexionDB.DBConnection;
import modelo.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservasDAO {    
    public void agregarReserva(Reserva reserva) {
        String sql = "INSERT INTO reservas (nombre_reserva, apellido_reserva, hora_reserva) VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, reserva.getNombreReserva());
            preparedStatement.setString(2, reserva.getApellidoReserva());
            preparedStatement.setDate(3, reserva.getHoraReserva());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Reserva obtenerPorId(int Id) {
        String sql = "SELECT * FROM reservas WHERE usuario_id = ?";
        try (Connection connection = DBConnection.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, Id);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setUsuarioId(rs.getInt("usuario_id"));
                reserva.setNombreReserva(rs.getString("nombre_reserva"));
                reserva.setApellidoReserva(rs.getString("apellido_reserva"));
                reserva.setHoraReserva(rs.getDate("hora_reserva"));
                return reserva;
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Reserva> obtenerTodos() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservas";
        try (Connection conn = DBConnection.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setUsuarioId(rs.getInt("usuario_id"));
                reserva.setNombreReserva(rs.getString("nombre_reserva"));
                reserva.setApellidoReserva(rs.getString("apellido_reserva"));
                reserva.setHoraReserva(rs.getDate("hora_reserva"));
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservas;
    }

    public void actualizarReserva(Reserva reserva) {
        String sql = "UPDATE reservas SET nombre_reserva = ?, apellido_reserva = ?, hora_reserva = ? WHERE usuario_id = ?";
        try (Connection conn = DBConnection.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, reserva.getNombreReserva());
            pstmt.setString(2, reserva.getApellidoReserva());
            pstmt.setDate(3, (java.sql.Date) (Date) reserva.getHoraReserva());
            pstmt.setInt(4, reserva.getUsuarioId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void eliminarReserva(int id) {
        String sql = "DELETE FROM reservas WHERE usuario_id = ?";
        try (Connection conn = DBConnection.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }
}
