package cinema.controller;


import cinema.model.Tickets;
import cinema.service.FilmSessionsService;
import cinema.service.TicketsService;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@ThreadSafe
@Controller
@RequestMapping("/tickets")
public class TicketsController {

    private final TicketsService ticketsService;

    private final FilmSessionsService filmSessionsService;
    public TicketsController(TicketsService ticketsService, FilmSessionsService filmSessionsService) {
        this.ticketsService = ticketsService;
        this.filmSessionsService = filmSessionsService;
    }


    @PostMapping("/create")
    public String create(@ModelAttribute Tickets tickets, Model model) {
        try {
            ticketsService.save(tickets);
            return "redirect:/filmSessions";
        } catch (Exception exception) {
            model.addAttribute("message", exception.getMessage());
            return "errors/404";
        }
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable int id) {
        var filmSession = filmSessionsService.findDtoById(id);
        if (filmSession.isEmpty()) {
            model.addAttribute("message", "Сеанс с указанным идентификатором не найден");
            return "errors/404";
        }
        model.addAttribute("filmSessionDto", filmSession.get());
        return "tickets/create";
    }

}
