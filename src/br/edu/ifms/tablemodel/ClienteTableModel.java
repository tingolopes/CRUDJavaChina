/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.edu.ifms.model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Michell
 * @author Kleber
 */
public class ClienteTableModel extends AbstractTableModel {

    private final List<String> cabecalho;
    private List<Cliente> listaClientes;

    public void setListaClientes(List<Cliente> listaCliente) {
        this.listaClientes = listaCliente;
    }

    public ClienteTableModel() {
        cabecalho = new ArrayList<>();
        listaClientes = new ArrayList<>();

        cabecalho.add("ID");
        cabecalho.add("Nome");
        cabecalho.add("Endereço");
    }

    @Override
    public String getColumnName(int column) {
        return cabecalho.get(column);
    }

    @Override
    public int getRowCount() {
        return listaClientes.size();
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
                return listaClientes.get(rowIndex).getId();
            case 1:
                //retornar o nome
                return listaClientes.get(rowIndex).getNome();
            case 2:
                //retornar o nome
                return listaClientes.get(rowIndex).getEndereco();
            default:
                return null;
        }
    }

}
