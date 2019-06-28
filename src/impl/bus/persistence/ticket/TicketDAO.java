package impl.bus.persistence.ticket;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.bus.model.City;
import com.bus.model.Search;
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
            Date departureDate = search.getDepartureDate();

            Class.forName(SQL_DRV);
            con = DriverManager.getConnection(SQL_URL, "mario", "password");
            ps = con.prepareStatement("select * from autobus.travel where departure_date <= ?");
            ps.setDate(1, departureDate);
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
}