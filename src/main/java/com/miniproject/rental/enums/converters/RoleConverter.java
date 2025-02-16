package com.miniproject.rental.enums.converters;

import com.miniproject.rental.enums.Role;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, Short> {
    @Override
    public Short convertToDatabaseColumn(Role role) {
        return Role.toDatabaseColumn(role);
    }

    @Override
    public Role convertToEntityAttribute(Short dataBaseValue) {
        return Role.toEntityAttribute(dataBaseValue);
    }
}