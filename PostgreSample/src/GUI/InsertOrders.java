package GUI;

import javax.swing.*;
import java.awt.*;

public class InsertOrders extends JFrame {
    JTextField orderNumber;
    JTextField customerid;

    public InsertOrders(){
        this.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,400);
        setVisible(true);

        initComponents();

    }
    private void initComponents(){
        JButton insertOrder = new JButton("Insert Order");
        add(insertOrder,BorderLayout.NORTH);
        insertOrder.addActionListener(new DbHandler(this));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout( new GridLayout(2,2));

        orderNumber = new JTextField();
        customerid = new JTextField();

        centerPanel.add(new JLabel("Order Number"));
        centerPanel.add(new JLabel("Customer ID"));

        centerPanel.add(orderNumber);
        centerPanel.add(customerid);

        add(centerPanel,BorderLayout.CENTER);
    }

    public String getOrderNumber(){
        return orderNumber.getText();
    }
    public String getCustomerID(){
        return customerid.getText();
    }

}
