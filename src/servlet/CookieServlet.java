package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("text/html");



        Cookie cookie = new Cookie("NAME", "VALUE");
        cookie.setSecure(true);
        resp.addCookie(cookie);

        try (var writer = resp.getWriter()) {
            writer.write("<h1>I ADDED COOKIE IN DEV TOOLS CHECK IT PLEASE</h1>");
        }
    }
}
