package ge.itstep.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tasks")
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
    @Column(name = "due_date")
    private String dueDate;
    @Getter
    @Setter
    @Column(name = "completed")
    private boolean completed;
    @Getter
    @Setter
    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;
    @Getter
    @Setter
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;
    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;

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
