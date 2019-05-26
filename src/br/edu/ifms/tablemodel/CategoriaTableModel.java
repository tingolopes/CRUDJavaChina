/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.edu.ifms.model.Categoria;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Michell
 * @author Kleber
 */
public class CategoriaTableModel extends AbstractTableModel {

    private final List<String> cabecalho;
    private List<Categoria> listaCategorias;

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public CategoriaTableModel() {
        cabecalho = new ArrayList<>();
        listaCategorias = new ArrayList<>();

        cabecalho.add("ID");
        cabecalho.add("Nome");
//        cabecalho.add("Qtde Produtos");
//        cabecalho.add("Total da Categoria");
    }

    @Override
    public String getColumnName(int column) {
        return cabecalho.get(column);
    }

    @Override
    public int getRowCount() {
        return listaCategorias.size();
    }

    @Override
    public int getColumnCount() {
        return cabecalho.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                //retornar o id
                return listaCategorias.get(rowIndex).getId();
            case 1:
                //retornar o nome
                return listaCategorias.get(rowIndex).getNome(); //Nome
//            case 2:
//                //retornar o Quantidade de Produtos
////                return listaCategorias.get(rowIndex).getQtdProduto();
//                return "requisito adiado getQtdProduto()";
//            case 3:
//                //retornar o Soma por categoria
//                DecimalFormat df = new DecimalFormat();
//                df.applyPattern("R$ #,##0.00");
////                return df.format(listaCategorias.get(rowIndex).getSomaCategoria());
//                return "requisito adiado getSomaCategoria()";
            default:
                return null;
        }
    }

}
