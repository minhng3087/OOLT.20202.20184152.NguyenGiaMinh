package hust.soict.hedspi.gui;

import hust.soict.hedspi.aims.disc.CompactDisc;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.disc.Track;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.order.Order;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class Menu extends JFrame {
    private final JLabel msg;

    public JFrame updateFrame;
    public JFrame displayFrame;
    public JFrame changeFrame;

    List<Book> tBook;
    List<CompactDisc> tCD;
    List<DigitalVideoDisc> tDVD;
    List<Track> tTrack;

    public Menu() {

        tBook = new ArrayList<>();
        tCD = new ArrayList<>();
        tDVD = new ArrayList<>();
        tTrack = new ArrayList<>();

        Container cp = getContentPane();
        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton create = new JButton("Create new order");
        cp.add(create);

        JButton update = new JButton("Update order");
        cp.add(update);

        JButton change = new JButton("Change order");
        cp.add(change);

        JButton display = new JButton("Display order");
        cp.add(display);

        JButton quit = new JButton("Quit");
        cp.add(quit);

        msg = new JLabel("");
        cp.add(msg);
        setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        create.addActionListener(evt -> {
            msg.setText("Created new order success. Let's choose your option");
            Order.getOrder();
        });

        quit.addActionListener(evt -> msg.setText("Thanks. Exit"));

        update.addActionListener(evt -> {
            updateFrame = new JFrame();
            Container updateCp = updateFrame.getContentPane();
            updateFrame.setSize(450,300);
            updateFrame.setVisible(true);
            updateFrame.setLayout(new BoxLayout(updateCp, BoxLayout.Y_AXIS));
            updateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            UpdatePanel book = new UpdatePanel("BOOK",0);
            updateCp.add(book);

            UpdatePanel cd = new UpdatePanel("CD",0);
            updateCp.add(cd);

            UpdatePanel dvd = new UpdatePanel("DVD",0);
            updateCp.add(dvd);

            UpdatePanel track = new UpdatePanel("TRACK",0);
            updateCp.add(track);

            JButton save = new JButton("SAVE");
            updateCp.add(save);

            save.addActionListener(e -> {
                updateFrame.setVisible(false);

                if(book.getCount() > 0) {
                    for(int i = 0; i < book.getCount(); i++) {
                        Book tmp = new Book();
                        tmp.setCost(2);
                        tBook.add(tmp);
                    }
                }

                if(cd.getCount() > 0) {
                    for(int i = 0; i < cd.getCount(); i++) {
                        CompactDisc tmp = new CompactDisc();
                        tmp.setCost(3);
                        tCD.add(tmp);
                    }
                }

                if(dvd.getCount() > 0) {
                    for(int i = 0; i < dvd.getCount(); i++) {
                        DigitalVideoDisc tmp = new DigitalVideoDisc();
                        tmp.setCost(4);
                        tDVD.add(tmp);
                    }
                }

                if(track.getCount() > 0) {
                    for(int i = 0; i < track.getCount(); i++) {
                        Track tmp = new Track();
                        tTrack.add(tmp);
                    }
                }
            });


        });
        change.addActionListener(evt -> {
            changeFrame = new JFrame();
            Container changeCp = changeFrame.getContentPane();
            changeFrame.setSize(450,300);
            changeFrame.setVisible(true);
            changeFrame.setLayout(new BoxLayout(changeCp, BoxLayout.Y_AXIS));
            changeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            UpdatePanel book = new UpdatePanel("BOOK", tBook.size());
            changeCp.add(book);

            UpdatePanel cd = new UpdatePanel("CD",tCD.size());
            changeCp.add(cd);

            UpdatePanel dvd = new UpdatePanel("DVD",tDVD.size());
            changeCp.add(dvd);

            UpdatePanel track = new UpdatePanel("TRACK",tTrack.size());
            changeCp.add(track);

            JButton save = new JButton("SAVE");
            changeCp.add(save);

            save.addActionListener(e -> {
                changeFrame.setVisible(false);

                if(tBook.size() > book.getCount()) {
                    while( tBook.size() - book.getCount() > 0 ) {
                        tBook.remove(tBook.size() - 1);
                    }
                }else if(tBook.size() < book.getCount()) {
                    for(int i = 0; i < book.getCount() - tBook.size(); i++) {
                        Book tmp = new Book();
                        tmp.setCost(2);
                        tBook.add(tmp);
                    }
                }

                if(tCD.size() > cd.getCount()) {
                    while( tCD.size() - cd.getCount() > 0 ) {
                        tCD.remove(tCD.size() - 1);
                    }
                }else if(tCD.size() < cd.getCount()) {
                    for(int i = 0; i < cd.getCount() - tCD.size(); i++) {
                        CompactDisc tmp = new CompactDisc();
                        tmp.setCost(3);
                        tCD.add(tmp);
                    }
                }

                if(tDVD.size() > dvd.getCount()) {
                    while( tDVD.size() - dvd.getCount() > 0 ) {
                        tDVD.remove(tDVD.size() - 1);
                    }
                }else if(tDVD.size() < dvd.getCount()) {
                    for(int i = 0; i < dvd.getCount() - tDVD.size(); i++) {
                        DigitalVideoDisc tmp = new DigitalVideoDisc();
                        tmp.setCost(4);
                        tDVD.add(tmp);
                    }
                }

                if(tTrack.size() > track.getCount()) {
                    while( tTrack.size() - track.getCount() > 0 ) {
                        tTrack.remove(tTrack.size() - 1);
                    }
                }else if(tTrack.size() < track.getCount()) {
                    for(int i = 0; i < track.getCount() - tTrack.size(); i++) {
                        Track tmp = new Track();
                        tTrack.add(tmp);
                    }
                }
            });
        });

        display.addActionListener(e -> {
            displayFrame = new JFrame();
            Container displayCp = displayFrame.getContentPane();
            displayFrame.setSize(450,300);
            displayFrame.setVisible(true);
            displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel p1 = new JPanel();
            JPanel p2 = new JPanel();

            String[][] data = { { "BOOK", tBook.size() + "", "2$", tBook.size()*2 + "$" },
                    { "CD", tCD.size() + "", "3$",tCD.size()*3 + "$" },
                    { "DVD", tDVD.size() + "", "4$", tDVD.size()*4 + "$" },
                    { "TRACK", tTrack.size() + "", "5$", tTrack.size()*5 + "$" },
                    { "SUM", "", "", tBook.size()*2 +
                            tCD.size()*3 +
                            tDVD.size()*4 +
                            tTrack.size()*5 + "$" } };

            String[] column = { "TYPE", "NUMBER", "UNIT", "COST" };
            JTable jt = new JTable(data, column);
            jt.setBounds(30, 40, 100, 200);

            JScrollPane sp = new JScrollPane(jt);
            p1.add(sp);

            JButton ok = new JButton("OK");
            p2.add(ok);

            displayFrame.setLayout(new BoxLayout(displayCp, BoxLayout.Y_AXIS));
            displayCp.add(p1);
            displayCp.add(p2);

            ok.addActionListener(e1 -> {
                JOptionPane.showMessageDialog(p2, "Thanks");
                displayFrame.setVisible(false);
            });
        });

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new);
    }

}
