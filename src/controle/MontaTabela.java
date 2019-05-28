/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.swing.JTable;

/**
 *
 * @author comp9
 */
public class MontaTabela {
    String[] coluna;
   public JTable monta(String tokens, JTable tabela,int estados){
 
    String montaToken="";
    
    for(int i=0; i<tokens.length();i++){
        if(tokens.charAt(i)==' ' || i==tokens.length()){
            montaToken+=tokens.charAt(i);
            adicionaColuna(montaToken.trim());
            montaToken="";
        }else{
            montaToken+= tokens.charAt(i);
            i++;
        }
    } 
  for(int i=0;)
    tabela.setRowHeight(estados);
       return tabela;
   }
   public void adicionaColuna(String token){
       for(int i=0;i<coluna.length;i++){
           if(coluna[i]==null){
               coluna[i]= token.trim();
               break;
           }
           i++;
       }       
   }
}
