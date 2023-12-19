package com.app.main;

import com.app.event.EventMenu;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        init();
    }

    private void init() {
        setBackground(new Color(0, 0, 0, 0)); // Xoa background
        menu2.initMoving(this);
        menu2.addEventMenu(new EventMenu() {
            @Override
            public void menuIndexChange(int index) {
                if (index == 0) {
                    JOptionPane.showMessageDialog(null, "Home");
                } else if (index == 1) {
                    JOptionPane.showMessageDialog(null, "Sell");
                } else if (index == 2) {
                    JOptionPane.showMessageDialog(null, "Product");
                } else if (index == 3) {
                    JOptionPane.showMessageDialog(null, "Staff");
                } else if (index == 4) {
                    JOptionPane.showMessageDialog(null, "Client");
                } else if (index == 5) {
                    JOptionPane.showMessageDialog(null, "Voucher");
                } else if (index == 6) {
                    JOptionPane.showMessageDialog(null, "Statistical");
                } else if (index == 7) {
                    JOptionPane.showMessageDialog(null, "Accout");
                } else if (index == 8) {
                    JOptionPane.showMessageDialog(null, "Setting");
                } else if (index == 9) {
                    JOptionPane.showMessageDialog(null, "Chat bot");
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.app.swing.PanelBorder();
        menu2 = new com.app.component.Menu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
                panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(958, Short.MAX_VALUE)));
        panelBorder1Layout.setVerticalGroup(
                panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(menu2, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Đặt giao diện Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Mã thiết lập giao diện (tùy
        // chọn) ">
        /*
         * Nếu Nimbus (được giới thiệu trong Java SE 6) không khả dụng, hãy sử dụng giao
         * diện mặc định.
         * Để biết chi tiết, hãy xem
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Tạo và hiển thị form chính */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.component.Menu menu2;
    private com.app.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
