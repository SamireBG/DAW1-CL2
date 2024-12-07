package pe.edu.cibertec.DAWI_Bobadilla_Guimaray.service;

import pe.edu.cibertec.DAWI_Bobadilla_Guimaray.dto.*;

import java.util.List;

public interface MaintenanceService {
    List<FilmDto> getAllFilms();

    FilmDetailDto getFilmById(int id);

    Boolean updateFilm(FilmDetailDto filmDetailDto);

    List<LanguageDto> findAllLanguages();
    void saveFilm(FilmRecordDto filmRecordDto);

    void deleteFilm(Integer filmId);
    void removeFilm(Integer id);

}

