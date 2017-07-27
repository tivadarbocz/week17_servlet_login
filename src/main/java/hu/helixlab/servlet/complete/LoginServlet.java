package hu.helixlab.servlet.complete;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {  
        response.setContentType("text/html");

        PrintWriter out=response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        if(name!= null && password != null){
            if(password.equals("admin") && password.equals("admin")){
                out.print("Welcome, "+name);
                HttpSession session=request.getSession();
                session.setAttribute("name",name);
            }
            else{
                out.print("Sorry, username or password error!");
                request.getRequestDispatcher("login.html").include(request, response);
            }
        }


        out.close();
    }

}
