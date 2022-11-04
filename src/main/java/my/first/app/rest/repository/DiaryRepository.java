package my.first.app.rest.repository;

import my.first.app.rest.models.Diary;
import org.springframework.data.repository.CrudRepository;

public interface DiaryRepository extends CrudRepository<Diary, Long>{

}
