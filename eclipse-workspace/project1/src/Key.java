import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Key extends JFrame
{
	JPanel contentPane = new JPanel();

	Key()
	{
		super("키 누르기 떼기 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		contentPane.setBackground(Color.CYAN);
		contentPane.addKeyListener(new MyKeyListener());
		setSize(500, 500);
		setVisible(true);
		contentPane.requestFocus();
	}

	class MyKeyListener extends KeyAdapter
	{		
		@Override
		public void keyPressed(KeyEvent e)
		{
			if (e.getKeyChar() == 'R')
			{
				contentPane.setBackground(Color.red);
			}
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			if (e.getKeyChar() == 'R')
			{
				contentPane.setBackground(Color.cyan);
			}
		}
	}

	public static void main(String[] args)
	{
		new Key();
	}
}