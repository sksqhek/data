import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test extends Thread
{
	static JFrame f = new JFrame();
	static JButton btn1 = new JButton();
	static JButton btn2 = new JButton();
	static int t = 0;
	static boolean tmrToggle = true;	
	
	@Override
	public void run()
	{
		try
		{
			while (true)
			{	
				if (tmrToggle == true)
				{					
					t += 1;
					System.out.println("" + t);
				}
				Thread.sleep(1000);
			}
		} catch (InterruptedException e)
		{
		}
	}

	public static void main(String[] args)
	{		
		Test test = new Test();
		test.start();
		f.setVisible(true);
		f.setPreferredSize(new Dimension(500, 500));
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		btn1.setBounds(0, 0, 100, 100);
		btn1.setText("start");
		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{				
				tmrToggle = true;
			}
		});
		btn2.setBounds(200, 0, 100, 100);
		btn2.setText("pause");
		btn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{				
				tmrToggle = false;				
			}
		});
		f.add(btn1);
		f.add(btn2);
	}
}