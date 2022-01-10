import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Task1 extends JPanel {
    private JPanel mainPanel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    Task1() {
        super();
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        add(leftPanel,  BorderLayout.WEST);
        add(rightPanel,  BorderLayout.EAST);

        mainPanel.setLayout(new BorderLayout());
        JButton rightButton = new JButton("->");
        JButton leftButton = new JButton("<-");
        mainPanel.add(rightButton, BorderLayout.SOUTH);
        mainPanel.add(leftButton, BorderLayout.NORTH);

        final String[] data1 = { "Чай" ,"Кофе"  ,"Минеральная","Морс"};
        final String[] data2 = { "Ясли","Детсад", "Школа"     , "Институт",
                "Университет"};

        DefaultListModel model1 = new DefaultListModel();
        DefaultListModel model2 = new DefaultListModel();
        for (int i = 0; i < data1.length; ++i) {
            model1.addElement(data1[i]);
        }
        for (int i = 0; i < data2.length; ++i) {
            model2.addElement(data2[i]);
        }
        JList<String> leftList = new JList<String>(model1);
        JList<String> rightList = new JList<String>(model2);

        leftList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        rightList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        leftPanel.add(leftList);
        rightPanel.add(rightList);

        rightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int[] indices = leftList.getSelectedIndices();
                for (int i = 0; i < indices.length; ++i) {
                    model2.addElement(model1.getElementAt(indices[i]));
                }
                for (int i = indices.length-1; i >= 0;--i) {
                    model1.remove(indices[i]);
                }
             }
        });
        leftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int[] indices = rightList.getSelectedIndices();
                for (int i = 0; i < indices.length; ++i) {
                    model1.addElement(model2.getElementAt(indices[i]));
                }
                for (int i = indices.length-1; i >= 0;--i) {
                    model2.remove(indices[i]);
                }
            }
        });
    }

}
