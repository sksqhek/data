import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

class GameObject
{
	protected int posX;
	protected int posY;
	protected String image;
	protected boolean Enable;

	public GameObject(int x, int y, String s)
	{
		posX = x;
		posY = y;
		image = s;
		Enable = true;
	}

	public void Xmove(int x)
	{
		posX += x;
	}

	public void Ymove(int y)
	{
		posY += y;
	}

	int getPosX()
	{
		return posX;
	}

	int getPosY()
	{
		return posY;
	}
}

class PlayerObject extends GameObject
{
	public String image;

	public PlayerObject(int x, int y, String player)
	{
		super(x, y, player);
// TODO Auto-generated constructor stub
		image = player;
	}

	public void GoRight()
	{
		Xmove(1);
		if (posX > 24)
		{
			posX--;
		}
	}

	public void GoLeft()
	{
		Xmove(-1);
		if (posX < 1)
		{
			posX++;
		}
	}

	public void GoUp()
	{
		Ymove(-1);
		if (posY < 0)
		{
			posY++;
		}
	}

	public void goDown()
	{
		Ymove(1);
		if (posY > 18)
		{
			posY--;
		}
	}
}

class EnemyObject extends GameObject
{
	public EnemyObject(int x, int y, String s)
	{
		super(x, y, s);
// TODO Auto-generated constructor stub
	}
}

class BulletObject extends GameObject
{
	public boolean Bullet;

	public BulletObject(int x, int y, String s)
	{
		super(x, y, s);
// TODO Auto-generated constructor stub
	}
	
	public boolean update()//####총알을 움직임
	{
		Ymove(-1);
		if(posY < 0)//화면을 벗어나면
		{
			return false;
		}else
		{
			return true;
		}
	}
}

public class ProjectSpaceInvader extends JFrame implements KeyListener
{
	private GameHandler handler;
	PlayerObject player = new PlayerObject(15, 18, ">=0=<");
	//BulletObject bullet = new BulletObject(player.posX + 2, player.posY, "!");//####
	private JTextArea textArea = new JTextArea();

	public ProjectSpaceInvader()
	{
		setTitle("Let Play SpaceInvader");
		setSize(900, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		textArea.setFont(new Font("Courier New", Font.PLAIN, 30));
		textArea.addKeyListener(this);
		add(textArea);
		textArea.setEditable(false);
		setVisible(true);
		handler = new GameHandler(textArea, player);//, bullet);
		new Thread(new GameThread()).start();

	}

	class GameThread implements Runnable
	{

		@Override
		public void run()
		{
// TODO Auto-generated method stub
			while (!handler.isGameOver())
			{
				handler.gaeTiming();
// 1. Game timing ================================
// 3. Game logic ==================================
				handler.gameLogic();
// 4. Render output ==============================
				handler.drawAll();
			}
//game over
			handler.drawGameOver();
		}
	}

	public static void main(String[] args)
	{
// TODO Auto-generated method stub
		new ProjectSpaceInvader();
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
// TODO Auto-generated method stub
		switch (e.getKeyCode())
		{
		case KeyEvent.VK_RIGHT:
			player.GoRight();
			break;
		case KeyEvent.VK_LEFT:
			player.GoLeft();
			break;
		case KeyEvent.VK_DOWN:
			player.goDown();
			break;
		case KeyEvent.VK_UP:
			player.GoUp();
			break;
		case KeyEvent.VK_SPACE:
			//bullet.Fire();
			BulletObject b = new BulletObject(player.posX + 2, player.posY, "!");//####
			
			handler.addBullet(b);//####생성된 총알을 배열에 추가 하기 
						
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
// TODO Auto-generated method stub
	}

}

class GameHandler
{
	private final int SCREEN_WIDTH = 50;
	private final int LEFT_PADDING = 1;
	private final int SCREEN_HEIGHT = 25;
	private final int FIELD_WIDTH = 30, FIELD_HEIGHT = 24;
	private JTextArea textArea;
	private char[][] buffer;
	private int field[];
	private PlayerObject player1;
	private boolean isGameOver;
	
	//private BulletObject bullet1;
	private ArrayList<BulletObject> bullets = new ArrayList<BulletObject>();//#### 총알들을 저장할 배열
	
	private EnemyObject enemy;

	public GameHandler(JTextArea ta, PlayerObject player)//, BulletObject bullet)
	{
// TODO Auto-generated constructor stub
		textArea = ta;
		field = new int[FIELD_WIDTH * FIELD_HEIGHT];
		buffer = new char[SCREEN_WIDTH][SCREEN_HEIGHT];
		initData();
		player1 = player;
		//bullet1 = bullet;
	}

	public void initData()
	{
// TODO Auto-generated method stub
		for (int x = 0; x < FIELD_WIDTH; x++)
			for (int y = 0; y < FIELD_HEIGHT; y++)
				field[y * FIELD_WIDTH + x] = (x == 0 || x == FIELD_WIDTH - 1 || y == FIELD_HEIGHT - 1) ? 9 : 0;
		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 4; j++)
			{
			}
		}
		isGameOver = false;
		clearBuffer();

	}

