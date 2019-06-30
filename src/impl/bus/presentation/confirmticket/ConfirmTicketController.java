package impl.bus.presentation.confirmticket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bus.model.User;

import impl.bus.presentation.scheduleticket.ShoppingCart;

@Controller
@SessionAttributes({"shoppingCart", "user"})
public class ConfirmTicketController {
	
	@RequestMapping(value = "/confirmTicket", method = RequestMethod.GET)
	public String getBuyTicket(Model model, ShoppingCart shoppingCart) throws Exception {
		System.out.println("Executing ConfirmTicket GET method.");
		System.out.println(shoppingCart.getId());
		User user = new User();
		
		List<String> metodosIdent = new ArrayList<String>() {
			{
				add("NIF");
				add("pasaporte");
				add("NIE");
			}
		};
		
		model.addAttribute("user", user);
		model.addAttribute("metodosident", metodosIdent);
		
		return "confirmTicket";
	}
	
	@RequestMapping(value ="/confirmTicket", method = RequestMethod.POST)
	public String postBuyTicket(@ModelAttribute User user, Model model, ShoppingCart shoppingCart) throws Exception {
		System.out.println("Executing ConfirmTicket POST method.");
		System.out.println("Received user " + user.toString());
		return "redirect:ticketResume";
	}
}
