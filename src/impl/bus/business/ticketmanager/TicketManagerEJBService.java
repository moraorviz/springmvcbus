package impl.bus.business.ticketmanager;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import com.bus.business.TicketManagerService;
import com.bus.model.City;
import com.bus.model.Search;
import com.bus.model.Travel;

public class TicketManagerEJBService implements TicketManagerService {

		@Autowired
		private TicketManager ticketManager = null;
		
		public void setTicketManager(TicketManager ticketManager) {
			System.out.println("Setting ticketManager reference");
			this.ticketManager = ticketManager;
		}
		
		public Vector<City> getCities() throws Exception {
			System.out.println("TicketManagerEJBService.getCities().");
			return ticketManager.getCities();
		}
		
		public Vector<Travel> getTravels(Search search) throws Exception {
			System.out.println("TicketManagerEJBService.getTravels().");
			return ticketManager.getTravels(search);
		}
}
