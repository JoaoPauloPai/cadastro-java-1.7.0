/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Banco.java
 *
 * Created on 02/05/2009, 04:32:48
 */

package br.com.jumbo.frame;





import java.awt.Dimension;
import java.awt.event.ActionListener;
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
 * @author Albert Eije
 */
public class RateioGas extends InternalFrame implements ActionListener {

    private Connection conn = null;
   // private RateioViagensController cabControle;
  //  private RateioViagensDetalheController detControle;
    private boolean movimentoNovo;

    /** Creates new form GridFrame2 */
    public RateioGas(Connection conn) {
        this.conn = conn;
        try {
          initComponents();
            setSize(750, 300);

           // this.cabControle = cabControle;
           // form1.setFormController(cabControle);

          //  detControle = new RateioGasDetalheController(this, conn);
          //  gridControl1.setController(detControle);
          //  gridControl1.setGridDataLocator(detControle);

         //   LookupController lookupController = new RateioGasLookupController(conn);
         //   txCodCondominio.setLookupController(lookupController);

            MaskFormatter mascaraMesAno = new MaskFormatter("##/####");
            mascaraMesAno.setValidCharacters("0123456789");
            txMesAno.setFormatter(mascaraMesAno);

            btInicia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iniciar.png")));
            btInicia.setPreferredSize(new Dimension(65, 41));
            btInicia.setToolTipText("Clique para iniciar o movimento");

            btConsultaMovimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pergunta.png")));
            btConsultaMovimento.setPreferredSize(new Dimension(65, 41));
            btConsultaMovimento.setToolTipText("Clique para verificar se já existe movimento");

            btImportaInquilinos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/importainq.png")));
            btImportaInquilinos.setPreferredSize(new Dimension(65, 41));
            btImportaInquilinos.setToolTipText("Clique para importar os inquilinos");

            btCalculaRateio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calculadora.png")));
            btCalculaRateio.setPreferredSize(new Dimension(65, 41));
            btCalculaRateio.setToolTipText("Clique para calcular o rateio");

            btCancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png")));
            btCancela.setPreferredSize(new Dimension(65, 41));
            btCancela.setToolTipText("Clique para cancelar o movimento");

            btSalva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png")));
            btSalva.setPreferredSize(new Dimension(65, 41));
            btSalva.setToolTipText("Clique para confirmar o movimento");

            btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fechar.png")));
            btSair.setPreferredSize(new Dimension(65, 41));
            btSair.setToolTipText("Clique para sair da janela atual");

            desabilita();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reloadData() {
        getGridControl1().reloadData();
    }
/*
    private void calculaRateio() {
        //mestre - Gas Cabecalho
        GasCVO gasC = (GasCVO) form1.getVOModel().getValueObject();

        //Detalhe Gas Detalhe
        GasDVO gasD = new GasDVO();
        Double totalConsumos = new Double(0);
        Double fatorConversao = new Double(0);

        //calcula o valor do consumo de cada inquilino
        //calcula o total geral dos consumos
        for (int i = 0; i < getGridControl1().getVOListTableModel().getRowCount(); i++) {
            gasD = (GasDVO) getGridControl1().getVOListTableModel().getObjectForRow(i);
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
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        form1 = new org.openswing.swing.form.client.Form();
        labelControl4 = new org.openswing.swing.client.LabelControl();
        labelControl3 = new org.openswing.swing.client.LabelControl();
        labelControl5 = new org.openswing.swing.client.LabelControl();
        labelControl2 = new org.openswing.swing.client.LabelControl();
        labelControl1 = new org.openswing.swing.client.LabelControl();
        txCodCondominio = new org.openswing.swing.client.CodLookupControl();
        txNomeCondominio = new org.openswing.swing.client.TextControl();
        txMesAno = new org.openswing.swing.client.FormattedTextControl();
        txValorCompra = new org.openswing.swing.client.CurrencyControl();
        txTotalConsumos = new org.openswing.swing.client.NumericControl();
        txFatorConversao = new org.openswing.swing.client.NumericControl();
        jPanel2 = new javax.swing.JPanel();
        btInicia = new org.openswing.swing.client.InsertButton();
        btConsultaMovimento = new org.openswing.swing.client.GenericButton();
        btImportaInquilinos = new org.openswing.swing.client.GenericButton();
        btCalculaRateio = new org.openswing.swing.client.GenericButton();
        btCancela = new org.openswing.swing.client.ReloadButton();
        btSalva = new org.openswing.swing.client.SaveButton();
        btSair = new org.openswing.swing.client.GenericButton();
        gridControl1 = new org.openswing.swing.client.GridControl();
        textColumn1 = new org.openswing.swing.table.columns.client.TextColumn();
        textColumn2 = new org.openswing.swing.table.columns.client.TextColumn();
        decimalColumn1 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn2 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn3 = new org.openswing.swing.table.columns.client.DecimalColumn();
        decimalColumn4 = new org.openswing.swing.table.columns.client.DecimalColumn();

        setTitle("Rateio do Gás");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        form1.setBackground(new java.awt.Color(0, 204, 204));
        form1.setVOClassName("br.com.syndic.vo.GasCVO");
        form1.setInsertButton(btInicia);
        form1.setNextFocusableComponent(txCodCondominio);
        form1.setReloadButton(btCancela);
        form1.setSaveButton(btSalva);
        form1.setLayout(new java.awt.GridBagLayout());

        labelControl4.setLabel("Total Consumos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        form1.add(labelControl4, gridBagConstraints);

        labelControl3.setLabel("Valor Compra:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        form1.add(labelControl3, gridBagConstraints);

        labelControl5.setLabel("Fator Conversão:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        form1.add(labelControl5, gridBagConstraints);

        labelControl2.setLabel("Mês/Ano:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        form1.add(labelControl2, gridBagConstraints);

        labelControl1.setLabel("Condomínio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        form1.add(labelControl1, gridBagConstraints);

        txCodCondominio.setAttributeName("codCondominio");
        txCodCondominio.setAutoCompletitionWaitTime(2L);
        txCodCondominio.setLinkLabel(labelControl1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        form1.add(txCodCondominio, gridBagConstraints);

        txNomeCondominio.setAttributeName("nomeCondominio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        form1.add(txNomeCondominio, gridBagConstraints);

        txMesAno.setAttributeName("mesAno");
        txMesAno.setLinkLabel(labelControl2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        form1.add(txMesAno, gridBagConstraints);

        txValorCompra.setAttributeName("vlrCompra");
        txValorCompra.setDecimals(2);
        txValorCompra.setLinkLabel(labelControl3);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        form1.add(txValorCompra, gridBagConstraints);

        txTotalConsumos.setAttributeName("totalConsumos");
        txTotalConsumos.setDecimals(3);
        txTotalConsumos.setEnabled(false);
        txTotalConsumos.setEnabledOnEdit(false);
        txTotalConsumos.setEnabledOnInsert(false);
        txTotalConsumos.setLinkLabel(labelControl4);
        txTotalConsumos.setTextAlignment(SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        form1.add(txTotalConsumos, gridBagConstraints);

        txFatorConversao.setAttributeName("fatorConversao");
        txFatorConversao.setDecimals(4);
        txFatorConversao.setEnabled(false);
        txFatorConversao.setEnabledOnEdit(false);
        txFatorConversao.setEnabledOnInsert(false);
        txFatorConversao.setLinkLabel(labelControl5);
        txFatorConversao.setTextAlignment(SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        form1.add(txFatorConversao, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(form1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btInicia.addActionListener(this);
        jPanel2.add(btInicia);

        btConsultaMovimento.addActionListener(this);
        jPanel2.add(btConsultaMovimento);

        btImportaInquilinos.addActionListener(this);
        jPanel2.add(btImportaInquilinos);

        btCalculaRateio.addActionListener(this);
        jPanel2.add(btCalculaRateio);

        btCancela.addActionListener(this);
        jPanel2.add(btCancela);

        btSalva.addActionListener(this);
        jPanel2.add(btSalva);

        btSair.addActionListener(this);
        jPanel2.add(btSair);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jPanel2, gridBagConstraints);

        gridControl1.setAutoLoadData(false);
        gridControl1.setFunctionId("banco");
        gridControl1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        gridControl1.setValueObjectClassName("br.com.syndic.vo.GasDVO");
        gridControl1.getColumnContainer().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        textColumn1.setAdditionalHeaderColumnName("Código Inquilino");
        textColumn1.setColumnFilterable(true);
        textColumn1.setColumnName("codInquilino");
        textColumn1.setColumnSortable(true);
        textColumn1.setHeaderColumnName("Código Inquilino");
        gridControl1.getColumnContainer().add(textColumn1);

        textColumn2.setColumnFilterable(true);
        textColumn2.setColumnName("nomeInquilino");
        textColumn2.setColumnSortable(true);
        textColumn2.setHeaderColumnName("Nome do Inquilino");
        textColumn2.setPreferredWidth(250);
        gridControl1.getColumnContainer().add(textColumn2);

        decimalColumn1.setColumnName("leituraAnterior");
        decimalColumn1.setDecimals(3);
        decimalColumn1.setHeaderColumnName("Leitura Anterior");
        gridControl1.getColumnContainer().add(decimalColumn1);

        decimalColumn2.setColumnName("leituraAtual");
        decimalColumn2.setDecimals(3);
        decimalColumn2.setEditableOnEdit(true);
        decimalColumn2.setEditableOnInsert(true);
        decimalColumn2.setHeaderColumnName("Leitura Atual");
        gridControl1.getColumnContainer().add(decimalColumn2);

        decimalColumn3.setColumnName("consumoMes");
        decimalColumn3.setDecimals(3);
        decimalColumn3.setHeaderColumnName("Consumo");
        gridControl1.getColumnContainer().add(decimalColumn3);

        decimalColumn4.setColumnName("vlrPagamento");
        decimalColumn4.setDecimals(2);
        decimalColumn4.setHeaderColumnName("Valor a Pagar");
        gridControl1.getColumnContainer().add(decimalColumn4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(gridControl1, gridBagConstraints);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == btInicia) {
            RateioGas.this.btIniciaActionPerformed(evt);
        }
        else if (evt.getSource() == btCancela) {
            RateioGas.this.btCancelaActionPerformed(evt);
        }
        else if (evt.getSource() == btSair) {
            RateioGas.this.btSairActionPerformed(evt);
        }
        else if (evt.getSource() == btConsultaMovimento) {
            RateioGas.this.btConsultaMovimentoActionPerformed(evt);
        }
        else if (evt.getSource() == btImportaInquilinos) {
            RateioGas.this.btImportaInquilinosActionPerformed(evt);
        }
        else if (evt.getSource() == btCalculaRateio) {
            RateioGas.this.btCalculaRateioActionPerformed(evt);
        }
        else if (evt.getSource() == btSalva) {
            RateioGas.this.btSalvaActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void btIniciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciaActionPerformed
        btConsultaMovimento.setEnabled(true);
}//GEN-LAST:event_btIniciaActionPerformed

    private void btCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelaActionPerformed
        gridControl1.reloadData();
    }//GEN-LAST:event_btCancelaActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btConsultaMovimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultaMovimentoActionPerformed
  /*
        ViagensCVO gasC = (ViagensCVO) form1.getVOModel().getValueObject();
        form1.push();
        if ((gasC.getCodCondominio() == null) || (gasC.getMesAno() == null)) {
            JOptionPane.showMessageDialog(null, "Selecione primeiro um condomínio e informe o Mês/Ano");
            txCodCondominio.requestFocus();
        } else {
            try {
                movimentoNovo = cabControle.consultaMovimento();
            } catch (Exception ex) {
                Logger.getLogger(RateioGas.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (movimentoNovo == true) {
                form1.save();
                form1.reload();
                btImportaInquilinos.setEnabled(true);
                btConsultaMovimento.setEnabled(false);
            } else {
                form1.setMode(Consts.READONLY);
                form1.pull();
                form1.reload();
                gridControl1.reloadData();
            }
        }
        */
    }//GEN-LAST:event_btConsultaMovimentoActionPerformed

    private void btImportaInquilinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImportaInquilinosActionPerformed
      
        if (movimentoNovo == true) {
          //  detControle.carregaInquilinoNovo();
        }
        gridControl1.setMode(Consts.EDIT);
        form1.setMode(Consts.EDIT);
        btImportaInquilinos.setEnabled(false);
        btCalculaRateio.setEnabled(true);
    }//GEN-LAST:event_btImportaInquilinosActionPerformed

