package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.*;
import domain.*;


public class Tur_TableModel extends AbstractTableModel {

	private String[] columns = new String[] {"Назва туристичного агенства", "Назва туру", 
			"Опис туру","Дата початку туру", "Тривалість туру", "Країна", "Вартість туру"};

	private final List<Tur> tur;

	public Tur_TableModel(List<Tur> game) {
		this.tur = game;
	}

	public void addTur(Tur game) {
		tur.add(game);
		fireTableRowsInserted(0, tur.size());
	}

	public Tur getRowTur(int rowIndex) {
		return tur.get(rowIndex);
	}

	public void removeRow(int rowIndex) {
		tur.remove(rowIndex);
		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void refreshUpdatedTable() {
		fireTableRowsUpdated(0, tur.size());
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Tur g = tur.get(rowIndex);
		switch (columnIndex) {
		case 0: {
			return getTurName(g.getAhenstvo_Tur());
		}
		case 1:
			return g.getNazva_turu();
		case 2:
			return g.getOpus_turu();
		case 3:
			return g.getData_poch_turu();
		case 4:
			return g.getTruv_turu();
		case 5:
			return g.getKraina();
		case 6: 
			return g.getVartist();
		}
		return "";
	}
	
	private String getTurName(Integer TurId) {
		if (TurId == null)
			return "";
		try {
			Ahenstvo c = new AhenstvoDao().findById(TurId);
			return c.getNazva_Tur_Ah();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public int getRowCount() {
		return tur.size();
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