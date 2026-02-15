package main.java.br.com.projectgradleboard;

import main.java.br.com.projectgradleboard.persistence.migration.MigrationStrategy;
import main.java.br.com.projectgradleboard.ui.MainMenu;

import java.sql.Connection;
import java.sql.SQLException;

import static br.com.projectgradleboard.persistence.config.ConnectionConfig.getConnection;

public class Main {

    public static void main(String[] args) throws SQLException {
        try (MigrationStrategy connection = getConnection()) {
            new MigrationStrategy(connection).executeMigration;
        }

        new MainMenu().execute();
    }
}
