package my.first.app.rest.exceptions;

public class NoteNotFoundException extends Exception {

    public NoteNotFoundException(long id){
        super(String.format("Note with id=%d not found.", id));
    }
}
