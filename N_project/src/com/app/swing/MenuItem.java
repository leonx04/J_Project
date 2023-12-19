package com.app.swing;

import com.app.model.Model_Menu;
import java.awt.Color;

public class MenuItem extends javax.swing.JPanel {

    // Dữ liệu của mục menu
    private final Model_Menu data;

    // Constructor của lớp MenuItem
    public MenuItem(Model_Menu data) {
        this.data = data;
        initComponents();
        setOpaque(false);
        // Kiểm tra loại của mục menu và thiết lập hình ảnh và tên tương ứng
        if (data.getType() == Model_Menu.MenuType.MENU) {
            lbIcon.setIcon(data.toIcon());
            lbName.setText(data.getName());
        } else {
            lbName.setText(" ");
        }
    }

    // Phương thức cài đặt trạng thái chọn của mục menu
    public void setSelected(boolean selected) {
        // Kiểm tra loại của mục menu
        if (data.getType() == Model_Menu.MenuType.MENU) {
            // Nếu mục menu được chọn
            if (selected) {
                lbIcon.setIcon(data.toIconSelected());
                lbName.setForeground(new Color(60, 60, 60));
            } else {
                // Nếu mục menu không được chọn
                lbIcon.setIcon(data.toIcon());
                lbName.setForeground(new Color(214, 217, 223));
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();

        lbName.setForeground(new java.awt.Color(226, 226, 226));
        lbName.setText("Menu Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbIcon)
                .addGap(18, 18, 18)
                .addComponent(lbName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
