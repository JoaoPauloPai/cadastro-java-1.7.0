package br.com.jumbo.main;

import java.util.*;
import org.openswing.swing.mdi.client.*;
import org.openswing.swing.util.client.ClientSettings;
import org.openswing.swing.internationalization.java.EnglishOnlyResourceFactory;
import org.openswing.swing.util.client.*;
import org.openswing.swing.permissions.client.*;
import javax.swing.*;
import org.openswing.swing.internationalization.java.Language;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import org.openswing.swing.mdi.java.ApplicationFunction;
import org.openswing.swing.client.SplashScreen;
import org.openswing.swing.tree.java.OpenSwingTreeNode;
import java.awt.Event;
import java.awt.BorderLayout;
import java.awt.Dimension;


/**
 * <p>Title: OpenSwing Demo</p>
 * <p>Description: Used to start application from main method:
 * it creates an MDI Frame app with 5 functions viewed in the menu tree and in the menubar</p>
 * <p>Copyright: Copyright (C) 2006 Mauro Carniel</p>
 * <p> </p>
 * @author Mauro Carniel
 * @version 1.0
 */
public class ClientApplication implements MDIController,LoginController {


//  private DemoClientFacade clientFacade = new DemoClientFacade();

  public ClientApplication(String[] argv) {
    Properties props = new Properties();

    ClientSettings clientSettings = new ClientSettings(
        new EnglishOnlyResourceFactory("E",props,true),
        new Hashtable()
    );

//    Enumeration k = System.getProperties().keys();
//    while(k.hasMoreElements()) {
//      String kk = k.nextElement().toString();
//      System.out.println(kk+"="+System.getProperty(kk));
//    }
//    System.out.println(ClientSettings.LOOK_AND_FEEL_CLASS_NAME);


    ClientSettings.BACKGROUND = "background3.jpg";
    ClientSettings.TREE_BACK = "treeback2.jpg";
    ClientSettings.AUTO_EXPAND_TREE_MENU = true;
    ClientSettings.MIN_MENU_WIDTH = 300;
    ClientSettings.DIVIDER_WIDTH = 0;
//    ClientSettings.AUTO_EXPAND_SUBTREE_MENU = "Folder3";

    if(argv.length==1)
      ClientSettings.LOOK_AND_FEEL_CLASS_NAME = argv[0];

//    ClientSettings.MAX_MENU_WIDTH = 300;
//    ClientSettings.MENU_WIDTH = 300;

    MDIFrame mdi = new MDIFrame(this);
//    mdi.setLocked(false);
  }


