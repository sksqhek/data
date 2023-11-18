import java.awt.*;
import javax.swing.*;

class Ball
{
	private int x = 100;
	private int y = 100;
	private int size = 30;
	private int xSpeed = 5;
	private int ySpeed = 5;

	public void draw(Graphics g)
	{
		g.setColor(Color.red);
		g.fillOval(x, y, size, size);
	}

	public void update()
	{
		x += xSpeed;
		y += ySpeed;
		if (x < 0)
		{
			xSpeed = -xSpeed;
			x = 0;//변경
		} else if (x + size > MyPanel.BOARD_WIDTH)
		{
			xSpeed = -xSpeed;
			x = MyPanel.BOARD_WIDTH - size;
		}
		if (y < 0)
		{
			ySpeed = -ySpeed;
			y = 0;//변경
		} else if (y + size > MyPanel.BOARD_HEIGHT)
		{
			ySpeed = -ySpeed;
			y = MyPanel.BOARD_HEIGHT - size;
		}
	}
}

public class MyPanel extends JPanel
{
	static final int BOARD_WIDTH = 600;
	static final int BOARD_HEIGHT = 300;
	private Ball ball = new Ball();

	public MyPanel()
	{
		this.setBackground(Color.yellow);
		Runnable task = () ->
		{
			while (true)
			{
				ball.update();
				repaint();
				try
				{
					Thread.sleep(16);//변경
				} catch (InterruptedException e)
				{
				}
			}
		};
		Thread th = new Thread(task);
		th.start();
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		ball.draw(g);
	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		MyPanel p = new MyPanel();
		p.setPreferredSize(new Dimension(MyPanel.BOARD_WIDTH, MyPanel.BOARD_HEIGHT));//패널 사이즈 설정
		//frame.setSize(MyPanel.BOARD_WIDTH, MyPanel.BOARD_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.add(p);
		frame.pack();//설정된 패널크기에 맞게 창크기 만들어주기
		frame.setVisible(true);
	}
}