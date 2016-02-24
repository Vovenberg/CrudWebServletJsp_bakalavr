package servlets;

import hibernate.Factory;
import hibernate.entity.Auto;
import hibernate.entity.Driver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Vladimir on 23.02.2016.
 */
public class Add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("name_driver")!=null) {
            Driver dr = new Driver();
            dr.setId_driver(new Random().nextInt(60));
            dr.setName_driver(req.getParameter("name_driver"));
            dr.setSurname_driver(req.getParameter("surname_driver"));
            dr.setVod_udost(Integer.parseInt(req.getParameter("vod_udost")));

            Factory.getInstanse().getDriverDao().addDriver(dr);
            RequestDispatcher rq = req.getRequestDispatcher("index.jsp");
            rq.forward(req, resp);
        }
        if (req.getParameter("marka")!=null){
            Auto a=new Auto();
            a.setNumber_auto(Integer.parseInt(req.getParameter("number_auto")));

            a.setMarka(req.getParameter("marka"));
            a.setSvidet_o_registr(Integer.parseInt(req.getParameter("svidet_o_registr")));

        }
        if (req.getParameter("mesto")!=null){}

    }
}
