package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainHandler implements ActionListener {

    JFrame frame;





    public MainHandler(JFrame frame){
        this.frame = frame;


    }
    public MainHandler(){



    }


    @Override
    public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if(button.getText().equals("Insert Operations")){
                frame.getContentPane().removeAll();
                frame.setLayout(new GridLayout(5,1));

                JButton customer = new JButton("Customer Insertion");
                JButton orderItem = new JButton("Order Item Insertion");
                JButton orders = new JButton ("Order Insertion");
                JButton product = new JButton("Product Insertion");
                JButton supplier = new JButton("Supplier Insertion");

                customer.addActionListener(new MainHandler());
                orderItem.addActionListener(new MainHandler());
                orders.addActionListener(new MainHandler());
                product.addActionListener(new MainHandler());
                supplier.addActionListener(new MainHandler());

                frame.add(customer);
                frame.add(orderItem);
                frame.add(orders);
                frame.add(product);
                frame.add(supplier);

                frame.revalidate();
                frame.repaint();


            }
            else if(button.getText().equals("Customer Insertion")){
              new InsertCustomer();

            }
            else if(button.getText().equals("Order Item Insertion")){
                new InsertOrderItem();
            }
            else if(button.getText().equals("Order Insertion")){
                new InsertOrders();
            }
            else if(button.getText().equals("Product Insertion")){
                new InsertProduct();
            }
            else if(button.getText().equals("Supplier Insertion")){
                new InsertSupplier();
            }

            //view Operations

            else if(button.getText().equals("View and Delete Operations")){
                new View();
            }
 }
}

