package edu.school21.chat.app;

import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.NotSavedSubEntityException;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.DataSource;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws SQLException {
        try {
            User creator = new User(3L, "user", "user", new ArrayList(), new ArrayList());
            User author = creator;
            ChatRoom room = new ChatRoom(1L, "room", creator, new ArrayList());
            Message message = new Message(12L, author, room, "Hello!", LocalDateTime.now());
            MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(new DataSource());
            messagesRepository.save(message);
            System.out.println(message.getId());
        }catch (NotSavedSubEntityException e){
            System.out.println(e.getMessage());
        }
    }
}