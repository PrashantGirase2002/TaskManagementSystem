package Task.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteTask extends JFrame implements ActionListener {
    
    Choice cTasktitle;
    JButton delete, back;
    
    DeleteTask() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempId = new JLabel("Task Title");
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);
        
        cTasktitle = new Choice();
        cTasktitle.setBounds(200, 50, 150, 30);
        add(cTasktitle);
        
        try {
            Connect c = new Connect();
            String query = "select * from task_table";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cTasktitle.add(rs.getString("task_title"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }     
        
        JLabel labelname = new JLabel("task_title");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);
        
        JLabel labelphone = new JLabel("task_description");
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);
        
        JLabel lblcontact = new JLabel();
        lblcontact.setBounds(200, 150, 100, 30);
        add(lblcontact);
        
        JLabel labelemail = new JLabel("due_date");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 200, 100, 30);
        add(lblemail);
        
        try {
            Connect c = new Connect();
            String query = "select * from task_table where task_title = '"+cTasktitle.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("task_title"));
                lblcontact.setText(rs.getString("task_description"));
                lblemail.setText(rs.getString("due_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cTasktitle.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Connect c = new Connect();
                    String query = "select * from task_table where task_title = '"+cTasktitle.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblcontact.setText(rs.getString("contact"));
                        lblemail.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }

    DeleteTask(String selectedItem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Connect c = new Connect();
                String query = "delete from task_table where task_title = '"+cTasktitle.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Task Deleted Sucessfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new DeleteTask();
    }
}
