package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class Message {
    private final Long idMessage;
    private final User authorMessage;
    private final ChatRoom chatRoom;
    private final String message;
    private final LocalDateTime date;

    public Message(Long idMessage, User authorMessage, ChatRoom chatRoom, String message, LocalDateTime date) {
        this.idMessage = idMessage;
        this.authorMessage = authorMessage;
        this.chatRoom = chatRoom;
        this.message = message;
        this.date = date;
    }


    public Long getId() {
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

    public LocalDateTime getDate() {
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
