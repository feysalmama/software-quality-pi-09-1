package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

import javax.swing.*;
import javax.tools.JavaFileManager.Location;

public class MainFORM extends JFrame implements ActionListener {
    JToolBar toolbar = new JToolBar();
	JPopupMenu popupmenu = new JPopupMenu();
	JButton button = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Forma_1) {
			onButtonClick();
		} else if (e.getSource() == Forma_2) {
			onButton2Click();
		} else if (e.getSource() == REDAGYVATU_GRYPY) {
			updateGroup();
		} else if (e.getSource() == ZAKRUTU_PROGRAMY) {
			onClose();
		} else if (e.getSource() == yesno) {
			yesno();
		} else if (e.getSource() == About_Programs) {
			About_Programs();
		}
	}

	JMenuItem Forma_1, Forma_2, REDAGYVATU_GRYPY, ZAKRUTU_PROGRAMY, yesno,
			About_Programs;

	void createMenu() {
		JMenuBar bar = new JMenuBar();
		bar.setBackground(Color.green);

		JMenu msgdialog = new JMenu("Файл");
		ImageIcon newicon = new ImageIcon("img/new.png");
		Forma_1 = new JMenuItem("Новий запис", newicon);
		Forma_1.setBackground(Color.yellow);
		Forma_1.setToolTipText("Добавити новий запис до бази");
		Forma_1.addActionListener(this);
		msgdialog.add(Forma_1);

		ImageIcon edit = new ImageIcon("img/edit.png");
		REDAGYVATU_GRYPY = new JMenuItem("Редагувати запис", edit);
		REDAGYVATU_GRYPY.setBackground(Color.yellow);
		REDAGYVATU_GRYPY.setToolTipText("Внести зміни у вже створений запис");
		REDAGYVATU_GRYPY.addActionListener(this);
		msgdialog.add(REDAGYVATU_GRYPY);

		ImageIcon delete = new ImageIcon("img/delete.png");
		Forma_2 = new JMenuItem("Видалити запис", delete);
		Forma_2.setBackground(Color.yellow);
		Forma_2.setToolTipText("Знищити запис у базі");
		Forma_2.addActionListener(this);
		msgdialog.add(Forma_2);

		ImageIcon exit = new ImageIcon("img/exit.png");
		ZAKRUTU_PROGRAMY = new JMenuItem("Закрити програму", exit);
		ZAKRUTU_PROGRAMY.setBackground(Color.yellow);
		ZAKRUTU_PROGRAMY.setToolTipText("Закінчити роботу з програмою");
		ZAKRUTU_PROGRAMY.addActionListener(this);
		msgdialog.add(ZAKRUTU_PROGRAMY);

		JMenu msgquery = new JMenu("Допомога");
		ImageIcon help = new ImageIcon("img/help.png");
		yesno = new JMenuItem("Постановка завдання", help);
		yesno.setBackground(Color.yellow);
		yesno.setToolTipText("Ознайомитись з програмою");
		yesno.addActionListener(this);
		msgquery.add(yesno);

		ImageIcon about = new ImageIcon("img/about.png");
		About_Programs = new JMenuItem("Про програму", about);
		About_Programs.setBackground(Color.yellow);
		About_Programs.addActionListener(this);
		About_Programs.setToolTipText("Отримати інформацію про виконавця");
		msgquery.add(About_Programs);
		
		bar.add(msgdialog);
		bar.add(msgquery);
		setJMenuBar(bar);

	}

	public MainFORM() {
		setTitle("Головна форма");
		setSize(520, 200);
		setResizable(false);
		setLocationByPlatform(true);
		createMenu();

		ImageIcon pnewicon = new ImageIcon("img/new.png");
		JMenuItem pnew = new JMenuItem("Новий запис", pnewicon);
		pnew.setBackground(Color.yellow);
		pnew.addActionListener(this);

		ImageIcon editicon = new ImageIcon("img/edit.png");
		JMenuItem pedit = new JMenuItem("Редагувати запис", editicon);
		pedit.setBackground(Color.yellow);
		pedit.addActionListener(this);

		ImageIcon deleteicon = new ImageIcon("img/delete.png");
		JMenuItem pdelete = new JMenuItem("Видалити запис", deleteicon);
		pdelete.setBackground(Color.yellow);
		pdelete.addActionListener(this);

		ImageIcon exiticon = new ImageIcon("img/exit.png");
		JMenuItem pexit = new JMenuItem("Закрити програму", exiticon);
		pexit.setBackground(Color.yellow);
		pexit.addActionListener(this);
		
		popupmenu.add(pnew);
		popupmenu.add(pedit);
		popupmenu.add(pdelete);
		popupmenu.add(pexit);

		ImageIcon tnewicon = new ImageIcon("img/tnew.png");
		ImageIcon tediticon = new ImageIcon("img/tedit.png");
		ImageIcon tdeleteicon = new ImageIcon("img/tdelete.png");
		JButton b1 = new JButton(tnewicon);
		JButton b2 = new JButton(tediticon);
		JButton b3 = new JButton(tdeleteicon);
		b1.setBorderPainted(false);
		b2.setBorderPainted(false);
		b3.setBorderPainted(false);
		b1.setBackground(Color.yellow);
		b2.setBackground(Color.yellow);
		b3.setBackground(Color.yellow);
		b1.setToolTipText("Добавити новий запис до бази");
		b2.setToolTipText("Внести зміни у вже створений запис");
		b3.setToolTipText("Знищити запис у базі");
		toolbar.add(b1);
		toolbar.add(b2);
		toolbar.add(b3);
		toolbar.setFloatable(false);
		toolbar.setPreferredSize(new Dimension(400, 25));
		toolbar.setBackground(Color.yellow);
		toolbar.setBorderPainted(isBackgroundSet());
		
		button.setText("Агенства");
		button2.setText("Тури");
		button3.setText("Вихід");
		panel panel = new panel();
		panel.add(label);
		panel.add(label2);
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		panel.add(label3);

		getContentPane().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if (me.isPopupTrigger())
					popupmenu.show(me.getComponent(), me.getX(), me.getY());
			}

			public void mouseReleased(MouseEvent me) {
				if (me.isPopupTrigger())
					popupmenu.show(me.getComponent(), me.getX(), me.getY());
			}
		});

		getContentPane().add(panel);
        getContentPane().add(toolbar, BorderLayout.NORTH);
        
		label.setText("              Відділення АКН               ");
		label.setForeground(Color.red);
		label.setVisible(true);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		label2.setText("               Людино-машинний інтерфейс              ");
		label2.setForeground(Color.green);
		label2.setVisible(true);
		label2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		label3.setText("          Туристичні агенства           ");
		label3.setForeground(Color.yellow);
		label3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		label3.setVisible(true);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onButtonClick();
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onButton2Click();
			}
		});

		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClose();
			}
		});
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onButtonClick();
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateGroup();
			}
		});

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onButton2Click();
			}
		});
		pnew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onButtonClick();
			}
		});
		pedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateGroup();
			}
		});
		pdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onButton2Click();
			}
		});
		pexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClose();
			}
		});
	}

	private void onClose() {
		dispose();
	}

	private void onButtonClick() {
		MainForm_Ahenstvo form = new MainForm_Ahenstvo();
		form.setTitle("Агенства");
		form.setVisible(true);
	}

	private void updateGroup() {
		MainForm_Ahenstvo form = new MainForm_Ahenstvo();
		form.setTitle("Агенства");
		form.setVisible(true);
	}

	private void onButton2Click() {
		MainForm_Tur form = new MainForm_Tur();
		form.setTitle("Тури");
		form.setVisible(true);
	}

	private void yesno() {
		Post_Zavd form = new Post_Zavd();
		form.setTitle("Постановка завдання");
		form.setVisible(true);
	}

	private void About_Programs() {
		Pro_Programy form = new Pro_Programy();
		form.setTitle("Про програму");
		form.setVisible(true);
	}
}
