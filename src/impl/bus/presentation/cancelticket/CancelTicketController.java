package impl.bus.presentation.cancelticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bus.business.TicketManagerService;

@Controller
public class CancelTicketController {
	
	@Autowired
	private TicketManagerService ticketManagerService;

	public void setCityManagerService(TicketManagerService ticketManagerService) {
		this.ticketManagerService = ticketManagerService;
	}

}
