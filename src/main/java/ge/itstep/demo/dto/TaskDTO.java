package ge.itstep.demo.dto;

public record TaskDTO(int id, String task, String note, String dueDate, boolean completed) {
}
