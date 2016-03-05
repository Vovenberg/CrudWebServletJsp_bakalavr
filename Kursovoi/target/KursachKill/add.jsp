<%@ page import="hibernate.HibernateUtil" %>
<%@ page import="hibernate.Factory" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %><%--
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
    <script src="./scripts.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style><%@include file="styles.css" %></style>
</head>
<body>
    <h1>Штрафы ГИБДД</h1>
    <%	String choiceTable = request.getParameter("ttype"); %>
    <div class="mainform">
        <form action="add.jsp" method="get" accept-charset="UTF-8">
           <select id="choice" name="ttype">
               <option selected disabled>Выберите таблицу</option>
               <option value="driver"> Водитель</option>
               <option value="auto"> Автомобиль</option>
               <option value="protocol"> Штраф</option>
           </select>
           <input type="submit">
        </form>


        <%if("driver".equals(choiceTable)){ %>
            <form method="get" action="/add">

                  <p>Введите имя</p>
                  <input type="text" name="name_driver">
                  <input type="hidden" name="id" value="1">
                  <p>Введите фамилию</p>
                  <input type="text" name="surname_driver">
                  <p>Введите номер водительского удостоверения</p>
                  <input type="text" name="vod_udost">

                  <input type="submit" value="Записать" >
            </form>
        <% }
        else if ("auto".equals(choiceTable)){%>
            <form method="get" action="/add">
                <input type="hidden" name="id" value="2">
                <p>Введите номер авто</p>
                <input type="text" name="number_auto">
                <p>Введите id водителя</p>
                <input type="text" name="id_driver2">
                <p>Введите марку</p>
                <input type="text" name="marka">
                <p>Введите номер свидельства о регистрации авто</p>
                <input type="text" name="svidet_o_registr">
                <input type="submit" value="Записать" >
            </form>
        <% }
        else if ("protocol".equals(choiceTable)){%>
            <form method="get" action="/add">
                <input type="hidden" name="id" value="3">
                <p>Введите номер авто</p>
                <input type="text" name="number_auto2">
                <p>Введите место нарушения</p>
                <input type="text" name="mesto">
                <p>Введите описание</p>
                <input type="text" name="opisanie">
                <input type="submit" value="Записать" >
            </form>
        <% }%>
    </div>
    <a href="showResult.jsp">Назад</a>
 </body>
</html>
