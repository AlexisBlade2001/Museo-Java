/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package cl.clasejava.bd_museos;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alexblade2001
 */
public class Bd_museos {

    public static void main(String[] args) throws SQLException {
        try {
            // Get the DB instance
            DatabaseConnection connection = DatabaseConnection.getInstance();

            // Make new instance, send the connection there
            Connect connect = new Connect(connection);
            connect.setVisible(true);

            // Let this wait
            while (connect.isVisible()) {
                Thread.sleep(100);
            }

            // remember to check
            // Ideally we need to tell the user that the connection was cancelled
            // sometimes people just close the program, wherever be accident or
            // on purpose
            if (!connection.isConnected()) {
                JOptionPane.showMessageDialog(null, "La conexión fue cancelada.");
                // end
                return;
            }

            Viewer mainScreen = new Viewer();
            mainScreen.setVisible(true);
            while (mainScreen.isVisible()) {
                Thread.sleep(100);
            }

        } catch (InterruptedException e) {
            // Check exceptions
            e.printStackTrace();
        }
    }
}
