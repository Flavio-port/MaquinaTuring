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
    String ler;

    public String analisaFita(String fita, ModeloTabela modelo) {// fita 

       int cabecote = 0;
        estado = "0";
        int inicio = 0;
        montaFita(fita);
        ler =""+fitaB.charAt(cabecote);
        transicao = modelo.getTransicao(Integer.parseInt(estado), fitaB.charAt(cabecote));
        StringBuffer verificaFita = null;
        while (!estado.equals("Fim")) {
            if (inicio != 0) {
                ler =""+fitaB.charAt(cabecote);
                transicao = modelo.getTransicao(Integer.parseInt(estado), fitaB.charAt(cabecote));
                desmembraTransicao(transicao);
                resultado += escreve;
            } else {
                desmembraTransicao(transicao);
                resultado = "" + escreve;
            }

            if (direcao.toUpperCase().equals("D")) {
                cabecote++;
                if (inicio == 0) {
                    inicio++;
                }

            } else if (direcao.toUpperCase().equals("E") && cabecote >= 0) {
                cabecote--;
                if (inicio == 0) {
                    inicio++;
                }
            } else {
                return "Erro na Tabela de Ações";
            }

        }

        tiraIcone();
        return resultado;
    }

    public void desmembraTransicao(String transicao) {
        String aux = "";
        int contvirg = 0;

        for (int i = 0; i < transicao.length(); i++) {
            char atual = transicao.charAt(i);
            if (transicao.charAt(i) == ',' && contvirg == 0) {
                estado = aux;
                aux = "";
                contvirg++;

            } else if (transicao.charAt(i) == ',' && contvirg == 1) {
                escreve = aux.trim().charAt(0);
                aux = "";
                contvirg++;

            } else if (i + 1 == transicao.length()) {
                aux += transicao.charAt(i);
                direcao = aux;
            } else {
                aux += transicao.charAt(i);
            }
        }
    }

    public void montaFita(String fitaAntes) {
        fitaB = new StringBuffer(fitaAntes);
        for (int i = 0; i < fitaB.length(); i++) {
            if (fitaB.charAt(i) == ' ') {
                fitaB.setCharAt(i, '-');
            }
        }
        fitaB.append("-");
    }

    public void tiraIcone() {
        for (int i = 0; i < fitaB.length(); i++) {
            if (fitaB.charAt(i) == '-') {
                fitaB.setCharAt(i, ' ');
            }
        }
    }

}
