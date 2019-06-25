package impl.bus.presentation.scheduleticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bus.business.CityManagerService;

@Controller
public class ScheduleTicketController {

    @Autowired
    private CityManagerService cityManagerService;

    public void setCityManagerService(CityManagerService cityManagerService) {
        this.cityManagerService = cityManagerService;
    }

    @RequestMapping("/scheduleTicket")
    public String scheduleTicket(Model model) throws Exception {
        System.out.println("Executing ScheduleTicket");

        model.addAttribute("citieslist", cityManagerService.getCities());
        return "scheduleTicket";
    }
}