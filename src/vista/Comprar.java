package vista;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Pasajero;
import modelo.RutaViaje;
import persistencia.PasajeroDAO;
import persistencia.RutaViajeDAO;

public class Comprar extends javax.swing.JInternalFrame {
    //Crea el modelo por default de la tabla y sobrescribe el metodo de la clase para hacer que las celdas no sean editabes.
    private DefaultTableModel modeloPase = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    
    RutaViajeDAO rvd;
    PasajeroDAO pjd;
    List<Pasajero> allPasajeros;
    List<RutaViaje> allViajes;
    
    public Comprar() {
        initComponents();
        UtilidadesGenerales.ocultarMenu(this);
        try {
            rvd = new RutaViajeDAO();
            pjd = new PasajeroDAO();
            allViajes = rvd.listarRutas();
            allPasajeros = pjd.listarT();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar los drivers", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        cargarComboBox();
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
        JBguardar = new javax.swing.JButton();
        JBbaja = new javax.swing.JButton();
        JLpasajero = new javax.swing.JLabel();
        JTFprecio = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cargar Lugar");

        JLcargarLugar.setText("Comprar Pasaje");
        JLcargarLugar.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N

        JLviajes.setText("VIAJE");
        JLviajes.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N

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
        JSPlugar.setViewportView(JTlugares);

        JBguardar.setText("Comprar pasaje");

        JBbaja.setText("Dar de Baja");

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
                    .addComponent(JBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(JBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(JBbaja, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        JLpasajero.setText("PASAJERO");
        JLpasajero.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLprecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLcargarLugar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLpasajero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCBpasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(JLviajes)))
                        .addGap(12, 12, 12)
                        .addComponent(JCBviajes, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(JLcargarLugar)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JCBviajes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLviajes, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JCBpasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLpasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBbaja;
    private javax.swing.JButton JBguardar;
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
}