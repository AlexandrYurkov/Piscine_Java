package edu.school21.chat.repositories;

import edu.school21.chat.models.ChatRoom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    Connection connection;
    public MessagesRepositoryJdbcImpl(DataSource data) throws SQLException {
        connection = data.getConnection();
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from chat.jc_message where message_id = " + id);
        if (!rs.next())
            return Optional.empty();
        Message message = new Message(
                rs.getLong(1),
                new User(rs.getInt(2), null, null),
                new ChatRoom(rs.getInt(3), null, null),
                rs.getString(4),
                rs.getDate(5)
        );
        statement.close();
        connection.close();
        return Optional.of(message);
    }
}
