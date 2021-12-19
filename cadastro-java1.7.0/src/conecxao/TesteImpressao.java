/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conecxao;

import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;

/**
 *
 * @author Joao
 */
public class TesteImpressao {
    
    public static void main(String[] args){
        
    
    PrinterMatrix printer = new PrinterMatrix();
    
    Extenso e = new Extenso();
    e.setNumber(101.85);
    
    //Define o tamanho do papel/tela para impressão, aqui 25 linhas e 80 colunas
    printer.setOutSize(25, 80);
    
    //Imprime * da 2ª linha a 25 na culuna 1
    printer.printCharAtLin(2, 25, 1, "*");
    
    //Imprime * da 1ª linha a 80
    printer.printCharAtCol(1, 1,  80, "*");
    
    //Imprime * da 2ª linha a 25 na coluna 1
    printer.printCharAtLin(2, 25, 80, "*");
    
    //Imprime 0 na linha 4 coluna 5
    printer.printTextLinCol(4, 5, e.toString());
    
    
    //printer.printTextLinCol(arg0, arg1, arg2);
    
    //Imprime Teste na linha 14 e coluna 40
   // printer.printTextLinCol(14, 40, "Teste");
    
    //Imprime * na linha 25 da coluna 1 a 80
    printer.printCharAtCol(25, 1, 80, "*");
    
    //Imprimir imprimindo em moodo texto na linha 14 e coluna 10
    printer.printTextLinCol(14, 10, "Imprimindo em modo de texto");
    
    printer.printTextLinCol(15, 11, "Imprimindo novo texto"); 
    //Imprimir - na linha 13 da 2 coluna a 79
    printer.printCharAtCol(13, 2, 79, "-");
    
    //Imprimir - na linha 15 da 2 coluna a 79
    printer.printCharAtCol(15, 2, 79, "-");
    
    //Imprimir + da linha 17 a 24 da coluna 50 a 79
    printer.printCharAtLinCol(17, 24, 50, 79, "+");
    
  //  printer.toImageFile(System.getProperty("user.dir")+"\\src\\impressao\\impressao.jpg");
    //printer.toFile("impressao.txt");
      printer.toImageFile("impressao.jpg");
   
    printer.mapearDocumentoImageFile(25, 80, "impressao.jpg");
    
   // String arg[] = {""};
    
   // TesteImpressao.main(arg);
    
    
    
}
}
