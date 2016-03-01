package fr.iocean.application.persistence.util.date;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

    public Date convertToDatabaseColumn(LocalDate date) {
        return Date.valueOf(date);
    }

    public LocalDate convertToEntityAttribute(Date value) {
        return value.toLocalDate();
    }
}