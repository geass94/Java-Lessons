package ge.itestep.Lesson_Five;
import com.fasterxml.jackson.databind.ObjectMapper;
import ge.itestep.Lesson_Four.Task;
import ge.itestep.Lesson_Four.dao.TaskDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class TodoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        TaskDAO dao = new TaskDAO();

        Task task = dao.getById(4);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(task);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
