package br.edu.ifms.tablemodel;

import br.edu.ifms.model.Venda;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Michell
 * @author Kleber
 */
public class VendaTableModel extends AbstractTableModel {

    final List<String> cabecalho;
    private List<Venda> listaDeVendas;

    public void setListaDasVendas(List<Venda> listaDeVendas) {
        this.listaDeVendas = listaDeVendas;
    }

    public VendaTableModel() {
        cabecalho = new ArrayList<>();
        listaDeVendas = new ArrayList<>();

        cabecalho.add("ID");
        cabecalho.add("Nome Cliente");
        cabecalho.add("Data Venda");
    }

    @Override
    public String getColumnName(int column) {
        return cabecalho.get(column);
    }

    @Override
    public int getRowCount() {
        return listaDeVendas.size();
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
                return listaDeVendas.get(rowIndex).getId();
            case 1:
                //retornar o nome produto
                return listaDeVendas.get(rowIndex).getCliente().getNome();
            case 2:
                //retornar a data da venda
                return new SimpleDateFormat("dd/MM/yyyy").
                        format(listaDeVendas.get(rowIndex).getDatavenda());
            default:
                return null;
        }
    }

}
