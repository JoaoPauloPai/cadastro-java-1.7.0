/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conecxao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Joao
 */
public class Conecxao {
    public static void main (String [] args)
    {
       try { 
           
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jumbo";
        Connection con = DriverManager.getConnection(url, "root", "1234" );

     //   System.out.println("con = "+ con);
                System.out.println("Produtos da Tabela ");

        
        Statement statement = con.createStatement();
        

        
        ResultSet rs = statement.executeQuery("Select * from banco");
        
        if (rs.first())
        {
            do
            { 
            System.out.println(rs.getInt("cod_banco")+"  " + rs.getInt("cod_compensacao")+"  "  +rs.getString("nome_banco")+"  "+rs.getString("site_banco")+" ");
        
            
        } while (rs.next());
            }
        
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        
    } catch (SQLException e) {
       e.printStackTrace(); 
    }
       }
    }
 
