/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jumbo.frame;

import br.com.jumbo.controller.RateioViagensController;
import br.com.jumbo.controller.RateioViagensDetalheController;
import br.com.jumbo.controller.RateioViagensLookupController;
import br.com.jumbo.controller.VeiculoDetalheController;
import br.com.jumbo.controller.VeiculoControler;
import br.com.jumbo.vo.ViagensCabVO;
import java.awt.Dimension;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import org.openswing.swing.lookup.client.LookupController;
import org.openswing.swing.mdi.client.InternalFrame;
import org.openswing.swing.util.java.Consts;

/**
 *
 * @author Joao
 */
public class RateioViagens extends InternalFrame {

    /**
     * Creates new form Carros
     */
    private Connection conn = null;
    private RateioViagensDetalheController detControle;
    private RateioViagensController cabControle;
    private boolean movimentoNovo;

    public RateioViagens(Connection conn, RateioViagensController cabControle) {
        this.conn = conn;

        try {

            initComponents();
            setSize(500, 200);
            this.cabControle = cabControle;
            form1.setFormController(cabControle);

            detControle = new RateioViagensDetalheController(this, conn);
            gridControl1.setController(detControle);
            gridControl1.setGridDataLocator(detControle);

            LookupController lookupController = new RateioViagensLookupController(conn);
            txtCodLookup.setLookupController(lookupController);

            MaskFormatter mascaraMesAno = new MaskFormatter("##/##");
            mascaraMesAno.setValidCharacters("0123456789");
            txMesAnoCab.setFormatter(mascaraMesAno);

            btInicia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iniciar.png")));
            btInicia.setPreferredSize(new Dimension(65, 41));
            btInicia.setToolTipText("Clique para iniciar o movimento");

            btConsultaMovimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pergunta.png")));
            btConsultaMovimento.setPreferredSize(new Dimension(65, 41));
            btConsultaMovimento.setToolTipText("Clique para consultar o movimento");

            btImportaViagens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/importainq.png")));
            btImportaViagens.setPreferredSize(new Dimension(65, 41));
            btImportaViagens.setToolTipText("Clique para importar viagens");

            btCalculaRateio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calculadora.png")));
            btCalculaRateio.setPreferredSize(new Dimension(65, 41));
            btCalculaRateio.setToolTipText("Clique para calcular o movimento");

            btCancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png")));
            btCancela.setPreferredSize(new Dimension(65, 41));
            btCancela.setToolTipText("Clique para cancelar o movimento");

            btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png")));
            btSalvar.setPreferredSize(new Dimension(65, 41));
            btSalvar.setToolTipText("Clique para salvar o movimento");

            btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fechar.png")));
            btSair.setPreferredSize(new Dimension(65, 41));
            btSair.setToolTipText("Clique para sair da janela atual");

            desabilita();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void reloadData() {

        gridControl1.reloadData();
    }
    /*
     private void calculaRateio() {
     //mestre - Gas Cabecalho
     //   ViagensCabVO gasC = (GasCVO) form1.getVOModel().getValueObject();

     //Detalhe Gas Detalhe
     //     GasDVO gasD = new GasDVO();
     Double totalConsumos = new Double(0);
     Double fatorConversao = new Double(0);

     //calcula o valor do consumo de cada inquilino
     //calcula o total geral dos consumos
     for (int i = 0; i < getGridControl1().getVOListTableModel().getRowCount(); i++) {
     //      gasD = (GasDVO) getGridControl1().getVOListTableModel().getObjectForRow(i);
     if (gasD.getLeituraAtual() != null) {
     gasD.setConsumoMes(gasD.getLeituraAtual() - gasD.getLeituraAnterior());
     }
     totalConsumos = totalConsumos + gasD.getConsumoMes();
     }

     //calcula o fator de conversão
     fatorConversao = gasC.getVlrCompra() / totalConsumos;

     //calcula o valor que cada inquilino deve pagar
     for (int i = 0; i < getGridControl1().getVOListTableModel().getRowCount(); i++) {
     gasD = (GasDVO) getGridControl1().getVOListTableModel().getObjectForRow(i);
     gasD.setVlrPagamento(gasD.getConsumoMes() * fatorConversao);
     }

     //atualiza edits FatorConversao e TotalConsumos
     gasC.setFatorConversao(fatorConversao);
     gasC.setTotalConsumos(totalConsumos);

     //atualiza controles graficos - repaint
     getGridControl1().repaint();
     form1.pull();
        
     }
     */

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
        integerColumn2 = new org.openswing.swing.table.columns.client.IntegerColumn();
        integerColumn3 = new org.openswing.swing.table.columns.client.IntegerColumn();
        jPanel1 = new javax.swing.JPanel();
        btInicia = new org.openswing.swing.client.InsertButton();
        btConsultaMovimento = new org.openswing.swing.client.GenericButton();
        btImportaViagens = new org.openswing.swing.client.GenericButton();
        btCalculaRateio = new org.openswing.swing.client.GenericButton();
        btCancela = new org.openswing.swing.client.ReloadButton();
        btSalvar = new org.openswing.swing.client.SaveButton();
        btSair = new org.openswing.swing.client.GenericButton();
        jPanel2 = new javax.swing.JPanel();
        form1 = new org.openswing.swing.form.client.Form();
        txVeiculoVeiPlaca = new org.openswing.swing.client.TextControl();
        txtCodLookup = new org.openswing.swing.client.CodLookupControl();
        txTotalViagens = new org.openswing.swing.client.NumericControl();
        txValorTotalCab = new org.openswing.swing.client.CurrencyControl();
        labelControl1 = new org.openswing.swing.client.LabelControl();
        labelControl2 = new org.openswing.swing.client.LabelControl();
        labelControl3 = new org.openswing.swing.client.LabelControl();
        labelControl4 = new org.openswing.swing.client.LabelControl();
        labelControl5 = new org.openswing.swing.client.LabelControl();
        txMesAnoCab = new org.openswing.swing.client.FormattedTextControl();

        setTitle("Rateio de Viagéns");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        gridControl1.setAutoLoadData(false);
        gridControl1.setFunctionId("rateioViagens");
        gridControl1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        gridControl1.setValueObjectClassName("br.com.jumbo.vo.ViagensDetVO");

        integerColumn1.setColumnFilterable(true);
        integerColumn1.setColumnName("viDetCod");
        integerColumn1.setColumnSortable(true);
        integerColumn1.setHeaderColumnName("Código ");
        gridControl1.getColumnContainer().add(integerColumn1);

        textColumn1.setColumnFilterable(true);
        textColumn1.setColumnName("viDetVeiculoVeiPlaca");
        textColumn1.setColumnSortable(true);
        textColumn1.setHeaderColumnName("Placa");
        gridControl1.getColumnContainer().add(textColumn1);

        textColumn2.setColumnFilterable(true);
        textColumn2.setColumnName("viDetMes");
        textColumn2.setColumnSortable(true);
        textColumn2.setHeaderColumnName("Mes");
        textColumn2.setTextAlignment(SwingConstants.CENTER);
        gridControl1.getColumnContainer().add(textColumn2);

        integerColumn2.setColumnFilterable(true);
        integerColumn2.setColumnName("viDetTotalViagen");
        integerColumn2.setColumnSortable(true);
        integerColumn2.setHeaderColumnName("Nº Viagens");
        integerColumn2.setTextAlignment(SwingConstants.CENTER);
        gridControl1.getColumnContainer().add(integerColumn2);

        integerColumn3.setColumnFilterable(true);
        integerColumn3.setColumnName("viDetTotalValor");
        integerColumn3.setColumnSortable(true);
        integerColumn3.setHeaderColumnName("Valor T Mes");
        gridControl1.getColumnContainer().add(integerColumn3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(gridControl1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        btInicia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciaActionPerformed(evt);
            }
        });
        jPanel1.add(btInicia);

        btConsultaMovimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultaMovimentoActionPerformed(evt);
            }
        });
        jPanel1.add(btConsultaMovimento);
        jPanel1.add(btImportaViagens);
        jPanel1.add(btCalculaRateio);

        btCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelaActionPerformed(evt);
            }
        });
        jPanel1.add(btCancela);

        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar);

        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel1.add(btSair);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setNextFocusableComponent(txtCodLookup);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        form1.setBackground(new java.awt.Color(255, 204, 255));
        form1.setVOClassName("br.com.jumbo.vo.ViagensCabVO");
        form1.setInsertButton(btInicia);
        form1.setNextFocusableComponent(txtCodLookup);
        form1.setReloadButton(btCancela);
        form1.setSaveButton(btSalvar);
        form1.setLayout(new java.awt.GridBagLayout());

        txVeiculoVeiPlaca.setAttributeName("veiculoVeiPlaca");
        txVeiculoVeiPlaca.setEnabled(false);
        txVeiculoVeiPlaca.setEnabledOnEdit(false);
        txVeiculoVeiPlaca.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        form1.add(txVeiculoVeiPlaca, gridBagConstraints);

        txtCodLookup.setAttributeName("colId");
        txtCodLookup.setAutoCompletitionWaitTime(2L);
        txtCodLookup.setMaxCharacters(2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        form1.add(txtCodLookup, gridBagConstraints);

        txTotalViagens.setAttributeName("totalViagensCab");
        txTotalViagens.setEnabled(false);
        txTotalViagens.setEnabledOnEdit(false);
        txTotalViagens.setEnabledOnInsert(false);
        txTotalViagens.setMaxCharacters(6);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        form1.add(txTotalViagens, gridBagConstraints);

        txValorTotalCab.setAttributeName("valorTotalMesCab");
        txValorTotalCab.setDecimals(2);
        txValorTotalCab.setEnabled(false);
        txValorTotalCab.setEnabledOnEdit(false);
        txValorTotalCab.setEnabledOnInsert(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 0);
        form1.add(txValorTotalCab, gridBagConstraints);

        labelControl1.setText("Código ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        form1.add(labelControl1, gridBagConstraints);

        labelControl2.setText("Placa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        form1.add(labelControl2, gridBagConstraints);

        labelControl3.setText("Mês");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        form1.add(labelControl3, gridBagConstraints);

        labelControl4.setText("Total Viagens");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        form1.add(labelControl4, gridBagConstraints);

        labelControl5.setText("Valor Total Mês");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        form1.add(labelControl5, gridBagConstraints);

        txMesAnoCab.setAttributeName("mesAnoCab");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        form1.add(txMesAnoCab, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(form1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIniciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciaActionPerformed
        //  new RateioViagensController(this, null, conn);
        btConsultaMovimento.setEnabled(true);
    }//GEN-LAST:event_btIniciaActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelaActionPerformed
        gridControl1.reloadData();
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelaActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        gridControl1.save();
// TODO add your handling code here:
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btConsultaMovimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultaMovimentoActionPerformed


        ViagensCabVO ViagensC = (ViagensCabVO) form1.getVOModel().getValueObject();
        form1.push();
        if ((ViagensC.getVeiculoVeiPlaca() == null) || (ViagensC.getMesAnoCab() == null)) {
            JOptionPane.showMessageDialog(null, "Selecione primeiro uma Placa e informe o Mês eo Ano");
            txtCodLookup.requestFocus();
        } else {
            try {
                movimentoNovo = cabControle.consultaMovimento();
            } catch (Exception ex) {
                Logger.getLogger(RateioViagens.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (movimentoNovo == true) {
                form1.save();
                form1.reload();
                btImportaViagens.setEnabled(true);
                btConsultaMovimento.setEnabled(false);
            } else {
                
              //  JOptionPane.showMessageDialog(null,"Este mes ja está fechado");
                
                form1.setMode(Consts.READONLY);
                form1.pull();
                form1.reload();
                gridControl1.reloadData();
            }
        }

    }//GEN-LAST:event_btConsultaMovimentoActionPerformed

    private void btImportaInquilinosActionPerformed(java.awt.event.ActionEvent evt) {
        if (movimentoNovo == true) {
            detControle.carregaViagensNova();
        }
        gridControl1.setMode(Consts.EDIT);
        form1.setMode(Consts.EDIT);
        btImportaViagens.setEnabled(false);
        btCalculaRateio.setEnabled(true);
    }

    private void btCalculaRateioActionPerformed(java.awt.event.ActionEvent evt) {
        //  calculaRateio();
    }

    private void btSalvaActionPerformed(java.awt.event.ActionEvent evt) {
        gridControl1.save();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.GenericButton btCalculaRateio;
    private org.openswing.swing.client.ReloadButton btCancela;
    private org.openswing.swing.client.GenericButton btConsultaMovimento;
    private org.openswing.swing.client.GenericButton btImportaViagens;
    private org.openswing.swing.client.InsertButton btInicia;
    private org.openswing.swing.client.GenericButton btSair;
    private org.openswing.swing.client.SaveButton btSalvar;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.client.GridControl gridControl1;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn1;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn2;
    private org.openswing.swing.table.columns.client.IntegerColumn integerColumn3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private org.openswing.swing.client.LabelControl labelControl1;
    private org.openswing.swing.client.LabelControl labelControl2;
    private org.openswing.swing.client.LabelControl labelControl3;
    private org.openswing.swing.client.LabelControl labelControl4;
    private org.openswing.swing.client.LabelControl labelControl5;
    private org.openswing.swing.table.columns.client.TextColumn textColumn1;
    private org.openswing.swing.table.columns.client.TextColumn textColumn2;
    private org.openswing.swing.client.FormattedTextControl txMesAnoCab;
    private org.openswing.swing.client.NumericControl txTotalViagens;
    private org.openswing.swing.client.CurrencyControl txValorTotalCab;
    private org.openswing.swing.client.TextControl txVeiculoVeiPlaca;
    private org.openswing.swing.client.CodLookupControl txtCodLookup;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the form1
     */
    public org.openswing.swing.form.client.Form getForm1() {
        return form1;
    }

    /**
     * @return the gridControl1
     */
    public org.openswing.swing.client.GridControl getGridControl1() {
        return gridControl1;
    }

    private void desabilita() {
        btImportaViagens.setEnabled(false);
        btCalculaRateio.setEnabled(false);
        btConsultaMovimento.setEnabled(false);
        /*btCancela.setEnabled(false);
         btSalva.setEnabled(false);
         btInicia.setEnabled(true);*/
        btSair.setEnabled(true);
        form1.setMode(Consts.READONLY);
    }

    /**
     * @return the txMesAnoCab
     */
    public org.openswing.swing.client.FormattedTextControl getTxMesAnoCab() {
        return txMesAnoCab;
    }

    /**
     * @return the txVeiculoVeiPlaca
     */
    public org.openswing.swing.client.TextControl getTxVeiculoVeiPlaca() {
        return txVeiculoVeiPlaca;
    }
}
