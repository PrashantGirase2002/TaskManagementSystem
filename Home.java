
package Task.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    JButton add,view,update,Delete;
    Home(){
    setLayout(null);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
    Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,1120,630);
    add(image);
    JLabel heading=new JLabel("TASK MANAGEMENT SYSTEM");
    heading.setBounds(650,20,450,40);
    heading.setFont(new Font("Railway",Font.BOLD,25));
  
    image.add(heading);
    
     add= new JButton("Add Task");
    add.setBounds(650,80,150,40);
    add.addActionListener(this);
    image.add(add);
    
     view= new JButton("View Tasks");
    view.setBounds(820,80,150,40);
    view.addActionListener(this);
    image.add(view);
    
     update= new JButton("Update Task");
    update.setBounds(650,140,150,40);
    update.addActionListener(this);
    image.add(update);
    
     Delete= new JButton("Delete Task");
    Delete.setBounds(820,140,150,40);
    Delete.addActionListener(this);
    image.add(Delete);
    
    
    
    setSize(1120,630);
    setLocation(50,50);
    setVisible(true);
   
    
    }
    
    public void actionPerformed(ActionEvent ae){
    if (ae.getSource()==add){
    setVisible(false);
    new CreateTask();
    }else if(ae.getSource()==view){
    setVisible(false);
    new ViewTask();
    }else if(ae.getSource()==update){
    setVisible(false);
    new UpdateTask();
    }else{
    setVisible(false);
    new DeleteTask();
    }
    }
    public static void main(String args[]){
    new Home();
    }
}
