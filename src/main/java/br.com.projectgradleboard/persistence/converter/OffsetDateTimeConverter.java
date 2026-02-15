package main.java.br.com.projectgradleboard.persistence.converter;

import lombok.NoAllArgsConstructor;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

import static lombok.AccessLevel.PRIVATE;
import static java.time.ZoneOffset.UTC;
import static java.util.Objects.nonNull;

@NoArgsCOnstructor(access = PRIVATE)
public final class OffsetDateTimeConverter {

    public static OffsetDateTime toOffsetDateTime(final Timestamp value) throws SQLException {

        return nonNull(value) ? OffsetDateTime.ofInstant(value.toInstant(), UTC) : null;
    }

    public static Timestamp toTimestamp(final OffsetDateTime value) {

        return nonNull(value) ? Timestamp.valueOf(value.atZoneSameInstant(UTC).toLocalDateTime()) : null;
    }
}
