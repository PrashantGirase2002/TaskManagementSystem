package Task.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class UpdateTask extends JFrame implements ActionListener {
    private JTextField tftitle, tfdescription;
    private JDateChooser dcdob;
    private JButton update, back;
    private String task_title;

    UpdateTask(String task_title) {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        this.task_title = task_title;

        JLabel heading = new JLabel("Update Task Detail");
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

        update = new JButton("Update Task");
        update.setBounds(250, 400, 150, 40);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);

        back = new JButton("Back");
        back.setBounds(450, 400, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        // Load existing task details
        try {
            Connect conn = new Connect();
            String query = "SELECT * FROM task_table WHERE task_title=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, task_title);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                tftitle.setText(rs.getString("task_title"));
                tfdescription.setText(rs.getString("task_description"));
                String dueDate = rs.getString("due_date");
                ((JTextField) dcdob.getDateEditor().getUiComponent()).setText(dueDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    UpdateTask() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String new_title = tftitle.getText();
            String new_description = tfdescription.getText();
            String new_due_date = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();

            try {
                Connect conn = new Connect();
                String query = "UPDATE task_table SET task_title=?, task_description=?, due_date=? WHERE task_title=?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, new_title);
                preparedStatement.setString(2, new_description);
                preparedStatement.setString(3, new_due_date);
                preparedStatement.setString(4, task_title);
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Task updated successfully");
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
        new UpdateTask("");
    }
}
