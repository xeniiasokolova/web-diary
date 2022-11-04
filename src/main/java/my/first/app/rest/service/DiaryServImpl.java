package my.first.app.rest.service;

import my.first.app.rest.models.Diary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DiaryServImpl implements DiaryService {
    private static Map<Integer, Diary> notes = new HashMap<>();
    private static final AtomicInteger NOTE_ID = new AtomicInteger();

    public void create(Diary note) {
        //для вставки нового юзера необходимо сделать инкремент для ключа
        final int noteID = NOTE_ID.incrementAndGet(); //инкремент для текущего ид
        note.setId(noteID); //сохранили для текущего юзера новый ключ
        notes.put(noteID, note);  //добавили юзера в коллекцию
    }

    @Override
    public List<Diary> readAll() {
        return new ArrayList<>(notes.values()); //получаем список всех объектов записей их hashmap
    }

    @Override
    public Diary read(int id) {
        return notes.get(id);
    }

    @Override
    public boolean update(Diary note, int id) {
        //проверим, что в users есть юзер с таким ид
        if (notes.containsKey(id)) {
            note.setId(id);
            notes.put(id, note);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return notes.remove(id) != null;
    }
}
