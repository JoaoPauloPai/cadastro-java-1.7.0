/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jumbo.frame;

import br.com.jumbo.controller.ProdutoLookupController;
import br.com.jumbo.controller.ViagensLookupController;
import br.com.jumbo.vo.LookupColaboradorVO;
import br.com.jumbo.vo.ViagensVO;
import java.sql.*;
import java.util.Collection;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import org.openswing.swing.mdi.client.InternalFrame;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.lookup.client.LookupListener;
import org.openswing.swing.message.receive.java.ValueObject;

/**
 *
 * @author Joao
 */
public class ViagensDetalhe extends InternalFrame {

    private Date data = null;
    private Connection conn = null;
    private LookupController LookupController = null;
   // private  LookupColaboradorVO viagens ;
   // private LookupController ViagenslookupController = null;
  //   private LookupController ProdutolookupController = null;
  // LookupController (LookupController) = ProdutolookupController;
  //  private LookupController LookupController2 = null;

    /**
     * Creates new form VeiculoDetalhe
     */
    public ViagensDetalhe(Connection conn, FormController dataController) {
        try {
            this.conn = conn;
            initComponents();
            
            MaskFormatter mesRef = new MaskFormatter(" ##/##");
          
            mesRef.setValidCharacters("0123456789");
    

            formattedTextControl1.setFormatter(mesRef);
           

            formattedTextControl1.setEnabled(false);
         

            formattedTextControl1.setColumns(10);
      


            LookupController LookupController = new ViagensLookupController(conn);
        //    LookupController  = new LookupController(conn);
           codLookupControl1.setLookupController(LookupController);

           LookupController = new ProdutoLookupController(conn);
             codLookupControl2.setLookupController(LookupController);
            /*
             lookupController.addLookupListener(new LookupListener() {
               

             public void beforeLookupAction(ValueObject parentVO) {
             }

             public void codeChanged(ValueObject parentVO, Collection parentChangedAttributes) {
             viagens = (LookupColaboradorVO) codLookupControl1.getLookupController().getLookupVO();
             }

             public void codeValidated(boolean validated) {
             }

             public void forceValidate() {
             }
             });  */
             
            form1.setFormController(dataController);

            setSize(590, 440);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Form getForm1() {
        return form1;
    }

       //   public VeiculoDetalhe(Connection conn, VeiculoDetalheController aThis) {
    //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        textControl7 = new org.openswing.swing.client.TextControl();
        dateControl3 = new org.openswing.swing.client.DateControl();
        form1 = new org.openswing.swing.form.client.Form();
        textControl1 = new org.openswing.swing.client.TextControl();
        textControl2 = new org.openswing.swing.client.TextControl();
        textControl3 = new org.openswing.swing.client.TextControl();
        textControl4 = new org.openswing.swing.client.TextControl();
        numericControl1 = new org.openswing.swing.client.NumericControl();
        numericControl2 = new org.openswing.swing.client.NumericControl();
        labelControl1 = new org.openswing.swing.client.LabelControl();
        labelControl2 = new org.openswing.swing.client.LabelControl();
        labelControl3 = new org.openswing.swing.client.LabelControl();
        labelControl4 = new org.openswing.swing.client.LabelControl();
        labelControl5 = new org.openswing.swing.client.LabelControl();
        labelControl6 = new org.openswing.swing.client.LabelControl();
        codLookupControl1 = new org.openswing.swing.client.CodLookupControl();
        textControl5 = new org.openswing.swing.client.TextControl();
        labelControl7 = new org.openswing.swing.client.LabelControl();
        labelControl8 = new org.openswing.swing.client.LabelControl();
        labelControl9 = new org.openswing.swing.client.LabelControl();
        labelControl10 = new org.openswing.swing.client.LabelControl();
        dateControl1 = new org.openswing.swing.client.DateControl();
        dateControl2 = new org.openswing.swing.client.DateControl();
        numericControl3 = new org.openswing.swing.client.NumericControl();
        labelControl11 = new org.openswing.swing.client.LabelControl();
        labelControl12 = new org.openswing.swing.client.LabelControl();
        currencyControl1 = new org.openswing.swing.client.CurrencyControl();
        labelControl13 = new org.openswing.swing.client.LabelControl();
        formattedTextControl1 = new org.openswing.swing.client.FormattedTextControl();
        labelControl14 = new org.openswing.swing.client.LabelControl();
        codLookupControl2 = new org.openswing.swing.client.CodLookupControl();
        labelControl15 = new org.openswing.swing.client.LabelControl();
        textAreaControl1 = new org.openswing.swing.client.TextAreaControl();
        jPanel1 = new javax.swing.JPanel();
        saveButton1 = new org.openswing.swing.client.SaveButton();
        editButton1 = new org.openswing.swing.client.EditButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Viagens (Iserindo/Alterando)");
        setPreferredSize(new java.awt.Dimension(500, 600));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        form1.setVOClassName("br.com.jumbo.vo.ViagensVO");
        form1.setEditButton(editButton1);
        form1.setSaveButton(saveButton1);
        form1.setLayout(new java.awt.GridBagLayout());

        textControl1.setAttributeName("viLocDes");
        textControl1.setEnabled(false);
        textControl1.setMaxCharacters(20);
        textControl1.setRequired(true);
        textControl1.setUpperCase(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        form1.add(textControl1, gridBagConstraints);

        textControl2.setAttributeName("viLocCar");
        textControl2.setEnabled(false);
        textControl2.setMaxCharacters(20);
        textControl2.setRequired(true);
        textControl2.setUpperCase(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        form1.add(textControl2, gridBagConstraints);

        textControl3.setAttributeName("colNome");
        textControl3.setEnabled(false);
        textControl3.setEnabledOnEdit(false);
        textControl3.setEnabledOnInsert(false);
        textControl3.setMaxCharacters(30);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        form1.add(textControl3, gridBagConstraints);

        textControl4.setAttributeName("veiculoVeiPlaca");
        textControl4.setEnabled(false);
        textControl4.setEnabledOnEdit(false);
        textControl4.setEnabledOnInsert(false);
        textControl4.setLinkLabel(labelControl8);
        textControl4.setMaxCharacters(15);
        textControl4.setRequired(true);
        textControl4.setUpperCase(true);
        textControl4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textControl4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        form1.add(textControl4, gridBagConstraints);

        numericControl1.setAttributeName("viPesoTotal");
        numericControl1.setDecimals(3);
        numericControl1.setEnabled(false);
        numericControl1.setHideZeroDigits(true);
        numericControl1.setMaxCharacters(6);
        numericControl1.setTextAlignment(SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        form1.add(numericControl1, gridBagConstraints);

        numericControl2.setAttributeName("viValorTon");
        numericControl2.setDecimals(2);
        numericControl2.setEnabled(false);
        numericControl2.setMaxCharacters(6);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        form1.add(numericControl2, gridBagConstraints);

        labelControl1.setLabel("Local Carregamento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        form1.add(labelControl1, gridBagConstraints);

        labelControl2.setLabel("Peso Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        form1.add(labelControl2, gridBagConstraints);

        labelControl3.setLabel("Local Descarga");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        form1.add(labelControl3, gridBagConstraints);

        labelControl4.setLabel("Valor Tonelada");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        form1.add(labelControl4, gridBagConstraints);

        labelControl5.setLabel("Número CTE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        form1.add(labelControl5, gridBagConstraints);

        labelControl6.setLabel("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        form1.add(labelControl6, gridBagConstraints);

        codLookupControl1.setAttributeName("colId");
        codLookupControl1.setEnabled(false);
        codLookupControl1.setMaxCharacters(2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        form1.add(codLookupControl1, gridBagConstraints);

        textControl5.setAttributeName("proNome");
        textControl5.setEnabled(false);
        textControl5.setEnabledOnEdit(false);
        textControl5.setEnabledOnInsert(false);
        textControl5.setMaxCharacters(10);
        textControl5.setUpperCase(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        form1.add(textControl5, gridBagConstraints);

        labelControl7.setLabel("Código");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 5, 0);
        form1.add(labelControl7, gridBagConstraints);

        labelControl8.setText("Placa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 5, 0);
        form1.add(labelControl8, gridBagConstraints);

        labelControl9.setText("Data Carregamento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 5, 0);
        form1.add(labelControl9, gridBagConstraints);

        labelControl10.setText("Data Decsarga");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        form1.add(labelControl10, gridBagConstraints);

        dateControl1.setAttributeName("viDataCar");
        dateControl1.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        form1.add(dateControl1, gridBagConstraints);

        dateControl2.setAttributeName("viDataDes");
        dateControl2.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        form1.add(dateControl2, gridBagConstraints);

        numericControl3.setAttributeName("viNumNf");
        numericControl3.setEnabled(false);
        numericControl3.setMaxCharacters(8);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        form1.add(numericControl3, gridBagConstraints);

        labelControl11.setLabel("Observações");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        form1.add(labelControl11, gridBagConstraints);

        labelControl12.setLabel("Produto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        form1.add(labelControl12, gridBagConstraints);

        currencyControl1.setAttributeName("viValorTotal");
        currencyControl1.setCurrencySymbol("");
        currencyControl1.setCurrencySymbolOnLeft(false);
        currencyControl1.setDecimals(2);
        currencyControl1.setEnabled(false);
        currencyControl1.setEnabledOnEdit(false);
        currencyControl1.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        form1.add(currencyControl1, gridBagConstraints);

        labelControl13.setText("Valor Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        form1.add(labelControl13, gridBagConstraints);

        formattedTextControl1.setAttributeName("viMesRef");
        formattedTextControl1.setRequired(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        form1.add(formattedTextControl1, gridBagConstraints);

        labelControl14.setText("Mês Ref");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        form1.add(labelControl14, gridBagConstraints);

        codLookupControl2.setAttributeName("proId");
        codLookupControl2.setEnabled(false);
        codLookupControl2.setMaxCharacters(2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        form1.add(codLookupControl2, gridBagConstraints);

        labelControl15.setText("Cód Produto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        form1.add(labelControl15, gridBagConstraints);

        textAreaControl1.setAttributeName("viObs");
        textAreaControl1.setMaxCharacters(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 20, 20);
        form1.add(textAreaControl1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(form1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        saveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton1);
        jPanel1.add(editButton1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textControl4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textControl4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textControl4ActionPerformed

    private void saveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton1ActionPerformed
        
         
        double valorTonelada = Double.parseDouble(numericControl2.getText());
        double pesoTotal = Double.parseDouble(numericControl1.getText());
        double valorTotal;

       valorTotal = valorTonelada * pesoTotal;
       
      // viagens.setViValorTotal(valorTotal);
       currencyControl1.setValue(valorTotal);
               //setValue(valorTotal);

     //   if (valorTonelada > 0.0) {
      // if  (valorTotal=pesoTotal*);
       // System.out.println("VALOR DO FRETE = " + valorTotal);
        //  if (valorTotal = pesoTotal * valorTonelada) {
       
      // Date data = new Date();
    }//GEN-LAST:event_saveButton1ActionPerformed

     
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.CodLookupControl codLookupControl1;
    private org.openswing.swing.client.CodLookupControl codLookupControl2;
    private org.openswing.swing.client.CurrencyControl currencyControl1;
    private org.openswing.swing.client.DateControl dateControl1;
    private org.openswing.swing.client.DateControl dateControl2;
    private org.openswing.swing.client.DateControl dateControl3;
    private org.openswing.swing.client.EditButton editButton1;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.client.FormattedTextControl formattedTextControl1;
    private javax.swing.JPanel jPanel1;
    private org.openswing.swing.client.LabelControl labelControl1;
    private org.openswing.swing.client.LabelControl labelControl10;
    private org.openswing.swing.client.LabelControl labelControl11;
    private org.openswing.swing.client.LabelControl labelControl12;
    private org.openswing.swing.client.LabelControl labelControl13;
    private org.openswing.swing.client.LabelControl labelControl14;
    private org.openswing.swing.client.LabelControl labelControl15;
    private org.openswing.swing.client.LabelControl labelControl2;
    private org.openswing.swing.client.LabelControl labelControl3;
    private org.openswing.swing.client.LabelControl labelControl4;
    private org.openswing.swing.client.LabelControl labelControl5;
    private org.openswing.swing.client.LabelControl labelControl6;
    private org.openswing.swing.client.LabelControl labelControl7;
    private org.openswing.swing.client.LabelControl labelControl8;
    private org.openswing.swing.client.LabelControl labelControl9;
    private org.openswing.swing.client.NumericControl numericControl1;
    private org.openswing.swing.client.NumericControl numericControl2;
    private org.openswing.swing.client.NumericControl numericControl3;
    private org.openswing.swing.client.SaveButton saveButton1;
    private org.openswing.swing.client.TextAreaControl textAreaControl1;
    private org.openswing.swing.client.TextControl textControl1;
    private org.openswing.swing.client.TextControl textControl2;
    private org.openswing.swing.client.TextControl textControl3;
    private org.openswing.swing.client.TextControl textControl4;
    private org.openswing.swing.client.TextControl textControl5;
    private org.openswing.swing.client.TextControl textControl7;
    // End of variables declaration//GEN-END:variables
}