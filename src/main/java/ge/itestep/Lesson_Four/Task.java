package ge.itestep.Lesson_Four;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.Serializable;

public class Task implements Serializable {
    private int id;
    private String task;
    private String note;
    private boolean completed;
    private String dueDate;
    private String createdAt;
    private String updatedAt;

    public Task() {
    }

    public Task(int id, String task, String note, boolean completed, String dueDate, String createdAt, String updatedAt) {
        this.id = id;
        this.task = task;
        this.note = note;
        this.completed = completed;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

//    public Task(JSONObject json) {
//
//        this.task = json.getString("task");
//
//        this.note = json.getString("note");
//
//        this.completed = json.getBoolean("iscompleted");
//
//        this.dueDate = json.getString("dueDate");
//
//    }
    public String toJson() throws JsonProcessingException {
        ObjectMapper OM = new ObjectMapper();
        String json = OM.writeValueAsString(this);
        return json;
    }
    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", task='" + task + '\'' + ", note='" + note + '\'' + ", completed=" + completed + ", dueDate='" + dueDate + '\'' + ", createdAt='" + createdAt + '\'' + ", updatedAt='" + updatedAt + '\'' + '}';
    }
}
