import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Window extends JFrame {
    private JButton openButton;
    private JButton addButton;
    private StudentCollection studentCollection;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private DefaultListModel model1;
    private DefaultListModel model2;
    private JList<Student> leftList;
    private JList<Student> rightList;

    Window() {
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        openButton = new JButton("Open file");
        addButton = new JButton("Add student");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(openButton);
        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.SOUTH);
        studentCollection = new StudentCollection();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        add(leftPanel,  BorderLayout.WEST);
        add(rightPanel,  BorderLayout.EAST);
        model1 = new DefaultListModel();
        model2 = new DefaultListModel();
        leftList = new JList<Student>(model1);
        rightList = new JList<Student>(model2);
        leftPanel.add(leftList);
        rightPanel.add(rightList);

        openButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser chooser = new JFileChooser();
                if (chooser.showOpenDialog(Window.this) == JFileChooser.APPROVE_OPTION) {
                    File inputFile = chooser.getSelectedFile();
                    studentCollection.clear();
                    try {
                        studentCollection.loadStudents(inputFile);
                        update();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(Window.this, "Error when opening file");
                    } catch (InputMismatchException ex) {
                        studentCollection.clear();
                        update();
                        JOptionPane.showMessageDialog(Window.this, "Error data");
                    }
                }
            }
        });

        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int cardNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter card number", 123456));
                    String surname = JOptionPane.showInputDialog("Enter surname", "");
                    String subject = JOptionPane.showInputDialog("Enter subject", "");
                    Integer grade = Integer.parseInt(JOptionPane.showInputDialog("Enter grade", 10));
                    studentCollection.addStudent(cardNumber, surname, subject, grade);
                    update();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Window.this, "Error data");
                }
            }

        });
        setVisible(true);
    }

    private void update() {
        model1.clear();
        model2.clear();
        for (Student i : studentCollection.starterStudentsData) {
            model1.addElement(i);
        }
        for (Student i : studentCollection.processedStudentData) {
            model2.addElement(i);
        }
    }
}
