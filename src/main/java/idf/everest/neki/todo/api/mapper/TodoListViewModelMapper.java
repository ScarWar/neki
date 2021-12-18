package idf.everest.neki.todo.api.mapper;

import idf.everest.neki.todo.api.model.AddTodoItemToListResultViewModel;
import idf.everest.neki.todo.api.model.QueryTodoListResultViewModel;
import idf.everest.neki.todo.core.cases.result.AddTodoItemToListResult;
import idf.everest.neki.todo.core.cases.result.QueryTodoListResult;
import idf.everest.neki.todo.core.model.TodoItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface TodoListViewModelMapper {
  @Mapping(target = "id", source = "todoList.id")
  @Mapping(target = "name", source = "todoList.name")
  @Mapping(target = "items", source = "todoList.items")
  @Mapping(target = "createdDate", source = "todoList.createdDate")
  @Mapping(target = "lastModifiedDate", source = "todoList.lastModifiedDate")
  QueryTodoListResultViewModel toQueryTodoListResultViewModel(QueryTodoListResult queryTodoListResult);

  QueryTodoListResultViewModel.TodoItemViewModel toTodoItemViewModel(TodoItem todoItem);

  @Mapping(target = "id", source = "todoList.id")
  @Mapping(target = "name", source = "todoList.name")
  @Mapping(target = "items", source = "todoList.items")
  AddTodoItemToListResultViewModel toAddTodoItemToListResultViewModel(AddTodoItemToListResult result);

  AddTodoItemToListResultViewModel.CreatedTodoItemViewModel toCreatedTodoItemViewModel(TodoItem todoItem);
}
