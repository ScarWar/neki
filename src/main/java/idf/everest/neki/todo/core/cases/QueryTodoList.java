package idf.everest.neki.todo.core.cases;

import idf.everest.neki.todo.core.cases.result.QueryTodoListResult;
import idf.everest.neki.todo.intrastracture.data.TodoListRepository;
import idf.everest.neki.todo.intrastracture.data.mapper.TodoListDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Component
public class QueryTodoList {
  private final TodoListRepository todoListRepository;
  private final TodoListDataMapper todoListMapper;

  @Transactional
  public QueryTodoListResult invoke(Long todolistId) {
    final var todoListEntity = todoListRepository.getById(todolistId);
    final var todoList = todoListMapper.toTodoList(todoListEntity);

    return new QueryTodoListResult(todoList);
  }
}
