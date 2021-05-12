package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.exceptions.LuckyItemException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Collections;
import java.util.List;

public class MenuFrame extends JFrame {
    JButton createButton = new JButton("Create new Order");
    JButton addButton = new JButton("Add item to the order");
    JButton deleteButton = new JButton("Delete item by Id");
    JButton displayButton = new JButton("Display the items of list order ");
    JButton createThresholds = new JButton("Create Thresholds");
    JButton exitButton = new JButton("Exit");
    public static Order anOrder;

    public MenuFrame(JFrame jFrame) {
        // Draw frame
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setResizable(false);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - 500)) / 2;
        int y = (int) ((dimension.getHeight() - 450)) / 2;
        setLocation(x, y);
        setVisible(true);
        setTitle("Order System");

        // Button Create new order


        createButton.setSize(300, 60);
        createButton.setLocation(100, 20);
        createButton.setFocusPainted(false);
        createButton.addActionListener(e -> {
            anOrder = Order.getOrder();
            JOptionPane.showMessageDialog(null, "Create new Order successfully");
        });
        add(createButton);

        // Create Thresholds
        createThresholds.setSize(300, 60);
        createThresholds.setLocation(100, 100);
        createThresholds.setFocusPainted(false);
        createThresholds.addActionListener(e -> new AddThresholdsDialog());
        add(createThresholds);

        // Button add item into order
        addButton.setSize(300, 60);
        addButton.setLocation(100, 180);
        addButton.setFocusPainted(false);
        addButton.addActionListener(e -> {
            if (anOrder != null) {
                // Create Frame Dialog
                new AddMediaDialog();
            } else {
                JOptionPane.showMessageDialog(null, "Please create an order", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        add(addButton);

        // Button delete an item from order
        deleteButton.setSize(300, 60);
        deleteButton.setLocation(100, 260);
        deleteButton.setFocusPainted(false);
        deleteButton.addActionListener(e -> {
            if (anOrder != null) {
                String strid = JOptionPane.showInputDialog(null,
                        "Moi ban nhap ID muon xoa: ",
                        "Delete ID",
                        JOptionPane.INFORMATION_MESSAGE);
                if (anOrder.removeMedia(strid)) {
                    JOptionPane.showMessageDialog(null, "Delete Media have ID = " + strid + " sucessfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Don't exist Media have ID = " + strid, "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please create an order", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        add(deleteButton);

        displayButton.setSize(300, 60);
        displayButton.setLocation(100, 340);
        displayButton.setFocusPainted(false);
        displayButton.addActionListener(e -> {
            if (anOrder != null) {
                // Create frame of dialog
                JDialog displayDialog = new JDialog();
                displayDialog.setSize(600, 400);
                displayDialog.setLayout(null);
                displayDialog.setResizable(false);

                Dimension dimension1 = Toolkit.getDefaultToolkit().getScreenSize();
                int x1 = (int) ((dimension1.getWidth() - 600)) / 2;
                int y1 = (int) ((dimension1.getHeight() - 400)) / 2;
                displayDialog.setLocation(x1, y1);

                displayDialog.setVisible(false);
                displayDialog.setModal(true);
                displayDialog.setTitle("List items of Order");

                String[] column_names = {"ID", "Type", "Title", "Category", "Cost($)"};
                List<Media> items;
                items = anOrder.itemsOrdered;
                Collections.sort(items);
                DefaultTableModel model = new DefaultTableModel(null, column_names);
                JTable table = new JTable(model);
                float cost = 0;
                Media temp = null;
                try {
                    temp = anOrder.getALuckyItem();
                } catch (LuckyItemException luckyItemException) {
                    luckyItemException.printStackTrace();
                }
                for (Media media : items) {
                    String typeString;
                    if (media instanceof Book)
                        typeString = "Book";
                    else if (media instanceof DigitalVideoDisc) {
                        typeString = "DVD";
                    } else {
                        typeString = "CD";
                    }
                    if (media == temp) {
                        cost = media.getCost();
                        model.addRow(new Object[]{media.getId(), typeString,
                                media.getTitle(), media.getCategory(), 0.0});
                    } else {
                        model.addRow(new Object[]{media.getId(), typeString,
                                media.getTitle(), media.getCategory(), media.getCost()});
                    }
                }

                model.addRow(new Object[]{"", "", "", "Total: ", anOrder.totalCost() - cost});
                table.setSize(500, 300);
                table.setLocation(50, 30);
                displayDialog.setLayout(new BorderLayout());
                displayDialog.add(table.getTableHeader(), BorderLayout.PAGE_START);
                displayDialog.add(table, BorderLayout.CENTER);
                TableColumn column;
                for (int i = 0; i < 5; i++) {
                    column = table.getColumnModel().getColumn(i);
                    if (i == 0) {
                        column.setPreferredWidth(50);
                    }
                    if (i == 1) {
                        column.setPreferredWidth(50);
                    }
                    if (i == 2) {
                        column.setPreferredWidth(200);
                    }
                    if (i == 3) {
                        column.setPreferredWidth(150);
                    }
                    if (i == 4) {
                        column.setPreferredWidth(50);
                    }

                }
                displayDialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Please create an order", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        add(displayButton);

        exitButton.setSize(300, 60);
        exitButton.setLocation(100, 420);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(e -> System.exit(0));
        add(exitButton);

        setVisible(true);

    }
}
