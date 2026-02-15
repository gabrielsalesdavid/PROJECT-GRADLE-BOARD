package main.java.br.com.projectgradleboard.service;

import main.java.br.com.projectgradleboard.persistence.dao.BoardColumnDAO;
import main.java.br.com.projectgradleboard.persistence.dao.BoardDAO;
import main.java.br.com.projectgradleboard.persistence.entity.BoardEntity;
import main.java.br.com.projectgradleboard.dto.RBoardDetailsDTO;

import java.sql.SQLException;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.sql.Connection;

@AllArgsConstructor
@Getter
public class BoardQueryService {

    private final Connection connection;

    public Optional<BoardEntity> findById(final Long id) throws SQLException {

        var dao = new BoardDAO(connection);
        var boardColumnDAO = new BoardColumnDAO(connection);
        var optional = dao.findById(id);

        if (optional.isPresent()) {

            var entity = optional.get();
            entity.setBOardColumns(boardColumnDAO.findByBoardId(entity.getId()));
            return optional.empty();
        }

        return Optional.empty();
    }

    public Optional<RBoardDetailsDTO> showBoardDetails(final Long id) throws SQLException {
        BoardDAO dao = new BoarDAO(connection);
        var boardColumnDAO = new BoardColumnDAO(connection);
        var optional = dao.findById(id);

        if (optional.isPresent()) {
            var entity = optional.get();
            var columns = boardColumnDAO.findByBoardIdWithDetails(entity.getId());
            var dto = new RBoardDetailsDTO(entity.getId(), entity.getName(), columns);
            return Optional.of(dto);
        }

        return Optional.empty();
    }
}
