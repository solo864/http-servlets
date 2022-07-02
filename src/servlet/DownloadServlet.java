package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/check-downloads")
public class DownloadServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Disposition", "attachment; \"filename.txt\"");

        try (var writer = resp.getOutputStream()) {
            InputStream resourceAsStream = DownloadServlet.class.getClassLoader().getResourceAsStream("application.properties");
            writer.write(resourceAsStream.readAllBytes());
        }
    }
}
