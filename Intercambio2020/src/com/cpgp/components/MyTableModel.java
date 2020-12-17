package com.cpgp.components;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel{
	private static final long serialVersionUID = 1L;
	
	public MyTableModel() {
//		column headings
		addColumn("Codigo");
		addColumn("Nombre");
		addColumn("");
		addColumn("");
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		if(column==0||column==1)
			return false;
		return true;
	}
	 
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0:
	            return String.class;
	        case 1:
	        	return String.class;
	        case 2:
	            return String.class;
	        case 3:
	            return String.class;
//	        case 4:
//	            return Boolean.class;// show JCheckBox
//	        case 5:
//	            return String.class;
	        default:
	            return String.class;
		}
	}
}
