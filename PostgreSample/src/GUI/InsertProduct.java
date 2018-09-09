package GUI;

import javax.swing.*;
import java.awt.*;

public class InsertProduct extends JFrame {

    private  JTextField productname;
    private JTextField supplierid;
    private JTextField unitprice;

    public InsertProduct(){
        this.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600,600);
        setVisible(true);

        initComponents();

    }
    private void initComponents(){
        JButton insertProduct = new JButton("Insert Product");
        add(insertProduct,BorderLayout.NORTH);
        insertProduct.addActionListener(new DbHandler(this));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout( new GridLayout(2,3));

        productname = new JTextField();
        supplierid = new JTextField();
        unitprice = new JTextField();


        centerPanel.add(new JLabel("Product Name"));
        centerPanel.add(new JLabel("Supplier ID"));
        centerPanel.add(new JLabel("Unit Price"));

        centerPanel.add(productname);
        centerPanel.add(supplierid);
        centerPanel.add(unitprice);

        add(centerPanel,BorderLayout.CENTER);

    }

    public String getProductName(){
        return productname.getText();}
     public String getSupplierID() {
        return supplierid.getText();
     }
     public String getUnitPrice(){
        return unitprice.getText();
     }
}
