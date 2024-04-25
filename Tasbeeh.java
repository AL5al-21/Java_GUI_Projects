import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Tasbeeh extends JFrame implements MouseListener  {
    JTextField textField1;
    JLabel ll,lr,lc ;
    Tasbeeh(){
    super("Test Window");
    try{
        String filename="./digital-7.ttf";
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File(filename));
        font = font.deriveFont(Font.BOLD,60);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        textField1 = new JTextField("0");
        
        textField1.setFont(font);
    }
    catch(Exception t){
        t.printStackTrace();

    }

    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container container = this.getContentPane();
    container.setBackground(new Color(0,0,0));
    lr = new JLabel(new ImageIcon("./resetb.png"));
    lr.setBounds(350,288,50,50);
    lc = new JLabel(new ImageIcon("./count.png"));
    
    lc.setBounds(195,330,166,161);
    
    container.setLayout(null);
    ll = new JLabel(new ImageIcon("./1.png"));

    ll.setBounds(20, 20, 512, 512);
    
    textField1.setBounds(135, 115, 285, 105);
    textField1.setEditable(false);
    textField1.setBackground(new Color(150,160,152));
    lr.addMouseListener(this);
    lc.addMouseListener(this);
    
    container.add(lc);
    container.add(lr);
    container.add(ll);
    container.add(textField1);
    
    
    

    setSize(600,600);
	setVisible(true);
    }
    public static void main(String[] args) {
        Tasbeeh t = new Tasbeeh();
    }
    public void mouseClicked(MouseEvent e) { 
        if(e.getSource() == lc){
           
            int n = Integer.parseInt(textField1.getText());
            
            n = n +1;
            if(n == 1000000000){
                System.out.println(n);
                n = 0;
                textField1.setText(""+n);
            }
            textField1.setText(String.valueOf(n));
            
        }
        if(e.getSource() == lr){
            textField1.setText("0");
        }

    } 
    public void mouseEntered(MouseEvent e) { 
        
    } 
    public void mouseExited(MouseEvent e) { 
     
    } 
    public void mousePressed(MouseEvent e) { 
       
    } 
    public void mouseReleased(MouseEvent e) { 
       
    } 
    
}

