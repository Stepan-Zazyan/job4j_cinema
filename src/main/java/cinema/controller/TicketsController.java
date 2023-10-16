package cinema.controller;


import cinema.model.Tickets;
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

    public TicketsController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
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


}
