package idf.everest.neki.todo.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@Value
public class TodoList {
  Long id;
  String name;
  List<TodoItem> items;
  LocalDateTime createdDate;
  LocalDateTime lastModifiedDate;

  public TodoList(String name, List<TodoItem> items) {
    this(null, name, items, LocalDateTime.now(), LocalDateTime.now());
  }

  public TodoList(String name) {
    this(name, new ArrayList<>());
  }

  public void add(TodoItem todoItem) {
    this.items.add(todoItem);
  }
}
