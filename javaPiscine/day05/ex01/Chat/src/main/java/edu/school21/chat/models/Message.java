package edu.school21.chat.models;

import java.util.Date;
import java.util.Objects;

public class Message {
    private final long idMessage;
    private final User authorMessage;
    public final ChatRoom chatRoom;
    public final String message;
    public final Date date;

    public Message(long idMessage, User authorMessage, ChatRoom chatRoom, String message) {
        this.idMessage = idMessage;
        this.authorMessage = authorMessage;
        this.chatRoom = chatRoom;
        this.message = message;
        this.date = new Date();
    }

    public Message(long idMessage, User authorMessage, ChatRoom chatRoom, String message, Date date) {
        this.idMessage = idMessage;
        this.authorMessage = authorMessage;
        this.chatRoom = chatRoom;
        this.message = message;
        this.date = date;
    }

    public long getIdMessage() {
        return idMessage;
    }

    public User getAuthorMessage() {
        return authorMessage;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return idMessage == message1.idMessage && Objects.equals(authorMessage, message1.authorMessage) && Objects.equals(chatRoom, message1.chatRoom) && Objects.equals(message, message1.message) && Objects.equals(date, message1.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMessage, authorMessage, chatRoom, message, date);
    }

    @Override
    public String toString() {
        return "Message{" +
                "idMessage=" + idMessage +
                ", authorMessage=" + authorMessage +
                ", chatRoom=" + chatRoom +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
