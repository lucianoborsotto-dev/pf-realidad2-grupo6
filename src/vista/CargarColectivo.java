package vista;

import javax.swing.table.DefaultTableModel;

public class CargarColectivo extends javax.swing.JInternalFrame {
    //Crea el modelo por default de la tabla y sobrescribe el metodo de la clase para hacer que las celdas no sean editabes.
    private DefaultTableModel modeloC = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    public CargarColectivo() {
        initComponents();
        UtilidadesGenerales.ocultarMenu(this);
        cargarCabecera();
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
        JPfiltrado.setEnabled(false);

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
        //        int filaS = JTalumnos.getSelectedRow(); //Traer la fila que estoy seleccionando.
        //        if (filaS != -1) {
            //            int id = (int) JTalumnos.getValueAt(filaS, 0);
            //            boolean estado = (boolean) JTalumnos.getValueAt(filaS, 4);
            //            if (estado) {
                //                JOptionPane.showMessageDialog(this, "No puede dar de alta a un alumno que ya lo esta! :b", "ERROR", JOptionPane.ERROR_MESSAGE);
                //            } else {
                //                ad.altaBajaLogica(id, true);
                //                for (Alumno a : allAlumnos) { //Recorre el ArrayList para verificar si el alumno esta dado de baja o alta.
                    //                    if (a.getIdAlumno() == id) {
                        //                        a.setActivo(true);
                        //                        modelo.setValueAt(true, filaS, 4);
                        //                        JCactivo.setSelected(true);
                        //                        break;
                        //                    }
                    //                }
                //                JOptionPane.showMessageDialog(this, "El alumno ha sido dado de alta con exito!");
                //            }
            //        } else {
            //            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila", "ERROR", JOptionPane.ERROR_MESSAGE);
            //        }
    }//GEN-LAST:event_JBaltaActionPerformed

    private void JBbajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBbajaActionPerformed
        //        int filaS = JTalumnos.getSelectedRow();
        //        if (filaS != -1) { //Solo entra si hay una fila seleccionada.
            //            int id = (int) JTalumnos.getValueAt(filaS, 0);
            //            boolean estado = (boolean) JTalumnos.getValueAt(filaS, 4);
            //            if (estado) {
                //                ad.altaBajaLogica(id, false);
                //                for (Alumno a : allAlumnos) { //Recorre el ArrayList para verificar si el alumno esta dado de baja o alta.
                    //                    if (a.getIdAlumno() == id) {
                        //                        a.setActivo(false);
                        //                        modelo.setValueAt(false, filaS, 4);
                        //                        JCactivo.setSelected(false);
                        //                        break;
                        //                    }
                    //                }
                //                try {
                    //                    //Permite que si se da de baja un alumno, se va a eliminar la cursada que contenga el id del alumno dado de baja.
                    //                    Menu.cd.borrarInscripcion(id);
                    //                } catch (SQLException ex) {
                    //                    JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
                    //                } catch (ClassNotFoundException ex) {
                    //                    JOptionPane.showMessageDialog(null, "Error al cargar los drivers", "ERROR", JOptionPane.ERROR_MESSAGE);
                    //                }
                //                JOptionPane.showMessageDialog(this, "El alumno ha sido dado de baja con exito!");
                //            } else {
                //                JOptionPane.showMessageDialog(this, "No puede dar de baja a un alumno que ya lo esta! :b", "ERROR", JOptionPane.ERROR_MESSAGE);
                //            }
            //        } else {
            //            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila", "ERROR", JOptionPane.ERROR_MESSAGE);
            //        }
    }//GEN-LAST:event_JBbajaActionPerformed

    private void JTcolectivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTcolectivosMouseClicked
//        int filaS = JTcolectivos.getSelectedRow();
//        if (filaS != -1) {
//            String dni = (String) JTcolectivos.getValueAt(filaS, 1);
//            String nombre = (String) JTcolectivos.getValueAt(filaS, 2);
//            String apellido = (String) JTcolectivos.getValueAt(filaS, 3);
//            String correo = (String) JTcolectivos.getValueAt(filaS, 4);
//            String telefono = (String) JTcolectivos.getValueAt(filaS, 5);
//
//            JTFmodelo.setText(dni);
//            JTFmatricula.setText(nombre);
//            JTFmarca.setText(apellido);
//            JTFcapacidad.setText(correo);
//            JTFchofer.setText(telefono);
//        }
//
//        JBborrar.setEnabled(true);
//        JBactualizar.setEnabled(true);
    }//GEN-LAST:event_JTcolectivosMouseClicked

    private void JTFfiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFfiltrarKeyReleased
