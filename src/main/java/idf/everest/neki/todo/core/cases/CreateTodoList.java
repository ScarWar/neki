package idf.everest.neki.todo.core.cases;

import idf.everest.neki.todo.core.cases.result.CreateTodoListResult;
import idf.everest.neki.todo.core.model.TodoList;
import idf.everest.neki.todo.intrastracture.data.TodoListRepository;
import idf.everest.neki.todo.intrastracture.data.mapper.TodoListDataMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Component
public class CreateTodoList implements UseCase {

  private static final Logger LOGGER = LoggerFactory.getLogger(CreateTodoList.class);

  private final TodoListRepository todoListRepository;
  private final TodoListDataMapper todoListDataMapper;

  @Transactional
  public CreateTodoListResult invoke(String name) {
    // Business logic
    LOGGER.info("Create new todo list");
    final var todoList = new TodoList(name);

    // Persistence logic
    LOGGER.trace("Map todo list to entity");
    final var todoListEntity = todoListDataMapper.toTodoListEntity(todoList);

    LOGGER.debug("Save new todo list");
    final var persistedTodoListEntity = todoListRepository.save(todoListEntity);
    LOGGER.debug("Saved new todo list {}", persistedTodoListEntity.getId());

    // Map to domain
    LOGGER.trace("Map entity to aggregate");
    final var newTodoList = todoListDataMapper.toTodoList(persistedTodoListEntity);

    // Return result
    return new CreateTodoListResult(newTodoList);
  }
}
