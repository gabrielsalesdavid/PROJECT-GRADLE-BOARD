package main.java.br.com.projectgradleboard.dto;

import main.java.br.com.projectgradleboard.persistence._enum.EBoardColumnKindEnum;
import main.java.br.com.projectgradleboard.dto.RBoardColumnDTO;

public record RBoardColumnDTO(Long id, String name, EBoardColumnKindEnum kind, int cardsAmount) {

}
