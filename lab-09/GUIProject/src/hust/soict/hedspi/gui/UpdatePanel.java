package hust.soict.hedspi.gui;
import javax.swing.*;
import java.awt.*;

public class UpdatePanel extends JPanel {

    private final JTextField number;
    private int count;

    public int getCount() {
        return count;
    }


    public UpdatePanel(String mediaType, int initCount) {
        setLayout(new FlowLayout(10,10,10));
        JLabel type = new JLabel("");
        type.setText(mediaType);
        number = new JTextField(10);
        number.setText(initCount + "");
        JButton up = new JButton("Up");
        JButton down = new JButton("Down");
        this.count = initCount;
        add(type);
        add(number);
        add(up);
        add(down);
        up.addActionListener(e -> {
            ++count;
            number.setText(count + "");
        });

        down.addActionListener(e -> {
            if(count > 0) {
                count--;
                number.setText(count + "");
            }
        });

    }

}
