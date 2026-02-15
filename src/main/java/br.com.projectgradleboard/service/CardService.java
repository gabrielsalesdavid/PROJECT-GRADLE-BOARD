package main.java.br.com.projectgradleboard.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import main.java.br.com.projectgradleboard.persistence.dao.BlockDAO;
import main.java.br.com.projectgradleboard.persistence.dao.CardDAO;
import main.java.br.com.projectgradleboard.persistence.entity.CardEntity;

import lombok.AllArgsConstructor;
import main.java.br.com.projectgradleboard.dto.RBoardColumnInfoDTO;
import main.java.br.com.projectgradleboard.dto.RCardDetailsDTO;
import main.java.br.com.projectgradleboard.exception.CardBolckedException;
import main.java.br.com.projectgradleboard.exception.CardFinishedException;
import main.java.br.com.projectgradleboard.exception.EntityNotFoundException;
import main.java.br.com.projectgradleboard.persistence._enum.EBoardColumnKindEnum;

@AllArgsConstructor
public class CardService {

    private final Connection connection;

    public CardEntity insert(final CardEntity entity) throws SQLException {

        try {

            var dao = new CardDAO(connection);

            dao.insert(entity);
            connection.commit();
            return entity;
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    public void moveToNextColumn(final Long cardId, final List<RBoardColumnInfoDTO> boardColumnsInfo) throws SQLException {

        try {

            var dao = new CardDAO(connection);
            var optional = dao.findById(cardId);
            var dto = optional.orElseThrow(
                    () -> new EntityNotFoundException("O card de id%s não foi encontrado".formatted(cardId))
            );

            if (dto.blocked()) {

                var message = "O card %s está bloqueado, é nessa´rio desbloquea-lo para mover".formatted(cardId);
                throw new CardBolckedException(message);
            }

            var currentColumn = boardColumnsInfo.stream().filter(bc -> bc.id()
                    .equals(dto.columnId()))
                    .orElseThrow(() -> new IllegalStateException("O card informado pertence a outro board"));

            if (currentColumn.kind().equals(EBoardColumnKindEnum.FINAL)) {

                throw new CardFinishedException("O card já foi finalizado");
            }

            var nextColumn = boardColumnsInfo.stream()
                    .filter(bc -> bc.order() == currentColumn.order() + 1)
                    .findFirst().orElseThrow(() -> new IllegalStateException("O card está cancelado"));
            dao.moveToColumn(nextColumn.id(), cardId);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    public void cancel(final Long cardId, final Long cancelColumnId, final List<RBoardColumnInfoDTO> boardColumnsInfo) throws SQLException {

        try {

            var dao = new CardDAO(connection);
            var optional = dao.findById(cardId);
            optional.orElseThrow(
                    () -> new EntityNotFoundException("O card de id %s não foi encontrado".formatted(cardId))
            );

            if (dto.blocked()) {

                var message = "O card %s está bloqueado, é nessa´rio desbloquea-lo para mover".formatted(cardId);
                throw new CardBolckedException(message);
            }

            var currentColumn = boardColumnsInfo.stream().filter(bc -> bc.id()
                    .equals(dto.columnId()))
                    .orElseThrow(() -> new IllegalStateException("O card informado pertence a outro board"));

            if (currentColumn.kind().equals(EBoardColumnKindEnum.FINAL)) {

                throw new CardFinishedException("O card já foi finalizado");
            }

            boardColumnsInfo.stream()
                    .filter(bc -> bc.order() == currentColumn.order() + 1)
                    .findFirst().orElseThrow(() -> new IllegalStateException("O card está cancelado"));
            dao.moveToColumn(cancelColumnId, cardId);
            connection.commit();
        } catch (SQLException e) {

            connection.rollback();
            throw e;
        }
    }

    public void block(final Long id, final String reason, final List<RBoardColumnInfoDTO> boardColumnsInfo) throws SQLException {

        try {

            var dao = new CardDAO(connection);

            var optional = dao.findById(id);
            var dto = optional, orElseThrow (
                () -> new EntityNotFoundException("O card de id %s não foi encontrado".formatted(id))
            );
            if (dto.blocked()) {

                var message = "O card %s já está bloqueado".formatted(id);
                throw new CardBolckedException(message);
            }
            var currentColumn = boardColumnsInfo.stream()
                    .filter(bc -> bc.id().equals(dto.columnId()))
                    .findFirst().orElseThrow();
            if (currentColumn.kind().equals(EBoardColumnKindEnum.FINAL) || currentColumn.kind().equals(EBoardColumnKindEnum.CANCEL)) {

                throw new IllegalStateException("O card está em uma coluna do tipo %s e não pode ser bloqueado".formatted(currentColumn.kind()));
            }

            var blockDao = new BlockDAO(connection);
            blockDao.block(reason, id);

            connection.commit();
        } catch (SQLException e) {

            connection.rollback();
            throw e;
        }
    }

    public void unblock(final Long id, final String reason) throws SQLException {

        try {

            var dao = new CardDAO(connection);
            var optional = dao.findById(id);
            var dto = optional.orElseThrow(
                    () -> new EntityNotFoundException("O card de id %s não foi encontrado".formatted(id))
            );
            if (!dto.blocked()) {

                throw new CardBlockedException("O card %s não está bloqueado".formatted(id));
            }

            var blckDAO = new BlockDAO(connection);
            blockDAO.unblock(reason, id);

            connection.commit();
        } catch (SQLException e) {

            connection.rollback();
            throw e;
        }
    }
}
