package ge.itestep.Lesson_Four.dao;

import ge.itestep.Lesson_Four.DatabaseConnection;
import ge.itestep.Lesson_Four.Task;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public int createTask(Task taask) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String insertQuery = "INSERT INTO tasks";

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Task getById(int id) {
        return new Task();
    }

    public List<Task> getAll() {
        return new ArrayList<>();
    }

    public Task update(Task task, int id) {
        return new Task();
    }

    public boolean delete(int id) {
        return true;
    }

}
