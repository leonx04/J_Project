package com.app.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

// Lớp ModernScrollBarUI mở rộng từ BasicScrollBarUI để tùy chỉnh giao diện thanh cuộn
public class ModernScrollBarUI extends BasicScrollBarUI {

    // Các hằng số quy định độ mờ và kích thước của thanh cuộn
    private static final int SCROLL_BAR_ALPHA_ROLLOVER = 100;
    private static final int SCROLL_BAR_ALPHA = 50;
    private static final int THUMB_SIZE = 8;
    private static final Color THUMB_COLOR = Color.BLACK;

    // Constructor của lớp ModernScrollBarUI
    public ModernScrollBarUI() {

    }

    // Phương thức tạo nút giảm giá trị
    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new InvisibleScrollBarButton();
    }

    // Phương thức tạo nút tăng giá trị
    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new InvisibleScrollBarButton();
    }

    // Phương thức vẽ thanh cuộn
    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        // Không thực hiện vẽ thanh cuộn track
    }

    // Phương thức vẽ "nút nhấn" (thumb) của thanh cuộn
    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        int alpha = isThumbRollover() ? SCROLL_BAR_ALPHA_ROLLOVER : SCROLL_BAR_ALPHA;
        int orientation = scrollbar.getOrientation();
        int x = thumbBounds.x;
        int y = thumbBounds.y;

        // Xác định chiều rộng và chiều cao của "nút nhấn" tùy theo hướng thanh cuộn
        int width = orientation == JScrollBar.VERTICAL ? THUMB_SIZE : thumbBounds.width;
        width = Math.max(width, THUMB_SIZE);

        int height = orientation == JScrollBar.VERTICAL ? thumbBounds.height : THUMB_SIZE;
        height = Math.max(height, THUMB_SIZE);

        Graphics2D graphics2D = (Graphics2D) g.create();
        // Đặt màu và vẽ "nút nhấn" của thanh cuộn
        graphics2D.setColor(new Color(THUMB_COLOR.getRed(), THUMB_COLOR.getGreen(), THUMB_COLOR.getBlue(), alpha));
        graphics2D.fillRect(x, y, width, height);
        graphics2D.dispose();
    }

    // Lớp Inner class InvisibleScrollBarButton để tạo nút ẩn
    private static class InvisibleScrollBarButton extends JButton {

        // Constructor của lớp InvisibleScrollBarButton
        private InvisibleScrollBarButton() {
            // Thiết lập các thuộc tính để tạo nút ẩn
            setOpaque(false);
            setFocusable(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setBorder(BorderFactory.createEmptyBorder());
        }
    }
}
