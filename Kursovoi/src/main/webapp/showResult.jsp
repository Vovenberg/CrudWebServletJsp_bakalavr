<%@ page import="hibernate.HibernateUtil" %>
<%@ page import="hibernate.Factory" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="hibernate.entity.Driver" %>
<%@ page import="hibernate.entity.Auto" %>
<%@ page import="hibernate.entity.Protocol" %><%--
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
    <hr>
    <aside>

        <a href="add.jsp">Добавить</a>
        </br></br>
        <a href="index.jsp">Назад</a>
    </aside>
    <div class="tables">
        <h3>Таблица "Водитель"</h3>
        <table>
            <tr>
                <td bgcolor="#f5f5dc">Id_водителя</td>
                <td>Имя</td>
                <td>Фамимлия</td>
                <td>Номер водительского удостоверения</td>
                <td>Редактирование</td>
            </tr>
            <% List<Driver> list=Factory.getInstanse().getDriverDao().getAllDrivers();
                for (Driver d:list){
            %>
            <tr>
                <td style="font-size: 26px" bgcolor="#f5f5dc"><%=d.getId_driver()%></td>
                <td style="font-size: 26px"><%=d.getName_driver()%></td>
                <td style="font-size: 26px"><%=d.getSurname_driver()%></td>
                <td style="font-size: 26px"><%=d.getVod_udost()%></td>
                <td><a href="edit.jsp?type=1&id=<%=d.getId_driver()%>"> Изменить</a></br><a href="/delete?type=1&id=<%=d.getId_driver()%>">Удалить</a></td>
            </tr>
            <%}%>
        </table>
        </br></br>
        <h3>Таблица "Авто"</h3>
        <table>
            <tr>
                <td bgcolor="#e0ffff">Номер</td>
                <td bgcolor="#f5f5dc">Id водителя</td>
                <td>Марка авто</td>
                <td>Свидетельство о регистрации</td>
                <td>Редактирование</td>
            </tr>
            <% List<Auto> list2=Factory.getInstanse().getAutoDao().getAllAuto();
                for (Auto a:list2){
            %>
            <tr>
                <td style="font-size: 26px" bgcolor="#e0ffff"><%=a.getNumber_auto()%></td>
                <td style="font-size: 26px" bgcolor="#f5f5dc"><%=a.getId_driver().getId_driver()%></td>
                <td style="font-size: 26px"><%=a.getMarka()%></td>
                <td style="font-size: 26px"><%=a.getSvidet_o_registr()%></td>
                <td> <a href="edit.jsp?type=2&id=<%=a.getNumber_auto()%>"> Изменить</a></br><a href="/delete?type=2&id=<%=a.getNumber_auto()%>">Удалить</a></td>
            </tr>
            <%}%>
        </table>
        </br></br>
        <h3>Таблица "Штраф-протокол"</h3>
        <table>
            <tr>
                <td bgcolor="#ffe4c4">Id протокола</td>
                <td bgcolor="#e0ffff">Номер авто</td>
                <td>Место нарушения</td>
                <td>Oписание</td>
                <td>Редактирование</td>
            </tr>
            <% List<Protocol> list3=Factory.getInstanse().getProtocolDao().getAllProtocols();
                for (Protocol p:list3){
            %>
            <tr>
                <td style="font-size: 26px"  bgcolor="#ffe4c4"><%=p.getId_protocol()%></td>
                <td style="font-size: 26px"  bgcolor="#e0ffff"><%=p.getNumber_auto().getNumber_auto()%></td>
                <td style="font-size: 26px"><%=p.getMesto()%></td>
                <td style="font-size: 26px"><%=p.getOpisanie()%></td>
                <td><a href="edit.jsp?type=3&id=<%=p.getId_protocol()%>"> Изменить</a></br> <a href="/delete?type=3&id=<%=p.getId_protocol()%>">Удалить</a></td>
            </tr>
            <%}%>
        </table>

    </div>


</body>
</html>
