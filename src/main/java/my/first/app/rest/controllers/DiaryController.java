package my.first.app.rest.controllers;

import my.first.app.rest.models.Note;
import my.first.app.rest.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class DiaryController {
    private final DiaryService diaryService; //с помощью объекта будем вызывать методы

    @Autowired  //внедрение зависимостей
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    //вставка заметки
    @PostMapping(value = "/notes")
    public ResponseEntity<?> create(@RequestParam("id") Integer id,
                                    @RequestParam("topic") String topic,
                                    @RequestParam("description") String description,
                                    @RequestParam("date") String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        Note note = new Note(Long.valueOf(id), topic, description, dateTime);
        diaryService.create(note);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //получение всех заметок
    @GetMapping(value = "/notes")
    public ResponseEntity<List<Note>> readAll() {
        final List<Note> notes = diaryService.readAll();
        return notes != null && !notes.isEmpty() ?
                new ResponseEntity<>(notes, HttpStatus.OK) :
                new ResponseEntity<>(notes, HttpStatus.NOT_FOUND);
    }

    //получение заметок по ид
    @GetMapping(value = "/notes/{id}")
    public ResponseEntity<Note> read(@PathVariable(name="id") Long id) {
        final Note note = diaryService.read(id);
        return note != null ?
                new ResponseEntity<>(note, HttpStatus.OK) :
                new ResponseEntity<>(note, HttpStatus.NOT_FOUND);
    }

    //обновление заметки
    @PutMapping(value = "/notes/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") Long id, @RequestBody Note note) {
        final boolean isUpdate = diaryService.update(note, id);
        return isUpdate ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //удаление заметки
    @DeleteMapping(value = "/notes/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
        final boolean isDelete = diaryService.delete(id);
        return isDelete ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
