package edu.school21.chat.repositories;

import edu.school21.chat.models.Message;
import edu.school21.chat.models.NotSavedSubEntityException;

import java.sql.SQLException;
import java.util.Optional;

public interface MessagesRepository {
    Optional<Message> findById(Long id) throws SQLException;
    public void save (Message message) throws SQLException, NotSavedSubEntityException;
}
