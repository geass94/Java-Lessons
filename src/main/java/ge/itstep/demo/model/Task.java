package ge.itstep.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String task;
    @Getter
    @Setter
    private String note;
    @Getter
    @Setter
    private String dueDate;
    @Getter
    @Setter
    private boolean completed;
    @Getter
    @Setter
    private Date createdAt;
    @Getter
    @Setter
    private Date updatedAt;

    public Task(int id, String task, String note, String dueDate, boolean completed) {
        this.id = id;
        this.task = task;
        this.note = note;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", note='" + note + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", completed=" + completed +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
