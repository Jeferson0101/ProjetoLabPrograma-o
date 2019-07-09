package br.com.sensorproject.gui;

import br.com.sensorproject.Services.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.MaskFormatter;

import br.com.sensorproject.Services.ServiceTela;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;

public class TelaCalc extends JFrame {
	ServiceTela servico = new ServiceTela();
	private JScrollPane scrollPane;
	private JFormattedTextField txtFieldDataAte;
	private JFormattedTextField txtFieldDataDe;
	private JLabel lblData;
	private JLabel lblDe;
	private JLabel lblAte;
	private JButton btnCalcular;
	private JList list;
	private DefaultListModel defaultlist = new DefaultListModel();
	private JLabel lblMedianaResult;
	private JLabel lblModaResult;
	private JLabel lblVarianciaResult;
	private JLabel lblMediaResult;
	public TelaCalc() {
		setResizable(false);
		getContentPane().setBackground(Color.GRAY);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Calculos");
		setSize(438, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getScrollPane());
		getContentPane().add(getTxtFieldDataAte());
		getContentPane().add(getTxtFieldDataDe());
		getContentPane().add(getLblData());
		getContentPane().add(getLblDe());
		getContentPane().add(getLblAte());
		getContentPane().add(getBtnCalcular());
		
		JSeparator separator = new JSeparator();
		separator.setBounds(180, 130, 314, 2);
		getContentPane().add(separator);
		
		JLabel lblMedia = new JLabel("Media:");
		lblMedia.setBackground(Color.DARK_GRAY);
		lblMedia.setForeground(Color.LIGHT_GRAY);
		lblMedia.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMedia.setBounds(191, 152, 68, 20);
		getContentPane().add(lblMedia);
		
		JLabel lblMediana = new JLabel("Mediana:");
		lblMediana.setBackground(Color.DARK_GRAY);
		lblMediana.setForeground(Color.LIGHT_GRAY);
		lblMediana.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMediana.setBounds(191, 183, 98, 20);
		getContentPane().add(lblMediana);
		
		JLabel lblModa = new JLabel("Moda:");
		lblModa.setBackground(Color.DARK_GRAY);
		lblModa.setForeground(Color.LIGHT_GRAY);
		lblModa.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblModa.setBounds(191, 214, 68, 20);
		getContentPane().add(lblModa);
		
		JLabel lblVariancia = new JLabel("Variancia:");
		lblVariancia.setBackground(Color.DARK_GRAY);
		lblVariancia.setForeground(Color.LIGHT_GRAY);
		lblVariancia.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVariancia.setBounds(191, 245, 109, 20);
		getContentPane().add(lblVariancia);
		
		getContentPane().add(getLblMedianaResult());
		getContentPane().add(getLblModaResult());
		getContentPane().add(getLblVarianciaResult());
		getContentPane().add(getLblMediaResult());
		setVisible(true);
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 181, 276);
			scrollPane.setViewportView(getList());
		}
		return scrollPane;
	}
	private JFormattedTextField getTxtFieldDataAte() {
		if (txtFieldDataAte == null) {
			txtFieldDataAte = new JFormattedTextField(mascara("####-##-##"));
			txtFieldDataAte.setBackground(Color.LIGHT_GRAY);
			txtFieldDataAte.setBounds(352, 25, 55, 20);
			txtFieldDataAte.setColumns(10);
		}
		return txtFieldDataAte;
	}
	private JFormattedTextField getTxtFieldDataDe() {
		if (txtFieldDataDe == null) {
			txtFieldDataDe = new JFormattedTextField(mascara("####-##-##"));
			txtFieldDataDe.setBackground(Color.LIGHT_GRAY);
			txtFieldDataDe.setBounds(259, 25, 55, 20);
			txtFieldDataDe.setColumns(10);
		}
		return txtFieldDataDe;
	}
	private JLabel getLblData() {
		if (lblData == null) {
			lblData = new JLabel("DATA:");
			lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblData.setForeground(Color.LIGHT_GRAY);
			lblData.setBounds(191, 28, 36, 14);
		}
		return lblData;
	}
	private JLabel getLblDe() {
		if (lblDe == null) {
			lblDe = new JLabel("de");
			lblDe.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblDe.setForeground(Color.LIGHT_GRAY);
			lblDe.setBounds(233, 28, 16, 14);
		}
		return lblDe;
	}
	private JLabel getLblAte() {
		if (lblAte == null) {
			lblAte = new JLabel("ate");
			lblAte.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblAte.setForeground(Color.LIGHT_GRAY);
			lblAte.setBounds(324, 28, 21, 14);
		}
		return lblAte;
	}
	private JButton getBtnCalcular() {
		if (btnCalcular == null) {
			btnCalcular = new JButton("Calcular");
			btnCalcular.setForeground(Color.DARK_GRAY);
			btnCalcular.setBackground(Color.GRAY);
			btnCalcular.setBounds(259, 76, 109, 43);
			btnCalcular.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					action();
				}
			});
		}
		return btnCalcular;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setBackground(Color.LIGHT_GRAY);
			list.setFont(new Font("Tahoma", Font.BOLD, 22));
			defaultlist.addElement("Anemometer");
			defaultlist.addElement("endDirection");
			defaultlist.addElement("pluviometer");
			defaultlist.addElement("humidity");
			defaultlist.addElement("temperature");
			list.setModel(defaultlist);
		}
		return list;
	}
	private JLabel getLblMediaResult() {
		if (lblMediaResult == null) {
			lblMediaResult = new JLabel("");
			lblMediaResult.setForeground(Color.LIGHT_GRAY);
			lblMediaResult.setBackground(Color.DARK_GRAY);
			lblMediaResult.setBounds(309, 152, 46, 20);
		}
		return lblMediaResult;
	}
	private JLabel getLblMedianaResult() {
		if (lblMedianaResult == null) {
			lblMedianaResult = new JLabel("");
			lblMedianaResult.setForeground(Color.LIGHT_GRAY);
			lblMedianaResult.setBackground(Color.DARK_GRAY);
			lblMedianaResult.setBounds(309, 183, 46, 20);
		}
		return lblMedianaResult;
	}
	private JLabel getLblModaResult() {
		if (lblModaResult == null) {
			lblModaResult = new JLabel("");
			lblModaResult.setForeground(Color.LIGHT_GRAY);
			lblModaResult.setBackground(Color.DARK_GRAY);
			lblModaResult.setBounds(309, 214, 46, 20);
		}
		return lblModaResult;
	}
	private JLabel getLblVarianciaResult() {
		if (lblVarianciaResult == null) {
			lblVarianciaResult = new JLabel("");
			lblVarianciaResult.setForeground(Color.LIGHT_GRAY);
			lblVarianciaResult.setBackground(Color.DARK_GRAY);
			lblVarianciaResult.setBounds(309, 245, 46, 20);
		}
		return lblVarianciaResult;
	}
	private MaskFormatter mascara(String Mascara){
		MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(Mascara);
            F_Mascara.setPlaceholder("  ");
        }
        catch (Exception excecao) {
        excecao.printStackTrace();
        } 
        return F_Mascara;
	}
	
	private void action(){
		if (list.isSelectionEmpty()){
			JOptionPane.showMessageDialog(null, "Selecione um item da Lista");
			return;
		}else if(txtFieldDataAte.getText().equals("    -  -  ") || txtFieldDataDe.getText().equals("    -  -  ")){
			JOptionPane.showMessageDialog(null, "Preencha ambas as datas");
			return;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gc = new GregorianCalendar();
		try {
			Date dtIni = dateFormat.parse(txtFieldDataDe.getText());
			Date dtFim = dateFormat.parse(txtFieldDataAte.getText());
			Timestamp timeIni = new Timestamp(dtIni.getTime());
			Timestamp timeFim = new Timestamp(dtFim.getTime());
			servico.getMedidas(timeIni,timeFim,list.getSelectedValue().toString());
			lblMediaResult.setText( Float.toString(servico.getMedia()));
			servico.getMediana();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
