package my.first.app.rest.controllers;

import my.first.app.rest.models.Diary;
import my.first.app.rest.repository.DiaryRepository;
import my.first.app.rest.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiaryController {
    private final DiaryService diaryService; //с помощью объекта будем вызывать методы

    @Autowired  //внедрение зависимостей
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @Autowired
    private DiaryRepository diaryRepository; //объект с помощью которого делаем запросы к таблице

    //вставка заметки
    @PostMapping(value = "/notes")
    public ResponseEntity<?> create(@RequestBody Diary note) {
        diaryService.create(note);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //получение всех заметок
    @GetMapping(value = "/notes")
    public ResponseEntity<List<Diary>> readAll() {
        final List<Diary> tasks = diaryService.readAll();
        return tasks != null && !tasks.isEmpty() ?
                new ResponseEntity<>(tasks, HttpStatus.OK) :
                new ResponseEntity<>(tasks, HttpStatus.NOT_FOUND);
    }

    //получение заметок по ид
    @GetMapping(value = "/notes/{id}")
    public ResponseEntity<Diary> read(@PathVariable(name="id") int id) {
        final Diary task = diaryService.read(id);
        return task != null ?
                new ResponseEntity<>(task, HttpStatus.OK) :
                new ResponseEntity<>(task, HttpStatus.NOT_FOUND);
    }

    //обновление заметки
    @PutMapping(value = "/notes/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") int id, @RequestBody Diary note) {
        final boolean isUpdate = diaryService.update(note, id);
        return isUpdate ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //удаление заметки
    @DeleteMapping(value = "/notes/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") int id) {
        final boolean isDelete = diaryService.delete(id);
        return isDelete ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
