package ge.itstep.demo.dto;

public record TaskDTO(Long id, String task, String note, String dueDate, boolean completed) {
}
