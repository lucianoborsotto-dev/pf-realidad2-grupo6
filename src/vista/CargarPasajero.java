package vista;

import java.awt.Image;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Pasajero;
import persistencia.PasajeroDAO;

public class CargarPasajero extends javax.swing.JInternalFrame {
    //Crea el modelo por default de la tabla y sobrescribe el metodo de la clase para hacer que las celdas no sean editabes.
    private DefaultTableModel modeloP = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    
    //Creacion de un objeto PasajeroDAO y el ArrayList donde estaran todos los pasajeros traidos de la base de datos.
    PasajeroDAO pd;
    List<Pasajero> allPasajeros;

    public CargarPasajero() {
        initComponents();
        UtilidadesGenerales.ocultarMenu(this);
        cargarCabecera();
        
        try {
            pd = new PasajeroDAO();
            allPasajeros = pd.listar();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar los drivers", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        cargarDatos();
        
        //Redimensionar iconos con el metodo.
        JBborrar.setIcon(redimensionIcon("/Imagen/eliminar.png", 30, 30));
        JBguardar.setIcon(redimensionIcon("/Imagen/guardar.png", 40, 40));
        JBactualizar.setIcon(redimensionIcon("/Imagen/actualizar.png", 30, 30));
        JBlimpiar.setIcon(redimensionIcon("/Imagen/limpiar.png", 30, 30));
        JBalta.setIcon(redimensionIcon("/Imagen/check.png", 25, 25));
        JBbaja.setIcon(redimensionIcon("/Imagen/cruz.png", 25, 25));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLcargarPasajero = new javax.swing.JLabel();
        JPfiltrado = new javax.swing.JPanel();
        JLbuscar = new javax.swing.JLabel();
        JTFfiltrar = new javax.swing.JTextField();
        JPdatos = new javax.swing.JPanel();
        JLapellido = new javax.swing.JLabel();
        JLemail = new javax.swing.JLabel();
        JLtelefono = new javax.swing.JLabel();
        JTFnombre = new javax.swing.JTextField();
        JTFapellido = new javax.swing.JTextField();
        JTFdni = new javax.swing.JTextField();
        JTFemail = new javax.swing.JTextField();
        JTFphone = new javax.swing.JTextField();
        JLnombre = new javax.swing.JLabel();
        JLdni = new javax.swing.JLabel();
        JBguardar = new javax.swing.JButton();
        JBborrar = new javax.swing.JButton();
        JBactualizar = new javax.swing.JButton();
        JBlimpiar = new javax.swing.JButton();
        JBalta = new javax.swing.JButton();
        JBbaja = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTpasajero = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cargar Pasajero");

        JLcargarPasajero.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        JLcargarPasajero.setText("Cargar Pasajero");

        JPfiltrado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLbuscar.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        JLbuscar.setText("BUSCAR PASAJERO:       DNI");

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
                .addContainerGap(20, Short.MAX_VALUE))
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

        JLapellido.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        JLapellido.setText("APELLIDO:");

        JLemail.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        JLemail.setText("EMAIL:");

        JLtelefono.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        JLtelefono.setText("TELEFONO:");

        JLnombre.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        JLnombre.setText("NOMBRE:");

        JLdni.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N
        JLdni.setText("DNI:");

        javax.swing.GroupLayout JPdatosLayout = new javax.swing.GroupLayout(JPdatos);
        JPdatos.setLayout(JPdatosLayout);
        JPdatosLayout.setHorizontalGroup(
            JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPdatosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JPdatosLayout.createSequentialGroup()
                        .addComponent(JLtelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFphone))
                    .addGroup(JPdatosLayout.createSequentialGroup()
                        .addComponent(JLdni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFdni, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPdatosLayout.createSequentialGroup()
                        .addComponent(JLnombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addGroup(JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JPdatosLayout.createSequentialGroup()
                        .addComponent(JLemail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFemail))
                    .addGroup(JPdatosLayout.createSequentialGroup()
                        .addComponent(JLapellido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        JPdatosLayout.setVerticalGroup(
            JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPdatosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLnombre)
                    .addComponent(JLapellido)
                    .addComponent(JTFnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLdni)
                    .addComponent(JLemail)
                    .addComponent(JTFdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLtelefono)
                    .addComponent(JTFphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        JTpasajero.setModel(new javax.swing.table.DefaultTableModel(
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
        JTpasajero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTpasajeroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTpasajero);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(JLcargarPasajero))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(JPfiltrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(JLcargarPasajero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JPfiltrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBguardarActionPerformed
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
//
//            //Verificacion de datos.
//            if (longitudDni == 7 || longitudDni == 8) { //Verficacion de DNI (cantidad de digitos).
//                int dni = Integer.parseInt(dniTexto);
//                for (Alumno alu : allAlumnos) { //Recorre el Arraylist para verficacion de DNI repetido.
//                    if (alu.getDni() == dni) {
//                        disparador = false;
//                        break;
//                    }
//                }
//                if (disparador) { //Verficacion de DNI repetido.
//                    if (nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$")) { //Verficacion de nombre. Funcion que fue investigada, permite que solo acepte letras de la a-z, "Ñ" y tildes (no acepta espacios).
//                        if (nombre.length() <= 20) { //Verificacion para que el nombre no supere los 20 caracteres admitidos por la base de datos.
//                            if (fechaNacimiento.isBefore(fechaMaxima) || fechaNacimiento.isEqual(fechaMaxima)) { //Verificacion de fecha de nacimiento.
//                                a = new Alumno(dni, nombre, fechaNacimiento, activo);
//                                ad.guardarAlumno(a);
//                                allAlumnos.add(a);
//                                limpiar();
//                                mostrarLista(); //Muestra la lista para corroborar que se actualizo el ArrayList.
//                                JOptionPane.showMessageDialog(this, "Alumno guardado!");
//                            } else {
//                                JOptionPane.showMessageDialog(this, "Fecha no admitida", "ERROR", JOptionPane.ERROR_MESSAGE);
//                            }
//                        }else{
//                            JOptionPane.showMessageDialog(this, "El nombre debe contener maximo 20 caracteres", "ERROR", JOptionPane.ERROR_MESSAGE);
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(this, "Nombre invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(this, "Este DNI ya se encuentra registrado", "ERROR", JOptionPane.ERROR_MESSAGE);
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "DNI invalido, debe contener una combinacion de 7-8 numeros,\nse aceptan solo numeros, sin puntos y espacios", "ERROR", JOptionPane.ERROR_MESSAGE);
//            }
//        } catch (NumberFormatException nf) {
//            JOptionPane.showMessageDialog(this, "Datos incompletos/incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
//        } catch (NullPointerException np) {
//            JOptionPane.showMessageDialog(this, "Fecha invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
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
        limpiar();
    }//GEN-LAST:event_JBlimpiarActionPerformed

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

    private void JTpasajeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTpasajeroMouseClicked
        int filaS = JTpasajero.getSelectedRow();
        if (filaS != -1) {
            String dni = (String) JTpasajero.getValueAt(filaS, 1);
            String nombre = (String) JTpasajero.getValueAt(filaS, 2);
            String apellido = (String) JTpasajero.getValueAt(filaS, 3);
            String correo = (String) JTpasajero.getValueAt(filaS, 4);
            String telefono = (String) JTpasajero.getValueAt(filaS, 5);

            JTFdni.setText(dni);
            JTFnombre.setText(nombre);
            JTFapellido.setText(apellido);
            JTFemail.setText(correo);
            JTFphone.setText(telefono);
        }

        JBborrar.setEnabled(true);
        JBactualizar.setEnabled(true);
    }//GEN-LAST:event_JTpasajeroMouseClicked

    private void JTFfiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFfiltrarKeyReleased
        borrarFilas();
        for (Pasajero p : allPasajeros) {
            String dni = p.getDni();
            if (dni.startsWith(JTFfiltrar.getText())) {
                modeloP.addRow(new Object[]{p.getIdPasajero(), p.getDni(), p.getNombre(), p.getApellido(), p.getCorreo(), p.getTelefono(), p.isEstado()});
            }
        }
    }//GEN-LAST:event_JTFfiltrarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBactualizar;
    private javax.swing.JButton JBalta;
    private javax.swing.JButton JBbaja;
    private javax.swing.JButton JBborrar;
    private javax.swing.JButton JBguardar;
    private javax.swing.JButton JBlimpiar;
    private javax.swing.JLabel JLapellido;
    private javax.swing.JLabel JLbuscar;
    private javax.swing.JLabel JLcargarPasajero;
    private javax.swing.JLabel JLdni;
    private javax.swing.JLabel JLemail;
    private javax.swing.JLabel JLnombre;
    private javax.swing.JLabel JLtelefono;
    private javax.swing.JPanel JPdatos;
    private javax.swing.JPanel JPfiltrado;
    private javax.swing.JTextField JTFapellido;
    private javax.swing.JTextField JTFdni;
    private javax.swing.JTextField JTFemail;
    private javax.swing.JTextField JTFfiltrar;
    private javax.swing.JTextField JTFnombre;
    private javax.swing.JTextField JTFphone;
    private javax.swing.JTable JTpasajero;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Permite redimensionar a gusto las imagenes.
     *
     * @param ruta
     * @param ancho
     * @param alto
     * @return
     */
    private ImageIcon redimensionIcon(String ruta, int ancho, int alto) {
        ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
        Image imagen = icono.getImage();
        Image imagenRedimensionada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);

        return new ImageIcon(imagenRedimensionada);
    }
    
    /**
     * Agrega las cabeceras a la tabla con sus respectivos nombres.
     */
    private void cargarCabecera() {
        modeloP.addColumn("idPasajero");
        modeloP.addColumn("Dni");
        modeloP.addColumn("Nombre");
        modeloP.addColumn("Apellido");
        modeloP.addColumn("Correo");
        modeloP.addColumn("Telefono");
        modeloP.addColumn("Estado");

        JTpasajero.setModel(modeloP);
    }
    
    /**
     * Carga los alumnos a la tabla.
     */
    private void cargarDatos() {
        for (Pasajero p : allPasajeros) {
            modeloP.addRow(new Object[]{p.getIdPasajero(), p.getDni(), p.getNombre(), p.getApellido(), p.getCorreo(), p.getTelefono(), p.isEstado()});
        }
    }
    
    /**
     * Permite borrar las filas mientras se encribe en los campos de filtrar.
     */
    private void borrarFilas() {
        int filas = JTpasajero.getRowCount() - 1;
        for (int f = filas; f >= 0; f--) {
            modeloP.removeRow(f);
        }
    }
    
    /**
     * Vacia/restablece todos los campos.
     */
    private void limpiar() {
        JTFdni.setText("");
        JTFnombre.setText("");
        JTFapellido.setText("");
        JTFemail.setText("");
        JTFphone.setText("");
        JTFfiltrar.setText("");
        modeloP.setRowCount(0);
        cargarDatos();
        JBguardar.setEnabled(false);
        JBborrar.setEnabled(false);
        JBactualizar.setEnabled(false);
    }
}
