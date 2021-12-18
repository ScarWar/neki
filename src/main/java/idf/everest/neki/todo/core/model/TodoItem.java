package idf.everest.neki.todo.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Value
public class TodoItem  {
  Long id;
  String text;
  LocalDateTime createdDate;
  LocalDateTime lastModifiedDate;

  public TodoItem(Long id, String text) {
    this(id, text, LocalDateTime.now(), LocalDateTime.now());
  }

  public TodoItem(String text) {
    this(null, text);
  }
}
