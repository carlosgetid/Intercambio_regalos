package com.cpgp.free;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7921530987200051397L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTable tblParticipantes;
	private DefaultTableModel dtm = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
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
		
		tblParticipantes = new JTable();
		dtm.addColumn("Codigo");
		dtm.addColumn("Nombre");
		dtm.addColumn("");
		dtm.addColumn("");
		tblParticipantes.setModel(dtm);
		scrollPane.setViewportView(tblParticipantes);
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		String nombre = leerNombre();
		
		Object row[] = {1, nombre, "", ""};
		
		dtm.addRow(row);
		
	}
	
	public String leerNombre(){
		return txtNombre.getText();
	}
}
