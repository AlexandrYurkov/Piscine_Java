package edu.school21.chat.models;

public class NotSavedSubEntityException extends Exception{
    public NotSavedSubEntityException(String message) {
        super(message);
    }
}
