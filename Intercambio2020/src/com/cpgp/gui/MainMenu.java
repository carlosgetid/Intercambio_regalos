package com.cpgp.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import com.cpgp.arrays.ArrayOfPlayers;
import com.cpgp.entities.Player;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7921530987200051397L;
	private JPanel contentPane;
	private JTextField txtNombre;
	public static JTable tblPlayers = new JTable();;
	ArrayOfPlayers arrayOfPlayers = new ArrayOfPlayers();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(125, 25, 114, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAgregar(e);
			}
		});
		btnAgregar.setBounds(281, 22, 117, 25);
		contentPane.add(btnAgregar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 98, 358, 188);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(tblPlayers);
		
		tblPlayers.setModel(arrayOfPlayers);
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		System.out.println(arrayOfPlayers.getSize());
		String nombre = leerNombre();
		Player c=new Player(arrayOfPlayers.generateID(), nombre);
		arrayOfPlayers.addPlayer(c);
		System.out.println(arrayOfPlayers.getSize());
		System.out.println(arrayOfPlayers.getValueAt(0, 0));
		System.out.println(arrayOfPlayers.getValueAt(0, 1));
		arrayOfPlayers.fireTableDataChanged();
	}
	
	public String leerNombre(){
		return txtNombre.getText();
	}
	
//	public static void setTableModel(TableModel x) {
//		
//		tblPlayers.getColumnModel().getColumn(0).setMinWidth(0);
//		tblPlayers.getColumnModel().getColumn(0).setMaxWidth(0);
//		tblPlayers.getColumnModel().getColumn(0).setWidth(0);
//	}
//	
//	private void refreshTable(TableModel x) {
//		setTableModel(x);
//		//Place custom buttons in a column of the table according to the column index
//	}
}
