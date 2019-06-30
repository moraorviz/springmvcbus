package impl.bus.persistence.ticket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.bus.model.City;
import com.bus.model.Search;
import com.bus.model.Ticket;
import com.bus.model.Travel;
import com.bus.persistence.TicketDataService;

public class TicketDAO implements TicketDataService {

    public Vector<City> getCities() throws Exception {

        Vector<City> result = new Vector<City>();

        PreparedStatement ps = null;
		ResultSet rs = null;
        Connection con = null;

        try {
            String SQL_DRV = "com.mysql.jdbc.Driver";
            String SQL_URL = "jdbc:mysql://127.0.0.1:3306/autobus";

            Class.forName(SQL_DRV);
            con = DriverManager.getConnection(SQL_URL, "mario", "password");
            ps = con.prepareStatement("select * from autobus.city");
            rs = ps.executeQuery();

            while (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("city_id"));
                city.setName(rs.getString("name"));
                result.add(city);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw(e);
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                throw(e);
            }
        }
        return result;
    }

	@Override
	public Vector<Travel> getTravels(Search search) throws Exception {
		
		Vector<Travel> result = new Vector<Travel>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
        Connection con = null;
		
        try {
            String SQL_DRV = "com.mysql.jdbc.Driver";
            String SQL_URL = "jdbc:mysql://127.0.0.1:3306/autobus";
            Class.forName(SQL_DRV);
            con = DriverManager.getConnection(SQL_URL, "mario", "password");
            ps = con.prepareStatement("select * from autobus.travel where departure_date = ? and departure_id = ? and arrival_id = ? ");
            ps.setDate(1, search.getDepartureDate(), java.util.Calendar.getInstance());
            ps.setInt(2, search.getDeparture());
            ps.setInt(3, search.getArrival());
            rs = ps.executeQuery();
            
            while (rs.next()) {
            	Travel travel = new Travel();
            	travel.setId(rs.getInt("travel_id"));
            	travel.setDeparture(rs.getInt("departure_id"));
            	travel.setArrival(rs.getInt("arrival_id"));
            	travel.setDepartureDate(rs.getDate("departure_date"));
            	travel.setDepartureHour(rs.getTime("departure_hour"));
            	travel.setArrivalDate(rs.getDate("arrival_date"));
            	travel.setArrivalHour(rs.getTime("arrival_hour"));
            	result.add(travel);
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
        	throw(e);
        } finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
        
		return result;
	}
	
	@Override
	public Vector<Travel> getTravelsVuelta(Search search) throws Exception {
		
		Vector<Travel> result = new Vector<Travel>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
        Connection con = null;
		
        try {
            String SQL_DRV = "com.mysql.jdbc.Driver";
            String SQL_URL = "jdbc:mysql://127.0.0.1:3306/autobus";
            Class.forName(SQL_DRV);
            con = DriverManager.getConnection(SQL_URL, "mario", "password");
            ps = con.prepareStatement("select * from autobus.travel where departure_date = ? and departure_id = ? and arrival_id = ? ");
            ps.setDate(1, search.getReturnDate(), java.util.Calendar.getInstance());
            ps.setInt(2, search.getArrival());
            ps.setInt(3, search.getDeparture());
            rs = ps.executeQuery();
            
            while (rs.next()) {
            	Travel travel = new Travel();
            	travel.setId(rs.getInt("travel_id"));
            	travel.setDeparture(rs.getInt("departure_id"));
            	travel.setArrival(rs.getInt("arrival_id"));
            	travel.setDepartureDate(rs.getDate("departure_date"));
            	travel.setDepartureHour(rs.getTime("departure_hour"));
            	travel.setArrivalDate(rs.getDate("arrival_date"));
            	travel.setArrivalHour(rs.getTime("arrival_hour"));
            	result.add(travel);
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
        	throw(e);
        } finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
        
		return result;
	}

	@Override
	public synchronized Ticket newTicket(Ticket ticket) throws Exception {
		// TODO Auto-generated method stub
		
		PreparedStatement ps = null;
		ResultSet rs = null;
        Connection con = null;
		
        try {
            String SQL_DRV = "com.mysql.jdbc.Driver";
            String SQL_URL = "jdbc:mysql://127.0.0.1:3306/autobus";
            Class.forName(SQL_DRV);
            con = DriverManager.getConnection(SQL_URL, "mario", "password");
            ps = con.prepareStatement("select max(ticket_id) as maximo from autobus.ticket");
            rs = ps.executeQuery();
            Integer id=0;
            while (rs.next()) {
            	id = rs.getInt("maximo");
            }
            
            System.out.println("Max id found: " + id);
            ticket.setId(id);
            ps = con.prepareStatement("insert into autobus.ticket values (?, ?, ?)");
            ps.setInt(1, id+1);
            ps.setString(2, ticket.getUser());
            ps.setString(3, ticket.getCode());
            ps.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        	throw(e);
        } finally {
        	try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
        }
		
		return ticket;
	}
	
	@Override
	public synchronized boolean getTicket(Ticket ticket) throws Exception {
		
		System.out.println("Getting ticket: " + ticket.toString());
		
		PreparedStatement ps = null;
		ResultSet rs = null;
        Connection con = null;
        
        boolean result = false;
		
        try {
            String SQL_DRV = "com.mysql.jdbc.Driver";
            String SQL_URL = "jdbc:mysql://127.0.0.1:3306/autobus";
            Class.forName(SQL_DRV);
            con = DriverManager.getConnection(SQL_URL, "mario", "password");
            ps = con.prepareStatement("select ticket_id from autobus.ticket where usr = ? and hashcode = ?");
            ps.setString(1, ticket.getUser());
            ps.setString(2, ticket.getCode());
            rs = ps.executeQuery();
            if (rs.next()) {
            	result = true;
            }

            
        } catch (Exception e) {
        	e.printStackTrace();
        	throw(e);
        } finally {
        	try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
        }
		return result;
	}

	@Override
	public synchronized Ticket cancelTicket(Ticket ticket) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Deleting ticket: " + ticket.toString());
		
		PreparedStatement ps = null;
        Connection con = null;
		
        try {
            String SQL_DRV = "com.mysql.jdbc.Driver";
            String SQL_URL = "jdbc:mysql://127.0.0.1:3306/autobus";
            Class.forName(SQL_DRV);
            con = DriverManager.getConnection(SQL_URL, "mario", "password");
            ps = con.prepareStatement("delete from autobus.ticket where hashcode = ? and usr = ?");
            ps.setString(1, ticket.getCode());
            ps.setString(2, ticket.getUser());
            ps.executeUpdate();
            
        } catch (Exception e) {
        	e.printStackTrace();
        	throw(e);
        } finally {
        	try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
        }
		return ticket;
	}
}