package com.example.laba8.servlet;

import com.example.laba8.service.PhotoService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addRentEntry")
public class PhotoFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // Создание JSON из параметров формы
            StringBuilder json = new StringBuilder("{");
            json.append("\"Name\":\"").append(request.getParameter("Name")).append("\",");
            json.append("\"PhoneNumber\":\"").append(request.getParameter("PhoneNumber")).append("\",");
            json.append("\"RentDate\":\"").append(request.getParameter("RentDate")).append("\",");
            json.append("\"ProductName\":").append(request.getParameter("ProductName")).append(",");
            json.append("\"Price\":").append(request.getParameter("Price")).append(",");
            json.append("\"Duration\":\"").append(request.getParameter("Duration")).append("\"}");

            // Передача в сервис
            PhotoService.addRentFromJson(getServletContext(), json.toString());
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            response.sendRedirect("index.jsp?error=" + e.getMessage());
        }
    }
}