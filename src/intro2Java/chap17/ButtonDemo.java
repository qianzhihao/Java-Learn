package intro2Java.chap17;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

import intro2Java.chap15.MessagePanel;

public class ButtonDemo extends JFrame {

	protected MessagePanel messagePanel = 
			new MessagePanel("Welcome to Java");
	
	private JButton jbtLeft = new JButton("<=");
	private JButton jbtRight = new JButton("=>");
	
	public static void main(String[] args) {
		ButtonDemo frame = new ButtonDemo();
		frame.setTitle("ButtonDemo");
		frame.setSize(250, 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	
	public ButtonDemo() {
		messagePanel.setBackground(Color.white);
		
		JPanel jpButtons = new JPanel();
		jpButtons.add(jbtLeft);
		jpButtons.add(jbtRight);
		
		jbtLeft.setMnemonic('L');
		jbtRight.setMnemonic('R');
		
		jbtLeft.setToolTipText("Move message to left");
		jbtRight.setToolTipText("Move message to right");
		
		setLayout(new BorderLayout());
		add(messagePanel, BorderLayout.CENTER);
		add(jpButtons, BorderLayout.SOUTH);
		
		jbtLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messagePanel.moveLeft();
			}
		});
		
		jbtRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messagePanel.moveRight();
			}
		});
		
		
	}

}













