import java.awt.*; 
import javax.swing.*; 
class MyFrame extends JFrame 
{ 
  private JLabel label; 
  private JButton button1, button2; 
  private JPanel panel1=new JPanel(); 
  private JPanel panel2=new JPanel(); 
  static int x=200,y=50; 
  public MyFrame() 
  { 
    this.setTitle("박스 움직이기"); 
    this.setSize(500,400); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    label =new JLabel(""); 
    label.setSize(80,300); 
    label.setLocation(x,y); 
    label.setOpaque(true); 
    label.setBackground(Color.red); 
    panel1.setLayout(null); 
    panel1.setSize(500,400); 
    panel1.setLocation(0,0); 
    panel1.setBackground(Color.yellow); 
    panel1.add(label); 
    button1=new JButton("왼쪽으로 이동"); 
    button1.addActionListener(e-> 
    { 
      x-=10; 
      label.setLocation(x,y); 
   }); 
   button2=new JButton("오른쪽으로 이동"); 
   button2.addActionListener(e-> 
   { 
     x+=20; 
     label.setLocation(x, y); 
  }); 
  panel2.add(button1); 
  panel2.add(button2); 
  this.add(BorderLayout.CENTER,panel1); 
  this.add(BorderLayout.SOUTH,panel2); 
  Dimension frameSize=this.getSize(); 
  Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize(); 
  this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2); 
  setResizable(true); 
  this.setVisible(true); 
} 
} 
public class BoxMove { 
  public static void main(String[] args) { 
    MyFrame f= new MyFrame(); 
 } 
}