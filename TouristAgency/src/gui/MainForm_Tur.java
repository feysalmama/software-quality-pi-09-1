package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.TableColumnModel;

import dao.TurDao;
import domain.Tur;

public class MainForm_Tur extends JFrame implements ActionListener {

	JToolBar toolbar = new JToolBar();
	JPopupMenu popupmenu = new JPopupMenu();
	private JButton ZAKRUTU;
	private JButton DODATU;
	private JButton REDAGYVATU;
	private JButton VUDALUTU;
	private JTable TurTable;

	private Tur_Form tur_Form = new Tur_Form();
	private Tur_TableModel tur_TableModel;

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == DODATU_Tur) {
			addTur();
		} else if (e.getSource() == VUDALUTU_Dani) {
			removeTur();
		} else if (e.getSource() == REDAGYVATU_Dani) {
			updateTur();
		} else if (e.getSource() == Pereutu) {
			onClose();
		}
	}
	JMenuItem DODATU_Tur, VUDALUTU_Dani, REDAGYVATU_Dani, Pereutu;

	void createMenu() {
		JMenuBar bar = new JMenuBar();
		bar.setBackground(Color.green);
		JMenu msgdialog = new JMenu("Файл");
		ImageIcon newicon = new ImageIcon("img/new.png");
		DODATU_Tur = new JMenuItem("Новий запис", newicon);
		DODATU_Tur.setBackground(Color.yellow);
		DODATU_Tur.setToolTipText("Добавити новий запис до бази");
		DODATU_Tur.addActionListener(this);
		msgdialog.add(DODATU_Tur);
		ImageIcon edit = new ImageIcon("img/edit.png");
		REDAGYVATU_Dani = new JMenuItem("Редагувати запис", edit);
		REDAGYVATU_Dani.setBackground(Color.yellow);
		REDAGYVATU_Dani.setToolTipText("Внести зміни у вже створений запис");
		REDAGYVATU_Dani.addActionListener(this);
		msgdialog.add(REDAGYVATU_Dani);
		ImageIcon delete = new ImageIcon("img/delete.png");
		VUDALUTU_Dani = new JMenuItem("Видалити запис", delete);
		VUDALUTU_Dani.setBackground(Color.yellow);
		VUDALUTU_Dani.setToolTipText("Знищити запис у базі");
		VUDALUTU_Dani.addActionListener(this);
		msgdialog.add(VUDALUTU_Dani);
		ImageIcon exit = new ImageIcon("img/exit.png");
		Pereutu = new JMenuItem("Закрити вікно", exit);
		Pereutu.setBackground(Color.yellow);
		Pereutu.setToolTipText("Закінчити роботу з таблицею");
		Pereutu.addActionListener(this);
		msgdialog.add(Pereutu);
		bar.add(msgdialog);
		setJMenuBar(bar);
	}

	
	public MainForm_Tur() {
		setTitle("Тури");
		setSize(1160, 460);
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
		JMenuItem pexit = new JMenuItem("Закрити вікно", exiticon);
		pexit.setBackground(Color.yellow);
		pexit.addActionListener(this);
		
		ImageIcon printicon = new ImageIcon("img/print.png");
		JMenuItem pprint = new JMenuItem("Друк", printicon);
		pprint.setBackground(Color.yellow);
		pprint.addActionListener(this);

		popupmenu.add(pnew);
		popupmenu.add(pedit);
		popupmenu.add(pdelete);
		popupmenu.add(pexit);
		popupmenu.add(pprint);
		
		ImageIcon tnewicon = new ImageIcon("img/tnew.png");
		ImageIcon tediticon = new ImageIcon("img/tedit.png");
		ImageIcon tdeleteicon = new ImageIcon("img/tdelete.png");
		ImageIcon tprinticon = new ImageIcon("img/tprint.png");
		JButton b1 = new JButton(tnewicon);
		JButton b2 = new JButton(tediticon);
		JButton b3 = new JButton(tdeleteicon);
		JButton b4 = new JButton(tprinticon);
		b1.setBorderPainted(false);
		b2.setBorderPainted(false);
		b3.setBorderPainted(false);
		b4.setBorderPainted(false);
		b1.setBackground(Color.yellow);
		b2.setBackground(Color.yellow);
		b3.setBackground(Color.yellow);
		b4.setBackground(Color.yellow);
		b1.setToolTipText("Добавити новий запис до бази");
		b2.setToolTipText("Внести зміни у вже створений запис");
		b3.setToolTipText("Знищити запис у базі");
		b4.setToolTipText("Друк");
		toolbar.add(b1);
		toolbar.add(b2);
		toolbar.add(b3);
		toolbar.add(b4);
		toolbar.setFloatable(false);
		toolbar.setPreferredSize(new Dimension(400, 25));
		toolbar.setBackground(Color.yellow);
		
		ZAKRUTU = new JButton("Закрити");
		DODATU = new JButton("Новий запис");
		REDAGYVATU = new JButton("Обновити дані");
		VUDALUTU = new JButton("Видалити дані");
		tur_TableModel = getTableModel();
		TurTable = new JTable(tur_TableModel);
		TurTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TurTable.getTableHeader().setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		TurTable.getTableHeader().setForeground(Color.red);
		TurTable.getTableHeader().setBackground(Color.green);
		TableColumnModel tcm = TurTable.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(210);
		tcm.getColumn(1).setPreferredWidth(200);
		tcm.getColumn(2).setPreferredWidth(200);
		tcm.getColumn(3).setPreferredWidth(140);
		tcm.getColumn(4).setPreferredWidth(130);
		tcm.getColumn(5).setPreferredWidth(110);
		tcm.getColumn(6).setPreferredWidth(110);
		TurTable.setPreferredScrollableViewportSize(new Dimension(1100, 300));
		TurTable.setBackground(Color.yellow);
		TurTable.setGridColor(Color.red);
		TurTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(TurTable);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		panel mainPanel = new panel();
		mainPanel.add(scrollPane);
		JPanel commandsPanel = new JPanel(new FlowLayout());
		commandsPanel.setOpaque(false);
		commandsPanel.add(DODATU);
		commandsPanel.add(REDAGYVATU);
		commandsPanel.add(VUDALUTU);
		commandsPanel.add(ZAKRUTU);
		mainPanel.add(commandsPanel);

		getContentPane().add(toolbar, BorderLayout.NORTH);
		getContentPane().add(mainPanel);
		getRootPane().setDefaultButton(ZAKRUTU);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTur();
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTur();
			}
		});

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeTur();
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printTur();
			}
		});
		TurTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if (me.isPopupTrigger())
					popupmenu.show(me.getComponent(), me.getX(), me.getY());
			}

			public void mouseReleased(MouseEvent me) {
				if (me.isPopupTrigger())
					popupmenu.show(me.getComponent(), me.getX(), me.getY());
			}
		});
		DODATU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTur();
			}
		});

		REDAGYVATU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTur();
			}
		});

		VUDALUTU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeTur();
			}
		});

		ZAKRUTU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClose();
			}
		});
		pnew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTur();
			}
		});
		pedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTur();
			}
		});
		pdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeTur();
			}
		});
		pexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClose();
			}
		});
		pprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printTur();
			}
		});

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				onClose();
			}
		});

		mainPanel.registerKeyboardAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClose();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
				JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
	}
	
	private void printTur() {
		try {
			MessageFormat headerFormat = new MessageFormat("Page {0}");
			MessageFormat footerFormat = new MessageFormat("- {0} -");
			TurTable.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
		} catch (PrinterException pe) {
			System.err.println("Error printing: " + pe.getMessage());
		}
	}

	private Tur_TableModel getTableModel() {
		try {
			TurDao dao = new TurDao();
			final List<Tur> tur = dao.findAll();

			return new Tur_TableModel(tur);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane
					.showMessageDialog(this,
							"Помилка при заповненні таблиці тури: "
									+ e.getMessage());
		}
		return new Tur_TableModel(new ArrayList<Tur>(0));
	}

	private void onClose() {
		dispose();
	}

	private void addTur() {
		tur_Form.newTur(new Tur());
		tur_Form.setVisible(true);
		if (tur_Form.getGame().getId() != null) {
			tur_TableModel.addTur(tur_Form.getGame());
		}
	}

	private void updateTur() {
		int index = TurTable.getSelectedRow();
		if (index == -1)
			return;

		Tur tur = tur_TableModel.getRowTur(index);
		if (tur != null) {
			tur_Form.setTur(tur);
			tur_Form.setVisible(true);
			tur_TableModel.refreshUpdatedTable();
		}
	}

	private void removeTur() {
		int index = TurTable.getSelectedRow();
		if (index == -1)
			return;

		try {
			Tur g = tur_TableModel.getRowTur(index);
			if (g != null) {
				TurDao dao = new TurDao();
				dao.deleteTur(g.getId());
				tur_TableModel.removeRow(index);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Помилка при видаленні туру: " + e.getMessage());
		}
	}

}
