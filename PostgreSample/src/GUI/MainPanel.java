package GUI;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JFrame {

    public MainPanel(){
        this.setLayout(new GridLayout(2,1));
        initPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);

    }

    private void initPanel(){
        JButton insertOperations = new JButton("Insert Operations");
        JButton viewOperations = new JButton ("View and Delete Operations");

        insertOperations.addActionListener(new MainHandler(this));
        viewOperations.addActionListener(new MainHandler(this));

        this.add(insertOperations);
        this.add(viewOperations);
    }
}
