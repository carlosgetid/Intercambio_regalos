package com.cpgp.components;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


public class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor,ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	JButton renderButton;
	JButton editButton;
	String text;

	String entityName;
	
	public ButtonColumn(JTable table,String entityName,int columnIndex) {
		super();
		this.table=table;
		
		//save in the global variable
		this.entityName=entityName;
		renderButton=new JButton();
		
		editButton=new JButton();
		editButton.setFocusPainted(false);
		editButton.addActionListener(this);
		
		TableColumnModel columnModel=table.getColumnModel();
		columnModel.getColumn(columnIndex).setCellRenderer(this);
		columnModel.getColumn(columnIndex).setCellEditor(this);
		
		//Put image to button
		if(entityName.matches("category|exercise")&&columnIndex==5||entityName.matches("topic")&&columnIndex==4) {
			Image img=new ImageIcon(this.getClass().getResource("/rename.png")).getImage();
			renderButton.setIcon(new ImageIcon(img));
		}
		if(entityName.matches("category|exercise")&&columnIndex==6||entityName.matches("topic")&&columnIndex==5) {
			Image img=new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
			renderButton.setIcon(new ImageIcon(img));
		}
	
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if(hasFocus) {
			renderButton.setForeground(table.getForeground());
			renderButton.setBackground(UIManager.getColor("Button.background"));
		}
		else if(isSelected) {
			renderButton.setForeground(table.getSelectionForeground());
			renderButton.setBackground(table.getSelectionBackground());
		}
		else {
			renderButton.setForeground(table.getForeground());
			renderButton.setBackground(UIManager.getColor("Button.background"));
		}
		renderButton.setText((value==null) ? "" : value.toString());
		return renderButton;
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		text = (value==null) ? "" : value.toString();
		editButton.setText(text);
		return editButton;
	}
	
	@Override
	public Object getCellEditorValue() {
		return text;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		fireEditingStopped();
		if (entityName.equals("category")&&table.getSelectedColumn()==5) {
//			Rename gui;
//			try {
//				gui = new Rename(entityName, table, 0, 50);
//				gui.setVisible(true);
//			} catch (BadLocationException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			
		}
		if (entityName.equals("category")&&table.getSelectedColumn()==6) {
//			Delete gui;
//			try {
//				gui=new Delete(entityName, table);
//				gui.setVisible(true);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
		}
		
		if (entityName.equals("exercise")&&table.getSelectedColumn()==5) {
//			Rename gui;
//			try {
//				gui = new Rename(entityName, table, 0, 200);
//				gui.setVisible(true);
//			} catch (BadLocationException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}
		if (entityName.equals("exercise")&&table.getSelectedColumn()==6) {
//			Delete gui;
//			try {
//				gui=new Delete(entityName, table);
//				gui.setVisible(true);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
		}
		
		if (entityName.equals("topic")&&table.getSelectedColumn()==4) {
//			Rename gui;
//			try {
//				gui = new Rename(entityName, table, 0, 201);
//				gui.setVisible(true);
//			} catch (BadLocationException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}
		if (entityName.equals("topic")&&table.getSelectedColumn()==5) {
//			Delete gui;
//			try {
//				gui=new Delete(entityName, table);
//				gui.setVisible(true);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
		}
		
		//System.out.println(e.getActionCommand() + " : " + table.getSelectedRow());
	}
	}
