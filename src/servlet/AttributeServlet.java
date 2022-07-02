package servlet;

import dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/attributes")
public class AttributeServlet extends HttpServlet {


    private static final String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        HttpSession session = req.getSession();
        UserDto attribute = (UserDto) session.getAttribute(USER);
        if (attribute  == null){
            UserDto someone = UserDto.builder()
                    .id(7L)
                    .name("SOMEONE")
                    .build();
            session.setAttribute(USER,someone);

            try (PrintWriter writer = resp.getWriter()) {
                writer.write("<h1> YOU ENTERED FIRST TIME IN THIS WEB SITE </h1 >");
            }
        }
    }
}
