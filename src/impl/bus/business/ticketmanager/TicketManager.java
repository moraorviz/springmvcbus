package impl.bus.business.ticketmanager;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.bus.business.TicketManagerService;
import com.bus.model.City;
import com.bus.model.Search;
import com.bus.model.Ticket;
import com.bus.model.Travel;
import com.bus.persistence.TicketDataService;

public class TicketManager implements TicketManagerService {
	
	@Autowired
	private TicketDataService ticketDataService = null;
	
	public void setTicketDataService(TicketDataService ticketDataService) {
		System.out.println("Setting ticketDataService bean.");
		this.ticketDataService = ticketDataService;
	}
	
	public Vector<City> getCities() throws Exception {
		Vector<City> cities = ticketDataService.getCities();
		return cities;
	}
	
	public Vector<Travel> getTravels(Search search) throws Exception {
		return this.ticketDataService.getTravels(search);
	}
	
	public Vector<Travel> getTravelsVuelta(Search search) throws Exception {
		return this.ticketDataService.getTravelsVuelta(search);
	}
	
	public Ticket newTicket(Ticket ticket) throws Exception {
		return this.ticketDataService.newTicket(ticket);
	}

}
