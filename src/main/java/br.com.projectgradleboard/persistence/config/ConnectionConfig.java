package br.com.projectgradleboard.persistence.config;

import java.sql.Connection;
import java.sql.DriverManager;

import lombok.NoArgsConstructor;
import lombok.Getter;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
@Getter
public final class ConnectionConfig {

    public static Connection getConnection() {

        var url = "jdbc:mysql://localhost/board";
        var user = "board";
        var password = "board";
        var connection = DriverManager.getConnection(url , user, password);

        connection.setAutoCommit(false);
        return connection;
    }
}