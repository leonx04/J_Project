// Import các gói và lớp cần thiết
package com.app.swing;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

// Lớp ScrollBar kế thừa từ JScrollBar
public class ScrollBar extends JScrollBar {

    // Constructor của lớp ScrollBar
    public ScrollBar() {
        // Đặt giao diện người dùng (UI) của thanh cuộn thành ModernScrollBarUI để tạo giao diện hiện đại
        setUI(new ModernScrollBarUI());

        // Đặt kích thước ưu tiên cho thanh cuộn
        setPreferredSize(new Dimension(5, 5));

        // Đặt màu nền cho thanh cuộn
        setBackground(new Color(242, 242, 242));

        // Đặt giá trị tăng/giảm khi di chuyển một đơn vị
        setUnitIncrement(20);
    }
}
