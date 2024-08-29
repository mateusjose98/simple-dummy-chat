package org.mateusjose98.simplechat.repository.rowmappers;

import lombok.Data;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class MessageDto {
    private String name;
    private String content;
    private Instant createdAt;

    public MessageDto(String name, String content, Instant createdAt) {
        this.name = name;
        this.content = content;
        this.createdAt = createdAt;
    }

    public MessageDto() {
    }

    public MessageDto(Object[] row) {
        this.name = (String) row[0];
        this.content = (String) row[1];
        this.createdAt = ((OffsetDateTime) row[2]).toInstant();
    }

}
