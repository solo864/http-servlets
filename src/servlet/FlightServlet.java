package servlet;

import dto.FlightDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.FlightService;
import util.JspHelper;

import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {


    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("flights", flightService.findAll());
        req.setAttribute("flightsMap", flightService.findAll().stream().collect(Collectors.toMap(FlightDto::getId,FlightDto::getDescription)));
        req.getRequestDispatcher(JspHelper.get("flights"))
                .forward(req, resp);

    }
}
