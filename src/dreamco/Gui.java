
package dreamco;

//by JERRY <3  
//////////////////////////////////////////////////////////////////////////////////////////////// THIS CLASS IS BASICALLY A GUI BUILDER/ FRAMERWORK TO PRODUCE GUIs
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//imports for the buttons
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Gui extends JFrame{

    ////////////////////////////////////////////////////////////////////////////////////////////Basic input setting
public static void dialogBox(){    
    String fn= JOptionPane.showInputDialog("Enter Name");
    String sn= JOptionPane.showInputDialog("Enter Password");    
//    int num1= Integer.parseInt(fn);
//    int num2= Integer.parseInt(sn);
//    int sum=num1+num2;
    JOptionPane.showMessageDialog(null, "The answer is " , "The title", JOptionPane.PLAIN_MESSAGE); //shows tat a message box
    }

///////////////////////////////////////////////////////////////////////////////////////////////// BUILDER DECLARATIONS 
private JLabel item1;
private JTextField fld1;
private JTextField fld2;
private JTextField fld3;
private JPasswordField pass;

private JButton yesbutton;
private JButton nobutton;
private JButton custombutton;


///////////////////////////////// /////////////////////////////////////////////////////////////This is just a constructor for the STARTUP Gui Frame/////////////////////////////////
public Gui(){
    super("2R2 DreamCo Scam"); //The 
    setLayout(new FlowLayout());
    
//    Icon b= new ImageIcon(getClass().getResource("b.png"));
//    custombutton=new JButton("Custom",b);
//    custombutton.setRolloverIcon(b);
    

    item1=new JLabel("This is a sentence");
    item1.setToolTipText("This is going to show up on hover");
    add(item1);
    
    fld1= new JTextField(10);
    add(fld1);
    
    fld2=new JTextField(10);
    add(fld2);
    
    fld3=new JTextField(10);
    fld3.setEditable(false);
    add(fld3);
    
    pass=new JPasswordField(10);
    add(pass);
    
    yesbutton= new JButton("Yes");
    add(yesbutton);
    nobutton=new JButton("no");
    add(nobutton);
//    nobutton.setVisible(false);
    
    
    ActHandler handler= new ActHandler();
    fld1.addActionListener(handler);
    fld2.addActionListener(handler);
    fld3.addActionListener(handler);
    pass.addActionListener(handler);
}

private class ActHandler implements ActionListener{  //This class is a subclass for action listener to handle events 
    @Override
    public void actionPerformed(ActionEvent event){
        String string= "";

        if(event.getSource()==fld1)
            string=String.format("field 1: %s", event.getActionCommand());
        else if(event.getSource()==fld2)
            string=String.format("field 1: %s", event.getActionCommand());
        else if(event.getSource()==fld3)
            string=String.format("field 1: %s", event.getActionCommand());  
        else if(event.getSource()==pass)
            string=String.format("password is: %s", event.getActionCommand());      
        
        JOptionPane.showMessageDialog(null, string);
    }  
}
/////////////////////////////////////////////////////////////////////////////////////////////// THIS IS WHERE STARTUP Gui Frame ENDS //////////////////////////////////////////////////////////

public static void runStartupFrame(){
    Gui startupGui=new Gui();
    startupGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    startupGui.setSize(400,700);
    startupGui.setLocationRelativeTo(null);
    startupGui.setVisible(true);
}

}