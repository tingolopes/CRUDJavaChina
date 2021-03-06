package br.edu.ifms.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Michell
 * @author Kleber
 */
public class frmPrincipal extends javax.swing.JFrame {

    private final Integer IDUSUARIO;

    public frmPrincipal(Integer idusuario) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH); //maximizado
        this.IDUSUARIO = idusuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/br/edu/ifms/image/fundo.jpg"));
        Image image = icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        }
        ;
        jMenuBar1 = new javax.swing.JMenuBar();
        Cadastro = new javax.swing.JMenu();
        menuUsuario = new javax.swing.JMenuItem();
        menuCategoria = new javax.swing.JMenuItem();
        menuCliente = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Sair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setName(""); // NOI18N

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        Cadastro.setText("Cadastro");

        menuUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        menuUsuario.setText("Usuario");
        menuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuarioActionPerformed(evt);
            }
        });
        Cadastro.add(menuUsuario);

        menuCategoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        menuCategoria.setText("Categoria");
        menuCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCategoriaActionPerformed(evt);
            }
        });
        Cadastro.add(menuCategoria);

        menuCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        menuCliente.setText("Produto");
        menuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClienteActionPerformed(evt);
            }
        });
        Cadastro.add(menuCliente);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Cadastro.add(jMenuItem1);

        jMenu1.setText("Vendas");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Efetuar Venda");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Listar Vendas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        Cadastro.add(jMenu1);

        jMenuBar1.add(Cadastro);

        Sair.setText("Sair");
        Sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SairMouseClicked(evt);
            }
        });
        jMenuBar1.add(Sair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SairMouseClicked
        System.exit(0);
    }//GEN-LAST:event_SairMouseClicked

    private void menuCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCategoriaActionPerformed
        frmCategoria form = new frmCategoria();
        form.setVisible(true);
        jDesktopPane1.add(form);
    }//GEN-LAST:event_menuCategoriaActionPerformed

    private void menuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClienteActionPerformed
        frmProduto form = new frmProduto(IDUSUARIO);
        form.setVisible(true);
        jDesktopPane1.add(form);
    }//GEN-LAST:event_menuClienteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        frmCliente form = new frmCliente();
        form.setVisible(true);
        jDesktopPane1.add(form);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        frmListaDeVendas form = new frmListaDeVendas();
        form.setVisible(true);
        jDesktopPane1.add(form);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        frmEfetuarVenda form = new frmEfetuarVenda();
        form.setVisible(true);
        jDesktopPane1.add(form);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuarioActionPerformed
        frmUsuario form = new frmUsuario();
        form.setVisible(true);
        jDesktopPane1.add(form);
    }//GEN-LAST:event_menuUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Cadastro;
    private javax.swing.JMenu Sair;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem menuCategoria;
    private javax.swing.JMenuItem menuCliente;
    private javax.swing.JMenuItem menuUsuario;
    // End of variables declaration//GEN-END:variables
}
