package main.java.br.com.projectgradleboard.persistence.entity;

import java.time.OffsetDateTime;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;

@NoArgsConstructor
@Getter
@Setter
@Data
public class BlockEntity {
    private Long id;
    private OffsetDateTime blockedAt;
    private String blockReason;
    private OffsetDateTime unblockedAt;
    private String unblockReason;
}