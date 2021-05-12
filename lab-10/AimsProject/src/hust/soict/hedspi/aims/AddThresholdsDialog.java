package hust.soict.hedspi.aims;


import javax.swing.*;
import java.awt.*;

public class AddThresholdsDialog {
    private final JDialog selectDialog = new JDialog();

    public AddThresholdsDialog() {
        selectDialog.setSize(500,450);
        selectDialog.getContentPane().setLayout(null);
        selectDialog.setResizable(false);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - 500))/2;
        int y = (int) ((dimension.getHeight() - 450))/2;
        selectDialog.setLocation(x, y);
        selectDialog.setModal(true);
        selectDialog.setTitle("Set");
        System.out.println("Thresholds");
        selectDialog.setVisible(false);
        JDialog thresholdsDialog = new JDialog();


        ThreshDialog thresh = new ThreshDialog(thresholdsDialog);

        // Author
        JTextField thresholdsSaleField = new JTextField();
        JLabel thresholdsSale = new JLabel("thresholdsSale");
        thresholdsSale.setSize(100,30);
        thresholdsSale.setLocation(90,180);
        thresholdsDialog.add(thresholdsSaleField);


        JTextField thresholdsTotalField = new JTextField();
        JLabel thresholdsTotal = new JLabel("thresholdsTotal");
        thresholdsTotal.setSize(100,30);
        thresholdsTotal.setLocation(90,180);
        thresholdsDialog.add(thresholdsTotalField);



        // Handler OK button
        thresh.okJButton.addActionListener(e1 -> {
            thresholdsDialog.setVisible(false);
            try {

                MenuFrame.anOrder.setThresholds(thresh.getTotal(), thresh.getSale());
                JOptionPane.showMessageDialog(null,"Success");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, e2.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
        thresholdsDialog.setVisible(true);

    }



    public static class ThreshDialog {

        JLabel totalJLabel = new JLabel("total");
        JLabel saleJLabel = new JLabel("sale");

        JButton okJButton = new JButton("OK");


        JTextField totalField = new JTextField();
        JTextField saleField = new JTextField();


        public float getSale() {
            return Float.parseFloat(saleField.getText());
        }
        public int getTotal() {
            return Integer.parseInt(totalField.getText());
        }

        public ThreshDialog(JDialog threshDialog) {

            threshDialog.setSize(500,450);
            threshDialog.setLayout(null);
            threshDialog.setResizable(false);

            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - 500))/2;
            int y = (int) ((dimension.getHeight() - 450))/2;
            threshDialog.setLocation(x, y);

            totalJLabel.setSize(100,30);
            totalJLabel.setLocation(90,20);
            threshDialog.add(totalJLabel);
            totalField.setSize(250, 30);
            totalField.setLocation(200,20);
            threshDialog.add(totalField);

            saleJLabel.setSize(100,30);
            saleJLabel.setLocation(90,60);
            threshDialog.add(saleJLabel);
            saleField.setSize(250, 30);
            saleField.setLocation(200,60);
            threshDialog.add(saleField);


            okJButton.setSize(100,30);
            okJButton.setLocation(200,330);
            okJButton.setFocusPainted(false);
            threshDialog.add(okJButton);

            threshDialog.setVisible(false);
            threshDialog.setModal(true);

        }
    }

}
