package com.app.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class PanelBorder extends javax.swing.JPanel {

    public PanelBorder() {
        initComponents();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    // Phương thức paintComponent để vẽ nội dung của JPanel
    protected void paintComponent(Graphics grphcs) {
        // Chuyển đổi đối tượng Graphics thành đối tượng Graphics2D để sử dụng các hiệu ứng chất lượng hình ảnh
        Graphics2D g2 = (Graphics2D) grphcs;

        // Thiết lập hiệu ứng chất lượng hình ảnh để làm mịn và chống nhòe
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Lấy màu nền của JPanel và đặt màu fill cho đối tượng Graphics2D
        g2.setColor(getBackground());

        // Vẽ hình chữ nhật tròn với các góc cong để tạo hình dạng và màu nền cho JPanel
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        // Gọi phương thức paintComponent của lớp cha để vẽ các thành phần con khác nếu có
        super.paintComponent(grphcs);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
