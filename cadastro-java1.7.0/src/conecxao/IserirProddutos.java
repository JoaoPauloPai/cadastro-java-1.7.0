/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conecxao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Joao
 */
public class IserirProddutos {
    public static void main (String [] args)
       {
       try { 
           
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jumbo";
        Connection con = DriverManager.getConnection(url, "root", "1234" );
        
    //    System.out.println("con = "+ con);
       // System.out.println("Produtos da Tabela ");
        Statement statement = con.createStatement();
        statement.executeUpdate ("Insert into viagens  ( cod_Vi, vi_Dat_Car, vi_Dat_Des, vi_Data, vi_Mes_Ref, vi_Loc_Car, vi_Loc_Des,"
                + " vi_Valor_Ton, vi_Peso_Total, vi_Num_Nf, vi_Obs) "
                + "values (12, '26/11/13', '01/13/13', '22/11/13', '12/13', 'Armazem binote, Lucas do Rio Verde', 'ARAGUARI-MG','170,00', '48,35', "
                + "'43234567', 'Não gastei muito nesta viagem' )");
        
        System.out.println("Dados inseridos com susseso.");

    } catch (ClassNotFoundException e) {
        // Aqui nao funciona o System.out
             // System.out.println("Erro ao inserir os produtos!");
  
        e.printStackTrace();
        
       // System.out.println("Erro ao inserir o produto!");
        
    } catch (SQLException e) {
       e.printStackTrace(); 
               System.out.println("Erro ao inserir o produto!!");
               

    }
       }
    
}

