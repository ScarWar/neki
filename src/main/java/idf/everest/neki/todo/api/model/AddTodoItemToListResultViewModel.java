package idf.everest.neki.todo.api.model;

import lombok.Value;

import java.util.List;

@Value
public class AddTodoItemToListResultViewModel {
  Long id;
  String name;
  List<CreatedTodoItemViewModel> items;

  @Value
  public static class CreatedTodoItemViewModel {
    Long id;
    String text;
  }
}
