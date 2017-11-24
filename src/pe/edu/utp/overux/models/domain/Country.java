package pe.edu.utp.overux.models.domain;

import pe.edu.utp.overux.models.Entity.RegionsEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Country {
    private String id;
    private String name;
    private Region region;

    public Country() {
    }

    public Country(String id, String name, Region region) {
        this.setId(id);
        this.setName(name);
        this.setRegion(region);
    }

    public String getId() {
        return id;
    }

    public Country setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public Country setRegion(Region region) {
        this.region = region;
        return this;
    }

    public static Country from(ResultSet resultSet, RegionsEntity regionsEntity) {
        Country country = new Country();
        try {
            country.setId(resultSet.getString("country_id"))
                    .setName(resultSet.getString("country_name"))
                    .setRegion(
                            regionsEntity.findById(
                                    resultSet.getInt("region_id")));
            return country;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
