package main.java.br.com.projectgradleboard.service;

import lombok.AllArgsConstructor;
import main.java.br.com.projectgradleboard.dto.RCardDetailsDTO;

import java.sql.Connection;
import java.util.Optional;
import java.sql.SQLException;

import main.java.br.com.projectgradleboard.persistence.dao.CardDAO;

@AllArgsConstructor
public class CardQueryService {

    private final Connection connection;

    public Optional<RCardDetailsDTO> findById(final Long id) throws SQLException {

        var dao = new CardDAO(connection);
        return dao.finById(id);
    }
}
