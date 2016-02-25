package servlets;

import hibernate.Factory;
import hibernate.entity.Auto;
import hibernate.entity.Driver;
import hibernate.entity.Protocol;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vladimir on 25.02.2016.
 */
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i= Integer.parseInt(req.getParameter("id"));
        int type=Integer.parseInt(req.getParameter("type"));
        switch (type){
        case 1: {
            Driver d= Factory.getInstanse().getDriverDao().getDriverById(i);
            Factory.getInstanse().getDriverDao().deleteDriver(d);

            RequestDispatcher rq = req.getRequestDispatcher("showResult.jsp");
            rq.forward(req, resp);break;}
        case 2:{
            Auto a=Factory.getInstanse().getAutoDao().getAutoById(i);
            Factory.getInstanse().getAutoDao().deleteAuto(a);

            RequestDispatcher rq = req.getRequestDispatcher("showResult.jsp");
            rq.forward(req, resp);
        break;
        }
        case 3:{
            Protocol p=Factory.getInstanse().getProtocolDao().getProtocolById(i);
            Factory.getInstanse().getProtocolDao().deleteProtocol(p);

            RequestDispatcher rq = req.getRequestDispatcher("showResult.jsp");
            rq.forward(req, resp);
         break;
        }

    }
}}
