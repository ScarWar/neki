package idf.everest.neki.todo.intrastracture.data.mapper;

import idf.everest.neki.todo.core.model.TodoItem;
import idf.everest.neki.todo.core.model.TodoList;
import idf.everest.neki.todo.intrastracture.data.model.TodoItemEntity;
import idf.everest.neki.todo.intrastracture.data.model.TodoListEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface TodoListDataMapper {

  @Mapping(source = "createdDate", target = "createdDate", qualifiedByName = "unwrap")
  @Mapping(source = "lastModifiedDate", target = "lastModifiedDate", qualifiedByName = "unwrap")
  TodoList toTodoList(TodoListEntity todoListEntity);

  @Mapping(source = "createdDate", target = "createdDate", qualifiedByName = "unwrap")
  @Mapping(source = "lastModifiedDate", target = "lastModifiedDate", qualifiedByName = "unwrap")
  TodoItem toTodoItem(TodoItemEntity todoItemEntity);

  TodoListEntity toTodoListEntity(TodoList todoList);
  TodoItemEntity toTodoItemEntity(TodoItem todoItem);

  @SuppressWarnings("unused")
  @Named("unwrap")
  default <T> T unwrap(Optional<T> optional) {
    return optional.orElse(null);
  }
}
