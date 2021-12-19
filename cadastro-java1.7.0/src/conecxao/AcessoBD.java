/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */

package conecxao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author vovo
 */
public class AcessoBD {
       private Connection con;
    
    public Connection getConexao(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/jumbo1_6?user=root&password=1234");
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
    
    public void desconectar(){
        try{
            con.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
