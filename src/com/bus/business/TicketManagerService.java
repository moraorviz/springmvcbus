package com.bus.business;

import java.util.Vector;

import com.bus.model.City;
import com.bus.model.Search;
import com.bus.model.Travel;

public interface TicketManagerService {
	public Vector<City> getCities() throws Exception;
	
	public Vector<Travel> getTravels(Search search) throws Exception;
}
