package impl.bus.presentation.buyticket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bus.model.Extra;

import impl.bus.presentation.scheduleticket.ShoppingCart;

@Controller
@SessionAttributes("shoppingCart")
public class BuyTicketController {
	
	@RequestMapping(value = "/buyTicket", method = RequestMethod.GET)
	public String getBuyTicket(Model model, ShoppingCart shoppingCart) throws Exception {
		System.out.println("Executing BuyTicket GET method.");
		System.out.println(shoppingCart.getId());
		System.out.println(shoppingCart.getVueltaId());
		
		List<Integer> numberList = new ArrayList<Integer>() {
			{
				add(1);
				add(2);
				add(3);
				add(4);
			}
		};
		
		model.addAttribute("numberlist", numberList);
		return "buyTicket";
	}
	
	@RequestMapping(value = "/buyTicket", method = RequestMethod.POST)
	public String postBuyTicket(@ModelAttribute Extra extra, Model model, ShoppingCart shoppingCart) throws Exception {
		System.out.println("Executing BuyTicket POST method.");
		System.out.println("Received "+ extra.toString());
		
		return "redirect:confirmTicket";
	}
	
	@ModelAttribute
	Extra getExtra() {
		return new Extra();
	}
	

}
