package main.java.br.com.projectgradleboard.service;

import main.java.br.com.projectgradleboard.persistence.dao.BoardColumnDAO;
import main.java.br.com.projectgradleboard.persistence.dao.BoardDAO;
import main.java.br.com.projectgradleboard.persistence.entity.BoardEntity;

import java.sql.SQLException;

public class BoardService {

    private final Connection connection;

    public BoardEntity insert(final BoardEntity entity) throws SQLException {

        var dao = new BoardDAO(connection);
        var boardColumnDAO = new BoardColumnDAO(connection);
        try {
            dao.insert(entity);
            var columns = entity.getBoard().stream().map(c -> {
                c.setBoard(entity);
                return c;
            }).toList();

            for (var column : columns) {
                boardColumnDAO.insert(column);
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
        return entity;
    }

    private boolean delete(final Long id) throws SQLException {
        var dao = new BoardDAO(connection);

        try {
            if (dao.exists(id)) {
                return false;
            }
            dao.delete(id);
            connection.commit();
            return true;
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }
}
