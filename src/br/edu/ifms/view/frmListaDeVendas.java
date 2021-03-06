/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.view;

import br.edu.ifms.model.Venda;
import br.edu.ifms.dao.DaoGenerico;
import br.edu.ifms.model.ItensVenda;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import br.edu.ifms.tablemodel.CupomFiscalTableModel;
import br.edu.ifms.tablemodel.VendaTableModel;
import java.util.List;

/**
 *
 * @author Michell
 * @author Kleber
 */
public class frmListaDeVendas extends javax.swing.JInternalFrame {

    public frmListaDeVendas() {
        initComponents();
        this.setLocation(300, 100);
        listarVendas();
        listarItensDaVenda(0);
        
        setLayout(new BorderLayout());
        add(jPanelListaDeCupons, BorderLayout.WEST);
        add(jDetalhamentoCupom);
        jDetalhamentoCupom.setLayout(new FlowLayout());
        
        
        //teste
                
        jDetalhamentoCupom.setLayout(new BorderLayout());
        jDetalhamentoCupom.add(jPanelTabela, BorderLayout.NORTH);
        jDetalhamentoCupom.add(jTotal);
        jTotal.setLayout(new FlowLayout());
    }

    public void listarVendas() {
        VendaTableModel modelo = new VendaTableModel();
        DaoGenerico<Venda> dao = new DaoGenerico<>();
        modelo.setListaDasVendas(dao.listaTodos(Venda.class));
        tblVendas.setModel(modelo);
        ajustaTabelaVendas();
    }

    public void ajustaTabelaVendas() {
        //seta tamanho das colunas
        tblVendas.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblVendas.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblVendas.getColumnModel().getColumn(2).setPreferredWidth(120);

        //configura centralizaçao das colunas
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tblVendas.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }

    public void listarItensDaVenda(Integer pesquisaPorId) {
        CupomFiscalTableModel modelo = new CupomFiscalTableModel();
        DaoGenerico<ItensVenda> dao = new DaoGenerico<>();
        modelo.setListaVenda(dao.findByNome(ItensVenda.class, String.valueOf(pesquisaPorId), "id_venda"));
        tblCupomFiscal.setModel(modelo);
        tblCupomFiscal.setVisible(true);
        ajustaTabelaCupomFiscal();
        
        //seta total do cupom
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        Double soma = 0.0;
        List<ItensVenda> lista = dao.findByNome(ItensVenda.class, String.valueOf(pesquisaPorId), "id_venda");
        for (int i = 0; i < lista.size(); i++) {
            soma += lista.get(i).getTotalProduto();
        }
        jLabelTotalCupom.setText(String.valueOf(df.format(soma)));
    }
    
        public void ajustaTabelaCupomFiscal() {
        //seta tamanho das colunas
        tblCupomFiscal.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblCupomFiscal.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblCupomFiscal.getColumnModel().getColumn(2).setPreferredWidth(120);
        tblCupomFiscal.getColumnModel().getColumn(3).setPreferredWidth(120);

        //configura centralizaçao das colunas
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tblCupomFiscal.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void selecionaVenda() {
        DaoGenerico<Venda> dao = new DaoGenerico<>();
        int seleciona = tblVendas.getSelectedRow();
        int idVenda = (int) tblVendas.getModel().getValueAt(seleciona, 0);
        Venda v = dao.findById(Venda.class, idVenda);
        int pesquisaPorId = v.getId();
        listarItensDaVenda(pesquisaPorId);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelListaDeCupons = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        jDetalhamentoCupom = new javax.swing.JPanel();
        jPanelTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCupomFiscal = new javax.swing.JTable();
        jTotal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelTotalCupom = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Vendas");
        setMinimumSize(new java.awt.Dimension(791, 422));

        jPanelListaDeCupons.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de cupons", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendasMouseClicked(evt);
            }
        });
        tblVendas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblVendasKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblVendas);
        tblVendas.getAccessibleContext().setAccessibleName("");
        tblVendas.getAccessibleContext().setAccessibleDescription("");

        jPanelTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhamento do cupom", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tblCupomFiscal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblCupomFiscal);

        javax.swing.GroupLayout jPanelTabelaLayout = new javax.swing.GroupLayout(jPanelTabela);
        jPanelTabela.setLayout(jPanelTabelaLayout);
        jPanelTabelaLayout.setHorizontalGroup(
            jPanelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTabelaLayout.setVerticalGroup(
            jPanelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTabelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("TOTAL DO CUPOM");

        jLabelTotalCupom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTotalCupom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jTotalLayout = new javax.swing.GroupLayout(jTotal);
        jTotal.setLayout(jTotalLayout);
        jTotalLayout.setHorizontalGroup(
            jTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
            .addGroup(jTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jTotalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabelTotalCupom, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jTotalLayout.setVerticalGroup(
            jTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
            .addGroup(jTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jTotalLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addGroup(jTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTotalCupom, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jDetalhamentoCupomLayout = new javax.swing.GroupLayout(jDetalhamentoCupom);
        jDetalhamentoCupom.setLayout(jDetalhamentoCupomLayout);
        jDetalhamentoCupomLayout.setHorizontalGroup(
            jDetalhamentoCupomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDetalhamentoCupomLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jDetalhamentoCupomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDetalhamentoCupomLayout.createSequentialGroup()
                        .addComponent(jPanelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDetalhamentoCupomLayout.createSequentialGroup()
                        .addComponent(jTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jDetalhamentoCupomLayout.setVerticalGroup(
            jDetalhamentoCupomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDetalhamentoCupomLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelListaDeCuponsLayout = new javax.swing.GroupLayout(jPanelListaDeCupons);
        jPanelListaDeCupons.setLayout(jPanelListaDeCuponsLayout);
        jPanelListaDeCuponsLayout.setHorizontalGroup(
            jPanelListaDeCuponsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaDeCuponsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDetalhamentoCupom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanelListaDeCuponsLayout.setVerticalGroup(
            jPanelListaDeCuponsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaDeCuponsLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelListaDeCuponsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDetalhamentoCupom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelListaDeCupons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelListaDeCupons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendasMouseClicked
        selecionaVenda();
    }//GEN-LAST:event_tblVendasMouseClicked

    private void tblVendasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblVendasKeyReleased
        selecionaVenda();
    }//GEN-LAST:event_tblVendasKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jDetalhamentoCupom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTotalCupom;
    private javax.swing.JPanel jPanelListaDeCupons;
    private javax.swing.JPanel jPanelTabela;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jTotal;
    private javax.swing.JTable tblCupomFiscal;
    private javax.swing.JTable tblVendas;
    // End of variables declaration//GEN-END:variables
}
