package tabela;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {

    private Map<Integer, List<String>> linhas = new HashMap<>();
    private List<String> colunas = Stream.of(new String[]{"Estado", ">", "*", "_"}).collect(Collectors.toList());
    public ModeloTabela(int qtdEstados){
        montaTabela(qtdEstados);
    }

    public ModeloTabela(int qtdEstados, String tokens) {

        if (tokens != null || tokens.trim().length() > 0) {

            List tokenSplit;

            if (tokens.indexOf(",") > 0) {
                tokenSplit = new ArrayList<>(Arrays.asList(tokens.split(",")));
            } else {
                tokenSplit = new ArrayList<>(Arrays.asList(tokens.split(" ")));
            }

            colunas.addAll(tokenSplit);
        }
        montaTabela(qtdEstados);

      
    }

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

        if (columnIndex > 0) {
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

    public String getColumnName(int columnIndex) {
        return colunas.get(columnIndex);
    }

    public String getTransicao(Integer estado, char token) {
        List<String> linha = linhas.get(estado);
        String tokens = "" + token;
        if (linha != null) {
            int idxColuna = 0;

            for (; idxColuna < colunas.size(); idxColuna++) {
                if (tokens.equals(colunas.get(idxColuna))) {
                    break;
                }
            }

            //TODO: idx > colunas.size
            return linha.get(idxColuna);
        }

        return null;
    }

    public void setValueAt1(int i, int i0, String d) {
        linhas.get(i).set(i0, d);
        fireTableDataChanged();
    }
    public void montaTabela( int qtdEstados){
          for (int i = 0; i < qtdEstados; i++) {

            ArrayList<String> col = new ArrayList();
            col.add(i + "");

            for (int j = 1; j < colunas.size(); j++) {
                col.add("");
            }

            linhas.put(i, col);
        }
    }

}
