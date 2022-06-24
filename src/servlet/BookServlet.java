package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BookService;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/books")
public class BookServlet extends HttpServlet {

    private final BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        var publisherId = Long.valueOf(req.getParameter("publisherId"));

        try (var writer = resp.getWriter()) {
            writer.write("<h1>BOOKS LIST</h1>");
            writer.write("<ul>");
            bookService.findAllByPublisherId(publisherId)
                            .forEach(entity -> {
                                writer.write("<h1> <li> %s %s %s %s %s </li></h1>".formatted(entity.getId(),entity.getName(),entity.getGenre(), entity.getPageCount(),entity.getPageCount()));
                            });
            writer.write("</ul>");
        }
    }
}