	private void clearBuffer()
	{
// TODO Auto-generated method stub
		for (int y = 0; y < SCREEN_HEIGHT; y++)
		{
			for (int x = 0; x < SCREEN_WIDTH; x++)
			{
				buffer[x][y] = '.';
			}
		}
	}

	private void drawToBuffer(int px, int py, String c)
	{
		for (int x = 0; x < c.length(); x++)
		{
			buffer[px + x + LEFT_PADDING][py] = c.charAt(x);
		}
	}

	private void drawToBuffer(int px, int py, char c)
	{
		buffer[px + LEFT_PADDING][py] = c;
	}

	public void drawGameOver()
	{
// TODO Auto-generated method stub
	}

	public void drawAll()
	{
// TODO Auto-generated method stub
		for (int x = 0; x < FIELD_WIDTH; x++)
		{
			for (int y = 0; y < FIELD_HEIGHT; y++)
			{
				drawToBuffer(x, y, " ABCDEFG=#".charAt(field[y * FIELD_WIDTH + x]));
			}
		}

		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				EnemyObject enemy = new EnemyObject(j * 6 + 3 + (i * 2), 1 * i + 1, "[XUX]");
				drawToBuffer(enemy.posX, enemy.posY, enemy.image);
			}
		}
		
		for(BulletObject b:bullets)//####
		{
			drawToBuffer(b.posX, b.posY, b.image);
		}
		
		drawToBuffer(player1.posX, player1.posY, player1.image);
		drawToBuffer(31, 4, "┌──────────────┐");
		drawToBuffer(31, 5, "│Score:0       │");
		drawToBuffer(31, 6, "└──────────────┘");
		drawToBuffer(35, 17, "by d.lee");
		render();
	}

	private void render()
	{
// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < SCREEN_HEIGHT; y++)
		{
			for (int x = 0; x < SCREEN_WIDTH; x++)
			{
				sb.append(buffer[x][y]);
			}
			sb.append("\n");
		}
		textArea.setText(sb.toString());
	}

	public void gameLogic()
	{
// TODO Auto-generated method stub
		for(BulletObject b:bullets)//####배열에 저장된 총알을 한개씩 꺼내와 처리
		{
			if(b.update() == false)//총알이 화면에서 벗어나면 배열에서 삭제
			{
				bullets.remove(b);
				break;
			}
		}
	}
	
	public void addBullet(BulletObject b)//####총알을 배열에 저장
	{
		bullets.add(b);
	}
	
	public void gaeTiming()
	{
// TODO Auto-generated method stub
		try
		{
			Thread.sleep(50);
		} catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}

	public boolean isGameOver()
	{
// TODO Auto-generated method stub
		return isGameOver;
	}
}