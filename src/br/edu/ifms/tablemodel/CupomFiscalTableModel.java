/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.tablemodel;

import br.edu.ifms.model.ItensVenda;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Michell
 * @author Kleber
 */
public class CupomFiscalTableModel extends AbstractTableModel {

    final List<String> cabecalho;
    private List<ItensVenda> listaDeItensDaVenda;

    public void setListaVenda(List<ItensVenda> listaVendas) {
        this.listaDeItensDaVenda = listaVendas;
    }

    public CupomFiscalTableModel() {
        cabecalho = new ArrayList<>();
        listaDeItensDaVenda = new ArrayList<>();

        cabecalho.add("Nome Produto");
        cabecalho.add("Qtd");
        cabecalho.add("Preço");
        cabecalho.add("Soma");

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
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        switch (columnIndex) {
            case 0:
                //retornar o nome produto
                return listaDeItensDaVenda.get(rowIndex).getProdutos().getNome();
            case 1:
                //retornar a qtd
                return listaDeItensDaVenda.get(rowIndex).getQtd();
            case 2:
                //retornar o preço
                return df.format(listaDeItensDaVenda.get(rowIndex).getProdutos().getPreco());
            case 3:
                //retornar a soma
                return df.format(listaDeItensDaVenda.get(rowIndex).getQtd()
                        * listaDeItensDaVenda.get(rowIndex).getProdutos().getPreco());
            default:
                return null;
        }
    }

}
