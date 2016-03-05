package servlets;

import hibernate.Factory;
import hibernate.entity.Auto;
import hibernate.entity.Driver;
import hibernate.entity.Protocol;
import org.hibernate.exception.ConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
         try {
             Driver d = Factory.getInstanse().getDriverDao().getDriverById(i);
             Factory.getInstanse().getDriverDao().deleteDriver(d);

             RequestDispatcher rq = req.getRequestDispatcher("showResult.jsp");
             rq.forward(req, resp);
             break;
             }
         catch (ConstraintViolationException ex){
                 PrintWriter pw=resp.getWriter();
                 pw.write("<h1>ERROR:  you can't delete</h1></br>");
                 pw.write("<h3>ERROR:  there is a relationship to another table</h3>");
         }
        }
        case 2:{
            Auto a=Factory.getInstanse().getAutoDao().getAutoById(i);
            try {
                Factory.getInstanse().getAutoDao().deleteAuto(a);

                RequestDispatcher rq = req.getRequestDispatcher("showResult.jsp");
                rq.forward(req, resp);
            }catch (ConstraintViolationException ex){
                PrintWriter pw=resp.getWriter();
                pw.write("<h1>ERROR:  you can't delete</h1></br>");
                pw.write("<h3>ERROR:  there is a relationship to another table</h3>");
                // resp.setStatus(409);
            }

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
