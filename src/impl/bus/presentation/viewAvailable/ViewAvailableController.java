package impl.bus.presentation.viewAvailable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/viewAvailable")
public class ViewAvailableController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAvailableTicket(Model model) throws Exception {
		System.out.println("Executing AvailableTicket GET method.");
		
		return "viewAvailable";
	}

}
