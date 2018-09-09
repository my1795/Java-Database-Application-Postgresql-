package GUI;

import javax.swing.*;
import java.awt.*;

public class InsertCustomer extends JFrame {
    JTextField name;
    JTextField lastName;
    JTextField city;
    JTextField phone;



    public InsertCustomer(){
        this.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600,600);
        setVisible(true);
        initComponents();
    }

    private void initComponents(){
        JButton insertCustomer = new JButton("Insert Customer");
        add(insertCustomer,BorderLayout.NORTH);
        insertCustomer.addActionListener(new DbHandler(this));


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout( new GridLayout(2,4));

         name = new JTextField();
        lastName  = new JTextField();
        city = new JTextField();
        phone  = new JTextField();

        centerPanel.add(new JLabel("Customer Name"));
        centerPanel.add(new JLabel("Customer Lastname"));
        centerPanel.add(new JLabel("Customer City"));
        centerPanel.add(new JLabel("Customer Phone"));

        centerPanel.add(name);
        centerPanel.add(lastName);
        centerPanel.add(city);
        centerPanel.add(phone);

       add(centerPanel,BorderLayout.CENTER);



    }
    public String getCustomerName(){
        return name.getText();
    }
    public String getCustomerLastName(){
        return lastName.getText();
    }
    public String getCustomerCity(){
        return city.getText();
    }
    public String getCustomerPhone(){
        return phone.getText();
    }

}
