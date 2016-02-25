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
    <aside>

             <a href="add.jsp">Добавить</a>
        </br></br>
    </aside>
    <div class="table" display: inline-block>

        <table>
            <tr>
                <td>Id_водителя</td>
                <td>Имя</td>
                <td>Фамимлия</td>
                <td>Номер водительского удостоверения</td>
                <td>Редактирование</td>
            </tr>
            <% List<Driver> list=Factory.getInstanse().getDriverDao().getAllDrivers();
                for (Driver d:list){
            %>
            <tr>
                <td style="font-size: 26px"><%=d.getId_driver()%></td>
                <td style="font-size: 26px"><%=d.getName_driver()%></td>
                <td style="font-size: 26px"><%=d.getSurname_driver()%></td>
                <td style="font-size: 26px"><%=d.getVod_udost()%></td>
                <td> Изменить</br><a href="/delete?type=1&id=<%=d.getId_driver()%>">Удалить</a></td>
            </tr>
            <%}%>
        </table>
        </br></br>
        <table>
            <tr>
                <td>Номер</td>
                <td>Id водителя</td>
                <td>Марка авто</td>
                <td>Свидетельство о регистрации</td>
                <td>Редактирование</td>
            </tr>
            <% List<Auto> list2=Factory.getInstanse().getAutoDao().getAllAuto();
                for (Auto a:list2){
            %>
            <tr>
                <td style="font-size: 26px"><%=a.getNumber_auto()%></td>
                <td style="font-size: 26px"><%=a.getId_driver().getId_driver()%></td>
                <td style="font-size: 26px"><%=a.getMarka()%></td>
                <td style="font-size: 26px"><%=a.getSvidet_o_registr()%></td>
                <td> Изменить</br><a href="/delete?type=2&id=<%=a.getNumber_auto()%>">Удалить</a></td>
            </tr>
            <%}%>
        </table>
        </br></br>
        <table>
            <tr>
                <td>Id протокола</td>
                <td>Номер авто</td>
                <td>Место нарушения</td>
                <td>Oписание</td>
                <td>Редактирование</td>
            </tr>
            <% List<Protocol> list3=Factory.getInstanse().getProtocolDao().getAllProtocols();
                for (Protocol p:list3){
            %>
            <tr>
                <td style="font-size: 26px"><%=p.getId_protocol()%></td>
                <td style="font-size: 26px"><%=p.getNumber_auto().getNumber_auto()%></td>
                <td style="font-size: 26px"><%=p.getMesto()%></td>
                <td style="font-size: 26px"><%=p.getOpisanie()%></td>
                <td> Изменить</br> <a href="/delete?type=3&id=<%=p.getId_protocol()%>">Удалить</a></td>
            </tr>
            <%}%>
        </table>
    </div>


</body>
</html>
