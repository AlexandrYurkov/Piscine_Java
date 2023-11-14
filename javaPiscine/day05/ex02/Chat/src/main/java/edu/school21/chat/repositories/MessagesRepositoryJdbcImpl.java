package edu.school21.chat.repositories;

import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.NotSavedSubEntityException;
import edu.school21.chat.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    Connection connection;
    public MessagesRepositoryJdbcImpl(DataSource data) throws SQLException {
        connection = data.getConnection();
    }

    @Override
    public void save(Message message) throws SQLException, NotSavedSubEntityException {
        try (Statement statement = connection.createStatement()) {
            if (message.getAuthorMessage().getIdUser() == null
                    || message.getChatRoom().getIdChatRoom() == null
                    || message.getId() == null) {
                throw new NotSavedSubEntityException("Значение Id неможет быть null");
            }
            statement.execute("INSERT INTO chat.jc_message (message_id, message_author, message_room, message_text, message_timestamp) values ('"
                    + message.getId() + "', '"
                    + message.getAuthorMessage().getIdUser() + "', '"
                    + message.getChatRoom().getIdChatRoom() + "', '"
                    + message.getMessage() + "', '"
                    + message.getDate() + "');"
            );
        } catch (SQLException e) {
            throw new NotSavedSubEntityException(e.getMessage());
        } finally {
            connection.close();
        }
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from chat.jc_message where message_id = " + id);
        if (!rs.next())
            return Optional.empty();
        Message message = new Message(
                rs.getLong(1),
                new User(rs.getLong(2), null, null, null, null),
                new ChatRoom(rs.getLong(3), null, null, null),
                rs.getString(4),
                rs.getDate(5).toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime()
        );
        statement.close();
        connection.close();
        return Optional.of(message);
    }
}
