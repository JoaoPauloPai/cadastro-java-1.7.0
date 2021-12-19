package br.com.jumbo.main;

import br.com.jumbo.controller.ViagensControler;
import org.openswing.swing.tree.java.OpenSwingTreeNode;
import java.util.*;
import org.openswing.swing.mdi.client.*;

import org.openswing.swing.util.client.ClientSettings;
import org.openswing.swing.internationalization.java.EnglishOnlyResourceFactory;
import org.openswing.swing.util.client.*;
import org.openswing.swing.permissions.client.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.openswing.swing.internationalization.java.Language;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import org.openswing.swing.mdi.java.ApplicationFunction;
import org.openswing.swing.internationalization.java.XMLResourcesFactory;
import java.sql.*;
import org.openswing.swing.domains.java.Domain;
import org.openswing.swing.internationalization.java.*;

/**
 * <p>
 * Title: OpenSwing Demo</p>
 * <p>
 * Description: Used to start application from main method: it creates an MDI
 * Frame app.</p>
 * <p>
 * Copyright: Copyright (C) 2014 João Paulo</p>
 * <p>
 * </p> @author João Paulo
 *
 * @version 1.7
 */
public class Menu implements MDIController, LoginController {

    private ClienteFachada clientFacade = null;
    private Connection conn = null;
    private Hashtable domains = new Hashtable();
    private String username = null;
    private Properties idiomas = new Properties();
    //  private Domain orderStateDomain2;

    public Menu() {
        createConnection();
        clientFacade = new ClienteFachada(conn);

        //  System.out.println("conecxao ="+  DriverManager);
        Hashtable xmlFiles = new Hashtable();
        /*
         xmlFiles.put("EN","demo2/Resources_en.xml");
         xmlFiles.put("IT","demo2/Resources_it.xml");
         */
        xmlFiles.put("EN", "recursos/Resources_en.xml");
        xmlFiles.put("IT", "recursos/Resources_it.xml");
        xmlFiles.put("PT_BR", "recursos/Resources_pt_br.xml");

        ClientSettings clientSettings = new ClientSettings(
                new XMLResourcesFactory(xmlFiles, true),
                domains
        );
        ClientSettings.BACKGROUND = "background4.jpg";
        ClientSettings.TREE_BACK = "treeback2.jpg";
        ClientSettings.VIEW_BACKGROUND_SEL_COLOR = true;
        ClientSettings.VIEW_MANDATORY_SYMBOL = true;
        ClientSettings.ALLOW_OR_OPERATOR = false;
        ClientSettings.INCLUDE_IN_OPERATOR = false;
        ClientSettings.SHOW_SCROLLBARS_IN_MDI = true;
        ClientSettings.getInstance().setLanguage("PT_BR");
        //ClientSettings.IGNORE_GRID_SELECTION_FOREGROUND = true;

        idiomas.setProperty("EN", "English");
        idiomas.setProperty("IT", "Italiano");
        idiomas.setProperty("PT_BR", "Português do Brasil");
        /*
         Domain orderStateDomain = new Domain("CONTA");
         orderStateDomain.addDomainPair("ENTRADA", " 1  ENTRADA");
         orderStateDomain.addDomainPair("SAIDA", " 2  SAIDA");

         domains.clear();
         domains.put(
         orderStateDomain.getDomainId(),
         orderStateDomain
         );
         */
        LoginDialog d = new LoginDialog(
                null,
                false,
                this);
    }

    /**
     * Method called after MDI creation.
     */
    public void afterMDIcreation(MDIFrame frame) {
        GenericStatusPanel userPanel = new GenericStatusPanel();
        userPanel.setColumns(12);
        MDIFrame.addStatusComponent(userPanel);
        userPanel.setText(username);
        MDIFrame.addStatusComponent(new Clock());

    }

    /**
     * @see JFrame getExtendedState method
     */
    public int getExtendedState() {
        return JFrame.MAXIMIZED_BOTH;
    }

    /**
     * @return client facade, invoked by the MDI Frame tree/menu
     */
    public ClientFacade getClientFacade() {
        return clientFacade;
    }

    /**
     * Method used to destroy application.
     */
    public void stopApplication() {
        System.exit(0);
    }

    /**
     * Defines if application functions must be viewed inside a tree panel of
     * MDI Frame.
     *
     * @return <code>true</code> if application functions must be viewed inside
     * a tree panel of MDI Frame, <code>false</code> no tree is viewed
     */
    // Este código comentado
    public boolean viewFunctionsInTreePanel() {
        return true;
    }

