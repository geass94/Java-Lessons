package ge.itestep.Lesson_Seven;

import ge.itestep.Lesson_Four.Task;
import ge.itestep.Lesson_Four.dao.TaskDAO;

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
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        TaskDAO dao = new TaskDAO();
        Task task = dao.getById(1);

        String html = "index.jsp";
        req.setAttribute("task", task);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(html);
        requestDispatcher.forward(req, resp);
    }
}
