package impl.bus.persistence.city;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.bus.model.City;
import com.bus.persistence.CityDataService;

public class CityDAO implements CityDataService {

    public Vector<City> getCities() throws Exception {

        Vector<City> result = new Vector<City>();

        PreparedStatement ps = null;
		ResultSet rs = null;
        Connection con = null;

        try {
            String SQL_DRV = "com.mysql.jdbc.Driver";
            String SQL_URL = "jdbc:mysql://127.0.0.1:4406/autobus";

            Class.forName(SQL_DRV);
            con = DriverManager.getConnection(SQL_URL, "root", "password");

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
}