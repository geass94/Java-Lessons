package ge.itestep.Lesson_Five;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import ge.itestep.Lesson_Four.Task;
import ge.itestep.Lesson_Four.dao.TaskDAO;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


@WebServlet("/*")
public class TodoServlet extends HttpServlet {


    private static final long serialVersionUID = 69420l;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().write("i am not gay");
        try (BufferedReader br = req.getReader()) {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            req.setCharacterEncoding("UTF-8");
            //creating variable
            StringBuilder payload = new StringBuilder();
            String input;
            //saving to variable
            while ((input = br.readLine()) != null) {
                payload.append(input);
            }

            JSONObject jo = new JSONObject(payload.toString());

            Task t = new Task(jo);

            TaskDAO DAO = new TaskDAO();
            Task t2 = DAO.getById(DAO.createTask(t));

            resp.getWriter().write(t2.toJson());


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getPathInfo() == null) {
            resp.setStatus(404);
            resp.sendError(404, "Missing path variable");
        }
        String[] pathVariables = req.getPathInfo().split("/");
        Integer id = Integer.valueOf(pathVariables[1]);

        ObjectMapper OM = new ObjectMapper();
        TaskDAO dao = new TaskDAO();

        Task task1 = dao.getById(id);

        if (task1 == null) {
            resp.setStatus(404);
            resp.sendError(404, "ur gay");
        }

        String json = OM.writeValueAsString(task1);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