    /**
     * Defines if application functions must be viewed in the menubar of MDI
     * Frame.
     *
     * @return <code>true</code> if application functions must be viewed in the
     * menubar of MDI Frame, <code>false</code> otherwise
     */
    public boolean viewFunctionsInMenuBar() {
        return false;
    }

    /**
     * @return <code>true</code> if the MDI frame must show a login menu in the
     * menubar, <code>false</code> no login menu item will be added
     */
    public boolean viewLoginInMenuBar() {
        return true;
    }

    /**
     * @return application title
     */
    public String getMDIFrameTitle() {
        return "Jumbo";
    }

    /**
     * @return text to view in the about dialog window
     */
    public String getAboutText() {
        return "        Sistema em MDI \n"
                + "\n"
                + "        Criado em 2014 \n"
                + "\n"
                + "        JUMBO V.1.7\n"
                + "\n"
                + "        Autor: João Paulo";
    }

    /**
     * @return image name to view in the about dialog window
     */
    public String getAboutImage() {
        return "about.jpg";
    }

    /**
     * @param parentFrame parent frame
     * @return a dialog window to logon the application; the method can return
     * null if viewLoginInMenuBar returns false
     */
    public JDialog viewLoginDialog(JFrame parentFrame) {
        JDialog d = new LoginDialog(
                parentFrame,
                true,
                this);
        return d;
    }

    /**
     * @return maximum number of failed login
     */
    public int getMaxAttempts() {
        JOptionPane.showMessageDialog(null, "Digite uma senha e Usuário!", "Erro no Sistema", JOptionPane.ERROR_MESSAGE);
        return 3;
    }

