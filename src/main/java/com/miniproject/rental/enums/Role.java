package com.miniproject.rental.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum Role {
    CLIENT((short) 1),
    EMPLOYEE((short) 2),
    MANAGER((short) 3);

    private final Short DATABASE_VALUE;

    private static final Map<Short, Role> ROLE_MAP = new LinkedHashMap<>();

    static {
        for (Role roleElement : Role.values()) {
            ROLE_MAP.put(roleElement.DATABASE_VALUE, roleElement);
        }
    }

    Role(short i) {
        DATABASE_VALUE = null;
    }

    public static Role toEntityAttribute(Short dataBaseValue) {
        return dataBaseValue == null ? null : ROLE_MAP.get(dataBaseValue);
    }

    public static Short toDatabaseColumn(Role role) {
        return role == null ? null : role.DATABASE_VALUE;
    }
}