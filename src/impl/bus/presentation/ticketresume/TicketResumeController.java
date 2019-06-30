package impl.bus.presentation.ticketresume;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bus.business.TicketManagerService;
import com.bus.model.Ticket;
import com.bus.model.User;

import impl.bus.presentation.scheduleticket.ShoppingCart;

@Controller
@SessionAttributes({"shoppingCart", "user"})
public class TicketResumeController {
	
	@Autowired
	private TicketManagerService ticketManagerService;

	public void setCityManagerService(TicketManagerService ticketManagerService) {
		this.ticketManagerService = ticketManagerService;
	}
	
	@RequestMapping(value="ticketResume", method=RequestMethod.GET)
	public String getTicketResume(Model model, ShoppingCart shoppingCart, User user, Ticket ticket) throws Exception {
		System.out.println("Executing TicketResume GET method.");
		System.out.println("Received " + shoppingCart.toString());
		System.out.println("Received" + user.toString());
		
		String randomString = getRandomCode();
		shoppingCart.setCode(randomString);
		
		ticket.setUser(user.getEmail());
		ticket.setCode(randomString);
		
		ticketManagerService.newTicket(ticket);
		
		return "ticketResume";
	}
	
	@RequestMapping(value="sendResume", method=RequestMethod.GET)
	public String getSendResume(Model model, ShoppingCart shoppingCart, User user) throws Exception {
		System.out.println("Executing SendResume GET method.");
		String userEmail = user.getEmail();
		String code = shoppingCart.getCode();
		Email email = new Email(userEmail, code);
		email.sendEmail();
		
		return "ticketResume";
	}
	
	public static String getRandomCode() {
		  
	    int length = 10;
	    boolean useLetters = true;
	    boolean useNumbers = false;
	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
	 
	    return generatedString;
	}
}
