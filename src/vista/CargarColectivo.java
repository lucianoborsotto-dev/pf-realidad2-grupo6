package vista;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Colectivo;
import persistencia.ColectivoDAO;

public class CargarColectivo extends javax.swing.JInternalFrame {

    //Crea el modelo por default de la tabla y sobrescribe el metodo de la clase para hacer que las celdas no sean editabes.
    private DefaultTableModel modeloC = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    ColectivoDAO cd;

    public CargarColectivo() {
        initComponents();
        UtilidadesGenerales.ocultarMenu(this);
        cargarCabecera();

        try {
            cd = new ColectivoDAO();
            cargarColectivos();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al conectar con la base de datos",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);

            Logger.getLogger(CargarColectivo.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBalta = new javax.swing.JButton();
        JBbaja = new javax.swing.JButton();
        JSPcolectivos = new javax.swing.JScrollPane();
        JTcolectivos = new javax.swing.JTable();
        JLcargarColectivo = new javax.swing.JLabel();
        JPfiltrado = new javax.swing.JPanel();
        JLbuscar = new javax.swing.JLabel();
        JTFfiltrar = new javax.swing.JTextField();
        JPdatos = new javax.swing.JPanel();
        JLmarca = new javax.swing.JLabel();
        JLchofer = new javax.swing.JLabel();
        JTFmatricula = new javax.swing.JTextField();
        JTFmarca = new javax.swing.JTextField();
        JTFmodelo = new javax.swing.JTextField();
        JTFchofer = new javax.swing.JTextField();
        JLmatricula = new javax.swing.JLabel();
        JLmodelo = new javax.swing.JLabel();
        JBguardar = new javax.swing.JButton();
        JBborrar = new javax.swing.JButton();
        JBactualizar = new javax.swing.JButton();
        JBlimpiar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cargar Colectivo");

        JBalta.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        JBalta.setText("Dar de Alta");
        JBalta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBaltaActionPerformed(evt);
            }
        });

