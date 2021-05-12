package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.CompactDisc;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.disc.Track;
import hust.soict.hedspi.aims.exceptions.InputException;
import hust.soict.hedspi.aims.media.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class AddMediaDialog {
    private final JDialog selectDialog = new JDialog();
    private final JButton bookButton;
    private final JButton dvdButton;
    private final JButton cdButton;

    public AddMediaDialog() {
        // Set Dialog size
        selectDialog.setSize(500,450);
        selectDialog.getContentPane().setLayout(null);
        selectDialog.setResizable(false);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - 500))/2;
        int y = (int) ((dimension.getHeight() - 450))/2;
        selectDialog.setLocation(x, y);
//		selectDialog.setVisible(false);
        selectDialog.setModal(true);
        selectDialog.setTitle("Select Media");

        // Button Add Book
        bookButton = new JButton("Book");
        bookButton.setSize(300, 60);
        bookButton.setLocation(100,55);
        bookButton.setFocusPainted(false);
        selectDialog.getContentPane().add(bookButton);
        addBookAction();

        // Button Add DVD
        dvdButton = new JButton("DVD");
        dvdButton.setSize(300, 60);
        dvdButton.setLocation(100,170);
        dvdButton.setFocusPainted(false);
        selectDialog.getContentPane().add(dvdButton);
        addDVDAction();

        cdButton = new JButton("CD");
        cdButton.setSize(300, 60);
        cdButton.setLocation(100,288);
        cdButton.setFocusPainted(false);
        selectDialog.getContentPane().add(cdButton);
        addCDAction();

        selectDialog.setVisible(true);
    }

    public void addBookAction() {
        bookButton.addActionListener(e -> {
            System.out.println("Book");
            selectDialog.setVisible(false);
            JDialog bookDialog = new JDialog();

            // Common dialog of Media
            MediaDialog bookMedia = new MediaDialog(bookDialog);

            // Author
            JTextField authorField = new JTextField();
            JLabel authorJLabel = new JLabel("Author");
            authorJLabel.setSize(100,30);
            authorJLabel.setLocation(90,180);
            bookDialog.add(authorJLabel);

            authorField.setSize(250, 30);
            authorField.setLocation(200,180);
            bookDialog.add(authorField);

            JLabel noteJLabel = new JLabel("* Cac author cach nhau boi dau phay ' , '");
            noteJLabel.setSize(300,40);
            noteJLabel.setLocation(100,220);
            bookDialog.add(noteJLabel);

            // Handler OK button
            bookMedia.okJButton.addActionListener(e1 -> {
                // System.out.println("OKIE Book");
                bookDialog.setVisible(false);
                try {
                    float i = bookMedia.getCost();
                    String[] authors = authorField.getText().split(",");
                    ArrayList<String> listauthor = new ArrayList<>();
                    Collections.addAll(listauthor, authors);
                    Book book = new Book(bookMedia.getId(), bookMedia.getTitle(), bookMedia.getCategory(), i, listauthor);
                    MenuFrame.anOrder.addMedia(book);
                    JOptionPane.showMessageDialog(null,"The Book added");
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            });
            bookDialog.setVisible(true);
        });
    }

    public void addDVDAction() {
        dvdButton.addActionListener(e -> {
            System.out.println("DVD");
            selectDialog.setVisible(false);
            JDialog dvdDialog = new JDialog();

            // Common dialog of Media
            MediaDialog dvdMedia = new MediaDialog(dvdDialog);

            JTextField textField = new JTextField();
            JLabel textJLabel = new JLabel("Length");
            textJLabel.setSize(100,30);
            textJLabel.setLocation(90, 180);
            dvdDialog.add(textJLabel);
            textField.setSize(250,30);
            textField.setLocation(200,180);
            dvdDialog.add(textField);

            JTextField directorField = new JTextField();
            JLabel directorJLabel = new JLabel("Director");
            directorJLabel.setSize(100,30);
            directorJLabel.setLocation(90,220);
            dvdDialog.add(directorJLabel);

            directorField.setSize(250, 30);
            directorField.setLocation(200,220);
            dvdDialog.add(directorField);

            // handler button OK
            dvdMedia.okJButton.addActionListener(e1 -> {
                dvdDialog.setVisible(false);
                try {
                    float i = dvdMedia.getCost();
                    int length = Integer.parseInt(textField.getText());
                    String director = directorField.getText();
                    DigitalVideoDisc dvd = new DigitalVideoDisc(dvdMedia.getId(), dvdMedia.getTitle(), dvdMedia.getCategory(), length, director, i);
                    dvd.play();
                    MenuFrame.anOrder.addMedia(dvd);
                    int result = JOptionPane.showConfirmDialog(null,"Ban co muon phat DVD ?","Play",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Playing DVD: " + dvd.getTitle() + "\nDVD length: " + dvd.getLength());
                    }
                    JOptionPane.showMessageDialog(null,"The DVD added");
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2.getMessage() + "\n" + e2, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            });
            dvdDialog.setVisible(true);

        });
    }

    public void addCDAction() {
        cdButton.addActionListener(e -> {
            System.out.println("CD");
            selectDialog.setVisible(false);
            JDialog cdDialog = new JDialog();

            // Common dialog of Media
            MediaDialog cdMedia = new MediaDialog(cdDialog);

            JTextField textField = new JTextField();
            JLabel textJLabel = new JLabel("Artist");
            textJLabel.setSize(100,40);
            textJLabel.setLocation(90, 180);
            cdDialog.add(textJLabel);
            textField.setSize(250,30);
            textField.setLocation(200,180);
            cdDialog.add(textField);

            JTextField trackField = new JTextField();
            JLabel trackJLabel = new JLabel("Track");
            trackJLabel.setSize(100,40);
            trackJLabel.setLocation(90,220);
            cdDialog.add(trackJLabel);
            trackField.setSize(250, 30);
            trackField.setLocation(200,220);
            cdDialog.add(trackField);

            JLabel noteJLabel = new JLabel("* Track: <Track1>:<Length1>,<Track2>:<Lenght2>,...");
            noteJLabel.setSize(500,40);
            noteJLabel.setLocation(100,260);
            cdDialog.add(noteJLabel);
            // handler button OK
            cdMedia.okJButton.addActionListener(e1 -> {
                cdDialog.setVisible(false);
                try {
                    float i = cdMedia.getCost();
                    CompactDisc cd = new CompactDisc(cdMedia.getId(), cdMedia.getTitle(), cdMedia.getCategory(), textField.getText(), i);
                    String[] outString = trackField.getText().split(",+");
                    for(String out : outString) {
                        String[] a = out.split(":+");
                        Track track;
                        try {
                            track = new Track(a[0], Integer.parseInt(a[1]));
                        } catch (Exception e2) {
                            continue;
                        }
                        cd.addTrack(track);
                    }
                    if(cd.getTracks().size() == 0 ) {
                        JOptionPane.showMessageDialog(null,"Khong the them vao Order\nBan nhap sai dinh dang\nCac truong ID, Title, Category, Code, Tracks khong the trong","Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }else {
                        cd.play();
                        MenuFrame.anOrder.addMedia(cd);
                        int result = JOptionPane.showConfirmDialog(null,"Ban co muon phat CD ?","Play",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(result == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, cd.message);
                        }
                        JOptionPane.showMessageDialog(null,"The CD added");
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2.getMessage() + "\n" + e2, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            });
            cdDialog.setVisible(true);
        });
    }

    public static class MediaDialog{
        JLabel idJLabel = new JLabel("ID");
        JLabel costJLabel = new JLabel("Cost");
        JLabel categoryJLabel = new JLabel("Category");
        JLabel titleJLabel = new JLabel("Title");

        JTextField idField = new JTextField();
        JTextField costField = new JTextField();
        JTextField cateField = new JTextField();
        JTextField titleField = new JTextField();

        JButton okJButton = new JButton("OK");

        public String getId() {
            return idField.getText();
        }
        public Float getCost() throws InputException{
            float f;
            try {
                f = Float.parseFloat(costField.getText());
                return f;
            } catch (Exception e) {
                throw new InputException(e.getMessage() + "\nError Input");
            }
        }
        public String getCategory() throws InputException{
            if(!cateField.getText().equals("")) {
                return cateField.getText();
            }else {
                throw new InputException("ERROR: Catagory Field is empty");
            }

        }
        public String getTitle() throws InputException{
            if(!titleField.getText().equals("")) {
                return titleField.getText();
            }else {
                throw new InputException("ERROR: Title Field is empty");
            }
        }

        public MediaDialog(JDialog mediaDialog) {
            mediaDialog.setSize(500,450);
            mediaDialog.setLayout(null);
            mediaDialog.setResizable(false);

            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - 500))/2;
            int y = (int) ((dimension.getHeight() - 450))/2;
            mediaDialog.setLocation(x, y);

            idJLabel.setSize(100,30);
            idJLabel.setLocation(90,20);
            mediaDialog.add(idJLabel);
            idField.setSize(250, 30);
            idField.setLocation(200,20);
            mediaDialog.add(idField);

            costJLabel.setSize(100,30);
            costJLabel.setLocation(90,60);
            mediaDialog.add(costJLabel);
            costField.setSize(250, 30);
            costField.setLocation(200,60);
            mediaDialog.add(costField);

            categoryJLabel.setSize(100,30);
            categoryJLabel.setLocation(90,100);
            mediaDialog.add(categoryJLabel);
            cateField.setSize(250, 30);
            cateField.setLocation(200,100);
            mediaDialog.add(cateField);

            titleJLabel.setSize(100,30);
            titleJLabel.setLocation(90,140);
            mediaDialog.add(titleJLabel);
            titleField.setSize(250, 30);
            titleField.setLocation(200,140);
            mediaDialog.add(titleField);

            okJButton.setSize(100,30);
            okJButton.setLocation(200,330);
            okJButton.setFocusPainted(false);
            mediaDialog.add(okJButton);

            mediaDialog.setVisible(false);
            mediaDialog.setModal(true);
        }

    }

}