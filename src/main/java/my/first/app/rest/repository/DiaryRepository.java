package my.first.app.rest.repository;

import my.first.app.rest.models.Note;
import org.springframework.data.repository.CrudRepository;

public interface DiaryRepository extends CrudRepository<Note, Long>{

}
