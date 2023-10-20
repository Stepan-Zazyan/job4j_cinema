package cinema.controller;

import cinema.service.FilmSessionsService;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@ThreadSafe
@Controller
@RequestMapping("/filmSessions")
public class FilmSessionsController {
    private final FilmSessionsService filmSessionsService;

    public FilmSessionsController(FilmSessionsService filmSessionsService) {
        this.filmSessionsService = filmSessionsService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("filmSessions", filmSessionsService.findAll());
        return "filmSessions/list";
    }
}
