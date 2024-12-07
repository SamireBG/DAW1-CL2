package pe.edu.cibertec.DAWI_Bobadilla_Guimaray.dto;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

import java.util.Date;

public record FilmRecordDto(
        Integer filmId,
        String title,
        String description,
        Integer releaseYear,
        Integer rentalDuration,
        Double rentalRate,
        Integer length,
        Double replacementCost,
        String rating,
        String specialFeatures,
        Integer languageId,
        @DateTimeFormat(pattern = "yyyy-MM-dd") Date lastUpdate
) {
    public static FilmRecordDto empty() {
        return new FilmRecordDto(null, "", "", null, null, null, null, null, "", "", null, null);
    }
}