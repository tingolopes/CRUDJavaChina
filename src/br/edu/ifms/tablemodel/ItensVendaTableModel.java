/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.tablemodel;

import br.edu.ifms.model.ItensVenda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Michell
 * @author Kleber
 */
public class ItensVendaTableModel extends AbstractTableModel {

    final List<String> cabecalho;
    private List<ItensVenda> listaDeItensDaVenda;

    public void setListaVenda(List<ItensVenda> listaVendas) {
        this.listaDeItensDaVenda = listaVendas;
    }

    public ItensVendaTableModel() {
        cabecalho = new ArrayList<>();
        listaDeItensDaVenda = new ArrayList<>();

        cabecalho.add("ID");
        cabecalho.add("Nome Produto");
        cabecalho.add("Qtd");
        cabecalho.add("Valor");
    }

    @Override
    public String getColumnName(int column) {
        return cabecalho.get(column);
    }

    @Override
    public int getRowCount() {
        return listaDeItensDaVenda.size();
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
                return listaDeItensDaVenda.get(rowIndex).getId();
            case 1:
                //retornar o nome produto
                return listaDeItensDaVenda.get(rowIndex).getProdutos().getNome();
            case 2:
                //retornar a qtd
                return listaDeItensDaVenda.get(rowIndex).getQtd();
            case 3:
                //retornar a qtd
                return listaDeItensDaVenda.get(rowIndex).getQtd()
                        * listaDeItensDaVenda.get(rowIndex).getProdutos().getPreco();
            default:
                return null;
        }
    }

}
