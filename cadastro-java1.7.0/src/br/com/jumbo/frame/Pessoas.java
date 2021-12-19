/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jumbo.frame;




import br.com.jumbo.controller.PessoasControler;
import br.com.jumbo.controller.PessoasDetalheController;
import java.sql.Connection;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import org.openswing.swing.client.GridControl;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.InternalFrame;
import org.openswing.swing.table.client.GridController;

/**
 *
 * @author Joao
 */
public class Pessoas extends InternalFrame {
    

    /**
     * Creates new form Carros
     */

        private Connection conn = null;

    public Pessoas(Connection conn, PessoasControler controller) {
        this.conn = conn;

        try {

            initComponents();
            setSize(500, 200);
            gridControl1.setController(controller);
            gridControl1.setGridDataLocator(controller);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        public Pessoas(Connection conn, GridController dataController) {
         try {
            this.conn = conn;
        initComponents();
                
       
      gridControl1.setBottomGridController(dataController);
            

      
            setSize(590, 440);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       public GridControl getGridControl1() {
        return  gridControl1;
    }

    public void reloadData() {
        
        gridControl1.reloadData();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        gridControl1 = new org.openswing.swing.client.GridControl();
        integerColumn1 = new org.openswing.swing.table.columns.client.IntegerColumn();
        textColumn1 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn2 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn3 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn4 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn5 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn6 = new org.openswing.swing.table.columns.client.TextColumn();
        jPanel1 = new javax.swing.JPanel();
        insertButton1 = new org.openswing.swing.client.InsertButton();
        reloadButton1 = new org.openswing.swing.client.ReloadButton();
        deleteButton1 = new org.openswing.swing.client.DeleteButton();
        jPanel2 = new javax.swing.JPanel();
        labelControl2 = new org.openswing.swing.client.LabelControl();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        gridControl1.setDeleteButton(deleteButton1);
        gridControl1.setFunctionId("veiculo");
        gridControl1.setReloadButton(reloadButton1);
        gridControl1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        gridControl1.setValueObjectClassName("br.com.jumbo.vo.PessoasVO");

        integerColumn1.setColumnFilterable(true);
        integerColumn1.setColumnName("pesId");
        integerColumn1.setColumnSortable(true);
        integerColumn1.setHeaderColumnName("Código");
        integerColumn1.setPreferredWidth(80);
        gridControl1.getColumnContainer().add(integerColumn1);

        textColumn1.setColumnFilterable(true);
        textColumn1.setColumnName("pesNome");
        textColumn1.setColumnSortable(true);
        textColumn1.setHeaderColumnName("Nome Completo");
        textColumn1.setMaxCharacters(50);
        textColumn1.setPreferredWidth(250);
        textColumn1.setUpperCase(true);
        gridControl1.getColumnContainer().add(textColumn1);

        textColumn2.setColumnFilterable(true);
        textColumn2.setColumnName("pesSexo");
        textColumn2.setColumnSortable(true);
        textColumn2.setHeaderColumnName("Sexo");
        textColumn2.setMaxCharacters(1);
        textColumn2.setPreferredWidth(50);
        textColumn2.setTextAlignment(SwingConstants.CENTER);
        textColumn2.setUpperCase(true);
        gridControl1.getColumnContainer().add(textColumn2);

        textColumn3.setColumnFilterable(true);
        textColumn3.setColumnName("pesCidade");
        textColumn3.setColumnSortable(true);
        textColumn3.setHeaderColumnName("Cidade");
        textColumn3.setPreferredWidth(200);
        gridControl1.getColumnContainer().add(textColumn3);

        textColumn4.setColumnFilterable(true);
        textColumn4.setColumnName("pesEst");
        textColumn4.setColumnSortable(true);
        textColumn4.setHeaderColumnName("Estado");
        textColumn4.setPreferredWidth(80);
        textColumn4.setTextAlignment(SwingConstants.CENTER);
        gridControl1.getColumnContainer().add(textColumn4);

        textColumn5.setColumnFilterable(true);
        textColumn5.setColumnName("pesFone1");
        textColumn5.setColumnSortable(true);
        textColumn5.setHeaderColumnName("Celular");
        gridControl1.getColumnContainer().add(textColumn5);

        textColumn6.setColumnFilterable(true);
        textColumn6.setColumnName("pesFone2");
        textColumn6.setColumnSortable(true);
        textColumn6.setHeaderColumnName("Fone");
        gridControl1.getColumnContainer().add(textColumn6);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(gridControl1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        insertButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(insertButton1);
        jPanel1.add(reloadButton1);

        deleteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        labelControl2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelControl2.setText("Cadastro de Pessoas");
        jPanel2.add(labelControl2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButton1ActionPerformed
      new PessoasDetalheController(this, null, conn);
    }//GEN-LAST:event_insertButton1ActionPerformed

    private void deleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.DeleteButton deleteButton1;
    private org.openswing.swing.client.GridControl gridControl1;
    private org.openswing.swing.client.InsertButton insertButton1;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private org.openswing.swing.client.LabelControl labelControl2;
    private org.openswing.swing.client.ReloadButton reloadButton1;
    private org.openswing.swing.table.columns.client.TextColumn textColumn1;
    private org.openswing.swing.table.columns.client.TextColumn textColumn2;
    private org.openswing.swing.table.columns.client.TextColumn textColumn3;
    private org.openswing.swing.table.columns.client.TextColumn textColumn4;
    private org.openswing.swing.table.columns.client.TextColumn textColumn5;
    private org.openswing.swing.table.columns.client.TextColumn textColumn6;
    // End of variables declaration//GEN-END:variables
}