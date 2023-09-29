package Task.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewTask extends JFrame implements ActionListener{

    JTable table;
    Choice ctask_title,ctask_description;
    JButton search, update, back;
    
    ViewTask() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search Task By Title");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        ctask_title = new Choice();
        ctask_title.setBounds(180, 20, 150, 20);
        add(ctask_title);
        
        
        
        JLabel searchlbl1 = new JLabel("Search Task By Description");
        searchlbl1.setBounds(20, 60, 150, 20);
        add(searchlbl1);
        
        ctask_description = new Choice();
        ctask_description.setBounds(180, 60, 150, 20);
        add(ctask_description);
        
        
        try {
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from task_table");
            while(rs.next()) {
                ctask_title.add(rs.getString("task_title"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from task_table");
            while(rs.next()) {
                ctask_description.add(rs.getString("task_description"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        table = new JTable();
        
        try {
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from task_table");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(120, 100, 80, 20);
        search.addActionListener(this);
        add(search);
        
       
        
        update = new JButton("Update");
        update.setBounds(220, 100, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 100, 80, 20);
        back.addActionListener(this);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    @Override
    
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == search) {
        String query = "select * from task_table where task_title like '%" + ctask_title.getSelectedItem() + "%' or task_description like '%" + ctask_description.getSelectedItem() + "%'";
        
        try {
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == update) {
        setVisible(false);
        new UpdateTask(ctask_title.getSelectedItem());
    } else {
        setVisible(false);
        new Home();
    }
}


    public static void main(String[] args) {
        new ViewTask();
    }
}
