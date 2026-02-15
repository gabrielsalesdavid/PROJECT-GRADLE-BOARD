package main.java.br.com.projectgradleboard.service;

import main.java.br.com.projectgradleboard.persistence.entity.BoardColumnEntity;

import lombok.AllArgsConstructor;
import java.sql.Connection;
import java.util.Optional;
import java.sql.SQLException;

@AllArgsConstructor
public class BoardColumnQueryService {

    private final Connection connection;

    public Optional<BoardColumnEntity> findById(final Long id) throws SQLException {

        var dao = new BOardColumnDAO(connection);
        return dao.findById(id);
    }
}
