package my.first.app.rest.service;

import my.first.app.rest.models.Diary;

import java.util.List;

public interface DiaryService {
    /**
     * Создание нового юзера
     * @param note - заметка, котрую будем добавлять
     */
    void create(Diary note);

    /**
     * Получение всех заметок
     * @return
     */
    List<Diary> readAll();

    /**
     *
     * @param id - идентификатор по которому получим заметку
     * @return
     */
    Diary read(int id);

    /**
     * Обновление информации о юзере по ид
     * @param note - объект, включающий новые свойства заметки
     * @param id - по этому ид ищем в базе заметку у которого меняем информацию
     * @return
     */
    boolean update(Diary note, int id);

    /**
     * Удаление заметки по id
     * @param id
     * @return
     */
    boolean delete(int id);
}
