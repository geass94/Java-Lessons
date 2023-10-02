package ge.itestep.Lesson_Seven;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String html = "index.html";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(html);
        requestDispatcher.forward(req, resp);
    }
}
