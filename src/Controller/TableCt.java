/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class TableCt extends AbstractTableModel{
    private List<String[]> linhas;
    private String[] colunas = new String[]{"Codigo de barras","Nome","volume","Quantidade","Valor Venda","Valor venda"};

    public TableCt() {
        linhas = new ArrayList<String[]>();
    }

    public TableCt(List<String[]> linhas) {
        linhas = new ArrayList<String[]>(linhas);
    }
    
    

    @Override
    public int getColumnCount() {        
        return colunas.length;
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String t[] = linhas.get(rowIndex);
        
        switch(columnIndex){
            case 0: return t[0];
            case 1: return t[1];
            case 2: return t[2];
            case 3: return t[3];
            case 4: return t[4];
            case 5: return t[5];
            default: return null;
        }
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        String t[] = linhas.get(rowIndex);
        
        switch(columnIndex){
            case 0: t[0] = aValue.toString(); break;
            case 1: t[1] = aValue.toString(); break;
            case 2: t[2] = aValue.toString(); break;
            case 3: t[3] = aValue.toString(); break;
            case 4: t[4] = aValue.toString(); break;
            case 5: t[5] = aValue.toString(); break;
            default: 
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    public String[] getProduto(int indiceLinha){
        return linhas.get(indiceLinha);
    }
    public void addProduto(String[] t){
        linhas.add(t);
        int ultimoIndice = getRowCount() -1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    public void RemoverProduto(int indiceLinha){
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
}

