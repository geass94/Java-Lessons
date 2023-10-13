package ge.itstep.demo.dto;

import java.util.Date;

public record TaskDTO(Long id, String task, String note, String dueDate, boolean completed) {
}
