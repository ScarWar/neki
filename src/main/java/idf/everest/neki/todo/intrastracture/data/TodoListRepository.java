package idf.everest.neki.todo.intrastracture.data;

import idf.everest.neki.todo.intrastracture.data.model.TodoListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends JpaRepository<TodoListEntity, Long> {
}
