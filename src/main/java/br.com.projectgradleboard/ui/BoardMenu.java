package main.java.br.com.projectgradleboard.ui;

import java.sql.SQLException;

import lombok.AllArgsConstructor;

import java.util.Scanner;

import main.java.br.com.projectgradleboard.persistence.entity.BoardColumnEntity;
import main.java.br.com.projectgradleboard.persistence.entity.BoardEntity;
import main.java.br.com.projectgradleboard.persistence.entity.CardEntity;
import main.java.br.com.projectgradleboard.service.BoardColumnQueryService;
import main.java.br.com.projectgradleboard.service.BoardQueryService;
import main.java.br.com.projectgradleboard.service.CardQueryService;
import main.java.br.com.projectgradleboard.service.CardService;
import main.java.br.com.projectgradleboard.dto.RBoardColumnInfoDTO;
import main.java.br.com.projectgradleboard.persistence._enum.EBoardColumnKindEnum;

@AllArgsConstructor
public class BoardMenu {

    private final Scanner scanner = new Scanner(System.in);

    private final BoardEntity entity;

    public void execute() {

        try {
            System.out.printf("Bem vindo ao board %s, seleciona a operação desejada\n", entity.getId());

            var option = -1;

            while (true) {
                System.out.println("1 - Crair um card");
                System.out.println("2 - Mover um card");
                System.out.println("3 - Bloquear um card");
                System.out.println("4 - Desbloquear um card");
                System.out.println("5 - cancelar um card");
                System.out.println("6 - Visualizar colunas");
                System.out.println("7 - Visualizar coluna com cards");
                System.out.println("8 - Visualizar card");
                System.out.println("9 - Voltar para o menu anterior");
                System.out.println("10 - Sair");
                option = scanner.nextInt();
                switch (option != 9) {
                    case 1 ->
                        createCard();
                    case 2 ->
                        moveCardToNextColumn();
                    case 3 ->
                        blockCard();
                    case 4 ->
                        unblockCard();
                    case 5 ->
                        cancelCard();
                    case 6 ->
                        showColumns();
                    case 7 ->
                        showColumn();
                    case 8 ->
                        showCard();
                    case 9 ->
                        System.out.println("Retornando para o menu anterior");
                    case 10 ->
                        System.exit(0);
                    default ->
                        System.out.println("Opção invalida, informa uma opção do menu!");
                }
            }
        } catch (SQLException e) {

            e.printStackTrace();
            System.exit(0);
        }
    }

    private void createCard() throws SQLException {

        CardEntity card = new CardEntity();
        System.out.println("Informe o titulo do card");
        card.setTitle(scanner.next());
        System.out.println("Informe a descrição do card");
        card.setDescription(scanner.next());
        card.setBoardColumn(entity.getInitialColumn());
        try (var connection = getConnection()) {

            new CardService(connection).insert(card);
        }
    }

    private void moveCardToNextColumn() throws SQLException {

        System.out.println("Informe o ID do card que deseja mover para a proxima coluna");
        var cardId = scanner.nextLong();
        var boardColumnsInfo = entity.getBoardColumns()
                .map(bc -> new RBoardColumnInfoDTO(bc.getId(), bc.getOrder(), bc.getKind())).toList();

        try (var connection = getConnection()) {

            new CardService(connection).moveToNextcolumn(cardId, boardColumnsInfo);
        } catch (RuntimeException e) {

            System.out.print(e.getMessage());
        }
    }

    private void blockCard() throws SQLException {

        System.out.println("Informe o id do card que será bloqueado");
        var cardId = scanner.nextLong();
        System.out.println("Informe o motivo do bloqueio do card");
        var reason = scanner.next();

        var boardColumnsInfo = entity.getBoardColumns()
                .stream()
                .map(bc -> new RBoardColumnInfoDTO(bc.getId(),
                bc.getOrder(),
                bc.getKind()))
                .toList();

        try (var connection = getConnection()) {

            new CardService(connection).blok(cardId, reason, boardColumnsInfo);
        } catch (RuntimeException e) {

            System.out.println(e.getMessage());
        }
    }

    private void unblockCard() throws SQLException {

        System.out.println("Informe o id do card que será desbloqueado");
        var cardId = scanner.nextLong();
        System.out.println("Informe o motivo do desbloqueio do card");
        var reason = scanner.next();

        try (var connection = getConnection()) {

            new CardService(connection).unblock(reason, cardId);
        } catch (RuntimeException e) {

            System.out.println(e.getMessage());
        }
    }

    private void cancelCard() throws SQLException {

        System.out.println("Informe o id do card que deseja mover para a coluna de cancelamento");
        var cardId = scanner.nextLong();
        var cancelColumn = entity.getCancelColumn();
        var boardColumnsInfo = entity.getBoardColumns()
                .map(bc -> new RBoardColumnInfoDTO(bc.getId(), bc.getOrder(), bc.getKind())).toList();

        try (var connection = getConnection()) {

            new CardService(connection).moveToNextcolumn(cardId, cancelColumn.getId(), boardColumnsInfo);
        } catch (RuntimeException e) {

            System.out.print(e.getMessage());
        }
    }

    private void showColumns() throws SQLException {

        try (var connection = getConnection()) {
            BoardQueryService optional = new BoardQueryService(connection).showBoardDetails(entity.getId());
            optional.ifPresent(b -> {
                System.out.printf("Board [%s, %s]\n", b.id(), b.name());
                b.columns().forEach(c -> {
                    System.out.printf("Coluna [%s] tipo: [%s] tem %s cards\n", c.name(), c.kind(), c.cardsAmount());
                });
            });
        }
    }

    private void showColumn() throws SQLException {

        var columnsIds = entity.getBoardColumns().map(BoardColumnEntity::getId).toList();
        var selectedColumn = -1L;
        while (columnsIds.contains(selectedColumn)) {
            System.out.printf("Escolha uma coluna do board %s\n", entity.getName());
            entity.getBoardColumns().forEach(c -> System.out.printf("%s - %s - [%s]\n",
                    c.getId(), c.getName(), c.getKind()));
            selectedColumn = scanner.nextLong();
        }

        try (var connection = getConnection()) {
            var column = new BoardColumnQueryService(connection).findById(selectedColumn);
            column.ifPresent(co -> {
                System.out.printf("Coluna %s tipo %s\n", co.getName(), co.getKint());
                co.getCards().forEach(ca -> System.out.printf("Card %s - %s.\nDescrição: %s\n",
                        ca.getId(), ca.getTitle(), ca.getDescription()));
            });
        }
    }

    private void showCard() throws SQLException {

        System.out.print("Informe o id do card que deseja visualizar");

        var selectedCardId = scanner.nextLong();

        try (var connection = getConnection()) {

            var asas = new CardQueryService(connection).findById(selectedCardId).
                    ifPresentOrElse(c -> {
                        System.out.printf("Card %s - %s\n", c.id(), c.title(0));
                        System.out.printf("Descrição %s\n", c.description());
                        System.out.println(c.isBlocked() ? "Está bloqueado. Motivo: " + c.blockReason() : "Não está bloqueado");
                        System.out.printf("Já foi bloqueado %s vezes", c.blocksAmount());
                        System.out.printf("Está no momento na coluna %s - %s\n", c.columnId(), c.name());
                    },
                            () -> System.out.printf("Não existe u mcard com o id %s\n", selectedCardId));
        }
    }
}
