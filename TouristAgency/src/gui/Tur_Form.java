package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import dao.*;
import domain.*;

public class Tur_Form extends JDialog {

	private Tur tur;

	private JTextField Ahenstvo_Tur;
	private JTextField Nazva_turu;
	private JTextField Opus_turu;
	private JTextField Data_poch_turu;
	private JTextField Truv_turu;
	private JTextField Kraina;
	private JTextField Vartist;
	
	JLabel l1 = new JLabel("Назва туристичного агенства");
	JLabel l2 = new JLabel("Назва туру");
	JLabel l3 = new JLabel("Опис туру");
	JLabel l4 = new JLabel("Дата початку туру");
	JLabel l5 = new JLabel("Тривалість туру");
	JLabel l6 = new JLabel("Країна");
	JLabel l7 = new JLabel("Вартість туру");
	
	public Tur_Form() {
		setTitle("Тури");
		setSize(500, 290);
		setModal(true);
		setResizable(false);
		setLocationByPlatform(true);

		final JButton cmdSave = new JButton("Зберегти");
		final JButton cmdCancel = new JButton("Відмінити");

		Ahenstvo_Tur = new JTextField(15);
		Nazva_turu = new JTextField(15);
		Opus_turu = new JTextField(15);
		Data_poch_turu = new JTextField(15);
		Truv_turu = new JTextField(15);
		Kraina = new JTextField(15);
		Vartist = new JTextField(15);
		
		l1.setForeground(Color.red);
		l1.setFont(new Font("Times New Poman", Font.BOLD, 14));
		l2.setForeground(Color.green);
		l2.setFont(new Font("Times New Poman", Font.BOLD, 14));
		l3.setForeground(Color.yellow);
		l3.setFont(new Font("Times New Poman", Font.BOLD, 14));
		l4.setForeground(Color.red);
		l4.setFont(new Font("Times New Poman", Font.BOLD, 14));
		l5.setForeground(Color.green);
		l5.setFont(new Font("Times New Poman", Font.BOLD, 14));
		l6.setForeground(Color.yellow);
		l6.setFont(new Font("Times New Poman", Font.BOLD, 14));
		l7.setForeground(Color.red);
		l7.setFont(new Font("Times New Poman", Font.BOLD, 14));
		
		panel panel = new panel();
		final JPanel fieldsPanel = new JPanel(new GridLayout(7, 2, 10, 10));
		final JPanel fieldsPanelBorder = new JPanel(new FlowLayout(
				FlowLayout.CENTER, 10, 10));
		fieldsPanel.setOpaque(false);
		fieldsPanel.setForeground(Color.blue);
		fieldsPanelBorder.setOpaque(false);
		fieldsPanelBorder.add(fieldsPanel);
		fieldsPanel.add(l1);
		fieldsPanel.add(Ahenstvo_Tur);
		fieldsPanel.add(l2);
		fieldsPanel.add(Nazva_turu);
		fieldsPanel.add(l3);
		fieldsPanel.add(Opus_turu);
		fieldsPanel.add(l4);
		fieldsPanel.add(Data_poch_turu);
		fieldsPanel.add(l5);
		fieldsPanel.add(Truv_turu);
		fieldsPanel.add(l6);
		fieldsPanel.add(Kraina);
		fieldsPanel.add(l7);
		fieldsPanel.add(Vartist);

		final JPanel commandsPanel = new JPanel(new FlowLayout());
		final JPanel commandsPanelBorder = new JPanel(new FlowLayout(
				FlowLayout.CENTER, 0, 0));
		commandsPanel.setOpaque(false);
		commandsPanelBorder.setOpaque(false);
		commandsPanelBorder.add(commandsPanel);
		commandsPanel.add(cmdSave);
		commandsPanel.add(cmdCancel);
		panel.add(fieldsPanel);
		panel.add(fieldsPanelBorder);
		panel.add(commandsPanel);
		panel.add(commandsPanelBorder);
		Container c = getContentPane();
		c.add(panel);

		cmdSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveTur();
			}
		});

		cmdCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSave();
			}
		});
	}

	public Tur getGame() {
		return tur;
	}

	public void newTur(Tur tur) {
		this.tur = tur;                           
			Ahenstvo_Tur.setText("");
			Nazva_turu.setText("");
			Opus_turu.setText("");
			Data_poch_turu.setText("");
			Truv_turu.setText("");
			Kraina.setText("");
			Vartist.setText("");
	}
	
	public void setTur(Tur tur) {
	this.tur = tur;
	 try {
			if (tur.getAhenstvo_Tur() != null) {
				Ahenstvo c = new AhenstvoDao().findById(tur
						.getAhenstvo_Tur());
				Ahenstvo_Tur.setText(c.getNazva_Tur_Ah());
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,
					"Помилка при ініціалізації форми: " + e.getMessage());
		}                                                         
		Nazva_turu.setText(tur.getNazva_turu());
		Opus_turu.setText(tur.getOpus_turu());
		Data_poch_turu.setText(tur.getData_poch_turu());
		Truv_turu.setText(String.valueOf(tur.getTruv_turu()));
		Kraina.setText(tur.getKraina());
		Vartist.setText(tur.getVartist());
	}

	private void saveTur() {
		try {
			Ahenstvo c = new AhenstvoDao().findBy_Name(Ahenstvo_Tur
					.getText());
			if (c == null) {
				JOptionPane.showMessageDialog(this, "Агенство з назвою '"
						+ Ahenstvo_Tur.getText() + " не існує.");
				return;
			}
			tur.setAhenstvo_Tur(c.getId());
			tur.setNazva_turu(Nazva_turu.getText());
			tur.setOpus_turu(Opus_turu.getText());
			tur.setData_poch_turu(Data_poch_turu.getText());
			try {
			tur.setTruv_turu(Integer.valueOf(Truv_turu.getText()));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this,
						"Незаровнені поля");
			}
			tur.setKraina(Kraina.getText());
			tur.setVartist(Vartist.getText());
		    tur.setAhenstvoId(1);

			if (tur.getId() == null) {
				int newId = new TurDao().insertTur(tur);
				tur.setId(newId);
			} else {
				new TurDao().updateTur(tur);
			}
			this.setVisible(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Помилка при збереженні туру: " + e.getMessage());
		}
	}

	private void cancelSave() {
		this.setVisible(false);
	}

}
