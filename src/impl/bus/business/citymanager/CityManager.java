package impl.bus.business.citymanager;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Vector;

import com.bus.business.CityManagerService;
import com.bus.model.City;
import com.bus.persistence.CityDataService;

public class CityManager implements CityManagerService {

    @Autowired
    private CityDataService cityDataService = null;

    public void setCityDataService(CityDataService cityDataService) {
        System.out.println("Setting cityDataService bean");
        this.cityDataService = cityDataService;
    }

    public Vector<City> getCities() throws Exception {
        Vector<City> cities = cityDataService.getCities();
        return cities;
    }

}