//        borrarFilas();
//        for (Pasajero p : allPasajeros) {
//            String dni = p.getDni();
//            if (dni.startsWith(JTFfiltrar.getText())) {
//                modeloP.addRow(new Object[]{p.getIdPasajero(), p.getDni(), p.getNombre(), p.getApellido(), p.getCorreo(), p.getTelefono(), p.isEstado()});
//            }
//        }
    }//GEN-LAST:event_JTFfiltrarKeyReleased

    private void JTFmatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFmatriculaKeyTyped
//        habilitarGuardar();
    }//GEN-LAST:event_JTFmatriculaKeyTyped

    private void JTFmarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFmarcaKeyTyped
//        habilitarGuardar();
    }//GEN-LAST:event_JTFmarcaKeyTyped

    private void JTFmodeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFmodeloKeyTyped
//        habilitarGuardar();
    }//GEN-LAST:event_JTFmodeloKeyTyped

    private void JTFchoferKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFchoferKeyTyped
//        habilitarGuardar();
    }//GEN-LAST:event_JTFchoferKeyTyped

    private void JBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBguardarActionPerformed
//        try {
//            //Variables para almacenar los datos extraidos.
//            String dni = JTFmodelo.getText().trim();
//            String nombre = JTFmatricula.getText().trim();
//            String apellido = JTFmarca.getText().trim();
//            String correo = JTFcapacidad.getText().trim();
//            String telefono = JTFchofer.getText().trim();
//
//            //Varibales para la verificacion de datos.
//            Pasajero p;
//            int longitudDni = dni.length();
//            boolean triggerDni = true;
//            boolean triggerCorreo = true;
//            boolean triggerPhone = true;
//
//            //Verificacion de datos.
//            if (longitudDni == 7 || longitudDni == 8) { //Verficacion de DNI (cantidad de digitos).
//                int dniNumber = Integer.parseInt(dni); //Se pasa a un int para verficar que solo haya numeros, si hay letras larga una excepcion al momento de convertir.
//                for (Pasajero pasaDni : allPasajeros) { //Recorre el Arraylist para verficacion de DNI repetido.
//                    if (pasaDni.getDni().equals(dni)) {
//                        triggerDni = false;
//                        break;
//                    }
//                }
//                if (triggerDni) { //Verficacion de DNI repetido.
//                    if (nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) { //Verficacion de nombre. Funcion que fue investigada, permite que solo acepte letras de la a-z, "Ñ" y tildes.
//                        if (nombre.length() <= 100) { //Verificacion para que el nombre no supere los 100 caracteres admitidos por la base de datos.
//                            if (apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) { //Verificación de apellido con solo letras
//                                if (apellido.length() <= 100) { // Verificación de apellido con menos de 100 dígitos
//                                    if (correo.matches("[^\\s@]+@[^\\s@]+\\.[^\\s@]+")) { // Validación para correo con formato ejemplo@ejemplo.com
//                                        for (Pasajero pasaCorreo : allPasajeros) {
//                                            if (pasaCorreo.getCorreo().equalsIgnoreCase(correo)) {
//                                                triggerCorreo = false;
//                                                break;
//                                            }
//                                        }
//                                        if (triggerCorreo) {
//                                            if (telefono.matches("\\d{7,15}")) { // Validación que permite solo números de 7 a 15 dígitos, evita letras, simbolos...
//                                                for (Pasajero pasaPhone : allPasajeros) {
//                                                    if (pasaPhone.getTelefono().equalsIgnoreCase(telefono)) {
//                                                        triggerPhone = false;
//                                                        break;
//                                                    }
//                                                }
//                                                if (triggerPhone) {
//                                                    p = new Pasajero(dni, nombre, apellido, correo, telefono, true);
//                                                    pd.insertar(p);
//                                                    allPasajeros.add(p);
//                                                    limpiar();
//                                                    mostrarLista(); //Muestra la lista para corroborar que se actualizo el ArrayList.
//                                                    JOptionPane.showMessageDialog(this, "Pasajero guardado!");
//                                                }else{
//                                                    JOptionPane.showMessageDialog(this, "El numero de telefono ya se encuentra registrado", "ERROR", JOptionPane.ERROR_MESSAGE);
//                                                }
//                                            } else {
//                                                JOptionPane.showMessageDialog(this, "Solo se permite números, sin espacios de 7 a 15 dígitos", "ERROR", JOptionPane.ERROR_MESSAGE);
//                                            }
//                                        } else {
//                                            JOptionPane.showMessageDialog(this, "La direccion de correo ya se encuentra registrada", "ERROR", JOptionPane.ERROR_MESSAGE);
//                                        }
//                                    } else {
//                                        JOptionPane.showMessageDialog(this, "Formato inválido de correo", "ERROR", JOptionPane.ERROR_MESSAGE);
//                                    }
//                                } else {
//                                    JOptionPane.showMessageDialog(this, "El apellido debe contener máximo 100 caracteres", "ERROR", JOptionPane.ERROR_MESSAGE);
//                                }
//
//                            } else {
//                                JOptionPane.showMessageDialog(this, "Apellido inválido", "ERROR", JOptionPane.ERROR_MESSAGE);
//                            }
//                        } else {
//                            JOptionPane.showMessageDialog(this, "El nombre debe contener maximo 100 caracteres", "ERROR", JOptionPane.ERROR_MESSAGE);
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(this, "Nombre invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(this, "Este DNI ya se encuentra registrado", "ERROR", JOptionPane.ERROR_MESSAGE);
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "DNI invalido, debe contener una combinacion de 7-8 numeros.", "ERROR", JOptionPane.ERROR_MESSAGE);
//            }
//        } catch (NumberFormatException nf) {
//            JOptionPane.showMessageDialog(this, "Solo se permiten dígitos sin espacios y puntos para el documento.", "ERROR", JOptionPane.ERROR_MESSAGE);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
//        } catch (ClassNotFoundException ex) {
//            JOptionPane.showMessageDialog(this, "Error al cargar los drivers", "ERROR", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_JBguardarActionPerformed

    private void JBborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBborrarActionPerformed
        //        Iterator<Alumno> it = allAlumnos.iterator(); //Se crea para borrar tambien al alumno del ArrayList.
        //        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea eliminar al alumno?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        //        int filaS = JTalumnos.getSelectedRow(); //Obtiene el indice de la fila que el usuario selecciono en la tabla.
        //        if (filaS != -1) {
            //
            //            int id = (int) JTalumnos.getValueAt(filaS, 0); //Obtiene el valor que se encuentra en esa fila justo en esa columna.
            //            if (respuesta == JOptionPane.YES_OPTION) { //Si la respuesta fue "Si".
                //                while (it.hasNext()) {
                    //                    if (it.next().getIdAlumno() == id) { //Se fija que el valor del idAlumno coincide con el valor extraido de esa fila seleccionada en la columna idAlumno.
                        //                        it.remove(); //Si coincide lo elimina.
                        //                        break;
                        //                    }
                    //                }
                //
                //                try {
                    //                    //Permite que si se borra el alumno, tambien se va a eliminar la cursada que contenga el id del alumno eliminado.
                    //                    Menu.cd.borrarInscripcion(id);
                    //                } catch (SQLException ex) {
                    //                    JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
                    //                } catch (ClassNotFoundException ex) {
                    //                    JOptionPane.showMessageDialog(null, "Error al cargar los drivers", "ERROR", JOptionPane.ERROR_MESSAGE);
                    //                }
                //
                //                ad.borrarAlumno(id); //Ejecuta el metodo de AlumnoData para borrar al alumno de la base de datos.
                //                modelo.removeRow(filaS); //Elimina al alumno seleccionado de la tabla.
                //                limpiar(); //Limpia todo al terminar.
                //                mostrarLista(); //Muestra la lista para corroborar que se actualizo el ArrayList.
                //                JOptionPane.showMessageDialog(this, "Alumno eliminado!");
                //            }
            //        } else {
            //            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila", "ERROR", JOptionPane.ERROR_MESSAGE);
            //        }
    }//GEN-LAST:event_JBborrarActionPerformed

    private void JBactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBactualizarActionPerformed
        //        try {
            //            //Variables para almacenar los datos extraidos.
            //            String dniTexto = JTFdni.getText().trim();
            //            String nombre = JTFnombre.getText().trim();
            //            LocalDate fechaNacimiento = JDCfechaNac.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            //            boolean activo = JCactivo.isSelected();
            //            Alumno a;
            //
            //            //Varibales para la verificacion de datos.
            //            int longitudDni = dniTexto.length();
            //            boolean disparador = true;
            //            LocalDate fechaActual = LocalDate.now();
            //            LocalDate fechaMaxima = fechaActual.minusYears(16);
            //            int filaS = JTalumnos.getSelectedRow();
            //
            //            //Verificacion de datos.
            //            if (filaS != -1) { //Todo funcionara si hay una fila seleccionada.
                //                int id = (int) JTalumnos.getValueAt(filaS, 0);
                //                if (longitudDni == 7 || longitudDni == 8) { //Verficacion de DNI (cantidad de digitos).
                    //                    int dni = Integer.parseInt(dniTexto);
                    //                    for (Alumno alu : allAlumnos) { //Recorre el Arraylist para verficacion de DNI repetido, evita el DNI del alumno seleccionado.
                        //                        if (alu.getIdAlumno() == id) {
                            //                            continue;
                            //                        }
                        //                        if (alu.getDni() == dni) {
                            //                            disparador = false;
                            //                            break;
                            //                        }
                        //                    }
                    //                    if (disparador) { //Verficacion de DNI repetido.
                        //                        if (nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$")) { //Verficacion de nombre. Funcion que fue investigada, permite que solo acepte letras de la a-z, "Ñ" y tildes (no acepta espacios).
                            //                            if (nombre.length() <= 20) { //Verificacion para que el nombre no supere los 20 caracteres admitidos por la base de datos.
                                //                                if (fechaNacimiento.isBefore(fechaMaxima) || fechaNacimiento.isEqual(fechaMaxima)) { //Verificacion de fecha de nacimiento.
                                    //                                    a = new Alumno(dni, nombre, fechaNacimiento, activo);
                                    //                                    a.setIdAlumno(id);
                                    //                                    for (Alumno act : allAlumnos) { //Actualizacion del alumno en el ArrayList para actualizar la tabla.
                                        //                                        if (act.getIdAlumno() == id) {
                                            //                                            if (act.getDni() != dni) {
                                                //                                                act.setDni(dni);
                                                //                                                modelo.setValueAt(dni, filaS, 1);
                                                //                                            }
                                            //                                            if (!act.getNombre().equals(nombre)) {
                                                //                                                act.setNombre(nombre);
                                                //                                                modelo.setValueAt(nombre, filaS, 2);
                                                //                                            }
                                            //                                            if (!act.getFechaNac().equals(fechaNacimiento)) {
                                                //                                                act.setFechaNac(fechaNacimiento);
                                                //                                                modelo.setValueAt(fechaNacimiento, filaS, 3);
                                                //                                            }
                                            //                                            break;
                                            //                                        }
                                        //                                    }
                                    //                                    ad.actualizarAlumno(a);
                                    //                                    limpiar();
                                    //                                    mostrarLista(); //Muestra la lista para corroborar que se actualizo el ArrayList.
                                    //                                    JOptionPane.showMessageDialog(this, "Alumno actualizado!");
                                    //                                } else {
                                    //                                    JOptionPane.showMessageDialog(this, "Fecha no admitida", "ERROR", JOptionPane.ERROR_MESSAGE);
                                    //                                }
                                //                            }else{
                                //                                JOptionPane.showMessageDialog(this, "El nombre debe contener maximo 20 caracteres", "ERROR", JOptionPane.ERROR_MESSAGE);
                                //                            }
                            //                        } else {
                            //                            JOptionPane.showMessageDialog(this, "Nombre invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
                            //                        }
                        //                    } else {
                        //                        JOptionPane.showMessageDialog(this, "Este DNI ya se encuentra registrado", "ERROR", JOptionPane.ERROR_MESSAGE);
                        //                    }
                    //                } else {
                    //                    JOptionPane.showMessageDialog(this, "DNI invalido, debe contener una combinacion de 7-8 numeros,\nse aceptan solo numeros, sin puntos y espacios", "ERROR", JOptionPane.ERROR_MESSAGE);
                    //                }
                //            } else {
                //                JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para actualizar", "ERROR", JOptionPane.ERROR_MESSAGE);
                //            }
            //        } catch (NumberFormatException nf) {
            //            JOptionPane.showMessageDialog(this, "Datos incompletos/incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
            //        } catch (NullPointerException np) {
            //            JOptionPane.showMessageDialog(this, "Fecha invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
            //        }
    }//GEN-LAST:event_JBactualizarActionPerformed

    private void JBlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBlimpiarActionPerformed
//        limpiar();
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
}
