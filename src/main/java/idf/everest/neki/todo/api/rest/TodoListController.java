package idf.everest.neki.todo.api.rest;

import idf.everest.neki.todo.api.mapper.TodoListViewModelMapper;
import idf.everest.neki.todo.api.model.*;
import idf.everest.neki.todo.core.cases.AddTodoItemToList;
import idf.everest.neki.todo.core.cases.CreateTodoList;
import idf.everest.neki.todo.core.cases.QueryTodoList;
import idf.everest.neki.todo.core.model.TodoItem;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todolist")
public class TodoListController {

  private final static Logger LOGGER = LoggerFactory.getLogger(TodoListController.class);

  private final CreateTodoList createTodoListUseCase;
  private final QueryTodoList queryTodoListUseCase;
  private final AddTodoItemToList addTodoItemToListUseCase;
  private final TodoListViewModelMapper todoListMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CreateTodoListResultViewModel createTodoList(@Valid @RequestBody CreateTodoListCommand command) {
    LOGGER.info("Invoke create todo list use case");
    final var result = createTodoListUseCase.invoke(command.getName());

    LOGGER.debug("Map result to view model");
    final var createTodoListResultViewModel = new CreateTodoListResultViewModel();
    createTodoListResultViewModel.listId = result.getListId();
    createTodoListResultViewModel.createDate = result.getTodoList().getCreatedDate();
    createTodoListResultViewModel.lastModifiedDate = result.getTodoList().getLastModifiedDate();

    return createTodoListResultViewModel;
  }

  @GetMapping(value = "/{todolist-id}", produces = {"application/json"})
  public QueryTodoListResultViewModel getTodoList(@Valid @Positive @PathVariable("todolist-id") Long todolistId) {
    LOGGER.info("Invoke query todo list use case");
    final var result = queryTodoListUseCase.invoke(todolistId);

    LOGGER.debug("Map result to view model");
    return todoListMapper.toQueryTodoListResultViewModel(result);
  }

  @PostMapping(value = "/{todolist-id}", produces = {"application/json"})
  public AddTodoItemToListResultViewModel addTodoItemToList(
          @Valid @Positive @PathVariable("todolist-id") Long todolistId,
          @Valid @RequestBody AddTodoItemToListCommand command
  ) {
    final var todoItem = new TodoItem(command.getText());
    final var result = addTodoItemToListUseCase.invoke(todolistId, todoItem);

    return todoListMapper.toAddTodoItemToListResultViewModel(result);
  }
}
