package servlet;

import entity.PublisherEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PublisherService;
import util.JspHelper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/publishers")
public class PublisherServlet extends HttpServlet {


    private final PublisherService publisherService = PublisherService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PublisherEntity> publishers = publisherService.findAll();
        req.setAttribute("publishers", publishers);
        req.getSession().setAttribute("publishersMap", publishers.stream().collect(Collectors.toMap(PublisherEntity::getId,PublisherEntity::getName)));
        req.getRequestDispatcher(JspHelper.get("publisher"))
                .forward(req, resp);

    }
}

