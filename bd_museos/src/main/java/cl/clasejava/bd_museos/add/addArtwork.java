package cl.clasejava.bd_museos.add;

import cl.clasejava.bd_museos.ConexionBD;
import cl.clasejava.bd_museos.JForm;
import javax.swing.*;
import java.sql.*;

/**
 * @author alexblade2001
 */
public class addArtwork extends JForm {

    private ConexionBD conexionBD;

    /**
     * Creates new form Artwork
     */
    public addArtwork() {
        initComponents();
        conexionBD = ConexionBD.getInstancia();
        // Cargar los datos de Museo y Autor al iniciar el JFrame
        cargarDatosMuseo();
        cargarDatosAutor();

    }

    // Resto del código...
    private void cargarDatosMuseo() {
        try {
            Connection conexion = conexionBD.getConexion();

            // Obtener los datos de los museos desde la base de datos
            Statement museoStatement = conexion.createStatement();
            ResultSet museoResultSet = museoStatement.executeQuery("SELECT nomMuseo FROM museo");

            // Llenar el JComboBox museo con los nombres de los museos
            museo.removeAllItems();
            while (museoResultSet.next()) {
                String nomMuseo = museoResultSet.getString("nomMuseo");
                museo.addItem(nomMuseo);
            }

            museoResultSet.close();
            museoStatement.close();

            conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de museo: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void cargarDatosAutor() {
        try {
            Connection conexion = conexionBD.getConexion();

            // Obtener los datos de los autores desde la base de datos
            Statement autorStatement = conexion.createStatement();
            ResultSet autorResultSet = autorStatement.executeQuery("SELECT nomAut FROM autor");

            // Llenar el JComboBox autor con los nombres de los autores
            autor.removeAllItems();
            while (autorResultSet.next()) {
                String nombreAutor = autorResultSet.getString("nomAut");
                autor.addItem(nombreAutor);
            }

            autorResultSet.close();
            autorStatement.close();

            conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de autor: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JTextField();
        autor = new javax.swing.JComboBox<>();
        fechaCreacion = new javax.swing.JFormattedTextField();
        tecnicaArtistica = new javax.swing.JTextField();
        estiloArtistico = new javax.swing.JTextField();
        ancho = new javax.swing.JTextField();
        alto = new javax.swing.JTextField();
        museo = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setTitle("Agregar Obra");

        titulo.setPreferredSize(new java.awt.Dimension(128, 20));

        autor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1" }));

        fechaCreacion.setFormatterFactory(
                new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        fechaCreacion.setToolTipText("");

        tecnicaArtistica.setPreferredSize(new java.awt.Dimension(128, 20));

        museo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1" }));

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

        jLabel1.setText("Titulo Obra");

        jLabel2.setText("Autor/a");

        jLabel3.setText("Fecha de Creación");

        jLabel4.setText("Tecnica Artistica");

        jLabel5.setText("Estilo Artistico");

        jLabel6.setText("Ancho");

        jLabel7.setText("Alto");

        jLabel8.setText("Museo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                false)
                                                                                .addComponent(jLabel6,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(jLabel8,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE))
                                                                        .addComponent(jLabel7))
                                                                .addGap(95, 95, 95)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(museo, 0,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(alto)
                                                                        .addComponent(ancho)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                130,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel1))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(estiloArtistico)
                                                                        .addComponent(tecnicaArtistica,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(fechaCreacion)
                                                                        .addComponent(autor, 0,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(titulo,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(add)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(cancel)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(autor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fechaCreacion, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tecnicaArtistica, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(estiloArtistico, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ancho, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(alto, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(museo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancel)
                                        .addComponent(add))
                                .addContainerGap()));

        pack();
    }//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addActionPerformed
        String tituloObra = titulo.getText();
        String nombreAutor = autor.getSelectedItem().toString();
        String fecha = fechaCreacion.getText();
        String tecnica = tecnicaArtistica.getText();
        String estilo = estiloArtistico.getText();
        int anchoObra = Integer.parseInt(ancho.getText());
        int altoObra = Integer.parseInt(alto.getText());
        String nombreMuseo = museo.getSelectedItem().toString();

        try {
            Connection conexion = conexionBD.getConexion();

            // Obtener el ID del autor seleccionado
            PreparedStatement autorStatement = conexion
                    .prepareStatement("SELECT idAutor FROM autor WHERE nomAutor = ?");
            autorStatement.setString(1, nombreAutor);
            ResultSet autorResultSet = autorStatement.executeQuery();
            autorResultSet.next();
            int idAutor = autorResultSet.getInt("idAutor");
            autorResultSet.close();
            autorStatement.close();

            // Obtener el ID del museo seleccionado
            PreparedStatement museoStatement = conexion
                    .prepareStatement("SELECT idMuseo FROM museo WHERE nomMuseo = ?");
            museoStatement.setString(1, nombreMuseo);
            ResultSet museoResultSet = museoStatement.executeQuery();
            museoResultSet.next();
            int idMuseo = museoResultSet.getInt("idMuseo");
            museoResultSet.close();
            museoStatement.close();

            // Insertar la nueva obra en la base de datos
            PreparedStatement insertStatement = conexion.prepareStatement(
                    "INSERT INTO obra (tituloObra, idAutor, fechaCreacion, tecArtistica, estiloArtistico, ancho, alto, idMuseo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            insertStatement.setString(1, tituloObra);
            insertStatement.setInt(2, idAutor);
            insertStatement.setString(3, fecha);
            insertStatement.setString(4, tecnica);
            insertStatement.setString(5, estilo);
            insertStatement.setInt(6, anchoObra);
            insertStatement.setInt(7, altoObra);
            insertStatement.setInt(8, idMuseo);
            insertStatement.executeUpdate();
            insertStatement.close();

            conexion.close();

            JOptionPane.showMessageDialog(this, "La obra se ha agregado correctamente.", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al agregar la obra: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en el formato de los campos Ancho y Alto.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }// GEN-LAST:event_addActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelActionPerformed
        dispose();
    }// GEN-LAST:event_cancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField alto;
    private javax.swing.JTextField ancho;
    private javax.swing.JComboBox<String> autor;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField estiloArtistico;
    private javax.swing.JFormattedTextField fechaCreacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox<String> museo;
    private javax.swing.JTextField tecnicaArtistica;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}
