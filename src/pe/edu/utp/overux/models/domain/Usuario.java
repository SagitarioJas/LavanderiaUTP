package pe.edu.utp.overux.models.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario extends  Base {
    private int id;
    private String name;
    private String clave;
    private int perfil;

    public Usuario() {
    }

    public Usuario(int id, String name, String clave, int perfil) {
        this.id = id;
        this.name = name;
        this.clave = clave;
        this.perfil = perfil;
    }

    public int getPerfil() {
        return perfil;
    }

    public Usuario setPerfil(int perfil) {
        this.perfil = perfil;
        return this;
    }

    public int getId() {
        return id;
    }

    public Usuario setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Usuario setName(String name) {
        this.name = name;
        return this;
    }

    public String getClave() {
        return clave;
    }

    public Usuario setClave(String clave) {
        this.clave = clave;
        return this;
    }

    public static Usuario from(ResultSet rs) {
        try {
            return (new Usuario())
                    .setId(rs.getInt("user_id"))
                    .setName(rs.getString("user_name"))
                    .setPerfil(rs.getInt("user_perfil"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
