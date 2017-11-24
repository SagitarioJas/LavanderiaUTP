package pe.edu.utp.overux.models;

import pe.edu.utp.overux.models.Entity.CountryEntity;
import pe.edu.utp.overux.models.Entity.RegionsEntity;
import pe.edu.utp.overux.models.domain.Country;
import pe.edu.utp.overux.models.domain.Region;

import java.sql.Connection;
import java.util.List;

public class HrDataStore {
    private Connection connection;
    private RegionsEntity regionsEntity;
    private CountryEntity countrieEntity;

    public HrDataStore(Connection connection) {
        this.setConnection(connection);
    }

    public HrDataStore() {
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private RegionsEntity getRegionsEntity() {
        if(regionsEntity == null) {
            regionsEntity = new RegionsEntity();
            regionsEntity.setConnection(getConnection());
        }
        return regionsEntity;
    }

    private CountryEntity getCountrieEntity() {
        if(countrieEntity == null) {
            countrieEntity = new CountryEntity();
            countrieEntity.setConnection(connection);
        }
        return countrieEntity;
    }

    public Region findRegionById(int id) {
        return getConnection() == null ?
                null :
                getRegionsEntity().findById(id);
    }

    public List<Region> findAllRegions() {
        return getConnection() == null ? null : getRegionsEntity().findAll();
    }

    public Country findCountryById(String id) {
        return getConnection() == null ?
                null :
                getCountrieEntity().findById(id, getRegionsEntity());
    }

    public List<Country> findAllCountries() {
        return getConnection() == null ? null : getCountrieEntity().findAll(getRegionsEntity());
    }

    public Region createRegion(String name) {
        return getConnection() == null ?
                null :
                getRegionsEntity().create(name);
    }

    public boolean eraseRegion(Region region) {
        return getConnection() == null ?
                false :
                getRegionsEntity().erase(region);
    }

    public boolean updateRegion(Region region) {
        return getConnection() == null ?
                false :
                getRegionsEntity().update(region);
    }

}






