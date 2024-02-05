package servlets;

import org.ServletRedirectExample.models.MySQLConnector;
import org.ServletRedirectExample.models.UsersBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name="showStudent", urlPatterns = "/showStudents")
public class ShowStudents extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        LinkedList data = MySQLConnector.getConnector().selectQuery("allFromStudenter");
        UsersBean usersBean = new UsersBean();
        usersBean.setData(data);

        req.getSession().setAttribute("usersBean", usersBean);
        System.out.println(((UsersBean)(req.getSession().getAttribute("usersBean"))).getData());
        req.getRequestDispatcher("showStudents.jsp").forward(req, resp);
    }
}
