package main.java.br.com.projectgradleboard.dto;

import java.sql.SQLException;
import java.time.OffsetDateTime;

public record RCardDetailsDTO(Long id,
        String title,
        String description,
        boolean blocked,
        OffsetDateTime blockedAt,
        String blockedReason,
        int blocksAmount,
        Long cloumnId,
        String columnName) {

}
