package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public  class View extends JFrame {
    private JPanel centerpanel;
    private JPanel northPanel;
    private JPanel southPanel;


    public View(){
        this.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800,600);
        setVisible(true);
        initComponents();
    }

    private void  initComponents(){
        JButton viewCustomers = new JButton("View Customers");
        JButton viewProducts = new JButton("View Products");
        JButton viewOrders = new JButton("View Orders");
        JButton viewSuppliers = new JButton("View Suppliers");
        JButton viewOrderItems = new JButton("View Order Items");

        viewCustomers.addActionListener(new DbHandler(this));
        viewProducts.addActionListener(new DbHandler(this));
        viewOrders.addActionListener(new DbHandler(this));
        viewSuppliers.addActionListener(new DbHandler(this));
        viewOrderItems.addActionListener(new DbHandler(this));

        northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1,4));
        northPanel.add(viewCustomers);
        northPanel.add(viewSuppliers);
        northPanel.add(viewProducts);
        northPanel.add(viewOrders);
        northPanel.add(viewOrderItems);

        add(northPanel,BorderLayout.NORTH);

        centerpanel = new JPanel();
        add(centerpanel,BorderLayout.CENTER);

        southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        add(southPanel,BorderLayout.SOUTH);


    }

    public void setTableScrollPane (JScrollPane tablePane){
        centerpanel.add(tablePane);
    }
    public void clearCenterPanel(){
        centerpanel.removeAll();

    }

    public void addButtonOnSouthPanel(JButton button){
        southPanel.removeAll();
        southPanel.add(button,BorderLayout.CENTER);
    }


}
