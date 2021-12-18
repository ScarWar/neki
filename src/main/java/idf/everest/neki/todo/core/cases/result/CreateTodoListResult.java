package idf.everest.neki.todo.core.cases.result;

import idf.everest.neki.todo.core.model.TodoList;
import lombok.Value;

@Value
public class CreateTodoListResult {
  Long listId;
  TodoList todoList;

  public CreateTodoListResult(Long id, TodoList todoList) {
    this.listId = id;
    this.todoList = todoList;
  }

  public CreateTodoListResult(TodoList todoList) {
    this(todoList.getId(), todoList);
  }
}
