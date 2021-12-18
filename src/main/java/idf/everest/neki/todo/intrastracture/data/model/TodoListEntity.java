package idf.everest.neki.todo.intrastracture.data.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class TodoListEntity extends AbstractAuditable<TodoListEntity, Long> {

  private String name;

  @OneToMany
  private List<TodoItemEntity> items;

  public void setId(Long id) {
    super.setId(id);
  }
}

