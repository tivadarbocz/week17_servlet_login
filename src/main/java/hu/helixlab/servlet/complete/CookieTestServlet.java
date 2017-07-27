package hu.helixlab.servlet.complete;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Admin on 2017.07.09..
 */
public class CookieTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookies[] = req.getCookies();
        PrintWriter out=resp.getWriter();
        if(cookies != null){
            for(Cookie c : cookies){
                out.print("<br>"+c.getName()+" "+c.getValue());//printing name and value of cookie
            }
        }


        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("Teszt_cookie", "alma");
        cookie.setMaxAge(10);
        resp.addCookie(cookie);
    }
}
