package br.com.sensorproject.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaLogin extends JFrame{
	
	private JLabel lblLogin;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JTextField textFieldUser;
	private JPasswordField passwordField;
	private JButton btnLogin;
	
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setForeground(Color.GRAY);
		getContentPane().setBackground(Color.GRAY);
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("LOGIN");
		getContentPane().setLayout(null);
		getContentPane().add(getLblLogin());
		getContentPane().add(getLblUser());
		getContentPane().add(getLblPassword());
		getContentPane().add(getTextFieldUser());
		getContentPane().add(getPasswordField());
		getContentPane().add(getBtnLogin());
		setSize(242, 300);
		setVisible(true);
	}
	
	private JLabel getLblLogin() {
		if (lblLogin == null) {
			lblLogin = new JLabel("Login");
			lblLogin.setForeground(Color.LIGHT_GRAY);
			lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogin.setFont(new Font("Arial Black", Font.PLAIN, 30));
			lblLogin.setBounds(61, 11, 113, 55);
		}
		return lblLogin;
	}
	
	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("User:");
			lblUser.setForeground(Color.LIGHT_GRAY);
			lblUser.setBackground(Color.LIGHT_GRAY);
			lblUser.setFont(new Font("Arial", Font.PLAIN, 14));
			lblUser.setBounds(36, 106, 46, 14);
		}
		return lblUser;
	}
	
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setForeground(Color.LIGHT_GRAY);
			lblPassword.setBackground(Color.LIGHT_GRAY);
			lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
			lblPassword.setBounds(36, 152, 65, 14);
		}
		return lblPassword;
	}
	
	private JTextField getTextFieldUser() {
		if (textFieldUser == null) {
			textFieldUser = new JTextField();
			textFieldUser.setBackground(Color.LIGHT_GRAY);
			textFieldUser.setBounds(116, 104, 86, 20);
			textFieldUser.setColumns(10);
			textFieldUser.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					HabilitaBotao();
				}
				
			});
		}
		return textFieldUser;
	}
	
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBackground(Color.LIGHT_GRAY);
			passwordField.setBounds(116, 150, 86, 20);
			passwordField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					HabilitaBotao();
				}
				
			});
		}
		return passwordField;
	}
	
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("LOGIN");
			btnLogin.setEnabled(false);
			btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnLogin.setForeground(Color.DARK_GRAY);
			btnLogin.setBackground(Color.GRAY);
			btnLogin.setBounds(73, 242, 89, 23);
			btnLogin.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new TelaCalc();
					dispose();
				}
			});
		}
		return btnLogin;
	}
	
	private void HabilitaBotao(){
		if(passwordField.getText().length()>=4 && textFieldUser.getText().length() != 0){
			btnLogin.setEnabled(true);
		}else{
			btnLogin.setEnabled(false);
		}
	}
	
}
