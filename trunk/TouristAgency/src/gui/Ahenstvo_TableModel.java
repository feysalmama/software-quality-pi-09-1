package gui;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.table.AbstractTableModel;

import domain.Ahenstvo;

public class Ahenstvo_TableModel extends AbstractTableModel {
	
	private String[] columns = new String[] { "Назва туристичного агенства", 
			"Адреса", "І`мя власника", "Номер телефону", 
			"Номер факсу", "Кількість клієнтів", "Оцінка агенства"};
	
	private final List<Ahenstvo> ahenstvos;

	public Ahenstvo_TableModel(List<Ahenstvo> ahenstvo) {
		this.ahenstvos = ahenstvo;
	}

	public void addAhenstvo(Ahenstvo ahenstvo) {
		ahenstvos.add(ahenstvo);
		fireTableRowsInserted(0, ahenstvos.size());
	}

	public Ahenstvo getRowAhenstvo(int rowIndex) {
		return ahenstvos.get(rowIndex);
	}

	public void removeRow(int rowIndex) {
		ahenstvos.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void refreshUpdatedTable() {
		fireTableRowsUpdated(0, ahenstvos.size());
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Ahenstvo g = ahenstvos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return g.getNazva_Tur_Ah();
		case 1:
			return g.getAdresa();
		case 2:
			return g.getImja_Vlas();
		case 3:
			return g.getTel_nomer();
		case 4:
			return g.getFax_nomer();
		case 5:
			return g.getClients_nomber();
		case 6:
			return g.getOcenka();
		}
		return "";
	}

	public int getRowCount() {
		return ahenstvos.size();
	}

	public String getColumnName(int columnIndex) {
		return columns[columnIndex];
	}

	public int getColumnCount() {
		return columns.length;
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
}