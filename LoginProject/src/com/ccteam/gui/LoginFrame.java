package com.ccteam.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.ccteam.action.UserAction;

public class LoginFrame extends Frame implements ActionListener {

	Label l1, l2;
	TextField tf1, tf2;
	Button b;
	String status = "";

	UserAction userAction;

	public LoginFrame() throws HeadlessException {
		super();
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle("Login Frame");
		this.setBackground(Color.magenta);

		this.setLayout(new FlowLayout());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		l1 = new Label("User name:");
		l2 = new Label("Password:");
		tf1 = new TextField(20);
		tf2 = new TextField(20);
		tf2.setEchoChar('*');
		b = new Button("Login");
		b.addActionListener(this);

		Font font = new Font("consolas", Font.BOLD, 20);
		l1.setFont(font);
		l2.setFont(font);

		tf1.setFont(font);
		tf2.setFont(font);
		b.setFont(font);

		this.add(l1);
		this.add(tf1);
		this.add(l2);
		this.add(tf2);
		this.add(b);

		userAction = new UserAction();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String uname = tf1.getText();
		String upwd = tf2.getText();

		status = userAction.checkLogin(uname, upwd);
		repaint();

	}

	public void paint(Graphics g) {
		Font font = new Font("arial", Font.BOLD, 100);
		g.getFont();
		g.drawString("User Login Status:" + status, 150, 150);

	}

}
