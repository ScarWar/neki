package idf.everest.neki.todo.intrastracture.data.model;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class TodoItemEntity extends AbstractAuditable<TodoItemEntity, Long> {
  String text;

  public void setId(Long id) {
    super.setId(id);
  }
}
