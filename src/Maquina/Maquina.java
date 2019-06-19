/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maquina;

import tabela.ModeloTabela;


public class Maquina {

    String resultado;
    String transicao;
    String estado;
    String direcao;
    char escreve;
    StringBuffer fitaB;

    public String analisaFita(String fita, ModeloTabela modelo) {// fita 

        int cabecote = 0;
        estado="0";
        escreve='>';
        int inicio =0;
        montaFita(fita);
        transicao=modelo.getTransicao(Integer.parseInt(estado),escreve); 
        while (!estado.equals("Fim")) {
           if(inicio!=0){
           transicao=modelo.getTransicao(Integer.parseInt(estado),fitaB.charAt(cabecote));   
           } 
            
            desmembraTransicao(transicao);
            fitaB.setCharAt(cabecote, escreve);
            if (direcao.toUpperCase().equals("D")) {               
                cabecote++;
                if(inicio ==0){
                    inicio++;
                }
                
            } else if (direcao.toUpperCase().equals("E") && cabecote >= 0) {
                cabecote--;
                 if(inicio ==0){
                    inicio++;
                }
            } else {
                return "Erro na Tabela de Ações";
            }
           

        }
        tiraIcone();
        return resultado = new String(fitaB.toString());
    }

    public void desmembraTransicao(String transicao) {
        String aux = "";
        int contvirg = 0;
        
        for (int i = 0; i < transicao.length(); i++) {
            char atual= transicao.charAt(i);
            if (transicao.charAt(i) == ',' && contvirg == 0) {
                estado = aux;
                aux = "";
                contvirg++;
              
            } else if (transicao.charAt(i) == ',' && contvirg == 1) {
                escreve = aux.trim().charAt(0);
                aux = "";
                contvirg++;
                
            } else if (i + 1 == transicao.length()) {
                aux+=transicao.charAt(i);
                direcao = aux;
            }else{
                 aux += transicao.charAt(i);
            }
        }
    }
    public void montaFita(String fitaAntes){
        fitaB= new StringBuffer(fitaAntes);
        for(int i=0;i<fitaB.length();i++){
        if(fitaB.charAt(i)==' '){
            fitaB.setCharAt(i, '_');
        }
        }
        fitaB.append("_");
    }
    public void tiraIcone(){
        for(int i=0;i<fitaB.length();i++){
        if(fitaB.charAt(i)=='_'){
            fitaB.setCharAt(i, ' ');
        }
        }
    }

}
