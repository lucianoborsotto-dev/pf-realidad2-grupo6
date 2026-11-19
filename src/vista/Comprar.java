package vista;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Lugar;
import modelo.Pasajero;
import modelo.RutaViaje;
import persistencia.LugarDAO;
import persistencia.PasajeroDAO;
import persistencia.RutaViajeDAO;

public class Comprar extends javax.swing.JInternalFrame {

    //Crea el modelo por default de la tabla y sobrescribe el metodo de la clase para hacer que las celdas no sean editabes.
    private DefaultTableModel modeloPasa = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    RutaViajeDAO rvd;
    PasajeroDAO pjd;
    LugarDAO ld;
    List<Pasajero> allPasajeros;
    List<RutaViaje> allViajes;
    List<Lugar> lugaresViajeS;
    boolean pasajeroS;

    public Comprar() {
        initComponents();
        UtilidadesGenerales.ocultarMenu(this);
        try {
            rvd = new RutaViajeDAO();
            pjd = new PasajeroDAO();
            allViajes = rvd.listarRutasT();
            allPasajeros = pjd.listarT();
            ld = new LugarDAO();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar los drivers", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        cargarCabecera();
        cargarComboBox();
        JCBpasajero.setSelectedIndex(-1);
        JCBviajes.setSelectedIndex(-1);
        JCBpasajero.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLcargarLugar = new javax.swing.JLabel();
        JCBviajes = new javax.swing.JComboBox<>();
        JLviajes = new javax.swing.JLabel();
        JCBpasajero = new javax.swing.JComboBox<>();
        JLprecio = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        JLlugares = new javax.swing.JLabel();
        JSPlugar = new javax.swing.JScrollPane();
        JTlugares = new javax.swing.JTable();
        JBcomprar = new javax.swing.JButton();
        JBbaja = new javax.swing.JButton();
        JLpasajero = new javax.swing.JLabel();
        JTFprecio = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cargar Lugar");

        JLcargarLugar.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        JLcargarLugar.setText("Comprar Pasaje");

        JCBviajes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBviajesItemStateChanged(evt);
            }
        });

        JLviajes.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        JLviajes.setText("VIAJE");

        JCBpasajero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBpasajeroItemStateChanged(evt);
            }
        });

        JLprecio.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        JLprecio.setText("PRECIO: ");

        JLlugares.setFont(new java.awt.Font("Dubai Medium", 1, 20)); // NOI18N
        JLlugares.setText("Lugares disponibles");

        JTlugares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTlugares.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTlugaresMouseClicked(evt);
            }
        });
        JSPlugar.setViewportView(JTlugares);

        JBcomprar.setText("Comprar pasaje");
        JBcomprar.setEnabled(false);

        JBbaja.setText("Dar de Baja");
        JBbaja.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(JSPlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(JLlugares)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBcomprar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBbaja, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JLlugares)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSPlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBcomprar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(JBbaja, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        JLpasajero.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        JLpasajero.setText("PASAJERO");

        JTFprecio.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(181, 181, 181))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLprecio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JLviajes)
                            .addGap(12, 12, 12)
                            .addComponent(JCBviajes, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(70, 70, 70)
                            .addComponent(JLpasajero)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JCBpasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JLcargarLugar)
                        .addGap(333, 333, 333))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(JLcargarLugar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCBviajes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLviajes, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCBpasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLpasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCBviajesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBviajesItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED && JCBviajes.getSelectedIndex() != -1) {
            ViajeString rutaS = (ViajeString) JCBviajes.getSelectedItem();
            if (rutaS != null) {
                JCBpasajero.setEnabled(true);
                String precio = rutaS.getViaje().getPrecio().toString();
                JTFprecio.setText("$" + precio);
                int idViaje = rutaS.getViaje().getIdRuta();
                lugaresViajeS = ld.listarPorViaje(idViaje);
                cargarDatos();
            }
        } else {
            JCBpasajero.setEnabled(false);
            JCBpasajero.setSelectedIndex(-1);
            JTFprecio.setText("");
            modeloPasa.setRowCount(0);
        }
        guardarBoton();
    }//GEN-LAST:event_JCBviajesItemStateChanged

    private void JTlugaresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTlugaresMouseClicked
        guardarBoton();
    }//GEN-LAST:event_JTlugaresMouseClicked

    private void JCBpasajeroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBpasajeroItemStateChanged
        guardarBoton();
    }//GEN-LAST:event_JCBpasajeroItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBbaja;
    private javax.swing.JButton JBcomprar;
    private javax.swing.JComboBox<PasajeroString> JCBpasajero;
    private javax.swing.JComboBox<ViajeString> JCBviajes;
    private javax.swing.JLabel JLcargarLugar;
    private javax.swing.JLabel JLlugares;
    private javax.swing.JLabel JLpasajero;
    private javax.swing.JLabel JLprecio;
    private javax.swing.JLabel JLviajes;
    private javax.swing.JScrollPane JSPlugar;
    private javax.swing.JTextField JTFprecio;
    private javax.swing.JTable JTlugares;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    /**
     * Carga los Pasajeros y los Viajes a los ComboBoxs.
     */
    private void cargarComboBox() {
        for (Pasajero p : allPasajeros) {
            JCBpasajero.addItem(new PasajeroString(p));
        }
        for (RutaViaje rv : allViajes) {
            JCBviajes.addItem(new ViajeString(rv));
        }
    }

    /**
     * Agrega las cabeceras a la tabla con sus respectivos nombres.
     */
    private void cargarCabecera() {
        modeloPasa.addColumn("Asiento");
        modeloPasa.addColumn("Estado");

        JTlugares.setModel(modeloPasa);
    }
    
    /**
     * Carga los viajes a la tabla.
     */
    private void cargarDatos() {
        modeloPasa.setRowCount(0);
        for (Lugar l : lugaresViajeS) {
            modeloPasa.addRow(new Object[]{l.getNumeroAsiento(), l.isEstado()});
        }
    }
    
    /**
     * Habilita el boton guardar
     */
    private void guardarBoton() {
        boolean listo = JTlugares.getSelectedRow() != -1 && JCBpasajero.getSelectedIndex() != -1;
        JBcomprar.setEnabled(listo);
    }
}
