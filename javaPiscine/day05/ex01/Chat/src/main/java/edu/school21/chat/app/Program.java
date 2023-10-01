package edu.school21.chat.app;

import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.DataSource;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

class Program{

    public static void main(String[] args)  {
        System.out.println("Введите id сообщения:");
        Scanner scan = new Scanner(System.in);
        long number = scan.nextLong();
        try{
//            Connection date = new DataSource().getConnection();
            MessagesRepositoryJdbcImpl test =  new MessagesRepositoryJdbcImpl(new DataSource());
            Optional<Message> message = test.findById(number);
            System.out.println(message.get());
        }catch (SQLException e){
            e.printStackTrace();
        }
        scan.close();
    }
}