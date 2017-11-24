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
                "user_id = %d", id)).get(0);
    }

    public Usuario findByName(String name) {
        return findByCriteria(String.format(
                "user_name = '%s'", name)).get(0);
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


    private List<Usuario> findByCriteria(String criteria) {
        List<Usuario> usuarios=null;
       try {

            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            criteria.isEmpty() ?
                                    getBaseStatement() :
                                    getBaseStatement()
                                            .concat(" WHERE ")
                                            .concat(criteria));
             usuarios = new ArrayList<>();
            while (rs.next())
                usuarios.add(Usuario.from(rs));
            return usuarios;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Usuario create(Usuario usuario) {
        return executeUpdate(String.format(
                "INSERT INTO %s(user_id, user_name,user_clave,user_perfil) VALUES (%d, '%s','%s',%d)",
                getTableName(), usuario.getId(), usuario.getName(),usuario.getClave(),usuario.getPerfil())) ?
                usuario : null;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(user_id) as max_id FROM user";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            return resultSet.next() ? resultSet.getInt("max_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public Usuario create(String name, String clave,int perfil) {
        return create(getMaxId()+1, name,clave,perfil);
    }

    private Usuario create(int id, String name, String clave,int perfil) {
        return create(new Usuario(id, name,clave,perfil));
    }

    public boolean update(Usuario usuario) {
        return executeUpdate(String.format("UPDATE %s SET user_id = %d, user_name = '%s' WHERE user_id = %d",
                getTableName(), usuario.getId(), usuario.getName(), usuario.getId()));
    }

    public boolean update(int id, String name, String clave,int perfil) {
        return update(new Usuario(id, name,clave,perfil));
    }

    public boolean erase(Usuario usuario) {
        return executeUpdate(String.format("DELETE FROM %s WHERE user_id = %d", getTableName(), usuario.getId()));
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
