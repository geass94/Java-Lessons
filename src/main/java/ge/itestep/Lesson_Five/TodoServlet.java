package ge.itestep.Lesson_Five;
import com.fasterxml.jackson.databind.ObjectMapper;
import ge.itestep.Lesson_Four.Task;
import ge.itestep.Lesson_Four.dao.TaskDAO;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet("/*")
public class TodoServlet extends HttpServlet {

    private static final long serialVersionUID = 69420l;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream(), "UTF-8"))) {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            req.setCharacterEncoding("UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();


            Task t = objectMapper.readValue(br, Task.class);

            TaskDAO DAO = new TaskDAO();
            Task t2 = DAO.getById(DAO.createTask(t));


            String jsonResponse = objectMapper.writeValueAsString(t2);
            resp.getWriter().write(jsonResponse);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream(),"UTF-8"))) {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            req.setCharacterEncoding("UTF-8");

            ObjectMapper objectMapper = new ObjectMapper();
            Task t = objectMapper.readValue(br, Task.class);

            TaskDAO taskDAO = new TaskDAO();
            Task updatedTask = taskDAO.update(t,t.getId());
            if(updatedTask == null)
                resp.getWriter().write("Task with ID " + t.getId() + " not found");

            else{
                String jsResponse = objectMapper.writeValueAsString(updatedTask);
                resp.getWriter().write(jsResponse);
            }


        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null) {
            resp.setStatus(404);
            resp.sendError(404, "Missing path variable");
        }
        String[] pathVariables = pathInfo.split("/");
        Integer id = Integer.valueOf(pathVariables[2]);
        TaskDAO taskDAO = new TaskDAO();
        boolean deleted = taskDAO.delete(id);
        if(deleted)
            resp.getWriter().write("Task with ID " + id + " is deleted!");
        else
            resp.getWriter().write("Task with ID " + id + " doesn't exist!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null) {
            resp.setStatus(404);
            resp.sendError(404, "Missing path variable");
        }
        String[] pathVariables = pathInfo.split("/");
        Integer id = Integer.valueOf(pathVariables[2]);

        TaskDAO dao = new TaskDAO();

        Task task = dao.getById(id);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(task);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
