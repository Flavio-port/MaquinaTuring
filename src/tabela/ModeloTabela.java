package tabela;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JTable;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class ModeloTabela extends AbstractTableModel {

    private Map<Integer,List<String>> linhas = new HashMap<>();
    private List<String> colunas = Stream.of(new String[]{"Estado", ">", "*"}).collect(Collectors.toList());

    public ModeloTabela(int qtdEstados, String tokens) {
        
        if(tokens != null || tokens.trim().length() > 0){
            
            List tokenSplit;
            
            if(tokens.indexOf(",") > 0){
               tokenSplit = new ArrayList<>(Arrays.asList(tokens.split(",")));
            }else{
                tokenSplit = new ArrayList<>(Arrays.asList(tokens.split(" ")));
            }
            
            colunas.addAll(tokenSplit);
        }
        
        for(int i = 0; i < qtdEstados ; i++) {
            
            ArrayList<String> col = new ArrayList();
            col.add(i+1 + "");
            
            for(int j = 1; j < colunas.size(); j++) {
                col.add("");
            }
            
            linhas.put(i, col);
        }
    }

//    public void montaTabela() {
//
//        int contColunas = 0;
//        Tokens coluna = new Tokens();
//        coluna.setCod(contColunas);
//        coluna.setNome("Estado"); 
//        colunas.add(coluna);
//        contColunas++;
//        
//        
//        
//       
//        coluna = new Tokens();
//        coluna.setCod(contColunas);
//        coluna.setNome(">"); 
//        colunas.add(coluna);
//        contColunas++;
//        
//        coluna = new Tokens();
//        coluna.setCod(contColunas);
//        coluna.setNome("*"); 
//        colunas.add(coluna);
//        contColunas++;
//        
//        
//
//        String aux = "";
//  
//        for (int i = 0; i < Integer.parseInt(estados.trim()); i++) {
//            Estado est = new Estado(i);
//            linhas.add(est);
//        }
//        for (int i = 0; i < tokens.length(); i++) {
//
//            if (tokens.charAt(i) == ',' || tokens.charAt(i) == ' ' || i == tokens.length()) {
//                coluna = new Tokens();
//                coluna.setCod(contColunas);
//                coluna.setNome(aux.trim());
//                colunas.add(coluna);
//                aux = "";
//            } else {
//                aux += tokens.charAt(i);
//            }
//        }
//     
//    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public String getValueAt(int l, int c) {
        return linhas.get(l).get(c);
    }
    
   @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        
        if(columnIndex > 0){
            return true;
        }
        
        return false;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       
        linhas.get(rowIndex).set(columnIndex, (String) aValue);
        
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}

/* //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return estados.size();
    }
    //retorna o total de colunas da tabela
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    //retorna o nome da coluna de acordo com seu indice
    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }

    //determina o tipo de dado da coluna conforme seu indice
    @Override
    public Class<?> getColumnClass(int columnIndex) {
             return String.class;      
    }

    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario funcionario = this.funcionarios.get(rowIndex);

        switch (columnIndex) {
            case COLUNA_NOME:
                return funcionario.getNome();
            case COLUNA_IDADE:
                return funcionario.getIdade();
            case COLUNA_MATRICULA:
                return funcionario.getMatricula();
            case COLUNA_ADMITIDO:
                return funcionario.isAdmitido();
        }
        return null;
    }
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //o argumento recebido pelo método é do tipo Object
        //mas como nossa tabela é de funcionários, é seguro(e até recomendável) fazer o cast de suas propriedades
        Funcionario funcionario = this.funcionarios.get(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        switch (columnIndex) {
            case COLUNA_NOME:
                funcionario.setNome(String.valueOf(aValue));
                break;
            case COLUNA_IDADE:
                funcionario.setIdade((int) aValue);
                break;
            case COLUNA_MATRICULA:
                funcionario.setMatricula((int) aValue);
                break;
            case COLUNA_ADMITIDO:
                funcionario.setAdmitido((boolean) aValue);
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}*/
