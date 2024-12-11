
package cl.clasejava.bd_museos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* alex: Ciertamente me tomo un tiempo, solo para recordar que debia crear un
 * singleton, quiero decir, tener una instancia singular de una clase, para
 * permitirme usarlo en el resto del codigo, menos mal estaba revisando mis
 * documentos, me tomo unos dias para encontrarlo */

public class ConexionBD {
    // Parametros de la clase
    private String address, port, database, user, password;
    private static ConexionBD instancia;
    private Connection conexion;

    // Constructor privado. Para evitar una instanciación directa
    private ConexionBD() {
    }

    // Obtener la instancia actual, si no existe (nula), crear una nueva
    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    // Configurar la conexion a la base de datos
    public void setConexion(String address, String port, String database,
            String user, String password) throws SQLException {
        this.address = address;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
        conexion = DriverManager.getConnection(
                "jdbc:mysql://" + address + ":" + port + "/" + database,
                user, password);
    }

    /*
     * Obtener la conexion a la base de datos, verificando si es nula o esta
     * cerrada, si uno de estos casos es verdadero, utilizar los parametros
     * para establecer la conexion, si es falso, retornar la conexion actual
     */
    public Connection getConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://" + address + ":" + port + "/" + database,
                    user, password);
        }
        return conexion;
    }

    // Revisar si esta conectado a la base de datos
    public boolean isConectado() throws SQLException {
        return conexion != null && !conexion.isClosed();
    }

    // Probar la conexion a la base de datos
    public boolean testConexion(String address, String port,
            String database, String user, String password) {
        String url = "jdbc:mysql://" + address + ":" + port + "/" + database;
        // Intentar Conectar
        try {
            // Verificar la existencia de la base de datos
            conexion = DriverManager.getConnection(url, user, password);
            return checkBaseDeDatos(conexion);
        } catch (SQLException e) {
            return false;
        } finally {
            if (conexion != null) {
                try {
                    // Cerrar conexion si esta conectado
                    conexion.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    private boolean checkBaseDeDatos(Connection conexion) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conexion.createStatement();
            resultSet = statement.executeQuery("SHOW TABLES");
            // retornar verdadero si hay al menos una tabla
            return resultSet.next();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }
}
