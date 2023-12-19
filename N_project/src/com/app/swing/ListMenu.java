package com.app.swing;

import com.app.event.EventMenuCallBack;
import com.app.event.EventMenuSelected;
import com.app.model.Model_Menu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;

// Lớp ListMenu mở rộng từ JList, chứa danh sách menu và xử lý sự kiện khi một menu được chọn
public class ListMenu<E extends Object> extends JList<E> {

    // Danh sách sự kiện khi một menu được chọn
    public void addEventSelectedMenu(EventMenuSelected event) {
        events.add(event);
    }

    // Mô hình danh sách mặc định và danh sách sự kiện
    private final DefaultListModel model;
    private final List<EventMenuSelected> events;

    // Chỉ số của menu được chọn
    private int selectedIndex = -1;

    // Constructor của class ListMenu
    public ListMenu() {
        model = new DefaultListModel();
        events = new ArrayList<>();
        super.setModel(model);
        // Bắt sự kiện click chuột
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object obj = model.getElementAt(index);
                    if (obj instanceof Model_Menu) {
                        Model_Menu data = (Model_Menu) obj;
                        // Kiểm tra nếu là loại MENU
                        if (data.getType() == Model_Menu.MenuType.MENU) {
                            if (index != selectedIndex) {
                                selectedIndex = -1;
                                runEvent(index);
                            }
                        }
                    } else {
                        if (index != selectedIndex) {
                            selectedIndex = -1;
                            runEvent(index);
                        }
                    }
                }
            }
        });
    }

    // Chạy sự kiện khi menu được chọn
    private void runEvent(int indexChange) {
        for (EventMenuSelected event : events) {
            event.menuSelected(indexChange, new EventMenuCallBack() {
                @Override
                public void call(int index) {
                    // Sự kiện callback chạy khi hiệu ứng hoàn tất
                    selectedIndex = index;
                    repaint();
                }
            });
        }
    }

    // Ghi đè phương thức để tùy chỉnh cách hiển thị mỗi phần tử trong danh sách
    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                Model_Menu data;
                // Kiểm tra nếu đối tượng là Model_Menu
                if (o instanceof Model_Menu) {
                    data = (Model_Menu) o;
                } else {
                    data = new Model_Menu("1", o + "", Model_Menu.MenuType.MENU);
                }
                // Tạo một MenuItem từ dữ liệu và thiết lập trạng thái được chọn
                MenuItem item = new MenuItem(data);
                item.setSelected(index == selectedIndex);
                return item;
            }

        };
    }

    // Ghi đè phương thức để thiết lập mô hình danh sách từ một mô hình danh sách khác
    @Override
    public void setModel(ListModel<E> lm) {
        for (int i = 0; i < lm.getSize(); i++) {
            model.addElement(lm.getElementAt(i));
        }
    }

    // Phương thức thêm một mục vào danh sách
    public void addItem(Model_Menu data) {
        model.addElement(data);
    }
}