    /**
     * Method called by MDI Frame to authenticate the user.
     *
     * @param loginInfo login information, like username, password, ...
     * @return <code>true</code> if user is correcly authenticated,
     * <code>false</code> otherwise
     */
    public boolean authenticateUser(Map loginInfo) throws Exception {
        if ("ADMIN".equalsIgnoreCase((String) loginInfo.get("username"))
                && "ADMIN".equalsIgnoreCase((String) loginInfo.get("password"))
                || "VOVO".equalsIgnoreCase((String) loginInfo.get("username"))
                && "123".equalsIgnoreCase((String) loginInfo.get("password"))) {

            JOptionPane.showMessageDialog(null, "A Senha e Usuário estão corretos!", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
            return true;

        } else {

            return false;
        }
        //  JOptionPane.showMessageDialog(this, "O desconto não pode ser maior que o valor da nota!", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    /*
     public boolean authenticateUser(Map loginInfo) throws Exception {
     String username = loginInfo.get("u_login").toString().toUpperCase();
        
     // String username = loginInfo.get().toString()..authenticateUser(loginInfo)toUpperCase();
          
     String encpassword = new String((byte[]) loginInfo.get("u_senha"));

     PreparedStatement stmt = null;
     ResultSet rset = null;
     try {
     String sql = "select usuario.u_login, usuario.u_senha from usuario where usuario.u_login=? and usuario.u_senha=?";

     HashMap map = new HashMap();

     map.put("uLogin", "usuario.u_login");
     map.put("uSenha", "usuario.u_senha");

     stmt = conn.prepareStatement(sql);
     stmt.setString(1, username);
     stmt.setString(2, encpassword);
     rset = stmt.executeQuery();
     if (rset.next()) {
     return true;
     } else {
     return false;
     }
     } catch (Exception ex) {
     ex.printStackTrace();
     return false;
     } finally {
     try {
     rset.close();
     } catch (Exception ex1) {
     }
     try {
     stmt.close();
     } catch (Exception ex1) {
     }
     }
     }
     public void loginSuccessful(Map loginInfo) {
     username = loginInfo.get("u_login").toString().toUpperCase();

     // MDIFrame mdi = new MDIFrame(this);
     }
     */
    public static void main(String[] argv) {
        new Menu();
    }

    /**
     * Method called by LoginDialog to notify the sucessful login.
     *
     * @param loginInfo login information, like username, password, ...
     */
    public void loginSuccessful(Map loginInfo) {
        username = loginInfo.get("username").toString().toUpperCase();
        if (username.equals("ADMIN")) {
            ClientSettings.getInstance().setLanguage("EN");
        } else if (username.equals("VOVO")) {
            ClientSettings.getInstance().setLanguage("PT_BR");
        }

        Domain orderStateDomain = new Domain("ESTADOS");

        orderStateDomain.addDomainPair("AC", "  ACRE");
        orderStateDomain.addDomainPair("AP", "  AMAPÁ");
        orderStateDomain.addDomainPair("AM", "  AMAZONAS");
        orderStateDomain.addDomainPair("AL", "  ALAGOAS");
        orderStateDomain.addDomainPair("BA", "  BAHIA");
        orderStateDomain.addDomainPair("CE", "  CEARÁ");
        orderStateDomain.addDomainPair("DF", "  DESTRITO FEDERAL");
        orderStateDomain.addDomainPair("ES", "  ESPÍRITO SANTO");
        orderStateDomain.addDomainPair("GO", "  GOIÁS");
        orderStateDomain.addDomainPair("MA", "  MARANHÃO");
        orderStateDomain.addDomainPair("MS", "  MATO GROSSO DO SUL");
        orderStateDomain.addDomainPair("MT", "  MATO GROSSO");
        orderStateDomain.addDomainPair("MG", "  MINAS GERAIS");
        orderStateDomain.addDomainPair("PA", "  PARÁ");
        orderStateDomain.addDomainPair("PB", "  PARAÍBA");
        orderStateDomain.addDomainPair("PR", "  PARANÁ");
        orderStateDomain.addDomainPair("PI", "  PIAUÍ");
        orderStateDomain.addDomainPair("RJ", "  RIO DE JANEIRO");
        orderStateDomain.addDomainPair("RN", "  RIO GRANDE DO NORTE");
        orderStateDomain.addDomainPair("RS", "  RIO GRANDE DO SUL");
        orderStateDomain.addDomainPair("RO", "  RÔNDONIA");
        orderStateDomain.addDomainPair("RR", "  RORAIMA");
        orderStateDomain.addDomainPair("SC", "  SANTA CATARINA");
        orderStateDomain.addDomainPair("SP", "  SÃO PAULO");
        orderStateDomain.addDomainPair("SE", "  SERGIPE");
        orderStateDomain.addDomainPair("TO", "  TOCANTINS");

        domains.clear();
        domains.put(
                orderStateDomain.getDomainId(),
                orderStateDomain
        );

        //omain orderStateDomain2;
        //  orderStateDomain2 = new Domain("NOMES");
        // orderStateDomain2.addDomainPair("SIM", "  PARA SIM");
        //  orderStateDomain2.addDomainPair("NÂO", "  PARA NÃO");
        domains.clear();
        domains.put(
                orderStateDomain.getDomainId(),
                orderStateDomain
        );

        MDIFrame mdi = new MDIFrame(this);
//    try {
//      UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//      SwingUtilities.updateComponentTreeUI(mdi);
//    }
//    catch (Throwable ex) {
//      ex.printStackTrace();
//    }
       // mdi.addSeparatorToToolBar();
        mdi.addButtonToToolBar("viagens.png", "Cadastro de Viagéns").addActionListener(new ViagensAction());
        mdi.addSeparatorToToolBar();
        mdi.addButtonToToolBar("telaSair01.png", "Sair do Sistema").addActionListener(new SairAction());
    }

    class SairAction implements ActionListener {

        //JOptionPane.showConfirmDialog(null,"O Sistema será encerrado! \n Deseja continuar?" );
        public void actionPerformed(ActionEvent e) {
            // JOptionPane.showConfirmDialog(null,"O Sistema será encerrado! \n Deseja continuar?" );
            //  JOptionPane.showInputDialog(null,"O sistema será encerrado!");
            // JOptionPane.showInternalConfirmDialog(null, "O sistema sera encerrado!");
            stopApplication();
        }
    }

    class ViagensAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new ViagensControler(conn);
        }
    }

    /**
     * @return <code>true</code> if the MDI frame must show a change language
     * menu in the menubar, <code>false</code> no change language menu item will
     * be added
     */
    public boolean viewChangeLanguageInMenuBar() {
        return false;
    }

    /**
     * @return list of languages supported by the application
     */
    public ArrayList getLanguages() {
        ArrayList list = new ArrayList();
        list.add(new Language("EN", "English"));
        list.add(new Language("IT", "Italiano"));
        list.add(new Language("PT_BR", "Portugues"));
        return list;
    }

