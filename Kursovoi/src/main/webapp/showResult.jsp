<%@ page import="hibernate.HibernateUtil" %>
<%@ page import="hibernate.Factory" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="hibernate.entity.Driver" %><%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 14.02.2016
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style><%@include file="styles.css" %></style>
</head>
<body>
    <h1>Штрафы ГИБДД</h1>
    <aside>
        <ul>
            <li> <a href="add.jsp">Добавить</a> </li>
            <li><a href="add.jsp">Изменить</a> </li>
        </ul>
    </aside>
    <div class="table">
        <table border="2" width="100">
            <tr>
                <td>Имя</td>
                <td>Фамимлия</td>
                <td>Номер водительского удостоверения</td>
                <td>Редактирование</td>
            </tr>
            <% List<Driver> list=Factory.getInstanse().getDriverDao().getAllDrivers();
                for (Driver d:list){
            %>
            <tr>
                <td style="font-size: 26px"><%=d.getName_driver()%></td>
                <td style="font-size: 26px"><%=d.getSurname_driver()%></td>
                <td style="font-size: 26px"><%=d.getVod_udost()%></td>
                <td> Изменить</br> Удалить</td>
            </tr>
            <%}%>
        </table>
    </div>


</body>
</html>
