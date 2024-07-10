package com.miniproject.rental.enums.converters;

import com.miniproject.rental.enums.Segment;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SegmentConverter implements AttributeConverter<Segment, Short> {
    @Override
    public Short convertToDatabaseColumn(Segment segment) {
        return Segment.toDatabaseColumn(segment);
    }

    @Override
    public Segment convertToEntityAttribute(Short dataBaseValue) {
        return Segment.toEntityAttribute(dataBaseValue);
    }
}