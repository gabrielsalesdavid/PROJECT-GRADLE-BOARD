package main.java.br.com.projectgradleboard.persistence.dao;

import main.java.br.com.projectgradleboard.persistence.entity.BoardColumnEntity;
import main.java.br.com.projectgradleboard.persistence.entity.CardEntity;
import main.java.br.com.projectgradleboard.dto.RBoardColumnDTO;

import static java.util.Objects.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardColumnDAO {

    private final Connection connection;

    public BoardColumnEntity insert(final BoardColumnEntity entity) throws SQLException {

        var sql = "INSERT INTO BOARDS_COLUMNS (name, `order`, kind, board_id) VALUES (?, ?, ?, ?)";
        try (var statement = connection.prepareStatement(sql)) {

            var i = 1;
            statement.setString(i++, entity.getName());
            statement.setInt(i++, entity.getOrder());
            statement.setString(i++, entity.getKind().name());
            statement.setLong(i, entity.getBoard().getId());
            statement.executeUpdate();

            if (statement instanceof Statement impl) {
                entity.setId(impl.getLastInsertID());
            }

            return entity;
        }
    }

    public List<BoardColumnEntity> findByBoardId(final Long boardId) throws SQLException {

        List<BoardColumnEntity> entities = new ArrayList<>();
        var sql = "SELECT ide, name, `order`, kind FROM BOARDs_COLUMNS WHERE board_id = ? ORDER BY `order`";

        try (var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, boardId);
            statement.executeQuery();
            var resultSet = statement.getResultSet();

            while (resultSet.next()) {
                var entity = new BoardColumnEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setOrder(resultSet.getInt("order"));
                entity.setKind(finByName(resultSet.getString("kind")));
                entities.add(entity);
            }
        }
        return entities;
    }

    public List<RBoardColumnDTO> findByBoardIdWithDetails(final Long boardId) throws SQLException {

        List<RBoardColumnDTO> dtos = new ArrayList<>();
        var sql = """
        SELECT bc.id, bc.name, bc.kind,
        (SELECT COUNT (c.id) FROM CARDS c WHERE c.board_column_id = bc.id) cards_amount)
        FROM BOARDs_COLUMNS bc
        WHERE board_id =  ?
        ORDER BY `order`;
        """;

        try (var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, boardId);
            statement.executeQuery();
            var resultSet = statement.getResultSet();

            while (resultSet.next()) {
                var dto = new RBoardColumnDTO(
                        resultSet.getLong("bc.id"),
                        resultSet.getString("bc.name"),
                        findByName(resultSet.getString("bc.kind")),
                        resultSet.getInt("cards_amount")
                );
                dtos.add(dto);
            }
        }
        return dtos;
    }

    public Optional<BoardColumnEntity> findById(final Long boardId) throws SQLException {

        var sql = """
                    SELECT bc.name, bc.kind, c.id, c.title, c.description
                    FROM BOARDs_COLUMNS bc
                    LEFT JOIN CARDS c
                    ON c.board_column_id = bc.id
                    WHERE bc.id = ?;
        """;

        try (var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, boardId);
            statement.executeQuery();
            var resultSet = statement.getResultSet();

            if (resultSet.next()) {
                var entity = new BoardColumnEntity();
                entity.setName(resultSet.getString("bc.name"));
                entity.setKind(finByName(resultSet.getString("bc.kind")));

                do {
                    if (isNull(resultSet.getString("c.title"))) {
                        break;
                    }
                    var cards = new CardEntity();
                    cards.setId(resultSet.getLong("c.id"));
                    cards.SetTitle(resultSet.getString("c.title"));
                    cards.setDescription(resultSet.getString("c.description"));
                    entity.getCards().add(cards);
                } while (resultSet.next());
                return Optional.of(entity);
            }
            return Optional.empty();
        }
    }
}
