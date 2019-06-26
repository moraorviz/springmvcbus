package impl.bus.presentation.scheduleticket;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bus.business.CityManagerService;
import com.bus.model.Travel;

@Controller
@RequestMapping("/scheduleTicket")
public class ScheduleTicketController {

	@Autowired
	private CityManagerService cityManagerService;

	public void setCityManagerService(CityManagerService cityManagerService) {
		this.cityManagerService = cityManagerService;
	}

	public static List<LocalDate> getDatesBetweenUsingJava8(LocalDate startDate, LocalDate endDate) {

		long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		return IntStream.iterate(0, i -> i + 1).limit(numOfDaysBetween).mapToObj(i -> startDate.plusDays(i))
				.collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String scheduleTicket(Model model) throws Exception {
		System.out.println("Executing ScheduleTicket GET method.");

		List<Integer> numberList = new ArrayList<Integer>() {
			{
				add(1);
				add(2);
				add(3);
				add(4);
			}
		};
		
		List<LocalDate> datesList = ScheduleTicketController.getDatesBetweenUsingJava8(LocalDate.of(2019, 07, 01),
				LocalDate.of(2019, 12, 31));

		model.addAttribute("numberlist", numberList);
		model.addAttribute("dateslist", datesList);
		model.addAttribute("citieslist", cityManagerService.getCities());
		return "scheduleTicket";
	}

	@ModelAttribute
	Travel getTravel() {
		return new Travel();
	}
}