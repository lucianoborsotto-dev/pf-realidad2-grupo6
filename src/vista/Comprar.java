package vista;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Lugar;
import modelo.Pasaje;
import modelo.Pasajero;
import modelo.RutaViaje;
import persistencia.LugarDAO;
import persistencia.PasajeDAO;
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
    PasajeDAO pd;
    LugarDAO ld;
    List<Pasajero> allPasajeros;
    List<RutaViaje> allViajes;
    List<Lugar> lugaresViajeS;
    boolean pasajeroS;

    public Comprar() {
        initComponents();

        JDCfechaVenta.setDate(new java.util.Date());

        try {
            rvd = new RutaViajeDAO();
            pjd = new PasajeroDAO();
            allViajes = rvd.listarRutasT();
            allPasajeros = pjd.listarT();
            ld = new LugarDAO();
            pd = new PasajeDAO();
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
        JBbajaPasaje = new javax.swing.JButton();
        JLpasajero = new javax.swing.JLabel();
        JTFprecio = new javax.swing.JTextField();
        JLhoraVenta = new javax.swing.JLabel();
        TPhoraVenta = new com.github.lgooddatepicker.components.TimePicker();
        JDCfechaVenta = new com.toedter.calendar.JDateChooser();
        JLfechaVenta = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cargar Lugar");

        JLcargarLugar.setText("Comprar Pasaje");
        JLcargarLugar.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N

        JCBviajes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBviajesItemStateChanged(evt);
            }
        });

        JLviajes.setText("VIAJE");
        JLviajes.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N

        JCBpasajero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBpasajeroItemStateChanged(evt);
            }
        });

        JLprecio.setText("PRECIO: ");
        JLprecio.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N

        JLlugares.setText("Lugares disponibles");
        JLlugares.setFont(new java.awt.Font("Dubai Medium", 1, 20)); // NOI18N

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
        JBcomprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBcomprarActionPerformed(evt);
            }
        });

        JBbajaPasaje.setText("Dar de Baja Pasaje");
        JBbajaPasaje.setEnabled(false);
        JBbajaPasaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBbajaPasajeActionPerformed(evt);
            }
        });

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
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBcomprar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBbajaPasaje, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JBbajaPasaje, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        JLpasajero.setText("PASAJERO");
        JLpasajero.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N

        JTFprecio.setEditable(false);

        JLhoraVenta.setText("HORA VENTA:");
        JLhoraVenta.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N

        JLfechaVenta.setText("FECHA VENTA:");
        JLfechaVenta.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLviajes)
                                .addGap(12, 12, 12)
                                .addComponent(JCBviajes, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(JLpasajero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCBpasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JLprecio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTFprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(98, 98, 98)
                                        .addComponent(JLhoraVenta))
                                    .addComponent(JLfechaVenta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TPhoraVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JDCfechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JLcargarLugar)
                        .addGap(333, 333, 333))))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                    .addComponent(JTFprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLhoraVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TPhoraVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JDCfechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLfechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
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

    private void JBcomprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBcomprarActionPerformed
        ViajeString viaje = (ViajeString) JCBviajes.getSelectedItem();
        PasajeroString pasajero = (PasajeroString) JCBpasajero.getSelectedItem();
        int idPasajero = pasajero.getPasajero().getIdPasajero();
        int idViaje = viaje.getViaje().getIdRuta();
        LocalDate fechaVenta = JDCfechaVenta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalTime horaVenta = TPhoraVenta.getTime();
        String texto = JTFprecio.getText().replace("$", "").trim();
        BigDecimal precio = new BigDecimal(texto);
        Pasaje pasaje = null;

        // Verificaciones
        int filaS = JTlugares.getSelectedRow();
        lugaresViajeS = ld.listarPorViaje(idViaje);
        Lugar lugar = lugaresViajeS.get(filaS);
        boolean estado = lugar.isEstado();
        int idLugar = lugar.getIdLugar();

        LocalTime horaSalida = viaje.getViaje().getHoraSalida();
        boolean estaDisponible = (boolean) JTlugares.getValueAt(filaS, 1);

        if (filaS != -1 && !estaDisponible) {
            JOptionPane.showMessageDialog(this, "Este lugar está ocupado.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!horaVenta.isBefore(horaSalida)) {
            JOptionPane.showMessageDialog(this, "ERROR: La hora de venta tiene que ser anterior a la hora de salida del viaje.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (fechaVenta.isBefore(LocalDate.now())) {
            JOptionPane.showMessageDialog(this, "No se puede comprar un pasaje anterior a la fecha de hoy.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (estado) {
            ld.altaBajaLogicaLugar(false, idLugar, idViaje);
            for (Lugar l : lugaresViajeS) {
                if (l.getIdLugar() == idLugar) {
                    l.setEstado(false);
                    modeloPasa.setValueAt(false, filaS, 1);
                    break;
                }
            }
        }
        pasaje = new Pasaje(pasajero.getPasajero(), lugar, viaje.getViaje(), fechaVenta, horaVenta, precio);
        try {
            pd.generar(pasaje);
        } catch (SQLException ex) {
            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Pasaje comprado!");


    }//GEN-LAST:event_JBcomprarActionPerformed

    private void JBbajaPasajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBbajaPasajeActionPerformed
        int filaS = JTlugares.getSelectedRow();
        ViajeString viaje = (ViajeString) JCBviajes.getSelectedItem();
        if (filaS == -1 || viaje == null) {
            return;
        }

        Lugar lugar = lugaresViajeS.get(filaS);
        int idLugar = lugar.getIdLugar();
        int idViaje = viaje.getViaje().getIdRuta();

        try {
            pd.borrarPorLugarYViaje(idLugar, idViaje);
            ld.altaBajaLogicaLugar(true, idLugar, idViaje);
            lugar.setEstado(true);
            modeloPasa.setValueAt(true, filaS, 1);
            JOptionPane.showMessageDialog(this, "Pasaje dado de baja.");
        } catch (SQLException ex) {
            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al dar de baja el pasaje.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBbajaPasajeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBbajaPasaje;
    private javax.swing.JButton JBcomprar;
    private javax.swing.JComboBox<PasajeroString> JCBpasajero;
    private javax.swing.JComboBox<ViajeString> JCBviajes;
    private com.toedter.calendar.JDateChooser JDCfechaVenta;
    private javax.swing.JLabel JLcargarLugar;
    private javax.swing.JLabel JLfechaVenta;
    private javax.swing.JLabel JLhoraVenta;
    private javax.swing.JLabel JLlugares;
    private javax.swing.JLabel JLpasajero;
    private javax.swing.JLabel JLprecio;
    private javax.swing.JLabel JLviajes;
    private javax.swing.JScrollPane JSPlugar;
    private javax.swing.JTextField JTFprecio;
    private javax.swing.JTable JTlugares;
    private com.github.lgooddatepicker.components.TimePicker TPhoraVenta;
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
        boolean listo = JTlugares.getSelectedRow() != -1
                && JCBpasajero.getSelectedIndex() != -1
                && JDCfechaVenta.getDate() != null
                && TPhoraVenta.getTime() != null;
        JBcomprar.setEnabled(listo);
        JBbajaPasaje.setEnabled(listo);
    }
}
