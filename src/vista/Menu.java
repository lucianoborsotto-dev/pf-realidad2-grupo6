package vista;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        try {
            // Carga la imagen desde las imagenes del proyecto y la establece como ícono
            setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Imagen/colectivo-icon.png")).getImage());
        } catch (Exception e) {
            System.out.println("No se pudo cargar el ícono de la ventana: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDPescritorio = new DesktopConFondo("/Imagen/fondo-principal.jpg");
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

        JDPescritorio.setAutoscrolls(true);

        javax.swing.GroupLayout JDPescritorioLayout = new javax.swing.GroupLayout(JDPescritorio);
        JDPescritorio.setLayout(JDPescritorioLayout);
        JDPescritorioLayout.setHorizontalGroup(
            JDPescritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1011, Short.MAX_VALUE)
        );
        JDPescritorioLayout.setVerticalGroup(
            JDPescritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 702, Short.MAX_VALUE)
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
    private javax.swing.JMenuBar JMBventanas;
    private javax.swing.JMenuItem JMIallColeChof;
    private javax.swing.JMenuItem JMIcargarCole;
    private javax.swing.JMenuItem JMIcargarViaje;
    private javax.swing.JMenuItem JMIlugar;
    private javax.swing.JMenuItem JMIpasajero;
    private javax.swing.JMenuItem JMIver;
    private javax.swing.JMenu JMadministrar;
    private javax.swing.JMenu JMinicio;
    // End of variables declaration//GEN-END:variables
}

//Permite cargarle una imagen al JDesktopPane.
class DesktopConFondo extends javax.swing.JDesktopPane {
    private java.awt.Image imagen;

    public DesktopConFondo(String rutaImagen) {
        try {
            this.imagen = new javax.swing.ImageIcon(getClass().getResource(rutaImagen)).getImage();
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen de fondo: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
