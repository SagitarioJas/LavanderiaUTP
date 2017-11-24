package pe.edu.utp.overux.services;

import pe.edu.utp.overux.models.domain.Country;
import pe.edu.utp.overux.models.HrDataStore;
import pe.edu.utp.overux.models.domain.Region;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class HrService {
    Connection connection;
    HrDataStore dataStore;
    public HrService() {
        try {
            InitialContext context = new InitialContext();
            connection = ((DataSource) context.lookup("jdbc/MySQLDataSource"))
            .getConnection();
            dataStore = new HrDataStore(connection);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Region findRegionById(int id) {
        return dataStore.findRegionById(id);
    }

    public List<Region> findAllRegions() {
        return dataStore.findAllRegions();
    }

    public List<Country> findAllCountries() {
        return dataStore.findAllCountries();
    }

    public Region createRegion(String name) { return dataStore.createRegion(name);}

    public boolean updateRegion(Region region) { return dataStore.updateRegion(region);}
}
