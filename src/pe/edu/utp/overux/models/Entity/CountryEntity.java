package pe.edu.utp.overux.models.Entity;

import pe.edu.utp.overux.models.domain.Country;
import pe.edu.utp.overux.models.domain.Region;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryEntity extends  BaseEntity {
    Connection connection;
    String criteria;
    public CountryEntity(Connection connection) {
        this.connection = connection;
    }

    public CountryEntity() {
        super();
        setTableName("countries");
    }


    public boolean create(Country country) {
        return  execute(String.format(
                "INSERT INTO %s(country_id,country_name,region_id) VALUES ('%s','%s',%d)",
                getTableName(),country.getId(),country.getName(),country.getRegion().getId()));
    }
    public boolean create(String id,String name,Region region)
    {
        return create(new Country(id,name,region));
    }

    public boolean update(Country country) {
        return  execute(String.format(
                "UPDATE %s set country_id='%s', country_name='%s', region_id=%d where country_id='%s'",
                getTableName(),country.getId(),country.getName(),country.getRegion().getId(),country.getId()));
    }

    public boolean update(String id,String name,Region region)
    {
        return update(new Country(id,name,region));
    }


    public boolean delete(Country country) {
        return  execute(String.format(
                "detele from %s where country_id=%d",
                getTableName(),country.getId()));
    }
    public boolean delete(String id,String name,Region region) { return delete(new Country(id,name,region)); }


    private boolean execute(String sql)
    {
        try {
            int result= getConnection().createStatement().executeUpdate(sql);
            return result > 0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public Country findById(String id,RegionsEntity regionsEntity) {
        return finByCriterio(String.format("country_id = %d",id),regionsEntity).get(0);
    }

    public Country finByname(String name,RegionsEntity regionsEntity) {
        return finByCriterio(String.format("country_name = '%s'",name),regionsEntity).get(0);
    }

    public List<Country> findAll(RegionsEntity regionsEntity)
    {
        return finByCriterio("",regionsEntity);
    }

    public List<Country> finByCriterio(String criterio,RegionsEntity regionsEntity) {
        List<Country> list=null;
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criterio.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                            .concat(" WHERE")
                                            .concat(criterio));
            list=new ArrayList<>();
            while (rs.next())
                list.add(Country.from(rs,regionsEntity));
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }



}
