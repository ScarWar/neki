package idf.everest.neki.todo.intrastracture.data;

import idf.everest.neki.todo.intrastracture.data.model.TodoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItemEntity, Long> {
}
