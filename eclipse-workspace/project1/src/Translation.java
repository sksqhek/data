import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class Translation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame main_frame = new JFrame("Midline, translation");
		main_frame.setSize(1500, 700);
		JButton drawLine = new JButton("Draw Line");
		main_frame.add(drawLine);
		JButton moveLine = new JButton("Translation");
		main_frame.add(moveLine);
		DrawBase drawbase = new DrawBase();
		drawbase.setSize(1500, 700);
		main_frame.add(drawbase);
		drawLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawLine1 drawline1 = new DrawLine1();
				drawline1.setSize(500, 500);
				main_frame.add(drawline1);
				drawline1.setBounds(0, 0, 500, 500);
				main_frame.repaint();
			}
		});
		moveLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 아직 작성한 내용 없음
			}
		});
		main_frame.setLayout(null);
//추가할 textfield, button 등을 setbounds로 위치 설정하기 
		moveLine.setBounds(800, 575, 100, 30);
		drawLine.setBounds(300, 575, 100, 30);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setVisible(true);
	}
}

class DrawLine1 extends JPanel {// 선 그리기
	public void paintComponent(Graphics s) {
		// super.paintComponent(s);
		s.drawLine(100, 100, 200, 400);
	}
}

class DrawBase extends JPanel {
	public void paintComponent(Graphics s) {
		// super.paintComponent(s);
		s.drawLine(500, 0, 500, 700);// 세로선 3개를 그어서 좌표평면이 그려질 부분 구분하기
		s.drawLine(1000, 0, 1000, 700);
		s.drawLine(0, 500, 1500, 500);
		// 각 칸에 대해 좌표평면 그리기, 정사각형을 반복해서 그리는 것으로 좌표평면을 나타낸다
		for (int x = 0; x < 40; x++)
			for (int y = 0; y < 40; y++) {
				s.drawRect(50 + x * 10, 50 + y * 10, 10, 10);
				s.drawRect(550 + x * 10, 50 + y * 10, 10, 10);
				s.drawRect(1050 + x * 10, 50 + y * 10, 10, 10);
			}
	}
}