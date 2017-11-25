package pe.edu.utp.overux.models.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Cliente extends  Base {
    private int id;
    private String name;
    private String telefono;
    private String distrito;
    private String direccion;

    public Cliente() {
    }


    public Cliente(int id, String name, String telefono, String distrito, String direccion) {
        this.id = id;
        this.name = name;
        this.telefono = telefono;
        this.distrito = distrito;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public Cliente setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Cliente setName(String name) {
        this.name = name;
        return this;
    }

    public String getTelefono() {
        return telefono;
    }

    public Cliente setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public String getDistrito() {
        return distrito;
    }

    public Cliente setDistrito(String distrito) {
        this.distrito = distrito;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public Cliente setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public static Cliente from(ResultSet rs) {
        try {
            return (new Cliente())
                    .setId(rs.getInt("client_id"))
                    .setName(rs.getString("client_name"))
                    .setDireccion(rs.getString("client_direccion"))
                    .setDistrito(rs.getString("client_district"))
                    .setTelefono(rs.getString("client_telefono"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
