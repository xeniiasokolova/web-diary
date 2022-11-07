package my.first.app.rest.service;

import my.first.app.rest.models.Note;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Repository
@Transactional
public class DiaryServImpl implements DiaryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void create(Note note) {
        entityManager.persist(note);
    }

    @Override
    public List<Note> readAll() {
        return entityManager.createQuery("from Note", Note.class).getResultList();
    }

    @Override
    public Note read(Long id) {
        return entityManager.find(Note.class, id);
    }

    @Override
    public boolean update(Note note, Long id) {
        try {
            Note noteOld = entityManager.find(Note.class, id);
            noteOld.setId(note.getId());
            noteOld.setDate(note.getDate());
            noteOld.setDescription(note.getDescription());
            noteOld.setTopic(note.getTopic());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        Note note = entityManager.find(Note.class, id);
        try {
            entityManager.remove(note);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
