/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maquina;

/**
 *
 * @author Agil Suporte
 */
public class Maquina {

    String resultado;
    String transicao = "0,>,D";
    String estado = "0";
    String direcao;
    char escreve;

    public String analisaFita(String fita/*tabela*/) {// fita 

        int cabecote = 0;
        StringBuffer fitaB = new StringBuffer(fita);

        while (!estado.equals("Fim")) {
            //chamar função busca transicao que ira trazer a transicao do item > e o estado 0 que sera 
            //exemplo 0,>,D se a busca for nulla erro tabela de transição errada 
            desmembraTransicao(transicao);
            fitaB.setCharAt(cabecote, escreve);
            if (direcao.toUpperCase().equals("D")) {
                cabecote++;
            } else if (direcao.toUpperCase().equals("E") && cabecote >= 0) {
                cabecote--;
            } else {
                return "Erro na Tabela de Ações";
            }
           

        }

        return resultado = new String(fitaB.toString());
    }

    public void desmembraTransicao(String transicao) {
        String aux = "";
        int contvirg = 0;
        for (int i = 0; i < transicao.length(); i++) {
            aux += transicao.charAt(i);
            if (transicao.charAt(i) == ',' && contvirg == 0) {
                estado = aux;
                aux = "";
                contvirg++;
                i++;
            } else if (transicao.charAt(i) == ',' && contvirg == 1) {
                escreve = aux.trim().charAt(0);
                aux = "";
                contvirg++;
                i++;
            } else if (i + 1 == transicao.length()) {
                direcao = aux;
            }
        }
    }

}