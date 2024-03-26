package cl.clasejava.bd_museos;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author alexblade2001
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        try {
            // Obtener instancia de la base de datos
            ConexionBD conexion = ConexionBD.getInstancia();

            /*
             * Crear nuevo cuadro para configurar la conexion,
             * pasar la instancia anterior al cuadro nuevo
             */
            Conectar conectarBD = new Conectar(conexion);
            conectarBD.setVisible(true);

            // Let this thing just wait
            while (conectarBD.isVisible()) {
                Thread.sleep(100);
            }

            /*
             * Recuerda revisar
             * Idealmente necesitamos decirle al usuario que la conexion fue
             * cancelada. A veces simplemente cierran el programa, sea por
             * accidente o sea a proposito
             */
            if (!conexion.isConectado()) {
                JOptionPane.showMessageDialog(null, "La conexión fue cancelada.");
                return;
            }
            MainScreen ventanaPrincipal = new MainScreen();
            ventanaPrincipal.setVisible(true);
            while (ventanaPrincipal.isVisible()) {
                Thread.sleep(100);
            }

        } catch (InterruptedException e) {
            // Check exceptions
        }
    }
}
