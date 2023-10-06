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
import java.util.List;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        TaskDAO dao = new TaskDAO();

        List<Task> tasks = dao.getAll();




        String html = "index.jsp";
        req.setAttribute("tasks", tasks);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(html);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        Task task = new Task();
        task.setTask(req.getParameter("task"));
        task.setNote(req.getParameter("note"));
        String checkBoxValue = req.getParameter("iscompleted");
        boolean checker = checkBoxValue != null && checkBoxValue.equals("1");
        task.setCompleted(checker);
        task.setDueDate(req.getParameter("duedate"));
        TaskDAO dao = new TaskDAO();
        Integer daoint =  dao.createTask(task);
        if(daoint != 1){

        }


    }
}
