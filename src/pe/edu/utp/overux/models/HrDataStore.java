package pe.edu.utp.overux.models;

import pe.edu.utp.overux.models.Entity.ClienteEntity;
import pe.edu.utp.overux.models.Entity.CountryEntity;
import pe.edu.utp.overux.models.Entity.RegionsEntity;
import pe.edu.utp.overux.models.Entity.UsuarioEntity;
import pe.edu.utp.overux.models.domain.Cliente;
import pe.edu.utp.overux.models.domain.Country;
import pe.edu.utp.overux.models.domain.Region;
import pe.edu.utp.overux.models.domain.Usuario;

import java.sql.Connection;
import java.util.List;

public class HrDataStore {
    private Connection connection;
    private RegionsEntity regionsEntity;
    private CountryEntity countrieEntity;
    private UsuarioEntity usuarioEntity;
    private ClienteEntity clienteEntity;


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

    /*INSTANCIANDO LA CONEXION DE LO ENTITIES*/
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

    private UsuarioEntity getUsuarioEntity(){
        if(usuarioEntity == null){
            usuarioEntity = new UsuarioEntity();
            usuarioEntity.setConnection(connection);
        }
        return  usuarioEntity;
    }

    private ClienteEntity getClienteEntity(){
        if(clienteEntity == null){
            clienteEntity = new ClienteEntity();
            clienteEntity.setConnection(connection);
        }
        return  clienteEntity;
    }


    /*TODO LOS METODOS DE LOS DOMAIN*/
    /*REGION*/
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

    /*USUARIOS*/

    public int finByLogin(String name,String clave,int perfil) {
        return getConnection() == null ?
                null :
                getUsuarioEntity().finByLogin(name,clave,perfil);
    }

    public Usuario createUsuario(String name,String clave,int perfil)
    {
        return getConnection() == null ?
                null:
                getUsuarioEntity().create(name,clave,perfil);
    }

    /*CLIENTES*/

    public Cliente findClienteById(String id) {
        return getConnection() == null ?
                null :
                getClienteEntity().findByName(id);
    }

    public List<Cliente> findAllClientes() {
        return getConnection() == null ? null : getClienteEntity().findAll();
    }
    public List<Cliente> findAllClientesByname(String name) {
        return getConnection() == null ? null : getClienteEntity().findAllbyName(name);
    }
    public Cliente findByName(String name){ return getConnection() == null ? null: getClienteEntity().findByName(name);}


}






