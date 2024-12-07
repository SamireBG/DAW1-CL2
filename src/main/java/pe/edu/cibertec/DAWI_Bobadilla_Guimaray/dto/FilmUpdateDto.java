package pe.edu.cibertec.DAWI_Bobadilla_Guimaray.dto;

import java.util.Date;

public record FilmUpdateDto(Integer filmId,
                            String title,
                            String language,
                            Double rentalRate) {
}
