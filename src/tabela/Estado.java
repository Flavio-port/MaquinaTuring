/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabela;

public class Estado {

    int id;
    String acao;

    public Estado(int nome) {

    }

    public Estado(int nome, String acao) {
        this.id = nome;
        this.acao = acao;
    }

    public int getNome() {
        return id;
    }

    public void setNome(int nome) {
        this.id = nome;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
}
