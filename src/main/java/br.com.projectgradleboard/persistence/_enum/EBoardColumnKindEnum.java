package main.java.br.com.projectgradleboard.persistence._enum;


import java.util.stream.Stream;

public enum EBoardColumnKindEnum {

    INITIAL, FINAL, CANCEL, PENDING;

    public static EBoardColumnKindEnum findByName(final String name) {
        return Stream.of(EBoardColumnKindEnum.values())
                .filter(b -> b.name().equals(name))
                .findFirst().orElseThrow();
    }
}
