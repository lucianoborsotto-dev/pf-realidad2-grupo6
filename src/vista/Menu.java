package vista;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDPescritorio = new javax.swing.JDesktopPane();
        JLbienvenido = new javax.swing.JLabel();
        JLcreadores = new javax.swing.JLabel();
        JSPintegrantes = new javax.swing.JScrollPane();
        JListIntegrantes = new javax.swing.JList<>();
        JMBventanas = new javax.swing.JMenuBar();
        JMinicio = new javax.swing.JMenu();
        JMIver = new javax.swing.JMenuItem();
        JMIallColeChof = new javax.swing.JMenuItem();
        JMadministrar = new javax.swing.JMenu();
        JMIpasajero = new javax.swing.JMenuItem();
        JMIcargarCole = new javax.swing.JMenuItem();
        JMIcargarViaje = new javax.swing.JMenuItem();
        JMIlugar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLbienvenido.setFont(new java.awt.Font("Dubai Medium", 1, 36)); // NOI18N
        JLbienvenido.setForeground(new java.awt.Color(255, 255, 255));
        JLbienvenido.setText("Bienvenido a TodoViaje!");

        JLcreadores.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        JLcreadores.setForeground(new java.awt.Color(255, 255, 255));
        JLcreadores.setText("Creadores:");

        JListIntegrantes.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        JListIntegrantes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "- Martin Ezequiel Ramos.", "- Luciano Emanuel Borsotto.", "- Roman Ezequiel Castro.", "- Enzo Roman Valverde.", "- Franco Emmanuel Orozco." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        JSPintegrantes.setViewportView(JListIntegrantes);

        JDPescritorio.setLayer(JLbienvenido, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JDPescritorio.setLayer(JLcreadores, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JDPescritorio.setLayer(JSPintegrantes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout JDPescritorioLayout = new javax.swing.GroupLayout(JDPescritorio);
        JDPescritorio.setLayout(JDPescritorioLayout);
        JDPescritorioLayout.setHorizontalGroup(
            JDPescritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDPescritorioLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(JLcreadores)
                .addGap(18, 18, 18)
                .addComponent(JSPintegrantes, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(511, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JDPescritorioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLbienvenido)
                .addGap(253, 253, 253))
        );
        JDPescritorioLayout.setVerticalGroup(
            JDPescritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDPescritorioLayout.createSequentialGroup()
                .addGroup(JDPescritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JDPescritorioLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JLbienvenido)
                        .addGap(36, 36, 36)
                        .addComponent(JSPintegrantes, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JDPescritorioLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(JLcreadores)))
                .addContainerGap(402, Short.MAX_VALUE))
        );

        JMinicio.setText("Ver");

        JMIver.setText("All pasajes pasajero");
        JMIver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIverActionPerformed(evt);
            }
        });
        JMinicio.add(JMIver);

        JMIallColeChof.setText("Todos los buses y chofres");
        JMinicio.add(JMIallColeChof);

        JMBventanas.add(JMinicio);

        JMadministrar.setText("Administrar");

        JMIpasajero.setText("1- Cargar Pasajero");
        JMIpasajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIpasajeroActionPerformed(evt);
            }
        });
        JMadministrar.add(JMIpasajero);

        JMIcargarCole.setText("2- Cargar Colectivo");
        JMIcargarCole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIcargarColeActionPerformed(evt);
            }
        });
        JMadministrar.add(JMIcargarCole);

        JMIcargarViaje.setText("3- Cargar Viaje");
        JMIcargarViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIcargarViajeActionPerformed(evt);
            }
        });
        JMadministrar.add(JMIcargarViaje);

        JMIlugar.setText("4- Comprar");
        JMIlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIlugarActionPerformed(evt);
            }
        });
        JMadministrar.add(JMIlugar);

        JMBventanas.add(JMadministrar);

        setJMenuBar(JMBventanas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDPescritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDPescritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMIverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JMIverActionPerformed

    private void JMIlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIlugarActionPerformed
        JDPescritorio.removeAll();
        JDPescritorio.revalidate();
        JDPescritorio.repaint();
        Comprar ventanaCL = new Comprar();
        ventanaCL.setVisible(true);
        JDPescritorio.add(ventanaCL);
        JDPescritorio.moveToFront(ventanaCL);

    }//GEN-LAST:event_JMIlugarActionPerformed

    private void JMIcargarViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIcargarViajeActionPerformed
        JDPescritorio.removeAll();
        JDPescritorio.revalidate();
        JDPescritorio.repaint();
        CargarViaje ventanaCV = new CargarViaje();
        ventanaCV.setVisible(true);
        JDPescritorio.add(ventanaCV);
        JDPescritorio.moveToFront(ventanaCV);
    }//GEN-LAST:event_JMIcargarViajeActionPerformed

    private void JMIcargarColeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIcargarColeActionPerformed
        JDPescritorio.removeAll();
        JDPescritorio.revalidate();
        JDPescritorio.repaint();
        CargarColectivo ventanaC = new CargarColectivo();
        ventanaC.setVisible(true);
        JDPescritorio.add(ventanaC);
        JDPescritorio.moveToFront(ventanaC);
    }//GEN-LAST:event_JMIcargarColeActionPerformed

    private void JMIpasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIpasajeroActionPerformed
        JDPescritorio.removeAll();
        JDPescritorio.revalidate();
        JDPescritorio.repaint();
        CargarPasajero ventanaP = new CargarPasajero();
        ventanaP.setVisible(true);
        JDPescritorio.add(ventanaP);
        JDPescritorio.moveToFront(ventanaP);
    }//GEN-LAST:event_JMIpasajeroActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JDPescritorio;
    private javax.swing.JLabel JLbienvenido;
    private javax.swing.JLabel JLcreadores;
    private javax.swing.JList<String> JListIntegrantes;
    private javax.swing.JMenuBar JMBventanas;
    private javax.swing.JMenuItem JMIallColeChof;
    private javax.swing.JMenuItem JMIcargarCole;
    private javax.swing.JMenuItem JMIcargarViaje;
    private javax.swing.JMenuItem JMIlugar;
    private javax.swing.JMenuItem JMIpasajero;
    private javax.swing.JMenuItem JMIver;
    private javax.swing.JMenu JMadministrar;
    private javax.swing.JMenu JMinicio;
    private javax.swing.JScrollPane JSPintegrantes;
    // End of variables declaration//GEN-END:variables
}
