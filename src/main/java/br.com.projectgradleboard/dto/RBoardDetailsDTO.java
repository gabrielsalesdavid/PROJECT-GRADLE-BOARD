package main.java.br.com.projectgradleboard.dto;

import main.java.br.com.projectgradleboard.dto.BoardColumnDTO;
import main.java.br.com.projectgradleboard.dto.RBoardDetailsDTO;

public record RBoardDetailsDTO(Long id, String name, List<BoardColumnDTO> columns) {

}
