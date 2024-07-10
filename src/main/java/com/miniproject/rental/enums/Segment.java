package com.miniproject.rental.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum Segment {
    HATCH((short) 1),
    SEDAN((short) 2),
    SUV((short) 3),
    PICK_UP((short) 4);

    private final Short DATABASE_VALUE;

    private static final Map<Short, Segment> SEGMENT_MAP = new LinkedHashMap<>();

    static {
        for (Segment segmentElement : Segment.values()) {
            SEGMENT_MAP.put(segmentElement.DATABASE_VALUE, segmentElement);
        }
    }

    public static Segment toEntityAttribute(Short dataBaseValue) {
        return dataBaseValue == null ? null : SEGMENT_MAP.get(dataBaseValue);
    }

    public static Short toDatabaseColumn(Segment segment) {
        return segment == null ? null : segment.DATABASE_VALUE;
    }
}