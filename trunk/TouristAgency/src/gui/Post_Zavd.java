package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Post_Zavd extends JDialog {
	String val = "	�������� �������� ��� ������ �� ������ ������� ��������� ������. ��� ������ \n"
			+ "���������� � mysql-��� �����, �������� ������� ��������� �� ���������� ��� � ���� �����. \n �����"
			+ "��������� ����������� �������� ������� ���� Java. �������� ������� ���� ��������� \n ���������."
			+ "�� ��������� ��������� �������� ����� �������:\n"
			+ "1.	����� �� ����������� ������, �������� ��� ������ �� ����������.\n"
			+ "2.	UML ������� �����������.\n"
			+ "3.	UML ������� �����.\n"
			+ "������ ������� ��������:\n"
			+ "1.	���������� ����� ������.\n"
			+ "2.	����������� �� ��������� �������� ������.\n"
			+ "3.	�������� �����.\n"
			+ "��������� �������:  ��������� �������� \n"
			+ " �������� ������� ��������� ��������� � ��������� �����������: \n"
			+ "1. 	��������\n"
			+ "2. 	����\n"
			+ "         ��� ����� �� ������������ ���� � �������� ������ �������."
			+ " ���������� ���� �������� \n ���� ��������, "
			+ "������������ ��� �������� �������. ����� ���� �������� ���, "
			+ "������������ \n ��� �������� �������� ������ ���� ������� �������� "
			+ "�� ��������� � ����.";
	TextArea text = new TextArea(val, 19, 82);
	JButton button1 = new JButton();
	JLabel label1 = new JLabel();

	public Post_Zavd() {
		setTitle("���������� ��������");
		setSize(640, 410);
		setResizable(true);
		button1.setText("������� ����");
		panel panel = new panel();
		panel.setOpaque(false);
		text.setBackground(Color.yellow);
		text.setForeground(Color.red);
		text.setFont(new Font("Times New Poman", Font.BOLD, 12));
		panel.add(label1);
		panel.add(text);
		panel.add(button1);
		getContentPane().add(panel);
		label1.setText("�������� ������. ��������� ������������� �� ��������� ���������� ��������");
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