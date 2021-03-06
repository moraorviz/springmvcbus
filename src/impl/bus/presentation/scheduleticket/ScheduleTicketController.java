package impl.bus.presentation.scheduleticket;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bus.business.TicketManagerService;
import com.bus.model.Search;	

@Controller
@SessionAttributes("shoppingCart")
public class ScheduleTicketController {

	@Autowired
	private TicketManagerService ticketManagerService;

	public void setCityManagerService(TicketManagerService ticketManagerService) {
		this.ticketManagerService = ticketManagerService;
	}

	public static List<LocalDate> getDatesBetweenUsingJava8(LocalDate startDate, LocalDate endDate) {

		long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		return IntStream.iterate(0, i -> i + 1).limit(numOfDaysBetween).mapToObj(i -> startDate.plusDays(i))
				.collect(Collectors.toList());
	}

	@RequestMapping(value = "/scheduleTicket", method = RequestMethod.GET)
	public String getScheduleTicket(Model model, ShoppingCart shoppingCart) throws Exception {
		System.out.println("Executing ScheduleTicket GET method.");
		shoppingCart.setId(null);
		shoppingCart.setVueltaId(null);
		shoppingCart.setCode(null);

		List<Integer> numberList = new ArrayList<Integer>() {
			{
				add(1);
				add(2);
				add(3);
				add(4);
			}
		};
		
		List<LocalDate> datesListLD = ScheduleTicketController.getDatesBetweenUsingJava8(LocalDate.of(2019, 07, 01),
				LocalDate.of(2019, 12, 31));
		List<Date> datesList = new ArrayList<Date>(datesListLD.size());
		for (LocalDate date:datesListLD) {
			datesList.add(Date.valueOf(date));
		}

		model.addAttribute("numberlist", numberList);
		model.addAttribute("dateslist", datesList);
		model.addAttribute("citieslist", ticketManagerService.getCities());
		return "scheduleTicket";
	}
	
	@RequestMapping(value = "/scheduleTicket", method = RequestMethod.POST)
	public String postScheduleTicket(@ModelAttribute Search search, BindingResult result, Model model, ShoppingCart shoppingCart) throws Exception {
		System.out.println("Executing ScheduleTicket POST method.");
		System.out.println("Received " + search);
		
		try {	
			model.addAttribute("travels", this.ticketManagerService.getTravels(search));
			if (search.getReturnDate() != null) {
				model.addAttribute("travelsVuelta", this.ticketManagerService.getTravelsVuelta(search));
			}
			model.addAttribute("shoppingCart", shoppingCart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// This conditional part here is very important.
		if (shoppingCart.getId() == null) {
			return "viewAvailable";
		} else {
			return "redirect:buyTicket";
		}
	}
	
	@ModelAttribute
	Search getSearch() {
		return new Search();
	}
}