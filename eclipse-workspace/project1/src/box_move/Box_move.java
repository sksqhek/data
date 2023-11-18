package box_move;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFrame extends JFrame implements MouseMotionListener {
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JButton button1, button2;
	static int x = 200, y = 50;

	public MyFrame() {
		setTitle("박스 움직이기");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1.setSize(50, 300);
		panel1.setLocation(x, y);
		panel1.setOpaque(true);
		panel1.setBackground(Color.RED);
		panel2.setLayout(null);
		panel2.setSize(500, 400);
		panel2.setLocation(0, 0);
		panel2.setBackground(Color.YELLOW);
		panel2.add(panel1);
		button1 = new JButton("왼쪽으로 이동");
		button1.addActionListener(e -> {
			x -= 10;
			panel1.setLocation(x, y);
			this.requestFocus();//추가
		});
		button2 = new JButton("오른쪽으로 이동");
		button2.addActionListener(e -> {
			x += 20;
			panel1.setLocation(x, y);
			this.requestFocus();//추가
		});
		panel3.add(button1);
		panel3.add(button2);
		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent k) {
				int keycode = k.getKeyCode();
				switch (keycode) {
				case KeyEvent.VK_LEFT:
					x -= 10;
					break;
				case KeyEvent.VK_RIGHT:
					x += 10;
					break;
				}
				panel1.setLocation(x, y);
			}

			public void keyReleased(KeyEvent k) {
			}

			public void keyTyped(KeyEvent k) {
			}
		});
		this.requestFocus();
		setFocusable(true);
		this.add(panel2, BorderLayout.CENTER);
		this.add(panel3, BorderLayout.SOUTH);
		this.setVisible(true);
		this.addMouseMotionListener(this);
	}

	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = 50;
		panel1.setLocation(x, y);
		this.requestFocus();//추가
	}

	public void mouseMoved(MouseEvent e) {
	}
}

public class Box_move {
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}
}