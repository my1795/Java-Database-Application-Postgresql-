package GUI;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import static com.sun.glass.ui.Cursor.setVisible;

public class InsertOrderItem extends JFrame {
    JTextField orderid;
    JTextField productid;
    JTextField quantity;

    public InsertOrderItem(){
        this.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,400);
        setVisible(true);
        initComponents();


    }

    private void initComponents(){
        JButton InsertOrderItem = new JButton("Insert Order Item");
        add(InsertOrderItem,BorderLayout.NORTH);
        InsertOrderItem.addActionListener(new DbHandler(this));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout( new GridLayout(2,3));

        centerPanel.add(new JLabel("Order ID"));
        centerPanel.add(new JLabel("Product ID"));
        centerPanel.add(new JLabel("Quantity"));

        orderid = new JTextField();
        productid = new JTextField();
        quantity = new JTextField();

        centerPanel.add(orderid);
        centerPanel.add(productid);
        centerPanel.add(quantity);
        add(centerPanel,BorderLayout.CENTER);

    }
    public String getOrderID(){
        return orderid.getText();
    }
    public String getProductID(){
        return productid.getText();
    }
    public String getQuantity(){
        return quantity.getText();
    }
}
