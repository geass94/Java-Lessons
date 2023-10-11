package ge.itstep.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Tasks")
public class Task {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    public Task(String task, String note, String dueDate, boolean completed) {
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
