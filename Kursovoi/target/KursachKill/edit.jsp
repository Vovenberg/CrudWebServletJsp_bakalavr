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
    <div class="mainform">
    <%int type=Integer.parseInt(request.getParameter("type"));
      int id=Integer.parseInt(request.getParameter("id"));
      if(type==1){
            Driver dr=Factory.getInstanse().getDriverDao().getDriverById(id);
            String name=dr.getName_driver();%>
            <form method="get" action="/edit">
                <h3> Изменение данных водителя</h3>
                <input type="hidden" name="id_driver" value="<%=dr.getId_driver()%>">
                <p>Введите имя</p>
                <input type="text" name="name_driver" value="<%=name%>">
                <input type="hidden" name="id" value="1">
                <p>Введите фамилию</p>
                <input type="text" name="surname_driver" value="<%=dr.getSurname_driver()%>">
                <p>Введите номер водительского удостоверения</p>
                <input type="text" name="vod_udost" value="<%=dr.getVod_udost()%>">

                <input type="submit" value="Принять изменение" >
            </form>
        <% }
        else if (type==2){
        Auto a=Factory.getInstanse().getAutoDao().getAutoById(id); %>
          <form method="get" action="/edit">
            <input type="hidden" name="id" value="2">
            <h3>Изменение данных авто</h3>
            <input type="hidden" name="number_auto" value="<%=a.getNumber_auto()%>">
            <input type="hidden" name="id_driver2" value="<%=a.getId_driver().getId_driver()%>">
            <p>Введите марку</p>
            <input type="text" name="marka" value="<%=a.getMarka()%>">
            <p>Введите номер свидельства о регистрации авто</p>
            <input type="text" name="svidet_o_registr" value="<%=a.getSvidet_o_registr()%>">
            <input type="submit" value="Принять изменение" >
        </form>
        <% }
        else if (type==3){
            Protocol p=Factory.getInstanse().getProtocolDao().getProtocolById(id);%>
        <form method="get" action="/edit">
            <input type="hidden" name="id" value="3">
            <input type="hidden" name="idprotocol" value="<%=p.getId_protocol()%>">
            <h3>Изменение данных штрафа</h3>
            <input type="hidden" name="number_auto2" value="<%=p.getNumber_auto().getNumber_auto()%>">
            <p>Введите место нарушения</p>
            <input type="text" name="mesto" value="<%=p.getMesto()%>">
            <p>Введите описание</p>
            <input type="text" name="opisanie" value="<%=p.getOpisanie()%>">
            <input type="submit" value="Принять изменение" >
        </form>
        <% }%>
    </form>
    </div>
 </body>
</html>
