package idf.everest.neki.todo.api.model;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
public class QueryTodoListResultViewModel {
  Long id;
  String name;
  List<TodoItemViewModel> items;
  LocalDateTime createdDate;
  LocalDateTime lastModifiedDate;

  @Value
  public static class TodoItemViewModel {
    Long id;
    String text;
    LocalDateTime createdDate;
    LocalDateTime lastModifiedDate;
  }
}
