package servlet;

import entity.BookEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BookService;
import util.JspHelper;

import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BookServlet extends HttpServlet {


    private final BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var publisherId = Long.valueOf(req.getParameter("publisherId"));
        final List<BookEntity> bookEntities = bookService.findAllByPublisherId(publisherId);
        req.setAttribute("books", bookEntities);
        req.getRequestDispatcher(JspHelper.get("books"))
                .forward(req, resp);

    }
}

