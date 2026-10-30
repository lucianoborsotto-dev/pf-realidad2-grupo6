package vista;

public class FrmPasajeros extends javax.swing.JFrame {

    public FrmPasajeros() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLbienvenido.setFont(new java.awt.Font("Dubai Medium", 1, 36)); // NOI18N
        JLbienvenido.setText("Bienvenido a TodoViaje!");

        JLcreadores.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
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
                .addGroup(JDPescritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JDPescritorioLayout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(JLbienvenido))
                    .addGroup(JDPescritorioLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(JLcreadores)
                        .addGap(18, 18, 18)
                        .addComponent(JSPintegrantes, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        JDPescritorioLayout.setVerticalGroup(
            JDPescritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDPescritorioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(JLbienvenido)
                .addGroup(JDPescritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JDPescritorioLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(JSPintegrantes, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JDPescritorioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            java.util.logging.Logger.getLogger(FrmPasajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPasajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPasajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPasajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPasajeros().setVisible(true);
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
    private javax.swing.JMenuItem JMIver;
    private javax.swing.JMenu JMadministrar;
    private javax.swing.JMenu JMinicio;
    private javax.swing.JScrollPane JSPintegrantes;
    // End of variables declaration//GEN-END:variables
}
