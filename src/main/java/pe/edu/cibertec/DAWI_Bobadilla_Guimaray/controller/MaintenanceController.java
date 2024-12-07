package pe.edu.cibertec.DAWI_Bobadilla_Guimaray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWI_Bobadilla_Guimaray.dto.*;
import pe.edu.cibertec.DAWI_Bobadilla_Guimaray.service.MaintenanceService;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
    public String start(Model model){
        List<FilmDto> films = maintenanceService.getAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {

        FilmDetailDto filmDetailDto = maintenanceService.getFilmById(id);
        model.addAttribute("filmDetailDto", filmDetailDto);
        return "maintenance-detail";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.getFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance-edit";
    }

    @PostMapping("/edit-confirm")
    public String editConfirm(@ModelAttribute FilmDetailDto filmDetailDto, Model model) {
        maintenanceService.updateFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }

    @PostMapping("/remove/{id}")
    public String remove(@PathVariable Integer id, Model model) {
        System.out.println("Eliminando " + id);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/record")
    public String showRegisterForm(Model model) {
        List<LanguageDto> languages = maintenanceService.findAllLanguages(); // Lista de idiomas
        model.addAttribute("languages", languages);
        model.addAttribute("filmRecordDto", FilmRecordDto.empty()); // DTO vacío para el formulario
        return "maintenance-create"; // Nombre de la vista Thymeleaf
    }

    @PostMapping("/record")
    public String registerFilm(@ModelAttribute FilmRecordDto filmRecordDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Si hay errores, retorna al formulario
            List<LanguageDto> languages = maintenanceService.findAllLanguages();
            model.addAttribute("languages", languages);
            return "maintenance-create";
        }

        maintenanceService.saveFilm(filmRecordDto);
        return "redirect:/maintenance/start"; // Redirige al listado de films después de guardar
    }

    @GetMapping("/maintenance")
    public String showMaintenancePage(Model model) {
        model.addAttribute("films", maintenanceService.getAllFilms());  // Asegúrate de cargar las películas correctamente
        return "maintenance";  // Página de mantenimiento
    }

    @PostMapping("/maintenance/remove/{id}")
    public String removeFilm(@PathVariable Integer id) {
        maintenanceService.removeFilm(id);
        return "redirect:/maintenance/start";
    }













}
