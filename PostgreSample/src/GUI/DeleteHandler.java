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

public class DeleteHandler implements ActionListener {


    JTable viewTable;
    Connection connection;
    Statement statement = null;
    ResultSet rs = null;

    public DeleteHandler(JTable viewTable){
        this.viewTable = viewTable;
        connection = new DB().getConnection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if(button.getText().equals("Delete Customer")){
            int selectedRowIndex = viewTable.getSelectedRow();
            String customerid = String.valueOf(viewTable.getValueAt(selectedRowIndex,0));

            try {
                statement = connection.createStatement();
                String sql = "DELETE FROM Customer WHERE customerid ="+customerid;
                statement.executeUpdate(sql);
                statement.close();
                connection.close();
                JOptionPane.showMessageDialog(null, "The Customer is Deleted!");
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong!, Failure!");
            }
        }
        else if(button.getText().equals("Delete Supplier")){
            int selectedRowIndex = viewTable.getSelectedRow();
            String supplierid = String.valueOf(viewTable.getValueAt(selectedRowIndex,0));

            try {
                statement = connection.createStatement();
                String sql = "DELETE FROM Supplier WHERE supplierid ="+supplierid;
                statement.executeUpdate(sql);
                statement.close();
                connection.close();
                JOptionPane.showMessageDialog(null, "The Customer is Deleted!");
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong!, Failure!");
            }
        }
        else if(button.getText().equals("Delete Product")){
            int selectedRowIndex = viewTable.getSelectedRow();
            String productid = String.valueOf(viewTable.getValueAt(selectedRowIndex,0));

            try {
                statement = connection.createStatement();
                String sql = "DELETE FROM Product WHERE productid ="+productid;
                statement.executeUpdate(sql);
                statement.close();
                connection.close();
                JOptionPane.showMessageDialog(null, "The Customer is Deleted!");
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong!, Failure!");
            }
        }
        else if(button.getText().equals("Delete Order")){
            int selectedRowIndex = viewTable.getSelectedRow();
            String orderid = String.valueOf(viewTable.getValueAt(selectedRowIndex,0));

            try {
                statement = connection.createStatement();
                String sql = "DELETE FROM Orders WHERE orderid ="+orderid;
                statement.executeUpdate(sql);
                statement.close();
                connection.close();
                JOptionPane.showMessageDialog(null, "The Customer is Deleted!");
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong!, Failure!");
            }
        }
        else if(button.getText().equals("Delete Order Item")){
            int selectedRowIndex = viewTable.getSelectedRow();
            String orderitemid = String.valueOf(viewTable.getValueAt(selectedRowIndex,0));

            try {
                statement = connection.createStatement();
                String sql = "DELETE FROM Orderitem WHERE orderitemid ="+orderitemid;
                statement.executeUpdate(sql);
                statement.close();
                connection.close();
                JOptionPane.showMessageDialog(null, "The Customer is Deleted!");
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Something went wrong!, Failure!");
            }
        }
    }
}