  /**
   * Method called after MDI creation.
   */
  public void afterMDIcreation(MDIFrame frame) {
    frame.addButtonToToolBar("new.gif","New Record");
    frame.addButtonToToolBar("edit.gif","Edit Record");
    frame.addButtonToToolBar("reload.gif","Undo/Refresh Record");
    frame.addButtonToToolBar("save.gif","Save Record");
    frame.addButtonToToolBar("del.gif","Delete Record");
    frame.setBorderPainterOnToolBar(false);
    frame.setFloatableOnToolBar(false);
    frame.setRolloverOnToolBar(false);
    new SplashScreen(frame,"about.jpg",getMDIFrameTitle(),5);
    frame.getMenuItem("F2").setMnemonic('2');

//    JPanel rightPanel = new JPanel();
//    rightPanel.setBorder(BorderFactory.createTitledBorder("Right Panel"));
//    rightPanel.setPreferredSize(new Dimension(150,frame.getHeight()));
//    frame.getContentPane().add(rightPanel,BorderLayout.EAST);

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
//  public ClientFacade getClientFacade() {
//    return clientFacade;
 // }


  /**
   * Method used to destroy application.
   */
  public void stopApplication() {
    System.exit(0);
  }


  /**
   * Defines if application functions must be viewed inside a tree panel of MDI Frame.
   * @return <code>true</code> if application functions must be viewed inside a tree panel of MDI Frame, <code>false</code> no tree is viewed
   */
  public boolean viewFunctionsInTreePanel() {
    return true;
  }


  /**
   * Defines if application functions must be viewed in the menubar of MDI Frame.
   * @return <code>true</code> if application functions must be viewed in the menubar of MDI Frame, <code>false</code> otherwise
   */
  public boolean viewFunctionsInMenuBar() {
    return true;
  }


  /**
   * @return <code>true</code> if the MDI frame must show a login menu in the menubar, <code>false</code> no login menu item will be added
   */
  public boolean viewLoginInMenuBar() {
    return false;
  }


  /**
   * @return application title
   */
  public String getMDIFrameTitle() {
    return "Demo";
  }


  /**
   * @return text to view in the about dialog window
   */
  public String getAboutText() {
    return
        "<html><body><p style='font-family: Arial,sans-serif;font-size:12'>This is an MDI Frame demo application<br>"+
        "<br>"+
        "Copyright: Copyright (C) 2006 Mauro Carniel<br>"+
        "<a href='http://oswing.sourceforge.net'>OpenSwing home page</a><br>"+
        "Author: Mauro Carniel</body></html>";
  }


  /**
   * @return image name to view in the about dialog window
   */
  public String getAboutImage() {
    return "about.jpg";
  }


  /**
   * @param parentFrame parent frame
   * @return a dialog window to logon the application; the method can return null if viewLoginInMenuBar returns false
   */
  public JDialog viewLoginDialog(JFrame parentFrame) {
    return null;
  }



  /**
   * @return maximum number of failed login
   */
  public int getMaxAttempts() {
    return 0;
  }


  /**
   * Method called by MDI Frame to authenticate the user.
   * @param loginInfo login information, like username, password, ...
   * @return <code>true</code> if user is correcly authenticated, <code>false</code> otherwise
   */
  public boolean authenticateUser(Map loginInfo) throws Exception {
    return true;
  }



  public static void main(String[] argv) {
    new ClientApplication(argv);
  }


  /**
   * Method called by LoginDialog to notify the sucessful login.
   * @param loginInfo login information, like username, password, ...
   */
  public void loginSuccessful(Map loginInfo) {

  }


  /**
   * @return <code>true</code> if the MDI frame must show a change language menu in the menubar, <code>false</code> no change language menu item will be added
   */
  public boolean viewChangeLanguageInMenuBar() {
    return false;
  }


  /**
   * @return list of languages supported by the application
   */
  public ArrayList getLanguages() {
    ArrayList list = new ArrayList();
    list.add(new Language("EN","English"));
    return list;
  }


  /**
   * @return application functions (ApplicationFunction objects), organized as a tree
   */
  public DefaultTreeModel getApplicationFunctions() {
    ApplicationFunction root = new ApplicationFunction("Function0","F0",null,"getF0");
//    DefaultMutableTreeNode root = new OpenSwingTreeNode();
    DefaultTreeModel model = new DefaultTreeModel(root);
    ApplicationFunction n1 = new ApplicationFunction("Folder1",null);
    ApplicationFunction n2 = new ApplicationFunction("Folder2",null);
    ApplicationFunction n3 = new ApplicationFunction("Folder3",null);

    ApplicationFunction n11 = new ApplicationFunction("Function1","F1",null,"getF1");
    n11.setShortCut(new Character('1'));

    ApplicationFunction n21 = new ApplicationFunction("Function2","F2",null,"getF2");
    n21.setAccelerator(KeyStroke.getKeyStroke('F',Event.CTRL_MASK));

    ApplicationFunction n22 = new ApplicationFunction("Function3","F3",null,"getF3");
    ApplicationFunction n31 = new ApplicationFunction("Folder31",null);
    ApplicationFunction n311 = new ApplicationFunction("Function4","F4",null,"getF4");
    ApplicationFunction n312 = new ApplicationFunction("Function5","F5",null,"getF5");
    n1.add(n11);
    n2.add(n21);
    n2.add(n22);
    n3.add(n31);
    n31.add(n311);
//    n31.add(n312);
    root.add(n312);
    root.add(n1);
    root.add(n2);
    root.add(n3);

    return model;
  }


  /**
   * @return <code>true</code> if the MDI frame must show a panel in the bottom, containing last opened window icons, <code>false</code> no panel is showed
   */
  public boolean viewOpenedWindowIcons() {
    return true;
  }


  /**
   * @return <code>true</code> if the MDI frame must show the "File" menu in the menubar of the frame, <code>false</code> to hide it
   */
  public boolean viewFileMenu() {
    return true;
  }

    @Override
    public ClientFacade getClientFacade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
