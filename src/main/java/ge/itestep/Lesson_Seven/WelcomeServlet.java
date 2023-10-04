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
import java.util.ArrayList;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        TaskDAO dao = new TaskDAO();

        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(dao.getById(1));
        tasks.add(dao.getById(2));
        tasks.add(dao.getById(3));
        tasks.add(dao.getById(4));




        String html = "index.jsp";
        req.setAttribute("tasks", tasks);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(html);
        requestDispatcher.forward(req, resp);
    }
}
