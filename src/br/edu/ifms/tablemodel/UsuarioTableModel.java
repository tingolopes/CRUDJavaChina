/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.edu.ifms.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Michell
 * @author Kleber
 */
public class UsuarioTableModel extends AbstractTableModel {

    private final List<String> cabecalho;
    private List<Usuario> listaUsuarios;

    public void setListaUsuario(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public UsuarioTableModel() {
        cabecalho = new ArrayList<>();
        listaUsuarios = new ArrayList<>();

        cabecalho.add("ID");
        cabecalho.add("Nome");
        cabecalho.add("Login");
    }

    @Override
    public String getColumnName(int column) {
        return cabecalho.get(column);
    }

    @Override
    public int getRowCount() {
        return listaUsuarios.size();
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
                return listaUsuarios.get(rowIndex).getId();
            case 1:
                //retornar o nome
                return listaUsuarios.get(rowIndex).getNome();
            case 2:
                //retornar o nome
                return listaUsuarios.get(rowIndex).getLogin();
            default:
                return null;
        }
    }
}
