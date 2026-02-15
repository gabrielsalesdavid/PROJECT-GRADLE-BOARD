package main.java.br.com.projectgradleboard.persistence.entity;

import main.java.br.com.projectgradleboard.persistence._enum.EBoardColumnKindEnum;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Getter
@Setter
@Data
public class BoardColumnEntity {

    private Long id;
    private String name;
    private int order;
    private EBoardColumnKindEnum kind;
    private BoardEntity boardEntity = new BoardEntity();
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<CardEntity> cards = new ArrayList<>();
}
