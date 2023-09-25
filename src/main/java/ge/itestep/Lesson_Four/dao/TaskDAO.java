package ge.itestep.Lesson_Four.dao;

import ge.itestep.Lesson_Four.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public int createTask(Task taask)
    {
        return 1;
    }

    public Task getById(int id)
    {
        return new Task();
    }

    public List<Task> getAll()
    {
        return new ArrayList<>();
    }

    public Task update(Task task, int id)
    {
        return new Task();
    }

    public boolean delete(int id)
    {
        return true;
    }

}
