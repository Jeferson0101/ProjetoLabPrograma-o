package br.com.sensorproject.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Window.Type;

public class TelaCalc extends JFrame {
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblData;
	private JLabel lblDe;
	private JLabel lblAte;
	private JButton btnCalcular;
	public TelaCalc() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Calculos");
		setSize(500, 300);
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().add(getScrollPane());
		getContentPane().add(getTextField());
		getContentPane().add(getTextField_1());
		getContentPane().add(getLblData());
		getContentPane().add(getLblDe());
		getContentPane().add(getLblAte());
		getContentPane().add(getBtnCalcular());
		setVisible(true);
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 172, 262);
		}
		return scrollPane;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(388, 25, 86, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(259, 25, 86, 20);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblData() {
		if (lblData == null) {
			lblData = new JLabel("DATA:");
			lblData.setBounds(191, 28, 36, 14);
		}
		return lblData;
	}
	private JLabel getLblDe() {
		if (lblDe == null) {
			lblDe = new JLabel("de");
			lblDe.setBounds(231, 28, 16, 14);
		}
		return lblDe;
	}
	private JLabel getLblAte() {
		if (lblAte == null) {
			lblAte = new JLabel("ate");
			lblAte.setBounds(360, 28, 18, 14);
		}
		return lblAte;
	}
	private JButton getBtnCalcular() {
		if (btnCalcular == null) {
			btnCalcular = new JButton("Calcular");
			btnCalcular.setBounds(385, 86, 89, 23);
		}
		return btnCalcular;
	}
}
