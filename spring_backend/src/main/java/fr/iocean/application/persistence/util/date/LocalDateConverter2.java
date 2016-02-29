package fr.iocean.application.persistence.util.date;

import java.sql.Date;
import java.time.LocalDate;

public class LocalDateConverter2 {
	public static Date toDate(LocalDate date) {
        return Date.valueOf(date);
    }

    public static LocalDate toLocalDate(Date value) {
        return value.toLocalDate();
    }
}
