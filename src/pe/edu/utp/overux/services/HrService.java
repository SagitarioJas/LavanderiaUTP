package pe.edu.utp.overux.services;

import pe.edu.utp.overux.models.domain.Cliente;
import pe.edu.utp.overux.models.domain.Country;
import pe.edu.utp.overux.models.HrDataStore;
import pe.edu.utp.overux.models.domain.Region;
import pe.edu.utp.overux.models.domain.Usuario;

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

    /*LOGIN REGION*/
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

    /*LOGIN USUARIO*/
    public int finByLogin(String name, String clave,int perfil){ return dataStore.finByLogin(name,clave,perfil);}
    public Usuario createUsuario(String name, String clave,int perfil){ return dataStore.createUsuario(name,clave,perfil);}


    public List<Cliente> finallCliente(){
        return dataStore.findAllClientes();
    }
    public List<Cliente> finallClientByname(String name){ return dataStore.findAllClientesByname(name);}
    public Cliente findByName (String name){return  dataStore.findByName(name);}
}
