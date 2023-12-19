// Import các gói và lớp cần thiết
package com.app.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

// Lớp Model_Menu đại diện cho một mục menu trong ứng dụng
public class Model_Menu {

    // Thuộc tính đường dẫn icon
    private String icon;

    // Thuộc tính tên của menu
    private String name;

    // Thuộc tính kiểu menu (MENU hoặc EMPTY)
    private MenuType type;

    // Constructor với tham số
    public Model_Menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    // Constructor mặc định
    public Model_Menu() {
    }

    // Phương thức getter cho thuộc tính icon
    public String getIcon() {
        return icon;
    }

    // Phương thức setter cho thuộc tính icon
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // Phương thức getter cho thuộc tính name
    public String getName() {
        return name;
    }

    // Phương thức setter cho thuộc tính name
    public void setName(String name) {
        this.name = name;
    }

    // Phương thức getter cho thuộc tính type
    public MenuType getType() {
        return type;
    }

    // Phương thức setter cho thuộc tính type
    public void setType(MenuType type) {
        this.type = type;
    }

    // Phương thức chuyển đổi thành biểu tượng (Icon) từ đường dẫn icon
    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("/com/app/icon/" + icon + ".png"));
    }

    // Phương thức chuyển đổi thành biểu tượng (Icon) được chọn từ đường dẫn icon
    public Icon toIconSelected() {
        return new ImageIcon(getClass().getResource("/com/app/icon/" + icon + "_selected.png"));
    }

    // Enum định nghĩa các kiểu menu có thể có
    public static enum MenuType {
        MENU, EMPTY
    }
}
