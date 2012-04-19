package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

import dao.AhenstvoDao;
import domain.Ahenstvo;

public class MainForm_Ahenstvo extends JFrame implements ActionListener {

	JToolBar toolbar = new JToolBar();
	JPopupMenu popupmenu = new JPopupMenu();
	private JButton ZAKRUTU;
	private JButton DOBAVUTU;
	private JButton REDAGYVATU;
	private JButton VUDALUTU;
	private JTable Ahenstvo_Table;

	private Ahenstvo_Form ahenstvo_Form = new Ahenstvo_Form();
	private Ahenstvo_TableModel ahenstvo_TableModel;

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == DODATU_Ahenstvo) {
			addAhenstvo();
		} else if (e.getSource() == VUDALUTU_Ahenstvo) {
			removeAhenstvo();
		} else if (e.getSource() == REDAGYVATU_Ahenstvo) {
			updateAhenstvo();
		} else if (e.getSource() == ZAKRUTU_PROGRAMY) {
			onClose();
		}
	}

	JMenuItem DODATU_Ahenstvo, VUDALUTU_Ahenstvo, REDAGYVATU_Ahenstvo,
			ZAKRUTU_PROGRAMY, yesno, About_Programs;

	void createMenu() {
		JMenuBar bar = new JMenuBar();
		bar.setBackground(Color.green);
		JMenu msgdialog = new JMenu("Файл");
		ImageIcon newicon = new ImageIcon("img/new.png");
		DODATU_Ahenstvo = new JMenuItem("Новий запис", newicon);
		DODATU_Ahenstvo.setBackground(Color.yellow);
		DODATU_Ahenstvo.setToolTipText("Добавити новий запис до бази");
		DODATU_Ahenstvo.addActionListener(this);
		msgdialog.add(DODATU_Ahenstvo);
		ImageIcon edit = new ImageIcon("img/edit.png");
		REDAGYVATU_Ahenstvo = new JMenuItem("Редагувати запис", edit);
		REDAGYVATU_Ahenstvo.setBackground(Color.yellow);
		REDAGYVATU_Ahenstvo
				.setToolTipText("Внести зміни у вже створений запис");
		REDAGYVATU_Ahenstvo.addActionListener(this);
		msgdialog.add(REDAGYVATU_Ahenstvo);
		ImageIcon delete = new ImageIcon("img/delete.png");
		VUDALUTU_Ahenstvo = new JMenuItem("Видалити запис", delete);
		VUDALUTU_Ahenstvo.setBackground(Color.yellow);
		VUDALUTU_Ahenstvo.setToolTipText("Знищити запис у базі");
		VUDALUTU_Ahenstvo.addActionListener(this);
		msgdialog.add(VUDALUTU_Ahenstvo);
		ImageIcon exit = new ImageIcon("img/exit.png");
		ZAKRUTU_PROGRAMY = new JMenuItem("Закрити вікно", exit);
		ZAKRUTU_PROGRAMY.setBackground(Color.yellow);
		ZAKRUTU_PROGRAMY.setToolTipText("Закінчити роботу з таблицею");
		ZAKRUTU_PROGRAMY.addActionListener(this);
		msgdialog.add(ZAKRUTU_PROGRAMY);
		bar.add(msgdialog);
		setJMenuBar(bar);
	}

	public MainForm_Ahenstvo() {
		setTitle("Агенства");
		setSize(1150, 460);
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
		DOBAVUTU = new JButton("Новий запис");
		REDAGYVATU = new JButton("Редагувати дані");
		VUDALUTU = new JButton("Видалити дані");

		ahenstvo_TableModel = getTableModel();
		Ahenstvo_Table = new JTable(ahenstvo_TableModel);
		Ahenstvo_Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumnModel tcm = Ahenstvo_Table.getColumnModel();
		Ahenstvo_Table.getTableHeader().setFont(
				new Font("Comic Sans MS", Font.BOLD, 14));
		Ahenstvo_Table.getTableHeader().setForeground(Color.red);
		Ahenstvo_Table.getTableHeader().setBackground(Color.green);

		tcm.getColumn(0).setPreferredWidth(210);
		tcm.getColumn(1).setPreferredWidth(200);
		tcm.getColumn(2).setPreferredWidth(150);
		tcm.getColumn(3).setPreferredWidth(130);
		tcm.getColumn(4).setPreferredWidth(110);
		tcm.getColumn(5).setPreferredWidth(130);
		tcm.getColumn(6).setPreferredWidth(130);
		Ahenstvo_Table.setGridColor(Color.red);
		Ahenstvo_Table.setPreferredScrollableViewportSize(new Dimension(1060,
				300));
		Ahenstvo_Table.setBackground(Color.yellow);
		Ahenstvo_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(Ahenstvo_Table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		panel mainPanel = new panel();
		mainPanel.add(scrollPane);
		JPanel commandsPanel = new JPanel(new FlowLayout());
		commandsPanel.setOpaque(false);
		commandsPanel.add(DOBAVUTU);
		commandsPanel.add(REDAGYVATU);
		commandsPanel.add(VUDALUTU);
		commandsPanel.add(ZAKRUTU);
		mainPanel.add(commandsPanel);

		getContentPane().add(toolbar, BorderLayout.NORTH);
		getContentPane().add(mainPanel);
		getRootPane().setDefaultButton(ZAKRUTU);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAhenstvo();
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAhenstvo();
			}
		});

		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAhenstvo();
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printAhenstvo();
			}
		});
		Ahenstvo_Table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if (me.isPopupTrigger())
					popupmenu.show(me.getComponent(), me.getX(), me.getY());
			}

			public void mouseReleased(MouseEvent me) {
				if (me.isPopupTrigger())
					popupmenu.show(me.getComponent(), me.getX(), me.getY());
			}
		});

		DOBAVUTU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAhenstvo();
			}
		});

		REDAGYVATU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAhenstvo();
			}
		});

		VUDALUTU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAhenstvo();
			}
		});

		ZAKRUTU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClose();
			}
		});
		pnew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAhenstvo();
				;
			}
		});
		pedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAhenstvo();
			}
		});
		pdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAhenstvo();
			}
		});
		pexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClose();
			}
		});
		pprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printAhenstvo();
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

	private Ahenstvo_TableModel getTableModel() {
		try {
			AhenstvoDao dao = new AhenstvoDao();
			final List<Ahenstvo> ahenstvo = dao.findAll();

			return new Ahenstvo_TableModel(ahenstvo);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(
					this,
					"Помилка при заповненні таблиці агенства: "
							+ e.getMessage());
		}
		return new Ahenstvo_TableModel(new ArrayList<Ahenstvo>(0));
	}

	private void printAhenstvo() {
		try {
			MessageFormat headerFormat = new MessageFormat("Page {0}");
			MessageFormat footerFormat = new MessageFormat("- {0} -");
			Ahenstvo_Table.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
		} catch (PrinterException pe) {
			System.err.println("Error printing: " + pe.getMessage());
		}
	}

	private void onClose() {
		dispose();
	}

	private void addAhenstvo() {
		ahenstvo_Form.newAhenstvo(new Ahenstvo());
		ahenstvo_Form.setVisible(true);
		if (ahenstvo_Form.getComand().getId() != null) {
			ahenstvo_TableModel.addAhenstvo(ahenstvo_Form.getComand());
		}
	}

	private void updateAhenstvo() {
		int index = Ahenstvo_Table.getSelectedRow();
		if (index == -1)
			return;

		Ahenstvo ahenstvo = ahenstvo_TableModel.getRowAhenstvo(index);
		if (ahenstvo != null) {
			ahenstvo_Form.setAhenstvo(ahenstvo);
			ahenstvo_Form.setVisible(true);
			ahenstvo_TableModel.refreshUpdatedTable();
		}
	}

	private void removeAhenstvo() {
		int index = Ahenstvo_Table.getSelectedRow();
		if (index == -1)
			return;

		try {
			Ahenstvo g = ahenstvo_TableModel.getRowAhenstvo(index);
			if (g != null) {
				AhenstvoDao dao = new AhenstvoDao();
				dao.deleteAhenstvo(g.getId());
				ahenstvo_TableModel.removeRow(index);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Помилка при видаленні агенства: " + e.getMessage());
		}
	}
}
