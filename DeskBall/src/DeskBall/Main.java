package DeskBall;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.awt.geom.Ellipse2D;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class Main extends JDialog implements MouseMotionListener, MouseListener {

	public static JPanel jp;

	public Main() {
		super();
		super.setFocusable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jp = new JPanel();
		jp.setBackground(new Color(r, g, b));
		add(jp);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	static int r = 0;
	static int g = 0;
	static int b = 128;

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

		catch_ball = true;
		dragx = arg0.getXOnScreen();
		dragy = arg0.getYOnScreen();
		x = dragx;
		y = dragy;
		height = toolkit.getScreenSize().height - dragy;
		count_height = 0;
		if (r < 128 && b > 0 ) {
			r++;
			b--;
			jp.setBackground(new Color(r, g, b));
		}
			

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// catch_ball = true;
		// TODO Auto-generated method stub
		// System.out.println(arg0.getX()+"  "+arg0.getY());
		// repaint();
		if (arg0.getX() < 75 && arg0.getY() < 75) {// 左上區塊

			// w.setLocation(w.getLocationOnScreen().x + powerx,
			// w.getLocationOnScreen().y + powery);
			// x += 5;
			// y += 5;
		} else if (arg0.getX() > 75 && arg0.getY() < 75) {// 右上區塊

			// w.setLocation(w.getLocationOnScreen().x - powerx,
			// w.getLocationOnScreen().y + powery);
			// x -= 5;
			// y += 5;
		} else if (arg0.getX() < 75 && arg0.getY() > 75) {// 左下區塊

			// w.setLocation(w.getLocationOnScreen().x + powerx,
			// w.getLocationOnScreen().y - powery);
			// x += 5;
			// y -= 5;
		} else if (arg0.getX() > 75 && arg0.getY() > 75) {// 右下區塊

			// w.setLocation(w.getLocationOnScreen().x - powerx,
			// w.getLocationOnScreen().y - powery);
			// x -= 5;
			// y -= 5;
		}

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

		if (arg0.getButton() == MouseEvent.BUTTON1) {
			System.out.println(arg0.getX() + "," + arg0.getY());

			; // the first button (left?)

		} else if (arg0.getButton() == MouseEvent.BUTTON2) {

			; // the second button (center?)

		} else if (arg0.getButton() == MouseEvent.BUTTON3) {
			System.exit(0);
			; // the third button (right?)

		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("enter");
		
		 if (arg0.getX() < 75 && arg0.getY() < 75) {
			 // 左上區塊 x++; y++; } else
		 }
		 if (arg0.getX() > 75 && arg0.getY() < 75) {
			 // 右上區塊 x--; y++; } else
		 }
		 if (arg0.getX() < 75 && arg0.getY() > 75) {
			 // 左下區塊 x++; y--; } else
			 
			 //
			 //catch_ball = true;
			 //y-=80;
			 height = toolkit.getScreenSize().height-arg0.getY();
			 count_height = 0;
			 down_or_up = true;
			 x++;
			 left_or_right=1;
			 System.out.println("左下區塊");
		 }
		 if (arg0.getX() > 75 && arg0.getY() > 75) {
			 // 右下區塊 x--; y--;
			 //
			 //catch_ball = true;
			 //y-=80;
			 //down_or_up = true;
			 height = toolkit.getScreenSize().height-arg0.getY();
			 count_height = 0;
			 down_or_up = true;
			 x--;
			 left_or_right=-1;
			 System.out.println("右下區塊");
			 
		 }
		 
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("exit");
		catch_ball = false;
		down_or_up = false;

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("起點:" + w.getLocationOnScreen() + "");

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("終點:" + w.getLocationOnScreen() + "");
		catch_ball = false;
		down_or_up = false;
	}

	/**
	 * @param args
	 */
	static int BallWidth = 150;
	static int BallHeight = 150;
	static Window w;
	static Toolkit toolkit;
	static Dimension screensize;

	public static int x = 0, y = 0;
	public static int powerx = 5, powery = 5;
	public static int dragx = 200, dragy = 200;
	public static int vectdown = 1;

	public static boolean catch_ball = false;
	public static int height = 0;
	public static boolean down_or_up = false;
	public static int left_or_right=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		w = new Main();
		((JDialog) w).setUndecorated(true);
		toolkit = java.awt.Toolkit.getDefaultToolkit();
		x = toolkit.getScreenSize().width / 2;
		y = toolkit.getScreenSize().height / 2;
		screensize = toolkit.getScreenSize();
		w.setSize(BallWidth, BallHeight);
		// w.setLocation(0, 0);
		// w.setLocation(screensize.width / 2, screensize.height / 2);
		w.setVisible(true);
		w.setAlwaysOnTop(true);
		height = y;
		AWTUtilitiesWrapper.setWindowShape(w,
				new Ellipse2D.Double(0, 0, w.getWidth(), w.getHeight()));
		AWTUtilitiesWrapper.setWindowOpacity(w, 0.8f);
		thread001.start();

	}

	public static int count_height = 0;

	public static void down() {
		if (catch_ball == false && down_or_up == false) {// down

			if (height > 0
					&& w.getLocationOnScreen().y < toolkit.getScreenSize().height
							- BallHeight) {
				y += 1;
				if (w.getLocationOnScreen().y >= toolkit.getScreenSize().height
						- BallHeight - 1) {
					left_or_right=0;
					// System.out.println("到底");
					// w.setLocation(x, toolkit.getScreenSize().height
					// - BallHeight);
					height = height / 2;
					count_height = 0;
					down_or_up = true;
					// System.out.println("反彈");
					
				}
				//System.out.println("call");
				if ((r >= 0 && r <= 128) || (b >= 0 && b <= 128)) {
					jp.setBackground(new Color(r--, g, b++));
				}
			}
			
			
		} else if (catch_ball == false && down_or_up == true) {// pop
			y-=1*1.5;
			x+=left_or_right;
			count_height++;
			if (count_height >= height) {
				// System.out.println("過半");
				down_or_up = false;
			}
		}

	}

	static Thread thread001 = new Thread(new Runnable() {
		public void run() {

			for (;;) {
				try {
					Thread.sleep(1);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				w.setLocation(x - BallWidth / 2, y - BallHeight / 2);
				down();

			}

		}

	});

	// /////////
}
