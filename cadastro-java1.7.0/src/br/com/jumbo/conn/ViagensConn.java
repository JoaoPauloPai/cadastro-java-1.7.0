/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */

package br.com.jumbo.conn;

import br.com.jumbo.main.Menu;
import conecxao.AcessoBD;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author vovo
 */
public class ViagensConn {
    
     private Connection conn = null;

    public ViagensConn(Connection conn) {
        
        this.conn = conn;
    
    
      // AcessoBD acessoBd = new AcessoBD();
       
      // private void  ActionPerformed(java.awt.event.ActionEvent evt) {
            AcessoBD acessoBd = new AcessoBD();
               
        try {
              HashMap parametros = new HashMap();
            parametros.put("DATA_INICIO", new Date("2014/01/01"));
            parametros.put("DATA_FIM", new Date("2016/12/31"));
            
            JasperPrint jp = JasperFillManager.fillReport(System.getProperty("user.dir") + "\\relatorios\\RelatorioDataViagem.jasper", parametros, acessoBd.getConexao());
            JasperViewer.viewReport(jp, false);
          //  Principal.close();
        } catch (JRException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            
        // Principal.close();
          //JFrame.EXIT_ON_CLOSE
        }
       }

    private Connection conn() {
        
        this.conn = conn;
         return null;
    }
}

