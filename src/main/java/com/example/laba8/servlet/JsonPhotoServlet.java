package com.example.laba8.servlet;

import com.example.laba8.service.PhotoService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/api/photos")
public class JsonPhotoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // Чтение JSON из запроса
            StringBuilder jsonBody = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBody.append(line);
            }

            // Обработка и сохранение
            PhotoService.addRentFromJson(getServletContext(), jsonBody.toString());

            // Возвращаем обновлённый список
            response.setContentType("application/json");
            response.getWriter().write(PhotoService.getAllRentsAsJson(getServletContext()));
        } catch (Exception e) {
            response.sendError(400, "Ошибка обработки JSON: " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setContentType("application/json");
            response.getWriter().write(PhotoService.getAllRentsAsJson(getServletContext()));
        } catch (Exception e) {
            response.sendError(500, "Ошибка чтения данных");
        }
    }
}