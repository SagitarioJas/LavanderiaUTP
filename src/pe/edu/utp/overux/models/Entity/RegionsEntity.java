package pe.edu.utp.overux.models.Entity;

import pe.edu.utp.overux.models.domain.Region;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionsEntity extends BaseEntity {

    public RegionsEntity() {
        super();
        setTableName("regions");
    }

    public List<Region> findAll() {
        return findByCriteria("");
    }

    public Region findById(int id) {
        return findByCriteria(String.format(
                "region_id = %d", id)).get(0);
    }

    public Region findByName(String name) {
        return findByCriteria(String.format(
                "region_name = '%s'", name)).get(0);
    }

    private List<Region> findByCriteria(String criteria) {
        try {

            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criteria.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                    .concat(" WHERE ")
                                    .concat(criteria));
            List<Region> regions = new ArrayList<>();
            while (rs.next())
                regions.add(Region.from(rs));
            return regions;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Region create(Region region) {
        return executeUpdate(String.format(
                "INSERT INTO %s(region_id, region_name) VALUES (%d, '%s')",
                getTableName(), region.getId(), region.getName())) ?
                region : null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(region_id) as max_id FROM regions";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            return resultSet.next() ? resultSet.getInt("max_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public Region create(String name) {
        return create(getMaxId()+1, name);
    }

    public Region create(int id, String name) {
        return create(new Region(id, name));
    }

    public boolean update(Region region) {
        return executeUpdate(String.format("UPDATE %s SET region_id = %d, region_name = '%s' WHERE region_id = %d",
                getTableName(), region.getId(), region.getName(), region.getId()));
    }

    public boolean update(int id, String name) {
        return update(new Region(id, name));
    }

    public boolean erase(Region region) {
        return executeUpdate(String.format("DELETE FROM %s WHERE region_id = %d", getTableName(), region.getId()));
    }

    private boolean executeUpdate(String sql) {
        try {
            int result = getConnection().createStatement().executeUpdate(sql);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}












