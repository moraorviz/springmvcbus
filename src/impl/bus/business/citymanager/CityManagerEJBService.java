package impl.bus.business.citymanager;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Vector;

import com.bus.business.CityManagerService;
import com.bus.model.City;

public class CityManagerEJBService implements CityManagerService {

    @Autowired
    private CityManager cityManager = null;

    public void setCityManager(CityManager cityManager) {
        System.out.println("setting cityManager reference");
        this.cityManager = cityManager;
    }

    public Vector<City> getCities() throws Exception {
        System.out.println("CityManagerEJBService.getCities();");
        return cityManager.getCities();
    }
}