        JBbaja.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        JBbaja.setText("Dar de Baja");
        JBbaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBbajaActionPerformed(evt);
            }
        });

        JTcolectivos.setModel(new javax.swing.table.DefaultTableModel(
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
        JTcolectivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTcolectivosMouseClicked(evt);
            }
        });
        JSPcolectivos.setViewportView(JTcolectivos);

        JLcargarColectivo.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        JLcargarColectivo.setText("Cargar Colectivo");

        JPfiltrado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLbuscar.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        JLbuscar.setText("BUSCAR COLECTIVO:       MATRICULA");

        JTFfiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFfiltrarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout JPfiltradoLayout = new javax.swing.GroupLayout(JPfiltrado);
        JPfiltrado.setLayout(JPfiltradoLayout);
        JPfiltradoLayout.setHorizontalGroup(
            JPfiltradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPfiltradoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(JLbuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTFfiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPfiltradoLayout.setVerticalGroup(
            JPfiltradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPfiltradoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPfiltradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLbuscar)
                    .addComponent(JTFfiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        JLmarca.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        JLmarca.setText("MARCA:");

        JLchofer.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        JLchofer.setText("CHOFER:");

        JTFmatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTFmatriculaKeyTyped(evt);
            }
        });

        JTFmarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTFmarcaKeyTyped(evt);
            }
        });

        JTFmodelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTFmodeloKeyTyped(evt);
            }
        });

        JTFchofer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTFchoferKeyTyped(evt);
            }
        });

        JLmatricula.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        JLmatricula.setText("MATRICULA:");

        JLmodelo.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        JLmodelo.setText("MODELO:");

        javax.swing.GroupLayout JPdatosLayout = new javax.swing.GroupLayout(JPdatos);
        JPdatos.setLayout(JPdatosLayout);
        JPdatosLayout.setHorizontalGroup(
            JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPdatosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPdatosLayout.createSequentialGroup()
                        .addComponent(JLmodelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPdatosLayout.createSequentialGroup()
                        .addComponent(JLmatricula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addGroup(JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPdatosLayout.createSequentialGroup()
                        .addComponent(JLmarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPdatosLayout.createSequentialGroup()
                        .addComponent(JLchofer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFchofer, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        JPdatosLayout.setVerticalGroup(
            JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPdatosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLmatricula)
                    .addComponent(JLmarca)
                    .addComponent(JTFmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLmodelo)
                    .addComponent(JTFmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLchofer)
                    .addComponent(JTFchofer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        JBguardar.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        JBguardar.setText("Guardar");
        JBguardar.setEnabled(false);
        JBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBguardarActionPerformed(evt);
            }
        });

        JBborrar.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        JBborrar.setText("Borrar");
        JBborrar.setEnabled(false);
        JBborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBborrarActionPerformed(evt);
            }
        });

        JBactualizar.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        JBactualizar.setText("Actualizar");
        JBactualizar.setEnabled(false);
        JBactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBactualizarActionPerformed(evt);
            }
        });

        JBlimpiar.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        JBlimpiar.setText("Limpiar");
        JBlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBlimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(JLcargarColectivo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JPdatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JBbaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JBalta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JBborrar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JSPcolectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(JPfiltrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(JLcargarColectivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JPfiltrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(JPdatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JBborrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBalta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBbaja, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(JSPcolectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBaltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBaltaActionPerformed
        int filaS = JTcolectivos.getSelectedRow(); //Traer la fila que estoy seleccionando.
        if (filaS != -1) {
            int id = (int) JTcolectivos.getValueAt(filaS, 0);
            boolean estado = (boolean) JTcolectivos.getValueAt(filaS, 6);
            if (estado) {
                JOptionPane.showMessageDialog(this, "No puede dar de alta a un colectivo que ya lo esta.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    if (cd.reactivar(id)) {
                        // Actualiza el estado en la tabla
                        modeloC.setValueAt(true, filaS, 6);

                        JOptionPane.showMessageDialog(this,
                                "El colectivo ha sido dado de alta con exito!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CargarColectivo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CargarColectivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBaltaActionPerformed

    private void JBbajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBbajaActionPerformed
        int filaS = JTcolectivos.getSelectedRow(); //Traer la fila que estoy seleccionando.
        if (filaS != -1) {
            int id = (int) JTcolectivos.getValueAt(filaS, 0);
            boolean estado = (boolean) JTcolectivos.getValueAt(filaS, 6);
            if (!estado) {
                JOptionPane.showMessageDialog(this, "No puede dar de baja a un colectivo que ya lo esta.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    if (cd.darDeBaja(id)) {
                        // Actualiza el estado en la tabla
                        modeloC.setValueAt(false, filaS, 6);

                        JOptionPane.showMessageDialog(this,
                                "El colectivo ha sido dado de baja con exito!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CargarColectivo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CargarColectivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBbajaActionPerformed

    private void JTcolectivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTcolectivosMouseClicked
        int filaS = JTcolectivos.getSelectedRow();
        if (filaS != -1) {
            String matricula = (String) JTcolectivos.getValueAt(filaS, 1);
            String marca = (String) JTcolectivos.getValueAt(filaS, 2);
            String modelo = (String) JTcolectivos.getValueAt(filaS, 3);
            String chofer = (String) JTcolectivos.getValueAt(filaS, 5);

            JTFmodelo.setText(modelo);
            JTFmatricula.setText(matricula);
            JTFmarca.setText(marca);
            JTFchofer.setText(chofer);
        }

        JBborrar.setEnabled(true);
        JBactualizar.setEnabled(true);
    }//GEN-LAST:event_JTcolectivosMouseClicked

    private void JTFfiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFfiltrarKeyReleased

    }//GEN-LAST:event_JTFfiltrarKeyReleased

    private void JTFmatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFmatriculaKeyTyped
        habilitarGuardar();
    }//GEN-LAST:event_JTFmatriculaKeyTyped

    private void JTFmarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFmarcaKeyTyped
        habilitarGuardar();
    }//GEN-LAST:event_JTFmarcaKeyTyped

    private void JTFmodeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFmodeloKeyTyped
        habilitarGuardar();
    }//GEN-LAST:event_JTFmodeloKeyTyped

    private void JTFchoferKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFchoferKeyTyped
        habilitarGuardar();
    }//GEN-LAST:event_JTFchoferKeyTyped

    private void JBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBguardarActionPerformed
        String matricula = JTFmatricula.getText();
        String marca = JTFmarca.getText();
        String modelo = JTFmodelo.getText();
        String chofer = JTFchofer.getText();

        Colectivo existeColectivo = null;

        try {
            existeColectivo = cd.buscarColectivoMatricula(matricula);
        } catch (SQLException ex) {
            Logger.getLogger(CargarColectivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (matricula.length() <= 0 | marca.length() <= 0 | modelo.length() <= 0 | chofer.length() <= 0) {
            JOptionPane.showMessageDialog(null, "Ningun campo puede estar vacio");
            return;
        }

        if (existeColectivo != null) {
            JOptionPane.showMessageDialog(null, "La matricula ya existe en la base de datos");
            return;
        }

        if (!marca.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) { //Verficacion de marca. Funcion que fue investigada, permite que solo acepte letras de la a-z, "Ñ" y tildes.
            JOptionPane.showMessageDialog(null, "Marca invalida");
            return;
        }

        if (!chofer.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) { //Verficacion de chofer. Funcion que fue investigada, permite que solo acepte letras de la a-z, "Ñ" y tildes.
            JOptionPane.showMessageDialog(null, "Nombre de chofer invalido");
            return;
        }

        Colectivo colectivoNuevo = new Colectivo(matricula, marca, modelo, 46, chofer, true);

        try {
            if (cd.insertar(colectivoNuevo)) {

                modeloC.addRow(new Object[]{
                    colectivoNuevo.getIdColectivo(),
                    colectivoNuevo.getMatricula(),
                    colectivoNuevo.getMarca(),
                    colectivoNuevo.getModelo(),
                    colectivoNuevo.getCapacidad(),
                    colectivoNuevo.getChofer(),
                    colectivoNuevo.isEstado()
                });

                JOptionPane.showMessageDialog(null, "Colectivo cargado correctamente");

            }
        } catch (SQLException ex) {
            Logger.getLogger(CargarColectivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargarColectivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JBguardarActionPerformed

    private void JBborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBborrarActionPerformed
        int filaS = JTcolectivos.getSelectedRow(); //Traer la fila que estoy seleccionando.
        if (filaS != -1) {
            int id = (int) JTcolectivos.getValueAt(filaS, 0);
            try {
                if (cd.borrar(id)) {
                    // borra el cole de la tabla
                    modeloC.removeRow(filaS);
                    JOptionPane.showMessageDialog(this,
                            "El colectivo ha sido borrado con exito");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CargarColectivo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CargarColectivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un colectivo");
        }
    }//GEN-LAST:event_JBborrarActionPerformed

    private void JBactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBactualizarActionPerformed
        int filaS = JTcolectivos.getSelectedRow(); //Traer la fila que estoy seleccionando.
        if (filaS != -1) {
            int id = (int) JTcolectivos.getValueAt(filaS, 0);
            try {
                if (cd.borrar(id)) {
                    // Actualiza el estado en la tabla
                    modeloC.setValueAt(false, filaS, 6);

                    JOptionPane.showMessageDialog(this,
                            "El colectivo ha sido borrado con exito");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CargarColectivo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CargarColectivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_JBactualizarActionPerformed

    private void JBlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBlimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_JBlimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBactualizar;
    private javax.swing.JButton JBalta;
    private javax.swing.JButton JBbaja;
    private javax.swing.JButton JBborrar;
    private javax.swing.JButton JBguardar;
    private javax.swing.JButton JBlimpiar;
    private javax.swing.JLabel JLbuscar;
    private javax.swing.JLabel JLcargarColectivo;
    private javax.swing.JLabel JLchofer;
    private javax.swing.JLabel JLmarca;
    private javax.swing.JLabel JLmatricula;
    private javax.swing.JLabel JLmodelo;
    private javax.swing.JPanel JPdatos;
    private javax.swing.JPanel JPfiltrado;
    private javax.swing.JScrollPane JSPcolectivos;
    private javax.swing.JTextField JTFchofer;
    private javax.swing.JTextField JTFfiltrar;
    private javax.swing.JTextField JTFmarca;
    private javax.swing.JTextField JTFmatricula;
    private javax.swing.JTextField JTFmodelo;
    private javax.swing.JTable JTcolectivos;
    // End of variables declaration//GEN-END:variables

    /**
     * Agrega las cabeceras a la tabla con sus respectivos nombres.
     */
    private void cargarCabecera() {
        modeloC.addColumn("idColectivo");
        modeloC.addColumn("Matricula");
        modeloC.addColumn("Marca");
        modeloC.addColumn("Modelo");
        modeloC.addColumn("Capacidad");
        modeloC.addColumn("Chofer");
        modeloC.addColumn("Estado");

        JTcolectivos.setModel(modeloC);
    }

    private void habilitarGuardar() {
        JBguardar.setEnabled(true);
    }

    private void cargarColectivos() {
        modeloC.setRowCount(0); // reseteo filas

        try {
            for (Colectivo c : cd.listarColectivos()) {
                modeloC.addRow(new Object[]{
                    c.getIdColectivo(),
                    c.getMatricula(),
                    c.getMarca(),
                    c.getModelo(),
                    c.getCapacidad(),
                    c.getChofer(),
                    c.isEstado()
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargarColectivo.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    private void limpiar() {
        JTFmatricula.setText("");
        JTFmarca.setText("");
        JTFmodelo.setText("");
        JTFchofer.setText("");
    }
}
