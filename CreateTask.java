package Task.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class CreateTask extends JFrame implements ActionListener{
   
    
    JTextField tftitle, tfdescription ;
    JDateChooser dcdob;
    
  
    JButton add, back;
    
    CreateTask() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Task Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Title");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tftitle = new JTextField();
        tftitle.setBounds(200, 150, 150, 30);
        add(tftitle);
        
        JLabel labelfname = new JLabel("Description");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        tfdescription = new JTextField();
        tfdescription.setBounds(600, 150, 150, 30);
        add(tfdescription);
        
        JLabel labeldob = new JLabel("Due Date");
        labeldob.setBounds(50, 250, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 250, 150, 30);
        add(dcdob);
        
       
       
        
      
       
        
        
        
       
       
        
        add = new JButton("Add Task");
        add.setBounds(250, 400, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 400, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String task_title = tftitle.getText();
            String task_description = tfdescription.getText();
            String due_date = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
           
            
            
            try {
                Connect conn = new Connect();
               
                String query = "insert into task_table values('"+task_title+"','"+task_description+"','"+due_date+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
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
        new CreateTask();
    }
}
