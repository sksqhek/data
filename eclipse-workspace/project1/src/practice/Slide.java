package practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slide
{

	public Slide()
	{
	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("슬라이드");
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JPanel show = new JPanel();
		JPanel bottom = new JPanel(new GridLayout(3, 1));
		show.setPreferredSize(new Dimension(390, 300));
		bottom.setPreferredSize(new Dimension(390, 100));
		frame.add(show, BorderLayout.CENTER);
		show.setBackground(Color.black);
		JPanel redp = new JPanel(new BorderLayout());
		JPanel greenp = new JPanel(new BorderLayout());
		JPanel bluep = new JPanel(new BorderLayout());
		bottom.add(redp);
		bottom.add(greenp);
		bottom.add(bluep);
		// redp.setBackground(Color.red);
		frame.add(bottom, BorderLayout.SOUTH);
		JLabel rl = new JLabel("빨강");
		JLabel gl = new JLabel("초록");
		JLabel bl = new JLabel("파랑");
		redp.add(rl, BorderLayout.WEST);
		greenp.add(gl, BorderLayout.WEST);
		bluep.add(bl, BorderLayout.WEST);
		JSlider rs = new JSlider(0, 250, 0);
		JSlider gs = new JSlider(0, 250, 0);
		JSlider bs = new JSlider(0, 250, 0);
		redp.add(rs);
		greenp.add(gs);
		bluep.add(bs);
		
		rs.addChangeListener(new ChangeListener()
		{			
			@Override
			public void stateChanged(ChangeEvent e)
			{				
				show.setBackground(new Color(rs.getValue(),gs.getValue(),bs.getValue()));				
			}
		});
		
		gs.addChangeListener(new ChangeListener()
		{			
			@Override
			public void stateChanged(ChangeEvent e)
			{				
				show.setBackground(new Color(rs.getValue(),gs.getValue(),bs.getValue()));				
			}
		});
		
		bs.addChangeListener(new ChangeListener()
		{			
			@Override
			public void stateChanged(ChangeEvent e)
			{				
				show.setBackground(new Color(rs.getValue(),gs.getValue(),bs.getValue()));				
			}
		});
	}

}