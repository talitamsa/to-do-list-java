package com.todojava.todolist.exceptions;

public class ObjectNotFoundException extends RuntimeException {


    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


}
