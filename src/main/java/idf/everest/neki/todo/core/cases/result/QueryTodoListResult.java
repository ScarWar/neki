package idf.everest.neki.todo.core.cases.result;


import idf.everest.neki.todo.core.model.TodoList;
import lombok.Value;

@Value
public class QueryTodoListResult {
  TodoList todoList;
}
