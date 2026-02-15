package main.java.br.com.projectgradleboard.persistence.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import main.java.br.com.projectgradleboard.persistence._enum.EBoardColumnKindEnum;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Data
public class BoardEntity {

    private Long id;
    private String name;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<BoardColumnEntity> boardColumns = new ArrayList<>();

    public BoardColumnEntity getInitialColumn() {

        return getFilteredColumn(bc -> bc.getKind().equals(EBoardColumnKindEnum.INITIAL));
    }

    public BoardColumnEntity getCancelColumn () {

        return getFilteredColumn(bc -> bc.getKind().equals(EBoardColumnKindEnum.CANCEL));
    }

    private BoardColumnEntity getFilteredColumn (Predicate<BoardColumnEntity> filter) {
        return boardColumns.stream().filter(filter).findFirst().orElseThrow();
    }
}
