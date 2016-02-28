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
import java.util.Random;

/**
 * Created by Vladimir on 23.02.2016.
 */
public class Edit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer s=Integer.parseInt( req.getParameter("id"));
        switch (s){
            case 1:{
                Driver dr = new Driver();
                try {
                    dr.setId_driver(Integer.parseInt(req.getParameter("id_driver")));
                    dr.setName_driver(req.getParameter("name_driver"));
                    dr.setSurname_driver(req.getParameter("surname_driver"));
                    dr.setVod_udost(Integer.parseInt(req.getParameter("vod_udost")));
                }catch (NullPointerException e){
                    System.out.print("dfsd");
                }


                Factory.getInstanse().getDriverDao().updateDriver(dr);
                RequestDispatcher rq = req.getRequestDispatcher("showResult.jsp");
                rq.forward(req, resp);
                break;
            }
            case 2:{
                Auto a=new Auto();
                a.setNumber_auto(Integer.parseInt(req.getParameter("number_auto")));
                Integer id=Integer.parseInt(req.getParameter("id_driver2"));
                Driver d=Factory.getInstanse().getDriverDao().getDriverById(id);
                a.setId_driver(d);
                a.setMarka(req.getParameter("marka"));
                a.setSvidet_o_registr(Integer.parseInt(req.getParameter("svidet_o_registr")));

                Factory.getInstanse().getAutoDao().updateAuto(a);
                RequestDispatcher rq = req.getRequestDispatcher("showResult.jsp");
                rq.forward(req, resp);
                break;
            }
            case 3:{
                Protocol p=new Protocol();
                p.setId_protocol(new Random().nextInt(60));
                Integer id=Integer.parseInt(req.getParameter("number_auto2"));
                Auto a=Factory.getInstanse().getAutoDao().getAutoById(id);
                p.setNumber_auto(a);
                p.setMesto(req.getParameter("mesto"));
                p.setOpisanie(req.getParameter("opisanie"));

                Factory.getInstanse().getProtocolDao().updateProtocol(p);
                RequestDispatcher rq = req.getRequestDispatcher("showResult.jsp");
                rq.forward(req, resp);
                break;
            }
        }



    }
}
