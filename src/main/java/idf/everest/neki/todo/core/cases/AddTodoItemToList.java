package idf.everest.neki.todo.core.cases;

import idf.everest.neki.todo.core.cases.result.AddTodoItemToListResult;
import idf.everest.neki.todo.core.model.TodoItem;
import idf.everest.neki.todo.intrastracture.data.TodoItemRepository;
import idf.everest.neki.todo.intrastracture.data.TodoListRepository;
import idf.everest.neki.todo.intrastracture.data.mapper.TodoListDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Component
public class AddTodoItemToList implements UseCase {
  final private TodoListRepository todoListRepository;
  final private TodoItemRepository todoItemRepository;
  final private TodoListDataMapper todoListDataMapper;

  @Transactional
  public AddTodoItemToListResult invoke(Long todoListId, TodoItem todoItem) {
    final var todoListEntity = todoListRepository.getById(todoListId);
    final var todoList = todoListDataMapper.toTodoList(todoListEntity);
    todoList.add(todoItem);

    final var updatedTodoListEntity = todoListDataMapper.toTodoListEntity(todoList);
    todoItemRepository.saveAll(updatedTodoListEntity.getItems());
    todoListRepository.save(updatedTodoListEntity);

    final var updateTodoList = todoListDataMapper.toTodoList(updatedTodoListEntity);
    return new AddTodoItemToListResult(updateTodoList);
  }
}
