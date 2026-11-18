package vista;

import java.awt.Image;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Colectivo;
import modelo.RutaViaje;
import persistencia.ColectivoDAO;
import persistencia.LugarDAO;
import persistencia.PasajeDAO;
import persistencia.RutaViajeDAO;

public class CargarViaje extends javax.swing.JInternalFrame {

    //Crea el modelo por default de la tabla y sobrescribe el metodo de la clase para hacer que las celdas no sean editabes.
    private DefaultTableModel modeloV = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    RutaViajeDAO rvd;
    ColectivoDAO cd;
    PasajeDAO pd;
    LugarDAO ld;
    List<Colectivo> allColectivos;
    List<RutaViaje> allViajes;

    public CargarViaje() {
        initComponents();
        UtilidadesGenerales.ocultarMenu(this);
        cargarCabecera();

        try {
            rvd = new RutaViajeDAO();
            cd = new ColectivoDAO();
            pd = new PasajeDAO();
            ld = new LugarDAO();
            allViajes = rvd.listarRutas();
            allColectivos = cd.listarColectivosT();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al establecer la conexion con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar los drivers", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        cargarDatos();
        cargarComboBox();
        JCBcole.setSelectedIndex(-1);

        TPsalida.addTimeChangeListener(event -> habilitarGuardar());
        TPllegada.addTimeChangeListener(event -> habilitarGuardar());
        mostrarLista();

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

        JPdatos = new javax.swing.JPanel();
        JLmarca = new javax.swing.JLabel();
        JLcapacidad = new javax.swing.JLabel();
        JLchofer = new javax.swing.JLabel();
        JTForigen = new javax.swing.JTextField();
        JTFdestino = new javax.swing.JTextField();
        JLmatricula = new javax.swing.JLabel();
        JLmodelo = new javax.swing.JLabel();
        JCBcole = new javax.swing.JComboBox<>();
        JLcapacidad1 = new javax.swing.JLabel();
        JTFprecio = new javax.swing.JTextField();
        TPsalida = new com.github.lgooddatepicker.components.TimePicker();
        TPllegada = new com.github.lgooddatepicker.components.TimePicker();
        JBguardar = new javax.swing.JButton();
        JBborrar = new javax.swing.JButton();
        JBactualizar = new javax.swing.JButton();
        JBalta = new javax.swing.JButton();
        JBbaja = new javax.swing.JButton();
        JBlimpiar = new javax.swing.JButton();
        JSPcolectivos = new javax.swing.JScrollPane();
        JTviajes = new javax.swing.JTable();
        JLcargarViaje = new javax.swing.JLabel();
        JPfiltrado = new javax.swing.JPanel();
        JLbuscar = new javax.swing.JLabel();
        JTFfiltrar = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

        JLmarca.setText("DESTINO:");
        JLmarca.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N

        JLcapacidad.setText("HORA DE LLEGADA:");
        JLcapacidad.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N

        JLchofer.setText("COLECTIVO:");
        JLchofer.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N

        JTForigen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTForigenKeyReleased(evt);
            }
        });

        JTFdestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFdestinoKeyReleased(evt);
            }
        });

        JLmatricula.setText("ORIGEN:");
        JLmatricula.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N

        JLmodelo.setText("HORA DE SALIDA:");
        JLmodelo.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N

        JCBcole.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBcoleItemStateChanged(evt);
            }
        });

        JLcapacidad1.setText("PRECIO:");
        JLcapacidad1.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N

        JTFprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTFprecioKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout JPdatosLayout = new javax.swing.GroupLayout(JPdatos);
        JPdatos.setLayout(JPdatosLayout);
        JPdatosLayout.setHorizontalGroup(
            JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPdatosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPdatosLayout.createSequentialGroup()
                        .addComponent(JLchofer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCBcole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPdatosLayout.createSequentialGroup()
                        .addComponent(JLmodelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TPsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPdatosLayout.createSequentialGroup()
                        .addComponent(JLmatricula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTForigen, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81)
                .addGroup(JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(JPdatosLayout.createSequentialGroup()
                            .addComponent(JLmarca)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(JTFdestino, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(JPdatosLayout.createSequentialGroup()
                            .addComponent(JLcapacidad)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TPllegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(JPdatosLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(JLcapacidad1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFprecio)))
                .addContainerGap())
        );
        JPdatosLayout.setVerticalGroup(
            JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPdatosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLmatricula)
                    .addComponent(JLmarca)
                    .addComponent(JTForigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFdestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLmodelo)
                    .addComponent(JLcapacidad)
                    .addComponent(TPsalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TPllegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLchofer)
                    .addGroup(JPdatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JLcapacidad1)
                        .addComponent(JTFprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JCBcole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        JBguardar.setText("Guardar");
        JBguardar.setEnabled(false);
        JBguardar.setFont(new java.awt.Font("Dubai Medium", 1, 18)); // NOI18N
        JBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBguardarActionPerformed(evt);
            }
        });

        JBborrar.setText("Borrar");
        JBborrar.setEnabled(false);
        JBborrar.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        JBborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBborrarActionPerformed(evt);
            }
        });

        JBactualizar.setText("Actualizar");
        JBactualizar.setEnabled(false);
        JBactualizar.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        JBactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBactualizarActionPerformed(evt);
            }
        });

        JBalta.setText("Dar de Alta");
        JBalta.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        JBalta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBaltaActionPerformed(evt);
            }
        });

        JBbaja.setText("Dar de Baja");
        JBbaja.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        JBbaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBbajaActionPerformed(evt);
            }
        });

        JBlimpiar.setText("Limpiar");
        JBlimpiar.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        JBlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBlimpiarActionPerformed(evt);
            }
        });

        JTviajes.setModel(new javax.swing.table.DefaultTableModel(
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
        JTviajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTviajesMouseClicked(evt);
            }
        });
        JSPcolectivos.setViewportView(JTviajes);

        JLcargarViaje.setText("Cargar Viaje");
        JLcargarViaje.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N

        JPfiltrado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLbuscar.setText("BUSCAR VIAJE:       DESTINO:");
        JLbuscar.setFont(new java.awt.Font("Dubai Medium", 1, 16)); // NOI18N

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(JLcargarViaje))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(JPfiltrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JSPcolectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                    .addComponent(JBlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(JLcargarViaje)
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
                .addGap(18, 18, 18)
                .addComponent(JSPcolectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBguardarActionPerformed
        // 1. Extracción de datos
        String origen = JTForigen.getText().trim();
        String destino = JTFdestino.getText().trim();
        String precio = JTFprecio.getText().trim().replace(',', '.');
        Colectivo cole = (Colectivo) JCBcole.getSelectedItem();
        LocalTime horaS = TPsalida.getTime();
        LocalTime horaL = TPllegada.getTime();
        RutaViaje rv;

        // 2. Validaciones de formato de texto y números
        if (!origen.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+$") || origen.length() > 100) {
            JOptionPane.showMessageDialog(this, "Origen no válido o excede los 100 caracteres.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!destino.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+$") || destino.length() > 100) {
            JOptionPane.showMessageDialog(this, "Destino no válido o excede los 100 caracteres.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!precio.matches("^\\d+(\\.\\d+)?$")) {
            JOptionPane.showMessageDialog(this, "Precio inválido.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        BigDecimal precioLimpio = new BigDecimal(precio);
        if (precioLimpio.compareTo(BigDecimal.ZERO) <= 0) {
            JOptionPane.showMessageDialog(this, "El precio debe ser mayor a 0.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Validación de horario del propio viaje
        if (!horaS.isBefore(horaL)) {
            JOptionPane.showMessageDialog(this, "La hora de salida debe ser anterior a la hora de llegada.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 4. Verificaciones contra los viajes existentes del colectivo seleccionado
        RutaViaje viajeAnterior = null;

        for (RutaViaje viaje : allViajes) {
            if (viaje.getColectivo().equals(cole)) {
                LocalTime hSalidaVieja = viaje.getHoraSalida();
                LocalTime hLlegadaVieja = viaje.getHoraLlegada();

                // A) Control de solape de horarios
                // Se cruzan si el nuevo viaje empieza antes de que termine el viejo Y termina después de que empiece el viejo
                boolean seCruzan = horaS.isBefore(hLlegadaVieja) && horaL.isAfter(hSalidaVieja);
                if (seCruzan) {
                    JOptionPane.showMessageDialog(this, "Conflicto de horario: El colectivo ya tiene un viaje asignado en ese intervalo.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return; // Frena el guardado
                }

                // B) Buscar si este viaje existente es previo al nuevo que queremos cargar
                // Un viaje es previo si su hora de llegada es anterior o igual a la hora de salida del nuevo viaje
                if (hLlegadaVieja.isBefore(horaS) || hLlegadaVieja.equals(horaS)) {
                    // Guardamos el viaje previo que termine más tarde (el más cercano al nuevo viaje)
                    if (viajeAnterior == null || hLlegadaVieja.isAfter(viajeAnterior.getHoraLlegada())) {
                        viajeAnterior = viaje;
                    }
                }
            }
        }

        // 5. Validar la ubicación de salida del colectivo
        if (viajeAnterior != null) {
            // Si tiene un viaje previo, obligatoriamente debe salir desde el destino de ese viaje anterior
            if (!origen.equalsIgnoreCase(viajeAnterior.getDestino())) {
                JOptionPane.showMessageDialog(this,
                        "El colectivo se encuentra en '" + viajeAnterior.getDestino()
                        + "' (finalizó su viaje anterior a las " + viajeAnterior.getHoraLlegada()
                        + "). Debe partir desde allí.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                return; // Frena el guardado
            }
        }

        // 6. ¡Todo validado con éxito! Guardamos el viaje una sola vez
        rv = new RutaViaje(origen, destino, horaS, horaL, cole, precioLimpio, true);
        rvd.insertar(rv);
        allViajes.add(rv);
        limpiar();
        mostrarLista();
        JOptionPane.showMessageDialog(this, "¡Viaje guardado con éxito!");
    }//GEN-LAST:event_JBguardarActionPerformed

    private void JBborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBborrarActionPerformed
        Iterator<RutaViaje> it = allViajes.iterator(); //Se crea para borrar tambien al viaje del ArrayList.
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el viaje?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        int filaS = JTviajes.getSelectedRow(); //Obtiene el indice de la fila que el usuario selecciono en la tabla.
        if (filaS != -1) {
            int id = (int) JTviajes.getValueAt(filaS, 0); //Obtiene el valor que se encuentra en esa fila justo en esa columna.
            if (respuesta == JOptionPane.YES_OPTION) { //Si la respuesta fue "Si".
                while (it.hasNext()) {
                    if (it.next().getIdRuta() == id) { //Se fija que el valor del idRuta coincide con el valor extraido de esa fila seleccionada en la columna idRuta.
                        it.remove(); //Si coincide lo elimina.
                        break;
                    }
                }
                //Permite que si se borra el viaje, tambien se va a eliminar la pasaje y los lugares.
                pd.borrarPasajeV(id);
                ld.borrarLugaresV(id);

                rvd.borrarRuta(id); //Ejecuta el metodo de AlumnoData para borrar al alumno de la base de datos.
                modeloV.removeRow(filaS); //Elimina al alumno seleccionado de la tabla.
                limpiar(); //Limpia todo al terminar.
                mostrarLista(); //Muestra la lista para corroborar que se actualizo el ArrayList.
                JOptionPane.showMessageDialog(this, "Viaje eliminado!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
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

    private void JBlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBlimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_JBlimpiarActionPerformed

    private void JTviajesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTviajesMouseClicked

        int filaS = JTviajes.getSelectedRow();

        if (filaS != -1) {

            String origen = (String) JTviajes.getValueAt(filaS, 1);
            String destino = (String) JTviajes.getValueAt(filaS, 2);
            LocalTime horaS = (LocalTime) JTviajes.getValueAt(filaS, 3);
            LocalTime horaL = (LocalTime) JTviajes.getValueAt(filaS, 4);
            Colectivo cole = (Colectivo) JTviajes.getValueAt(filaS, 5);
            BigDecimal precio = (BigDecimal) JTviajes.getValueAt(filaS, 6);

            JTForigen.setText(origen);
            JTFdestino.setText(destino);
            TPsalida.setTime(horaS);
            TPllegada.setTime(horaL);

            JTFprecio.setText(precio + "");
            for (int i = 0; i < JCBcole.getItemCount(); i++) {
                if (JCBcole.getItemAt(i).getIdColectivo() == cole.getIdColectivo()) {

                    JCBcole.setSelectedIndex(i);
                    break;
                }
            }
        }

        JBborrar.setEnabled(true);
        JBactualizar.setEnabled(true);
    }//GEN-LAST:event_JTviajesMouseClicked

    private void JTFfiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFfiltrarKeyReleased
        borrarFilas();
        for (RutaViaje rv : allViajes) {
            String destino = rv.getDestino().toLowerCase();
            if (destino.startsWith(JTFfiltrar.getText().toLowerCase())) {
                modeloV.addRow(new Object[]{rv.getIdRuta(), rv.getOrigen(), rv.getDestino(), rv.getHoraSalida(), rv.getHoraLlegada(), rv.getColectivo(), rv.getPrecio(), rv.isEstado()});
            }
        }
    }//GEN-LAST:event_JTFfiltrarKeyReleased

    private void JCBcoleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBcoleItemStateChanged
        habilitarGuardar();
    }//GEN-LAST:event_JCBcoleItemStateChanged

    private void JTForigenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTForigenKeyReleased
        habilitarGuardar();
    }//GEN-LAST:event_JTForigenKeyReleased

    private void JTFdestinoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFdestinoKeyReleased
        habilitarGuardar();
    }//GEN-LAST:event_JTFdestinoKeyReleased

    private void JTFprecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFprecioKeyReleased
        habilitarGuardar();
    }//GEN-LAST:event_JTFprecioKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBactualizar;
    private javax.swing.JButton JBalta;
    private javax.swing.JButton JBbaja;
    private javax.swing.JButton JBborrar;
    private javax.swing.JButton JBguardar;
    private javax.swing.JButton JBlimpiar;
    private javax.swing.JComboBox<Colectivo> JCBcole;
    private javax.swing.JLabel JLbuscar;
    private javax.swing.JLabel JLcapacidad;
    private javax.swing.JLabel JLcapacidad1;
    private javax.swing.JLabel JLcargarViaje;
    private javax.swing.JLabel JLchofer;
    private javax.swing.JLabel JLmarca;
    private javax.swing.JLabel JLmatricula;
    private javax.swing.JLabel JLmodelo;
    private javax.swing.JPanel JPdatos;
    private javax.swing.JPanel JPfiltrado;
    private javax.swing.JScrollPane JSPcolectivos;
    private javax.swing.JTextField JTFdestino;
    private javax.swing.JTextField JTFfiltrar;
    private javax.swing.JTextField JTForigen;
    private javax.swing.JTextField JTFprecio;
    private javax.swing.JTable JTviajes;
    private com.github.lgooddatepicker.components.TimePicker TPllegada;
    private com.github.lgooddatepicker.components.TimePicker TPsalida;
    // End of variables declaration//GEN-END:variables

    /**
     * Agrega las cabeceras a la tabla con sus respectivos nombres.
     */
    private void cargarCabecera() {
        modeloV.addColumn("idViaje");
        modeloV.addColumn("Origen");
        modeloV.addColumn("Destino");
        modeloV.addColumn("Hora de salida");
        modeloV.addColumn("Hora de llegada");
        modeloV.addColumn("Colectivo");
        modeloV.addColumn("Precio");
        modeloV.addColumn("Estado");

        JTviajes.setModel(modeloV);
    }

    /**
     * Carga los viajes a la tabla.
     */
    private void cargarDatos() {
        for (RutaViaje rv : allViajes) {
            modeloV.addRow(new Object[]{rv.getIdRuta(), rv.getOrigen(), rv.getDestino(), rv.getHoraSalida(), rv.getHoraLlegada(), rv.getColectivo(), rv.getPrecio(), rv.isEstado()});
        }
    }

    /**
     * Carga los colectivos al combobox
     */
    private void cargarComboBox() {
        for (Colectivo c : allColectivos) {
            JCBcole.addItem(c);
        }

    }

    /**
     * Permite borrar las filas mientras se encribe en los campos de filtrar.
     */
    private void borrarFilas() {
        int filas = JTviajes.getRowCount() - 1;
        for (int f = filas; f >= 0; f--) {
            modeloV.removeRow(f);
        }
    }

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
     * Vacia/restablece todos los campos.
     */
    private void limpiar() {

        JTForigen.setText("");
        JTFdestino.setText("");
        TPsalida.clear();
        TPllegada.clear();
        JCBcole.setSelectedIndex(-1);
        JTFprecio.setText("");

        modeloV.setRowCount(0);
        cargarDatos();
        JBguardar.setEnabled(false);
        JBborrar.setEnabled(false);
        JBactualizar.setEnabled(false);
    }

    private void habilitarGuardar() {
        if (!JTForigen.getText().trim().isEmpty() && !JTFdestino.getText().trim().isEmpty() && !JTFprecio.getText().trim().isEmpty() && JCBcole.getSelectedIndex() != -1 && TPsalida.getTime() != null && TPllegada.getTime() != null) {
            JBguardar.setEnabled(true);
        } else {
            JBguardar.setEnabled(false);
        }
    }

    private void mostrarLista() {
        System.out.println("------------------------");
        for (RutaViaje rv : allViajes) {
            System.out.println(rv);
            System.out.println("------------------------");
        }
        System.out.println("");
        System.out.println("");
    }
}
