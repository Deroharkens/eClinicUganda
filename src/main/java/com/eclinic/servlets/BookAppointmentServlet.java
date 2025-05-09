package com.eclinic.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.*;

import com.eclinic.utils.DBConnection;

@WebServlet("/bookAppointment")
public class BookAppointmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int patientId = Integer.parseInt(request.getParameter("patientId"));
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));
        String dateTime = request.getParameter("dateTime");

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO appointments (patient_id, doctor_id, date_time, status) VALUES (?, ?, ?, 'pending')";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, patientId);
            stmt.setInt(2, doctorId);
            stmt.setString(3, dateTime);
            stmt.executeUpdate();

            response.sendRedirect("jsp/patientDashboard.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Error booking appointment: " + e.getMessage());
        }
    }
}
