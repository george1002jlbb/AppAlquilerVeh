/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appalquilerveh.vehiculo;

import appalquilerveh.dao.Metodos;
import appalquilerveh.logica.Vehiculo;
import static appalquilerveh.principal.jDesktopPane;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author jbermudezb
 */
public class frmConsultarVe extends javax.swing.JInternalFrame {

    // variables para gestionar los metodos a la base de datos HUELLAS
    static Metodos logica = new Metodos();

    /**
     * Creates new form Consultar
     */
    public frmConsultarVe() {
        initComponents();
    }

    // metodo para reiniciar tabla
    public void reiniciarJTable(javax.swing.JTable Tabla) {
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        TableColumnModel modCol = Tabla.getColumnModel();
        while (modCol.getColumnCount() > 0) {
            modCol.removeColumn(modCol.getColumn(0));
        }
        txtBusqueda.setText(""); // limpar caja de texto
    }

    public String ucFirst(String str) {
        if (str.isEmpty()) {
            return str;
        } else {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboBuscar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblBusqVeh = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        btnLim = new javax.swing.JButton();
        btnCer = new javax.swing.JButton();

        setTitle("Consultar Vehiculo");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Escriba su busqueda");

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Buscar por");

        cboBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matricula", "Tipo", "Todos" }));

        jtblBusqVeh = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jtblBusqVeh.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblBusqVeh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblBusqVehMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblBusqVeh);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Resultado");

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnLim.setText("Limpiar");
        btnLim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimActionPerformed(evt);
            }
        });

        btnCer.setText("Cerrar");
        btnCer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEnviar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCer)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnLim)
                    .addComponent(btnCer))
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBusquedaKeyPressed

    private void jtblBusqVehMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblBusqVehMouseClicked
        // TODO add your handling code here:
        try {
            int seleccionfila = jtblBusqVeh.rowAtPoint(evt.getPoint()); // obtenemos la posicion
            String identificacion = String.valueOf(jtblBusqVeh.getValueAt(seleccionfila, 0));
            Vehiculo v = logica.consultarVehiculoMatricula(identificacion);

            frmVehiculo frmVehiculo = new frmVehiculo();
            frmVehiculo.txtmat.setText(v.getMatricula());

            frmVehiculo.cboti.setSelectedItem(v.getTipo());
            frmVehiculo.txtdesc.setText(v.getDescripcion());

            frmVehiculo.txtmat.setEnabled(false);
            frmVehiculo.cboti.setEnabled(false);
            frmVehiculo.btnen.setEnabled(false);
            frmVehiculo.btnModificar.setEnabled(true);

            int x = (jDesktopPane.getWidth() / 2) - frmVehiculo.getWidth() / 2;
            int y = (jDesktopPane.getHeight() / 2) - frmVehiculo.getHeight() / 2;
            frmVehiculo.setLocation(x, y);
            jDesktopPane.add(frmVehiculo);
            frmVehiculo.show();

        } catch (SQLException ex) {
            Logger.getLogger(frmVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(frmVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(frmVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtblBusqVehMouseClicked

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        List l = new LinkedList();

        String busqueda = (String) cboBuscar.getSelectedItem();
        //System.out.println("busqueda "+busqueda);
        switch (busqueda) {
            case "Matricula":
                try {
                    
                    l.clear(); // limpiamos el listado
                    l = logica.listarTodosVehiculosMatricula( txtBusqueda.getText().toUpperCase() );
                    //System.out.println("lista " + l.size());
                    DefaultTableModel modelo = new DefaultTableModel();
                    jtblBusqVeh.setModel(modelo);
                    modelo.addColumn("Matricula");
                    modelo.addColumn("Tipo");
                    modelo.addColumn("Descripcion");
                    jLabel3.setText("Resultado (" + l.size() + ")");
                    Object[] fila = null;
                    for (int i = 0; i < l.size(); i++) {
                        modelo.addRow(fila);
                        // Se crea un array que será una de las filas de la tabla.
                        Vehiculo v = (Vehiculo) l.get(i);
                        //fila[i] = l.get(i);
                        modelo.setValueAt(v.getMatricula(), i, 0);
                        modelo.setValueAt(v.getTipo(), i, 1);
                        modelo.setValueAt(v.getDescripcion(), i, 2);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmConsultarVe.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(frmConsultarVe.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(frmConsultarVe.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(frmConsultarVe.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Tipo":
                try {
                    l.clear(); // limpiamos el listado
                    l = logica.listarTodosVehiculosTipo(ucFirst(txtBusqueda.getText()) );
                    //System.out.println("lista " + l.size());
                    DefaultTableModel modelo = new DefaultTableModel();
                    jtblBusqVeh.setModel(modelo);
                    modelo.addColumn("Matricula");
                    modelo.addColumn("Tipo");
                    modelo.addColumn("Descripcion");
                    jLabel3.setText("Resultado (" + l.size() + ")");
                    Object[] fila = null;
                    for (int i = 0; i < l.size(); i++) {
                        modelo.addRow(fila);
                        // Se crea un array que será una de las filas de la tabla.
                        Vehiculo v = (Vehiculo) l.get(i);
                        //fila[i] = l.get(i);
                        modelo.setValueAt(v.getMatricula(), i, 0);
                        modelo.setValueAt(v.getTipo(), i, 1);
                        modelo.setValueAt(v.getDescripcion(), i, 2);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmConsultarVe.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(frmConsultarVe.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(frmConsultarVe.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(frmConsultarVe.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Todos":
                try {
                    l.clear(); // limpiamos el listado
                    l = logica.listarTodosVehiculos();
                    //System.out.println("lista " + l.size());
                    DefaultTableModel modelo = new DefaultTableModel();
                    jtblBusqVeh.setModel(modelo);
                    modelo.addColumn("Matricula");
                    modelo.addColumn("Tipo");
                    modelo.addColumn("Descripcion");
                    jLabel3.setText("Resultado (" + l.size() + ")");
                    Object[] fila = null;
                    for (int i = 0; i < l.size(); i++) {
                        modelo.addRow(fila);
                        // Se crea un array que será una de las filas de la tabla.
                        Vehiculo v = (Vehiculo) l.get(i);
                        //fila[i] = l.get(i);
                        modelo.setValueAt(v.getMatricula(), i, 0);
                        modelo.setValueAt(v.getTipo(), i, 1);
                        modelo.setValueAt(v.getDescripcion(), i, 2);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmConsultarVe.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(frmConsultarVe.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(frmConsultarVe.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(frmConsultarVe.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                jLabel3.setText("Resultado");
                throw new IllegalArgumentException(":: Error de aplicacion ::" + busqueda);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnLimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimActionPerformed
        // TODO add your handling code here:
        this.reiniciarJTable(jtblBusqVeh); // Limpiar tabla
        jLabel3.setText("Resultado");
    }//GEN-LAST:event_btnLimActionPerformed

    private void btnCerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerActionPerformed
        // TODO add your handling code here:
        this.dispose(); // cerrar ventana
    }//GEN-LAST:event_btnCerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCer;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnLim;
    private javax.swing.JComboBox<String> cboBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblBusqVeh;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
