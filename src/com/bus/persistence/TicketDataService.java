package com.bus.persistence;

import java.util.Vector;

import com.bus.model.City;
import com.bus.model.Search;
import com.bus.model.Ticket;
import com.bus.model.Travel;

public interface TicketDataService {
	public Vector<City> getCities() throws Exception;
	public Vector<Travel> getTravels(Search search) throws Exception;
	public Vector<Travel> getTravelsVuelta(Search search) throws Exception;
	public Ticket newTicket(Ticket ticket) throws Exception;
}
