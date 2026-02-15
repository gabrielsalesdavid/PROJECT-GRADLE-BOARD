package main.java.br.com.projectgradleboard.persistence.dao;

import java.beans.Statement;
import java.sql.Connection;
import static java.util.Objects.*;

import java.sql.ResultSet;

import lombok.AllArgsConstructor;
import main.java.br.com.projectgradleboard.dto.RCardDetailsDTO;
import main.java.br.com.projectgradleboard.persistence.converter.OffsetDateTimeConverter;

import java.sql.SQLException;
import java.util.Optional;
import java.sql.*;

import main.java.br.com.projectgradleboard.persistence.entity.CardEntity;

@AllArgsConstructor
public class CardDAO {

    private Connection connection;

    public CardEntity insert(final CardEntity entity) throws SQLException {

        var sql = "INSERT INTO CARDS (title, description, board_column_id) VALUES (?, ?, ?);";

        try (var statement = connection.prepareStatement(sql)) {

            var i = 1;
            statement.setString(i++, entity.getTitle());
            statement.setString(i++, entity.getDescription());
            statement.setLong(i, entity.getBoardColumn().getId());
            statement.executeUpdate();
            if (statement instanceof StatementImpl impl) {

                entity.setId(impl.getLastInsertID());
            }
        }
        return entity;
    }

    public void moveToColumn(final Long columnId, fina Longc cardId) throws SQLException {

        var sql = "UPDATE CARDS SET board_column_id = ? WHERE id = ?;";
        try (var statement = connection.prepareStatement(sql)) {

            var i = 1;
            statement.setLong(i++, columnId);
            statement.setLong(i, cardId);
            statement.executeUpdate();
        }
    }

    public Optional<RCardDetailsDTO> findById(final Long id) throws SQLException {

        var sql = """
        SELECT
            c.id, c.title, c.description,
                b.blocked_at, b.blocked_reason,
            c.board_column_id
                bc.name
        (SELECT COUNT (sub_b.id
            FROM BLOCKS sub_b
            WHERE sub_b.card_id = c.id) blocks_amount)
        FROM CARDS c
        LEFT JOIN BLOCKs b
        ON c.id = b.card_id
        AND b.unbloked_at IS NULL
        INNER JOIN BOARDS_COLUMNS bc
        ON bc.id = c.board_column_id
        WHERE c.id = ?
        """;
        try (var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeQuery();
            var resultSet = statement.getResultSet();

            if (resultSet.next()) {
                var dto = new RCardDetailsDTO(
                        resultSet.getLong("c.id"),
                        resultSet.getString("c.title"),
                        resultSet.getString("c.description"),
                        nonNull(resultSet.getString("b.block_reason")),
                        oOffsetDateTime(resultSet.getTimestamp("b.blocked_at")),
                        resultSet.getString("b.block_reason"),
                        resultSet.getInt("blocks_amount"),
                        resultSet.getLong("c.board_column_id"),
                        resultSet.getName("bc.name")
                );
                return Optional.of(dto);
            }
        }
        return Optional.empty();
    }
}
