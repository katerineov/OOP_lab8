<%@ page import="com.example.laba8.service.PhotoService" %>
<%@ page import="org.json.JSONArray" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Аренда фототехники PhotoGear</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="content">
    <h1>Добавить запись аренды фототехники PhotoGear</h1>

    <% if (request.getParameter("error") != null) { %>
    <p class="error">Ошибка: <%= request.getParameter("error") %></p>
    <% } %>
    <form action="addRentEntry" method="post">
        Имя покупателя:        <input type="text" name="Name" required><br>
        Номер телефона:    <input type="text" name="PhoneNumber" required><br>
        Срок аренды:    <input type="text" name="RentDate" required><br>
        Наименование товара:       <input type="text" name="ProductName" required><br>
        Стоимость аренды:     <input type="number" step="10" name="Price" required><br>
        Длительность аренды:    <input type="text" name="Duration" required><br>
        <button type="submit" class="but add-button">Добавить</button>
    </form>

    <h2>Список записей аренды</h2>
    <table>
        <tr>
            <th>Имя покупателя</th>
            <th>Номер телефона</th>
            <th>Срок аренды</th>
            <th>Наименование товара</th>
            <th>Стоимость аренды</th>
            <th>Длительность аренды</th>
        </tr>
        <%
            try {
                String json = PhotoService.getAllRentsAsJson(application);
                JSONArray Photos = new JSONArray(json);
                for (int i = 0; i < Photos.length(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + Photos.getJSONObject(i).getString("Name") + "</td>");
                    out.println("<td>" + Photos.getJSONObject(i).getString("PhoneNumber") + "</td>");
                    out.println("<td>" + Photos.getJSONObject(i).getString("RentDate") + "</td>");
                    out.println("<td>" + Photos.getJSONObject(i).getString("ProductName") + "</td>");
                    out.println("<td>" + Photos.getJSONObject(i).getDouble("Price") + "</td>");
                    out.println("<td>" + Photos.getJSONObject(i).getString("Duration") + "</td>");
                    out.println("</tr>");
                }
            } catch (Exception e) {
                out.println("<tr><td colspan='6' class='error'>Ошибка загрузки данных: " + e.getMessage() + "</td></tr>");
            }
        %>
    </table>
</div>
</body>
</html>