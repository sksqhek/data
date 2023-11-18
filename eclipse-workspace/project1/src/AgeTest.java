import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AgeTest extends JFrame
{
	private JButton button1, button2, button3;
	private JLabel label;
	int count = 100;
	int counta = 0;
	String a;
	MyPanel mypanel;

	public AgeTest()
	{
		this.setSize(480, 200);
		this.setTitle("피로도 테스트");
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		
		label = new JLabel(a);
		
		button1 = new JButton("시작");
		button2 = new JButton("예");
		button3 = new JButton("아니오");
		add(panel);
		panel.add(button1);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mypanel = new MyPanel();// ####객체 생성

		button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				button1.setVisible(false);
				add(mypanel, BorderLayout.CENTER);// ####생성된 객체 화면에 추가
				panel1.add(label);
				panel1.add(button2);
				panel1.add(button3);
				add(panel1, BorderLayout.SOUTH);
			}
		});

		button2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				count = count - 20;
				mypanel.repaint();				
				
				setLabel();
				
				counta = counta + 1;
			}
		});
		button3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				counta = counta + 1;
				
				setLabel();
				
				counta = counta + 1;
			}
		});
	}
	
	void setLabel()
	{
		if (counta==0) {
			a="여행을 떠나고 싶다는 생각을 자주하십니까";
			}
			else if(counta==1){
			a="충분한 숙면 후에도 졸립니까";
			}
			else if(counta==2) {
			a="대인관계에 어려움을 느낍니까";
			}
			else if(counta==3) {
			a="오늘 소리내어 웃은 적이 있습니까";
			}
			else if(counta==4) {
			a="시간내어 운동을 하십니까";
			}
		label.setText(a);

	}

	class MyPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.setColor(Color.GREEN);
			g.drawLine(80, 30, 90, 100);// 세로(왼쪽)
			g.drawLine(200, 30, 190, 100);// 세로(오른쪽)
			g.drawLine(90, 100, 190, 100);// 가로(아래)
			g.drawLine(80, 30, 200, 30);// 가로(위)
			if (count == 80) {
				g.setColor(Color.black);
				g.fillOval(90, 30, 25, 25);
			} else if (count == 60) {
				g.setColor(Color.black);
				g.fillOval(90, 30, 25, 25);
				g.setColor(Color.black);
				g.fillOval(150, 30, 25, 25);
			} else if (count == 40) {
				g.setColor(Color.black);
				g.fillOval(90, 30, 25, 25);
				g.setColor(Color.black);
				g.fillOval(150, 30, 25, 25);
				g.setColor(Color.black);
				g.fillOval(120, 55, 25, 25);
			} else if (count == 20) {
				g.setColor(Color.black);
				g.fillOval(90, 30, 25, 25);
				g.setColor(Color.black);
				g.fillOval(150, 30, 25, 25);
				g.setColor(Color.black);
				g.fillOval(120, 55, 25, 25);
				g.setColor(Color.black);
				g.fillOval(90, 70, 25, 25);
			} else if (count == 0) {
				g.setColor(Color.black);
				g.fillOval(90, 30, 25, 25);
				g.setColor(Color.black);
				g.fillOval(150, 30, 25, 25);
				g.setColor(Color.black);
				g.fillOval(120, 55, 25, 25);
				g.setColor(Color.black);
				g.fillOval(90, 70, 25, 25);
				g.setColor(Color.black);
				g.fillOval(150, 70, 25, 25);
			}
		}

	}

	public static void main(String[] args)
	{
// TODO Auto-generated method stub

		AgeTest f = new AgeTest();
	}

}