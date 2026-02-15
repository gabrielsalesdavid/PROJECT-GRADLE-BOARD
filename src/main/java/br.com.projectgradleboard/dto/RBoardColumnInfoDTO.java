package main.java.br.com.projectgradleboard.dto;

import main.java.br.com.projectgradleboard.persistence._enum.EBoardColumnKindEnum;

public record RBoardColumnInfoDTO(Long id, int order, EBoardColumnKindEnum kind) {
}
