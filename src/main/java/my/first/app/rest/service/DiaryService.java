package my.first.app.rest.service;

import my.first.app.rest.models.Note;

import java.util.List;

public interface DiaryService {
    /**
     * Создание новой заметки
     * @param note - заметка, которую будем добавлять
     */
    void create(Note note);

    /**
     * Получение всех заметок
     * @return
     */
    List<Note> readAll();

    /**
     * Получить заметку по id
     * @param id - идентификатор
     * @return
     */
    Note read(Long id);

    /**
     * Обновить заметку по id
     * @param note - заметок
     * @param id - идентификатор
     * @return
     */
    boolean update(Note note, Long id);

    /**
     * Удалить заметку по id
     * @param id - идентификатор
     * @return
     */
    boolean delete(Long id);
}
