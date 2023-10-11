package ge.itstep.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tasks")
public class Task {
    @Id
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    @Column(name = "task")
    private String task;
    @Getter
    @Setter
    @Column(name = "note")
    private String note;
    @Getter
    @Setter
    @Column(name = "dueDate")
    private String dueDate;
    @Getter
    @Setter
    @Column(name = "completed")
    private boolean completed;
    @Getter
    @Setter
    @Column(name = "createdAt")
    private Date createdAt;
    @Getter
    @Setter
    @Column(name = "updatedAt")
    private Date updatedAt;

    public Task(Long id, String task, String note, String dueDate, boolean completed) {
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
