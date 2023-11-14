package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private Long idUser;
    private final String login;
    private final String password;
    public ArrayList<ChatRoom> createChatRoom  = new ArrayList<>();
    public ArrayList<ChatRoom> activeChatRoom = new ArrayList<>();

    public User(Long idUser, String login, String password, ArrayList<ChatRoom> createChatRoom,
                ArrayList<ChatRoom> activeChatRoom) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.createChatRoom.addAll(createChatRoom);
        this.activeChatRoom.addAll(activeChatRoom);
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public Boolean getPassword(String password) {
        return this.password.equals(password);
    }
    public ArrayList<ChatRoom> getCreateChatRoom() {
        return createChatRoom;
    }

    public void setCreateChatRoom(ChatRoom createChatRoom) {
        this.createChatRoom.add(createChatRoom);
    }

    public ArrayList<ChatRoom> getActiveChatRoom() {
        return activeChatRoom;
    }

    public void setActiveChatRoom(ChatRoom activeChatRoom) {
        this.activeChatRoom.add(activeChatRoom);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(idUser, user.idUser) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(createChatRoom, user.createChatRoom) && Objects.equals(activeChatRoom, user.activeChatRoom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, login, password, createChatRoom, activeChatRoom);
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser + "\n" +
                "login='" + login + '\'' + "\n" +
                "password='" + password + '\'' + "\n" +
                "createChatRoom=" + createChatRoom + "\n" +
                "ActiveChatRoom=" + activeChatRoom + "\n" +
                '}';
    }
}