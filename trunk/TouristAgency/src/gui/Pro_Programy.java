package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Pro_Programy extends JDialog {
	
	String val = "        Метою написання цієї програми є створення курсового проекту \n"
		+ " Компілювання проекту здійснюється в середовищі Eclipse Platform Version: " +
				"3.4.0 \n"
		+ "                  ВИКОНАВЕЦЬ: Крохмалюк П.А. \n " +
		"                 КЕРІВНИК: викладач Левицький І.В. ";
	
TextArea text = new TextArea(val, 5, 70);
JButton button1 = new JButton();
JLabel label1 = new JLabel();

public Pro_Programy() {
	setTitle("Довідка про програму:)))");
	setSize(540, 190);
	setResizable(true);
	button1.setText("Закрити вікно");
	panel panel = new panel();
	panel.setOpaque(false);
	text.setBackground(Color.yellow);
	text.setForeground(Color.red);
	text.setFont(new Font("Times New Roman", Font.BOLD, 12));
	panel.add(label1);
	panel.add(text);
	panel.add(button1);
	getContentPane().add(panel);
	label1.setText("COPYRIGHT © 2010 BY PETRO KROHMALUK ALL RIGHT RESERVED");
	label1.setForeground(Color.red);
	
	button1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			onClose();
		}
	});
}

private void onClose() {
	dispose();
}

}