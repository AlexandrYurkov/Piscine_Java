package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class ChatRoom {
    private Long idChatRoom;
    private String nameChatRoom;
    private User author;
    private ArrayList<User> users = new ArrayList<>();

    public ChatRoom(Long idChatRoom, String nameChatRoom, User author, ArrayList<User> users) {
        this.idChatRoom = idChatRoom;
        this.nameChatRoom = nameChatRoom;
        this.author = author;
        this.users = users;
    }

    public Long getIdChatRoom() {
        return idChatRoom;
    }

    public void setIdChatRoom(Long idChatRoom) {
        this.idChatRoom = idChatRoom;
    }

    public String getNameChatRoom() {
        return nameChatRoom;
    }

    public void setNameChatRoom(String nameChatRoom) {
        this.nameChatRoom = nameChatRoom;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatRoom chatRoom = (ChatRoom) o;
        return Objects.equals(idChatRoom, chatRoom.idChatRoom) && Objects.equals(nameChatRoom, chatRoom.nameChatRoom) && Objects.equals(author, chatRoom.author) && Objects.equals(users, chatRoom.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChatRoom, nameChatRoom, author, users);
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "idChatRoom=" + idChatRoom +
                ", nameChatRoom='" + nameChatRoom + '\'' +
                ", author=" + author +
                ", users=" + users +
                '}';
    }
}