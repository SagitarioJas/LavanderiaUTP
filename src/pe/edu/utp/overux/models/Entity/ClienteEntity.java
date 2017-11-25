package pe.edu.utp.overux.models.Entity;

import pe.edu.utp.overux.models.domain.Cliente;
import pe.edu.utp.overux.models.domain.Region;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteEntity extends  BaseEntity {

    public ClienteEntity() {
        super();
        setTableName("client");
    }

    public List<Cliente> findAll() {
        return findByCriteria("");
    }
    public List<Cliente> findAllbyName(String name) {
        return findByCriteria(String.format(
                "client_district = '%s'", name));
    }

    public Cliente findById(int id) {
        return findByCriteria(String.format(
                "user_id = %d", id)).get(0);
    }

    public Cliente findByName(String name) {
        return findByCriteria(String.format(
                "client_district = '%s'", name)).get(0);
    }



    public int finByLogin(String name,String clave,int perfil) {
        String sql = "SELECT user_id  FROM user where user_name='"+ name+"' and user_clave='"+ clave +"' and user_perfil='"+ perfil +"'";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            return resultSet.next() ? resultSet.getInt("user_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    private List<Cliente> findByCriteria(String criteria) {
        try {

            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criteria.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                            .concat(" WHERE ")
                                            .concat(criteria));
            List<Cliente> clientes = new ArrayList<>();
            while (rs.next())
                clientes.add(Cliente.from(rs));
            return clientes;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cliente create(Cliente cliente) {
        return executeUpdate(String.format(
                "INSERT INTO %s(client_id, client_name,client_telefono,client_district,client_direccion) VALUES (%d, '%s', '%s', '%s','%s')",
                getTableName(), cliente.getId(), cliente.getName(),cliente.getTelefono(),cliente.getDistrito(),cliente.getDireccion())) ?
                cliente : null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(cliente) as max_id FROM client";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            return resultSet.next() ? resultSet.getInt("max_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public Cliente create(String name,String telefono,String distrito,String direccion) {
        return create(getMaxId()+1, name,telefono,distrito,direccion);
    }

    private Cliente create(int id, String name, String telefono,String distrito,String direccion) {
        return create(new Cliente(id, name,telefono,distrito,direccion));
    }

    public boolean update(Cliente cliente) {
        return executeUpdate(String.format("UPDATE %s SET client_name = %d, client_telefono = '%s',client_district='%s',client_direccion='%s' WHERE client_id = %d",
                getTableName(), cliente.getName(), cliente.getTelefono(), cliente.getDistrito(),cliente.getDireccion()));
    }

    public boolean update(int id, String name, String telefono,String distrito,String direccion) {
        return update(new Cliente(id, name,telefono,distrito,direccion));
    }

    public boolean erase(Cliente cliente) {
        return executeUpdate(String.format("DELETE FROM %s WHERE client_id = %d", getTableName(), cliente.getId()));
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
