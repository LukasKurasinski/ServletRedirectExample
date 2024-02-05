package servlets;

import org.ServletRedirectExample.models.MySQLConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "inputChooserServlet", urlPatterns = "/inputChooser")
public class InputChooserServlet extends HttpServlet {

    String address="";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("we've posted");

        if(req.getParameter("signIn") != null){
            address="signIn.jsp";
        }else if(req.getParameter("register") != null){
            address="register.jsp";
        }else if(req.getParameter("logIn") != null){
            LinkedList data = MySQLConnector.getConnector().selectQuery("findUser", req.getParameter("username"), req.getParameter("password"));
            if(data.size()>0){
                System.out.println("logged In!");
                address="welcomeUser.jsp";
            }else {
                address = "signIn.jsp";
            }
        }

        req.getRequestDispatcher(address).forward(req, resp);

    }
}
