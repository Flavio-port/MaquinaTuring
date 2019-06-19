/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Maquina.Maquina;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import tabela.ModeloTabela;

/**
 *
 * @author comp9
 */
public class telaPrincipal extends javax.swing.JFrame {

    ModeloTabela modelo;
    String fita;

    /**
     * Creates new form telaPrincipal
     */
    public telaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFita = new javax.swing.JTextField();
        btnCriaTabela = new javax.swing.JButton();
        txtQuantidadeEstado = new javax.swing.JTextField();
        txtTokens = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAcoes = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("telaPrincipal");
        setMaximumSize(new java.awt.Dimension(250, 250));
        setMinimumSize(new java.awt.Dimension(250, 250));
        setPreferredSize(new java.awt.Dimension(600, 550));
        getContentPane().setLayout(null);

        txtFita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFitaActionPerformed(evt);
            }
        });
        getContentPane().add(txtFita);
        txtFita.setBounds(130, 20, 262, 29);

        btnCriaTabela.setText("Cria Tabela de Ações");
        btnCriaTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriaTabelaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCriaTabela);
        btnCriaTabela.setBounds(396, 74, 133, 23);
        getContentPane().add(txtQuantidadeEstado);
        txtQuantidadeEstado.setBounds(220, 80, 90, 30);

        txtTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTokensActionPerformed(evt);
            }
        });
        getContentPane().add(txtTokens);
        txtTokens.setBounds(220, 120, 90, 30);

        jLabel1.setText("Informe a Fita :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(18, 34, 180, 14);

        jLabel2.setText("Informe a quantidade de Estados :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 90, 210, 14);

        jLabel3.setText("Informe os Tokens :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 130, 180, 14);

        tabelaAcoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaAcoes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 200, 510, 220);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Os tokens de espaço (_) e simbolo inicial (>) já estão cadastrados");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 160, 510, 14);

        jButton1.setText("Executa Maquina");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(400, 120, 130, 23);

        jLabel5.setText("Utilize o simbolo > como inicial");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(180, 50, 150, 14);

        setSize(new java.awt.Dimension(632, 481));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriaTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriaTabelaActionPerformed
        fita = txtFita.getText().trim();
        String numeroEstado = txtQuantidadeEstado.getText().trim();
        String Tokens = txtTokens.getText().trim();
        modelo = new ModeloTabela(Integer.parseInt(numeroEstado), Tokens.toUpperCase());
        tabelaAcoes.setModel(modelo);
        tabelaAcoes.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnCriaTabelaActionPerformed

    private void txtFitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFitaActionPerformed


    }//GEN-LAST:event_txtFitaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Maquina maquina = new Maquina();
        /* modelo.setValueAt1(0, 1, "0,>,d");
         modelo.setValueAt1(0, 2, "0,*,D");
          modelo.setValueAt1(0, 3, "1,_,D");
           modelo.setValueAt1(1, 2, "1,*,d");
            modelo.setValueAt1(1, 3, "Fim,_,d");*/
        try {
            String resultado = maquina.analisaFita(fita, modelo);//">*** **"
            JOptionPane.showMessageDialog(this, "Executado com sucesso o seu resultado é: " + resultado);
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, "Erro em sua fita ou em sua tabela de ações");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTokensActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTokensActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriaTabela;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAcoes;
    private javax.swing.JTextField txtFita;
    private javax.swing.JTextField txtQuantidadeEstado;
    private javax.swing.JTextField txtTokens;
    // End of variables declaration//GEN-END:variables
}
