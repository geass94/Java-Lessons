package ge.itestep.Lesson_Four.dao;

import ge.itestep.Lesson_Four.DatabaseConnection;
import ge.itestep.Lesson_Four.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public int createTask(Task task) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String insertQuery = "INSERT INTO tasks (task, note) VALUES (?, ?)";

            PreparedStatement stmt  = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, task.getTask());
            stmt.setString(2, task.getNote());

            int rows = stmt.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Failed to create task");
            }


            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    return  keys.getInt(1);
                } else {
                    throw new SQLException("Failed to create task");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Task getById(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tasks WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet results = stmt.executeQuery();

            if (results.next()) {
                return new Task(
                        results.getInt("id"),
                        results.getString("task"),
                        results.getString("note"),
                        results.getBoolean("completed"),
                        results.getString("dueDate"),
                        results.getString("createdAt"),
                        results.getString("updatedAt")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
