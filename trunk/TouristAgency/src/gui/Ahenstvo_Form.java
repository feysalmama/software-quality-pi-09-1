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

import dao.AhenstvoDao;
import domain.Ahenstvo;

public class Ahenstvo_Form extends JDialog {

	public static final String Ocenka1 = "1";
	public static final String Ocenka2 = "2";
	public static final String Ocenka3 = "3";
	public static final String Ocenka4 = "4";
	public static final String Ocenka5 = "5";

	private Ahenstvo ahenstvo;

	private JTextField Nazva_Tur_Ah;
	private JTextField Adresa;
	private JTextField Imja_Vlas;
	private JTextField Tel_nomer;
	private JTextField Fax_nomer;
	private JTextField Clients_nomber;
	private JComboBox OcenkaList;

	JLabel l1 = new JLabel("Назва туристичного агенства");
	JLabel l2 = new JLabel("Адреса");
	JLabel l3 = new JLabel("І`мя власика");
	JLabel l4 = new JLabel("Телефонний номер");
	JLabel l5 = new JLabel("Номер факсу");
	JLabel l6 = new JLabel("Кількість клієнтів");
	JLabel l7 = new JLabel("Оцінка агенства");

	public Ahenstvo_Form() {
		setTitle("Агенство");
		setSize(500, 320);
		setModal(true);
		setResizable(false);
		setLocationByPlatform(true);

		final JButton cmdSave = new JButton("Зберегти");
		final JButton cmdCancel = new JButton("Відмінити");

		Nazva_Tur_Ah = new JTextField(15);
		Adresa = new JTextField(15);
		Imja_Vlas = new JTextField(15);
		Tel_nomer = new JTextField(15);
		Fax_nomer = new JTextField(15);
		Clients_nomber = new JTextField(15);
		OcenkaList = new JComboBox(new Object[] { Ocenka1, Ocenka2, Ocenka3,
				Ocenka4, Ocenka5 });
		OcenkaList.setEditable(false);

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
		fieldsPanelBorder.setOpaque(false);
		fieldsPanelBorder.add(fieldsPanel);
		fieldsPanel.add(l1);
		fieldsPanel.add(Nazva_Tur_Ah);
		fieldsPanel.add(l2);
		fieldsPanel.add(Adresa);
		fieldsPanel.add(l3);
		fieldsPanel.add(Imja_Vlas);
		fieldsPanel.add(l4);
		fieldsPanel.add(Tel_nomer);
		fieldsPanel.add(l5);
		fieldsPanel.add(Fax_nomer);
		fieldsPanel.add(l6);
		fieldsPanel.add(Clients_nomber);
		fieldsPanel.add(l7);
		fieldsPanel.add(OcenkaList);

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
				saveAhenstvo();
			}
		});

		cmdCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSave();
			}
		});
	}

	public Ahenstvo getComand() {
		return ahenstvo;
	}

	public void newAhenstvo(Ahenstvo ahenstvo) {
		this.ahenstvo = ahenstvo;
		Nazva_Tur_Ah.setText("");
		Adresa.setText("");
		Imja_Vlas.setText("");
		Tel_nomer.setText("");
		Fax_nomer.setText("");
		Clients_nomber.setText("");
		OcenkaList.setSelectedItem(Ocenka1);

		if (ahenstvo.getOcenka() == Ahenstvo.Ocenka1) {
			OcenkaList.setSelectedItem(Ocenka1);
		} else if (ahenstvo.getOcenka() == Ahenstvo.Ocenka2) {
			OcenkaList.setSelectedItem(Ocenka2);
		} else if (ahenstvo.getOcenka() == Ahenstvo.Ocenka3) {
			OcenkaList.setSelectedItem(Ocenka3);
		} else if (ahenstvo.getOcenka() == Ahenstvo.Ocenka4) {
			OcenkaList.setSelectedItem(Ocenka4);
		} else if (ahenstvo.getOcenka() == Ahenstvo.Ocenka5) {
			OcenkaList.setSelectedItem(Ocenka5);
		}
	}

	public void setAhenstvo(Ahenstvo ahenstvo) {
		this.ahenstvo = ahenstvo;
		Nazva_Tur_Ah.setText(ahenstvo.getNazva_Tur_Ah());
		Adresa.setText(ahenstvo.getAdresa());
		Imja_Vlas.setText(ahenstvo.getImja_Vlas());
		Tel_nomer.setText(String.valueOf(ahenstvo.getTel_nomer()));
		Fax_nomer.setText(String.valueOf(ahenstvo.getFax_nomer()));
		Clients_nomber.setText(String.valueOf(ahenstvo.getClients_nomber()));
		OcenkaList.setSelectedItem(Ocenka1);

		if (ahenstvo.getOcenka() == Ahenstvo.Ocenka1) {
			OcenkaList.setSelectedItem(Ocenka1);
		} else if (ahenstvo.getOcenka() == Ahenstvo.Ocenka2) {
			OcenkaList.setSelectedItem(Ocenka2);
		} else if (ahenstvo.getOcenka() == Ahenstvo.Ocenka3) {
			OcenkaList.setSelectedItem(Ocenka3);
		} else if (ahenstvo.getOcenka() == Ahenstvo.Ocenka4) {
			OcenkaList.setSelectedItem(Ocenka4);
		} else if (ahenstvo.getOcenka() == Ahenstvo.Ocenka5) {
			OcenkaList.setSelectedItem(Ocenka5);
		}
	}

	private void saveAhenstvo() {
		try {
			ahenstvo.setNazva_Tur_Ah(Nazva_Tur_Ah.getText());
			ahenstvo.setAdresa(Adresa.getText());
			ahenstvo.setImja_Vlas(Imja_Vlas.getText());
			try {
				ahenstvo.setTel_nomer(Integer.valueOf(Tel_nomer.getText()));
				ahenstvo.setFax_nomer(Integer.valueOf(Fax_nomer.getText()));
				ahenstvo.setClients_nomber(Integer.valueOf(Clients_nomber.getText()));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this,
						"Незаповнені поля");
			}

			if (OcenkaList.getSelectedItem().equals(Ocenka1)) {
				ahenstvo.setOcenka(Ahenstvo.Ocenka1);
			} else if (OcenkaList.getSelectedItem().equals(Ocenka2)) {
				ahenstvo.setOcenka(Ahenstvo.Ocenka2);
			} else if (OcenkaList.getSelectedItem().equals(Ocenka3)) {
				ahenstvo.setOcenka(Ahenstvo.Ocenka3);
			} else if (OcenkaList.getSelectedItem().equals(Ocenka4)) {
				ahenstvo.setOcenka(Ahenstvo.Ocenka4);
			} else if (OcenkaList.getSelectedItem().equals(Ocenka5)) {
				ahenstvo.setOcenka(Ahenstvo.Ocenka5);
			}

			if (ahenstvo.getId() == null) {
				int newId = new AhenstvoDao().insertAhenstvo(ahenstvo);
				ahenstvo.setId(newId);
			} else {
				new AhenstvoDao().updateAhenstvo(ahenstvo);
			}
			this.setVisible(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Помилка при збереженні агенства: " + e.getMessage());
		}
	}

	private void cancelSave() {
		this.setVisible(false);
	}

}
