package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class InsertSupplier extends JFrame {

    JTextField name;
    JTextField city;
    JTextField phone;
    public InsertSupplier(){
        this.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600,600);
        setVisible(true);
        initComponents();
    }


    private void initComponents(){
        JButton insertSupplier = new JButton("Insert Supplier");
        add(insertSupplier,BorderLayout.NORTH);
        insertSupplier.addActionListener(new DbHandler(this));


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout( new GridLayout(2,3));

         name = new JTextField();
        city = new JTextField();
        phone   = new JTextField();

        centerPanel.add(new JLabel("Supplier Name"));
        centerPanel.add(new JLabel("Supplier City"));
        centerPanel.add(new JLabel("Supplier Phone"));

        centerPanel.add(name);
        centerPanel.add(city);
        centerPanel.add(phone);

        add(centerPanel,BorderLayout.CENTER);

    }

    public String getSupplierName(){
        return name.getText();
    }
    public String getSupplierCity(){
        return city.getText();
    }
    public String getSupplierPhone(){
        return phone.getText();
    }


}
