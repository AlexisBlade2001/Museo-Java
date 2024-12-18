package cl.clasejava.bd_museos.add;

import cl.clasejava.bd_museos.ConexionBD;
import cl.clasejava.bd_museos.JForm;
import javax.swing.*;
import java.sql.*;

/**
 * @author alexblade2001
 */
public class addMuseum extends JForm {

    private ConexionBD conexionBD;

    public addMuseum() {
        initComponents();
        conexionBD = ConexionBD.getInstancia();// Llamar al método para cargar los países en el JComboBox
        loadCountries();
    }

    private void loadCountries() {
        try {
            Connection conexion = conexionBD.getConexion();
            Statement statement = conexion.createStatement();
            String selectQuery = "SELECT nomPais FROM pais_origen";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Crear un modelo para el JComboBox
            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

            // Agregar los países al modelo del JComboBox
            while (resultSet.next()) {
                String pais = resultSet.getString("nombre");
                comboBoxModel.addElement(pais);
            }

            // Establecer el modelo del JComboBox
            pais.setModel(comboBoxModel);

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ...
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        museo = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        calle = new javax.swing.JTextField();
        ciudad = new javax.swing.JTextField();
        pais = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setTitle("Agregar Museo");

        pais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        add.setText("Agregar");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        cancel.setText("Cancelar");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre del Museo");

        jLabel2.setText("Dirección");

        jLabel3.setText("Calle");

        jLabel4.setText("Ciudad");

        jLabel5.setText("Pais");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addComponent(add)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(cancel))
                                        .addComponent(direccion, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(museo, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(calle, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ciudad, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(pais, javax.swing.GroupLayout.Alignment.TRAILING, 0,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(museo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(calle, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ciudad, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pais, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(add)
                                        .addComponent(cancel))
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {
        String museoName = museo.getText(); // Obtener el nombre del museo del campo de texto
        String direccionValue = direccion.getText(); // Obtener el valor de la dirección del campo de texto
        String calleValue = calle.getText(); // Obtener el valor de la calle del campo de texto
        String ciudadValue = ciudad.getText(); // Obtener el valor de la ciudad del campo de texto
        String paisValue = (String) pais.getSelectedItem(); // Obtener el país seleccionado del JComboBox

        try {
            Connection conexion = conexionBD.getConexion();
            Statement statement = conexion.createStatement();

            // Obtener el identificador del país seleccionado
            String selectQuery = "SELECT idPais FROM pais_origen WHERE nomPais = '" + paisValue + "'";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            if (resultSet.next()) {
                int paisId = resultSet.getInt("idPais");

                // Insertar los datos en la tabla correspondiente
                String insertQuery = "INSERT museo (nomMuseo, direccion, calle, ciudad, idPais) VALUES ('"
                        + museoName + "', '" + direccionValue + "', '" + calleValue + "', '" + ciudadValue + "', "
                        + paisId + ")";
                statement.executeUpdate(insertQuery);
                JOptionPane.showMessageDialog(this, "El museo se ha agregado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el país seleccionado.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al agregar el museo: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        dispose();
    }

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelActionPerformed
        dispose();
    }// GEN-LAST:event_cancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField calle;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField ciudad;
    private javax.swing.JTextField direccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField museo;
    private javax.swing.JComboBox<String> pais;
    // End of variables declaration//GEN-END:variables
}
