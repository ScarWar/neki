package idf.everest.neki.todo.api.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateTodoListCommand {
  @NotBlank
  String name;
}
