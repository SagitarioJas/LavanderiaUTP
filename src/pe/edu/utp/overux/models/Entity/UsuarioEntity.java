package pe.edu.utp.overux.models.Entity;

import pe.edu.utp.overux.models.domain.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioEntity extends BaseEntity {

    public UsuarioEntity() {
        super();
        setTableName("user");
    }

    public List<Usuario> findAll() {
        return findByCriteria("");
    }

    public Usuario findById(int id) {
        return findByCriteria(String.format(
                "region_id = %d", id)).get(0);
    }

    public Usuario findByName(String name) {
        return findByCriteria(String.format(
                "region_name = '%s'", name)).get(0);
    }

    private List<Usuario> findByCriteria(String criteria) {
        try {

            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criteria.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                            .concat(" WHERE ")
                                            .concat(criteria));
            List<Usuario> regions = new ArrayList<>();
            while (rs.next())
                regions.add(Usuario.from(rs));
            return regions;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Usuario create(Usuario region) {
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
    public Usuario create(String name) {
        return create(getMaxId()+1, name);
    }

    public Usuario create(int id, String name) {
        return create(new Usuario(id, name,null));
    }

    public boolean update(Usuario region) {
        return executeUpdate(String.format("UPDATE %s SET region_id = %d, region_name = '%s' WHERE region_id = %d",
                getTableName(), region.getId(), region.getName(), region.getId()));
    }

    public boolean update(int id, String name) {
        return update(new Usuario(id, name,null));
    }

    public boolean erase(Usuario region) {
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
