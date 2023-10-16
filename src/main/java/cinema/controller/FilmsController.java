package cinema.controller;

import cinema.dto.FileDto;
import cinema.model.Films;
import cinema.service.FilmsService;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@ThreadSafe
@Controller
@RequestMapping("/films") /* Работать с кандидатами будем по URI /vacancies/** */

public class FilmsController {

    private final FilmsService filmsService;


    public FilmsController(FilmsService filmsService) {
        this.filmsService = filmsService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("films", filmsService.findAll());
        return "films/list";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Films film, @RequestParam MultipartFile file, Model model) {
        try {
            filmsService.save(film, new FileDto(file.getOriginalFilename(), file.getBytes()));
            return "redirect:/films";
        } catch (Exception exception) {
            model.addAttribute("message", exception.getMessage());
            return "errors/404";
        }
    }



}
