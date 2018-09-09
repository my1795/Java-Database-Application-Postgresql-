package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.*;
import java.util.Vector;

public class DbHandler implements ActionListener {
    Connection connection;
    Statement statement = null;
    ResultSet rs = null;
    InsertCustomer customer;
    InsertSupplier supplier;
    InsertOrders orders;
    InsertProduct product;
    InsertOrderItem orderItem;

    View view;

    public DbHandler(InsertCustomer customer) {
        connection = new DB().getConnection();
        this.customer = customer;
    }

    public DbHandler(InsertSupplier supplier) {
        connection = new DB().getConnection();
        this.supplier = supplier;
    }

    public DbHandler(InsertOrders orders) {
        connection = new DB().getConnection();
        this.orders = orders;
    }

    public DbHandler(InsertProduct product) {
        connection = new DB().getConnection();
        this.product = product;
    }

    public DbHandler(InsertOrderItem orderItem) {
        connection = new DB().getConnection();
        this.orderItem = orderItem;
    }

    public DbHandler(View view) {
        connection = new DB().getConnection();
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        // Insert Operations
        if (button.getText().equals("Insert Customer")) {

            try {
                statement = connection.createStatement();
                String sql = "INSERT INTO Customer " +
                        "VALUES (DEFAULT" + ",'" + customer.getCustomerName() + "','" + customer.getCustomerLastName() + "','" + customer.getCustomerCity() + "'," + customer.getCustomerPhone() + ");";
                statement.executeUpdate(sql);
                statement.close();
                connection.close();
                JOptionPane.showMessageDialog(null, "The Customer is Inserted!");
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong!, Failure!");
            }
        } else if (button.getText().equals("Insert Supplier")) {
            try {
                statement = connection.createStatement();
                String sql = "INSERT INTO Supplier " +
                        "VALUES (DEFAULT" + ",'" + supplier.getSupplierName() + "','" + supplier.getSupplierCity() + "'," + supplier.getSupplierPhone() + ");";
                statement.executeUpdate(sql);
                statement.close();
                connection.close();
                JOptionPane.showMessageDialog(null, "The Supplier is Inserted!");
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong!, Failure!");
            }
        } else if (button.getText().equals("Insert Order")) {
            try {
                statement = connection.createStatement();
                String sql = "INSERT INTO Orders " +
                        "VALUES (DEFAULT," + orders.getOrderNumber() + "," + orders.getCustomerID() + ",0,DEFAULT);";
                statement.executeUpdate(sql);
                statement.close();
                connection.close();
                JOptionPane.showMessageDialog(null, "The Order is Inserted!");
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong!, Failure!");
            }
        } else if (button.getText().equals("Insert Product")) {

            try {
                statement = connection.createStatement();
                String sql = "INSERT INTO Product " +
                        "VALUES (DEFAULT,'" + product.getProductName() + "'," + product.getSupplierID() + "," + product.getUnitPrice() + ");";
                statement.executeUpdate(sql);
                statement.close();
                connection.close();
                JOptionPane.showMessageDialog(null, "The Product is Inserted!");
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong!, Failure!");
            }
        } else if (button.getText().equals("Insert Order Item")) {
            try {
                statement = connection.createStatement();
                String sql = "INSERT INTO Orderitem " +
                        "VALUES (DEFAULT," + orderItem.getOrderID() + "," + orderItem.getProductID() + ",DEFAULT," + orderItem.getQuantity() + ");";
                statement.executeUpdate(sql);
                statement.close();
                connection.close();
                JOptionPane.showMessageDialog(null, "The Order Item is Inserted!");
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong!, Failure!");
            }
        }

        // View Operations

        else if (button.getText().equals("View Customers")) {
            try {
                statement = connection.createStatement();
                String sql = "SELECT * FROM Customer;";
                ResultSet rs = statement.executeQuery(sql);

                view.clearCenterPanel();

                JTable viewTable = new JTable(buildTableModel(rs));
                view.setTableScrollPane(new JScrollPane(viewTable));

                JButton deleteCustomer = new JButton("Delete Customer");
                deleteCustomer.addActionListener(new DeleteHandler(viewTable));
                view.addButtonOnSouthPanel(deleteCustomer);

                view.revalidate();
                view.repaint();

                if(!view.isValid()){
                    statement.close();
                    connection.close();
                }


            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong!, Failure!");
            }
        }
        else if(button.getText().equals("View Suppliers")){
            try {
                statement = connection.createStatement();
                String sql = "SELECT * FROM Supplier;";
                ResultSet rs = statement.executeQuery(sql);

                view.clearCenterPanel();
                JTable viewTable = new JTable(buildTableModel(rs));
                view.setTableScrollPane(new JScrollPane(viewTable));

                JButton deleteSupplier = new JButton("Delete Supplier");
                deleteSupplier.addActionListener(new DeleteHandler(viewTable));
                view.addButtonOnSouthPanel(deleteSupplier);

                view.revalidate();
                view.repaint();

                if(!view.isValid()){
                    statement.close();
                    connection.close();
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong!, Failure!");
            }
        }
        else if(button.getText().equals("View Orders")){
            try {
                statement = connection.createStatement();
                String sql = "SELECT * FROM Orders;";
                ResultSet rs = statement.executeQuery(sql);

                view.clearCenterPanel();
                JTable viewTable = new JTable(buildTableModel(rs));
                view.setTableScrollPane(new JScrollPane(viewTable));

                JButton deleteOrder = new JButton("Delete Order");
                deleteOrder.addActionListener(new DeleteHandler(viewTable));
                view.addButtonOnSouthPanel(deleteOrder);

                view.revalidate();
                view.repaint();

                if(!view.isValid()){
                    statement.close();
                    connection.close();
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong!, Failure!");
            }
        }
        else if(button.getText().equals("View Products")){
            try {
                statement = connection.createStatement();
                String sql = "SELECT * FROM Product;";
                ResultSet rs = statement.executeQuery(sql);

                view.clearCenterPanel();
                JTable viewTable = new JTable(buildTableModel(rs));
                view.setTableScrollPane(new JScrollPane(viewTable));

                JButton deleteProduct = new JButton("Delete Product");
                deleteProduct.addActionListener(new DeleteHandler(viewTable));
                view.addButtonOnSouthPanel(deleteProduct);

                view.revalidate();
                view.repaint();

                if(!view.isValid()){
                    statement.close();
                    connection.close();
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong!, Failure!");
            }
        }
        else if (button.getText().equals("View Order Items")){
            try {
                statement = connection.createStatement();
                String sql = "SELECT * FROM Orderitem;";
                ResultSet rs = statement.executeQuery(sql);

                view.clearCenterPanel();
                JTable viewTable = new JTable(buildTableModel(rs));
                view.setTableScrollPane(new JScrollPane(viewTable));

                JButton deleteOrderItem = new JButton("Delete Order Item");
                deleteOrderItem.addActionListener(new DeleteHandler(viewTable));
                view.addButtonOnSouthPanel(deleteOrderItem);

                view.revalidate();
                view.repaint();

                if(!view.isValid()){
                    statement.close();
                    connection.close();
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong!, Failure!");
            }
        }

    }
    private DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }
}

