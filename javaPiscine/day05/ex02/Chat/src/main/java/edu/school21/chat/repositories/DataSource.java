package edu.school21.chat.repositories;

import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.*;

public class DataSource extends HikariDataSource {
    HikariConfig config;
    HikariDataSource data;

    public DataSource() {
        config = new HikariConfig();
        config.setUsername("lfallon");
        config.setPassword("");
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/lfallon");
        data = new HikariDataSource(config);

    }
    public Connection getConnection() throws SQLException {
        if(!data.getConnection().isClosed()){
            return this.data.getConnection();
        }
        else{
            return new DataSource().getConnection();
        }
    }


}
