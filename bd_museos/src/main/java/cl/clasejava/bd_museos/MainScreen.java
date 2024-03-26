package cl.clasejava.bd_museos;

import cl.clasejava.bd_museos.add.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 * @author alexblade2001
 */
public class MainScreen extends javax.swing.JFrame {
    private final ConexionBD conexionBD;

    public MainScreen() {
        initComponents();
        conexionBD = ConexionBD.getInstancia();
        getTablas();
    }

    private void getTablas() {
        try (Connection conexion = conexionBD.getConexion()) {
            List<String> Tablas = getNombreTablas(conexion);
            for (String nombreTabla : Tablas) {
                crearTabla(conexion, nombreTabla);
            }
        } catch (SQLException e) {
        }
    }

    private List<String> getNombreTablas(Connection conexion) throws SQLException {
        List<String> nombreTablas = new ArrayList<>();
        DatabaseMetaData metaDato = conexion.getMetaData();
        try (ResultSet resultSet = metaDato.getTables(null, null, null, new String[] { "TABLE" })) {
            while (resultSet.next()) {
                nombreTablas.add(resultSet.getString("TABLE_NAME"));
            }
        }
        return nombreTablas;
    }

    private void crearTabla(Connection conexion, String nombreTabla) {
        try (Statement statement = conexion.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM " + nombreTabla)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnasContadas = metaData.getColumnCount();
            var nombreColumnas = new String[columnasContadas];
            for (int i = 1; i <= columnasContadas; i++) {
                nombreColumnas[i - 1] = metaData.getColumnName(i);
            }

            var modeloTabla = new DefaultTableModel(nombreColumnas, 0);
            while (resultSet.next()) {
                Object[] datoFila = new Object[columnasContadas];
                for (int i = 1; i <= columnasContadas; i++) {
                    datoFila[i - 1] = resultSet.getObject(i);
                }
                modeloTabla.addRow(datoFila);
            }

            var tabla = new JTable(modeloTabla);
            pestana.addTab(nombreTabla, new JScrollPane(tabla));
            pestana.setName(nombreTabla);
        } catch (SQLException e) {
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        pestana = new javax.swing.JTabbedPane();
        separador = new javax.swing.JSeparator();
        agregar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Base de Datos: Museo");

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        cerrar.setText("Cerrar");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(agregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(modificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(eliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(actualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cerrar)
                                .addContainerGap())
                        .addComponent(separador, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(pestana, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(12, 12, 12)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pestana, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(agregar)
                                        .addComponent(eliminar)
                                        .addComponent(cerrar)
                                        .addComponent(actualizar)
                                        .addComponent(modificar))
                                .addContainerGap()));

        pack();
    }

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {
        switch (pestana.getTitleAt(pestana.getSelectedIndex())) {
            case "museo":
                addMuseum museum = new addMuseum();
                museum.setVisible(true);
                break;
            case "autor":
                addAuthor author = new addAuthor();
                author.setVisible(true);
                break;
            case "pais_origen":
                addCountry country = new addCountry();
                country.setVisible(true);
                break;
            case "obra":
                addArtwork artwork = new addArtwork();
                artwork.setVisible(true);
                break;
            default:
                break;
        }
    }

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {
        var tituloTabla = pestana.getTitleAt(pestana.getSelectedIndex());
        if (tituloTabla != null) {
            JTable tablaSeleccionada = pestana.getSelectedComponent() instanceof JScrollPane
                    ? (JTable) ((JScrollPane) pestana.getSelectedComponent()).getViewport().getView()
                    : (JTable) pestana.getSelectedComponent();
            var tabla = (DefaultTableModel) tablaSeleccionada.getModel();
            var id = tablaSeleccionada.getColumnName(0);
            var row = tablaSeleccionada.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this,
                        "No se ha seleccionado ningún registro para modificar.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {
        var tituloTabla = pestana.getTitleAt(pestana.getSelectedIndex());
        if (tituloTabla != null) {
            JTable tablaSeleccionada = pestana.getSelectedComponent() instanceof JScrollPane
                    ? (JTable) ((JScrollPane) pestana.getSelectedComponent()).getViewport().getView()
                    : (JTable) pestana.getSelectedComponent();
            var tabla = (DefaultTableModel) tablaSeleccionada.getModel();
            var id = tablaSeleccionada.getColumnName(0);
            var row = tablaSeleccionada.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this,
                        "No se ha seleccionado ningún registro para eliminar.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            var confirmar = JOptionPane.showConfirmDialog(this,
                    "¿Estás seguro de que deseas eliminar el registro seleccionado?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                try {
                    Connection conexion = conexionBD.getConexion();
                    try (Statement statement = conexion.createStatement()) {
                        var string = "DELETE FROM " + tituloTabla + " WHERE " + id + " = "
                                + tablaSeleccionada.getValueAt(row, 0);
                        statement.executeUpdate(string);
                        JOptionPane.showMessageDialog(this,
                                "El registro se ha eliminado exitosamente.");
                    }
                    tabla.removeRow(row);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this,
                            "Error al eliminar el registro: " + e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            conexionBD.getConexion().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton agregar;
    private javax.swing.JButton cerrar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton modificar;
    private javax.swing.JTabbedPane pestana;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables
}