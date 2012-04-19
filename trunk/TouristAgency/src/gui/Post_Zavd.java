package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Post_Zavd extends JDialog {
	String val = "	Написати програму для роботи із даними вказаної предметної області. Дані повинні \n"
			+ "зберігатися в mysql-базі даних, програма повинна зчитувати та записувати дані у базу даних. \n Мовою"
			+ "написання програмного продукту повинна бути Java. Програма повинна мати графічний \n інтерфейс."
			+ "До результат виконання завдання також входить:\n"
			+ "1.	Файли із початковими даними, готовими для роботи та тестування.\n"
			+ "2.	UML діаграми прецендентів.\n"
			+ "3.	UML діаграма класів.\n"
			+ "Основні функції програми:\n"
			+ "1.	Добавлення нових записів.\n"
			+ "2.	Редагування та видалення існуючих записів.\n"
			+ "3.	Перегляд даних.\n"
			+ "Предметна область:  Туристичні агенства \n"
			+ " Програма повинна дозволяти працювати з наступною інформацією: \n"
			+ "1. 	Агенства\n"
			+ "2. 	Тури\n"
			+ "         При старті має відобразитися вікно з кнопками вибору таблиці."
			+ " Користувач може добавити \n нове агенство, "
			+ "відредагувати або видалити існуюче. Також може добавити тур, "
			+ "відредагувати \n або видалити існуючий список турів кожного агенства "
			+ "та працювати з ними.";
	TextArea text = new TextArea(val, 19, 82);
	JButton button1 = new JButton();
	JLabel label1 = new JLabel();

	public Post_Zavd() {
		setTitle("Постановка завдання");
		setSize(640, 410);
		setResizable(true);
		button1.setText("Закрити вікно");
		panel panel = new panel();
		panel.setOpaque(false);
		text.setBackground(Color.yellow);
		text.setForeground(Color.red);
		text.setFont(new Font("Times New Poman", Font.BOLD, 12));
		panel.add(label1);
		panel.add(text);
		panel.add(button1);
		getContentPane().add(panel);
		label1.setText("Курсовий проект. Технологія програмування та створення програмних продуктів");
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