    /**
     * @return application functions (ApplicationFunction objects), organized as
     * a tree
     */
    public DefaultTreeModel getApplicationFunctions() {

        DefaultMutableTreeNode root = new OpenSwingTreeNode();

        DefaultTreeModel model = new DefaultTreeModel(root);

        ApplicationFunction n1 = new ApplicationFunction("Cadastro", null);
        ApplicationFunction n11 = new ApplicationFunction("Funções Empresa", null);
        ApplicationFunction n12 = new ApplicationFunction("Viagens", null);
        ApplicationFunction n13 = new ApplicationFunction("Roupas", null);

        ApplicationFunction n2 = new ApplicationFunction("Movimento", null);
        ApplicationFunction n21 = new ApplicationFunction("RateioViagens", "rateioviagens", null, "getRateioViagens");

        //ApplicationFunction n3 = new ApplicationFunction("Visualizar", null);
        //ApplicationFunction n31 = new ApplicationFunction("Bancos", "boscos", null, "getBanco");

        //  Referente a pasta Veiculos
        ApplicationFunction n111 = new ApplicationFunction("Veiculo", "veiculo", null, "getVeiculo");
        ApplicationFunction n112 = new ApplicationFunction("Colaborador", "colaborador", null, "getColaborador");
        ApplicationFunction n113 = new ApplicationFunction("Cargos", "cargos", null, "getCargos");
        ApplicationFunction n114 = new ApplicationFunction("Pessoas", "pessoas", null, "getPessoas");

        //  ApplicationFunction n13 = new ApplicationFunction(true);
        //  Referente a pasta Viagens
        ApplicationFunction n121 = new ApplicationFunction("Produto", "produto", null, "getProduto");
        ApplicationFunction n122 = new ApplicationFunction("Viagens", "viagens", null, "getViagens");

        //   ApplicationFunction n16 = new ApplicationFunction(true);
        // Referente a pasta Roupas
        ApplicationFunction n131 = new ApplicationFunction("Cores", "cores", null, "getCores");
        ApplicationFunction n132 = new ApplicationFunction("Modelos", "modelos", null, "getModelos");
        ApplicationFunction n133 = new ApplicationFunction("Endereços", "endereco", null, "getEndereco");
        ApplicationFunction n134 = new ApplicationFunction("Roupas", "roupas", null, "getRoupas");
        
        
        ApplicationFunction n4 = new ApplicationFunction("Relatórios", null);
         ApplicationFunction n41 = new ApplicationFunction("Relatórios Viagens", null);
       ApplicationFunction n411 = new ApplicationFunction("Data Viagéns","viagens",null,"getViagensRelatorio");
       ApplicationFunction n412 = new ApplicationFunction("Graficos Viagéns","viagens",null,"getViagensGraficos"); 
       
        // ApplicationFunction n31 = new ApplicationFunction("Folder31",null);
        //ApplicationFunction n311 = new ApplicationFunction("Function4","F4",null,"getF4");
        //ApplicationFunction n312 = new ApplicationFunction("Function5","F5",null,"getF5");
        //  n1.add(n10);
        n1.add(n11);
        n1.add(n12);
        n1.add(n13);

        n11.add(n111);
        n11.add(n112);
        n11.add(n113);
        n11.add(n114);

        n12.add(n121);
        n12.add(n122);

        n13.add(n131);
        n13.add(n132);
        n13.add(n133);
        n13.add(n134);
        
         n4.add(n41);
         n41.add(n411);
         n41.add(n412);

        n2.add(n21);

        //n3.add(n31);
        // n31.add(n311);
        // n31.add(n312);
        root.add(n1);
        root.add(n2);
       // root.add(n3);
        root.add(n4);

        return model;
    }

    /**
     * Create the database connection (using Hypersonic DB - in memory) and
     * initialize tables...
     */
    private void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            // conn = DriverManager.getConnection("jdbc:mysql://192.168.0.10:3306/jumbo1_7?user=root&password=1234");;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/jumbo1_6?user=root&password=1234");;
            //localhost senha = 1234
            //192.168.0.10
            JOptionPane.showMessageDialog(null, "O Sistema está conectado ao banco de dados!", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
            // JOptionPane.showMessageDialog(null, "teste1", "teste2", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return <code>true</code> if the MDI frame must show a panel in the
     * bottom, containing last opened window icons, <code>false</code> no panel
     * is showed
     */
    public boolean viewOpenedWindowIcons() {
        return true;
    }

    /**
     * @return <code>true</code> if the MDI frame must show the "File" menu in
     * the menubar of the frame, <code>false</code> to hide it
     */
    public boolean viewFileMenu() {
        return true;
    }

}
