package impl.bus.presentation.cancelticket;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bus.business.TicketManagerService;
import com.bus.model.Search;
import com.bus.model.Ticket;


@Controller
public class CancelTicketController {
	
	@Autowired
	private TicketManagerService ticketManagerService;

	public void setCityManagerService(TicketManagerService ticketManagerService) {
		this.ticketManagerService = ticketManagerService;
	}
	
	@RequestMapping(value = "/cancelTicket", method=RequestMethod.GET)
	public String getCancelTicket(Model model) throws Exception {
		System.out.println("Executing CancelTicket GET method.");
		return "cancelTicket";
	}
	
	@RequestMapping(value = "/cancelTicket", method = RequestMethod.POST)
	public String postCancelTicket(@ModelAttribute Ticket ticket, Model model, BindingResult result) throws Exception {
		System.out.println("Executing CancelTicket POST method.");
		
		ticketManagerService.cancelTicket(ticket);
		
		return "cancelTicket";
	}
	
	@ModelAttribute
	Ticket getTicket() {
		return new Ticket();
	}

}