    private void btCalculaRateioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalculaRateioActionPerformed
     //   calculaRateio();
    }//GEN-LAST:event_btCalculaRateioActionPerformed

    private void btSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvaActionPerformed
        gridControl1.save();
    }//GEN-LAST:event_btSalvaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.openswing.swing.client.GenericButton btCalculaRateio;
    private org.openswing.swing.client.ReloadButton btCancela;
    private org.openswing.swing.client.GenericButton btConsultaMovimento;
    private org.openswing.swing.client.GenericButton btImportaInquilinos;
    private org.openswing.swing.client.InsertButton btInicia;
    private org.openswing.swing.client.GenericButton btSair;
    private org.openswing.swing.client.SaveButton btSalva;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn1;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn2;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn3;
    private org.openswing.swing.table.columns.client.DecimalColumn decimalColumn4;
    private org.openswing.swing.form.client.Form form1;
    private org.openswing.swing.client.GridControl gridControl1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private org.openswing.swing.client.LabelControl labelControl1;
    private org.openswing.swing.client.LabelControl labelControl2;
    private org.openswing.swing.client.LabelControl labelControl3;
    private org.openswing.swing.client.LabelControl labelControl4;
    private org.openswing.swing.client.LabelControl labelControl5;
    private org.openswing.swing.table.columns.client.TextColumn textColumn1;
    private org.openswing.swing.table.columns.client.TextColumn textColumn2;
    private org.openswing.swing.client.CodLookupControl txCodCondominio;
    private org.openswing.swing.client.NumericControl txFatorConversao;
    private org.openswing.swing.client.FormattedTextControl txMesAno;
    private org.openswing.swing.client.TextControl txNomeCondominio;
    private org.openswing.swing.client.NumericControl txTotalConsumos;
    private org.openswing.swing.client.CurrencyControl txValorCompra;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the txCodCondominio
     */
    public org.openswing.swing.client.CodLookupControl getTxCodCondominio() {
        return txCodCondominio;
    }

    /**
     * @return the txMesAno
     */
    public org.openswing.swing.client.FormattedTextControl getTxMesAno() {
        return txMesAno;
    }

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
        btImportaInquilinos.setEnabled(false);
        btCalculaRateio.setEnabled(false);
        btConsultaMovimento.setEnabled(false);
        /*btCancela.setEnabled(false);
        btSalva.setEnabled(false);
        btInicia.setEnabled(true);*/
        btSair.setEnabled(true);
        form1.setMode(Consts.READONLY);
    }

}
