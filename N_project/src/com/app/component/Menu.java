package com.app.component;

import com.app.event.EventMenu;
import com.app.event.EventMenuCallBack;
import com.app.event.EventMenuSelected;
import com.app.model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Path2D;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Menu extends javax.swing.JPanel {

    // Sự kiện Menu
    public void addEventMenu(EventMenu event) {
        this.event = event;
    }

    // Chỉ số của menu được chọn
    private int selectedIndex = -1;

    // Timer cho hiệu ứng di chuyển menu và hiệu ứng ẩn hiện danh sách mục menu
    private final Timer timer;

    // Biến xác định hướng di chuyển của menu
    private boolean toUp;   // For animation is go up

    // Vị trí Y của menu (hiện tại và mục tiêu)
    private int menuYTarget;
    private int menuY;

    // Tốc độ di chuyển
    private int speed = 2;

    // Callback cho sự kiện Menu
    private EventMenuCallBack callBack;

    // Sự kiện Menu
    private EventMenu event;

    // Constructor của class Menu
    public Menu() {
        initComponents();  // Khởi tạo các thành phần giao diện
        setOpaque(false);
        listMenu.setOpaque(false);
        listMenu.addEventSelectedMenu(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, EventMenuCallBack callBack) {
                if (index != selectedIndex) {
                    Menu.this.callBack = callBack;
                    toUp = selectedIndex > index;
                    if (selectedIndex == -1) {
                        speed = 20;
                    } else {
                        speed = selectedIndex - index;
                        if (speed < 0) {
                            speed *= -1;
                            //  Nếu giá trị tốc độ < 0, đổi nó thành > 0   Ví dụ: -1 thành 1
                        }
                    }
                    speed++;    //  Thêm 1 tốc độ
                    selectedIndex = index;
                    menuYTarget = selectedIndex * 35 + listMenu.getY(); //  menuYTarget là vị trí y
                    if (!timer.isRunning()) {
                        timer.start();
                    }
                }
            }
        });
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (toUp) {
                    if (menuY <= menuYTarget - 5) {
                        menuY = menuYTarget;
                        repaint();
                        timer.stop();
                        callBack.call(selectedIndex);
                        if (event != null) {
                            event.menuIndexChange(selectedIndex);
                        }
                    } else {
                        menuY -= speed;
                        repaint();
                    }
                } else {
                    if (menuY >= menuYTarget + 5) { //  Thêm phong cách
                        menuY = menuYTarget;
                        repaint();
                        timer.stop();
                        callBack.call(selectedIndex);
                        if (event != null) {
                            event.menuIndexChange(selectedIndex);
                        }
                    } else {
                        menuY += speed;
                        repaint();
                    }
                }
            }
        });
        initData();
    }

    // Khởi tạo dữ liệu mẫu cho danh sách menu
    private void initData() {
        listMenu.addItem(new Model_Menu("1", "Home", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("2", "Sell", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("3", "Product", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("4", "Staff", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("5", "Client", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("6", "Voucher", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("7", "Statistical", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("8", "Accout", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("9", "Setting", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("10", "Chat bot", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listMenu = new com.app.swing.ListMenu<>();

        panelMoving.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Logo");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Phương thức vẽ nền gradient và menu được chọn
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#a8c0ff"), 0, getHeight(), Color.decode("#3f2b96"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        if (selectedIndex >= 0) {
            int menuX = 10;
            int height = 35;
            int width = getWidth();
            g2.setColor(new Color(242, 242, 242));
            g2.fillRoundRect(menuX, menuY, width, height, 35, 35);
            Path2D.Float f = new Path2D.Float();
            f.moveTo(width - 30, menuY);
            f.curveTo(width - 10, menuY, width, menuY, width, menuY - 30);
            f.lineTo(width, menuY + height + 30);
            f.curveTo(width, menuY + height, width - 10, menuY + height, width - 30, menuY + height);

            g2.fill(f);
        }
        super.paintComponent(grphcs);
    }

    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX() + 6;
                y = me.getY() + 6;
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private com.app.swing.ListMenu<String> listMenu;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
