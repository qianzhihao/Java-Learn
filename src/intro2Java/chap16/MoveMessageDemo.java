package intro2Java.chap16;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MoveMessageDemo extends JFrame {

	public MoveMessageDemo() {
		MovableMessagePanel p = new MovableMessagePanel("Welcome to Java");
		
		setLayout(new BorderLayout());
		add(p);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class MovableMessagePanel extends JPanel {
		private String message = "welcome to Java";
		private int x = 20;
		private int y = 20;
		
		public MovableMessagePanel(String s) {
			message = s;
			addMouseMotionListener(new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e) {
					x = e.getX();
					y = e.getY();
					repaint();
				}
			});
		}
		
		protected void patintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString(message, x, y);
		}
	}
}
