import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyFrame extends JFrame {
    MyFrame(String name) {
        super(name);
        setSize(500, 300);
        setLayout(new FlowLayout());
        JRadioButton linerButton = new JRadioButton("Liner");
        linerButton.setSelected(true);
        JRadioButton exponentialButton = new JRadioButton("Exponential");
        add(linerButton);
        add(exponentialButton);
        ButtonGroup radioButtonsGroup = new ButtonGroup();
        radioButtonsGroup.add(linerButton);
        radioButtonsGroup.add(exponentialButton);

        JTextField firstElementField = new JTextField("First element", 10);
        add(firstElementField);
        JTextField coeficentField = new JTextField("Coeficent", 10);
        add(coeficentField);
        JTextField amountField = new JTextField("Amount", 10);
        add(amountField);

        JButton generateButton = new JButton("Create series");
        add(generateButton);

        JTextField pathField = new JTextField("Path", 40);
        add(pathField);

        JButton saveButton = new JButton("Save");
        saveButton.setEnabled(false);
        add(saveButton);

        JLabel elementsLabel = new JLabel("Elements");
        add(elementsLabel);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isErrors = false;
                double firstElement = 0;
                double coeficent = 0;
                int amount = 0;
                try {
                    firstElement = Double.parseDouble(firstElementField.getText());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(MyFrame.this, "Wrong argument in first element field");
                    isErrors = true;
                }
                try {
                    coeficent = Double.parseDouble(coeficentField.getText());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(MyFrame.this, "Wrong argument in coeficent field");
                    isErrors = true;
                }
                try {
                    amount = Integer.parseInt(amountField.getText());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(MyFrame.this, "Wrong argument in amount field");
                    isErrors = true;
                }

                if (isErrors == false) {
                    saveButton.setEnabled(true);
                    if (linerButton.isSelected()) {
                        s = new Liner(firstElement, coeficent, amount);
                    } else {
                        s = new Exponential(firstElement, coeficent, amount);
                    }
                    elementsLabel.setText(s.toElements());
                } else {
                    saveButton.setEnabled(false);
                    elementsLabel.setText("Elements");
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String filePath = pathField.getText();
                    if (filePath.length() == 0) {
                        s.writeToFile("D:/proga 3 sem/Java/Lab5/src/output.txt");
                    } else {
                        s.writeToFile(filePath);
                    }
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(MyFrame.this, "Error when writing to a file");
                }
            }
        });
    }

    Series s;
}
