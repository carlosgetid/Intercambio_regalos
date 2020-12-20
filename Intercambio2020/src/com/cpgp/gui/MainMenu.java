package com.cpgp.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cpgp.arrays.ArrayOfPlayers;
import com.cpgp.entities.Player;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7921530987200051397L;
	private JPanel contentPane;
	private JTextField txtName;
	public static JTable tblPlayers = new JTable();;
	ArrayOfPlayers arrayOfPlayers = new ArrayOfPlayers();
	private JButton btnListo;
	

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
		
		txtName = new JTextField();
		txtName.setBounds(125, 25, 114, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
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
		
		btnListo = new JButton("Listo");
		btnListo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnListo(e);
			}
		});
		btnListo.setBounds(295, 378, 117, 25);
		contentPane.add(btnListo);
		
		focusName();
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		String nombre = readName();
		Player c=new Player(arrayOfPlayers.generateID(), nombre);
		arrayOfPlayers.addPlayer(c);
		arrayOfPlayers.fireTableDataChanged();
		clearName();
		focusName();
	}
	
	public String readName(){
		return txtName.getText();
	}
	
	public void clearName(){
		txtName.setText("");;
	}
	
	public void focusName(){
		txtName.requestFocus();
	}
	

	protected void actionPerformedBtnListo(ActionEvent e) {
		ArrayList<ArrayList<Player>> arrayOfPosibilities = new ArrayList<ArrayList<Player>>();
		
		ArrayList<Player> arr = arrayOfPlayers.randomArray();
		
		arrayOfPosibilities.add(arr);

		for (Player player : arrayOfPosibilities.get(0)) {			
			System.out.println(player);
		}
		
		System.out.println("-----------------FIN------------------");
		
		@SuppressWarnings("unchecked")
		ArrayList<Player> arr2 = (ArrayList<Player>) arrayOfPosibilities.get(0).clone();
		
		Collections.rotate(arr2, -1);
		
		for (Player player : arr2) {
			System.out.println(player);
		}
		
		arrayOfPosibilities.add(arr2);
		
		
		System.out.println("-----------------VER CONTENIDO------------------");
		System.out.println("-----------------PRIMERO------------------");
		for (Player player : arrayOfPosibilities.get(0)) {
			System.out.println(player);
		}
		
		System.out.println("-----------------SEGUNDO------------------");
		for (Player player : arrayOfPosibilities.get(1)) {
			System.out.println(player);
		}
		
		
		System.out.println("total: "+arrayOfPosibilities.size());
		System.out.println("-----------------SEPARADO------------------");
		
		
		for(int i = 1; i<=arr.size()-1; i++) {
			Collections.rotate(arr2, -1);
			System.out.println(".........................");
			for (Player player : arr2) {
				System.out.println(player);
			}
			arrayOfPosibilities.add(arr2);
		}
		
		System.out.println("----------CONTENIDO------------");
		System.out.println("-----------------------------------");
		
		
//		for (ArrayList<Player> arreglo : arrayOfPosibilities) {
//			System.out.println("_________________________________");
//			for (Player player : arreglo) {
//				System.out.println(player);
//			}
//		}
		
		for (int i = 0; i < arrayOfPosibilities.size(); i++) {
			System.out.println("---------------------|-----------------");
			for (int j = 0; j < arrayOfPosibilities.get(i).size(); j++) {
				System.out.println(arrayOfPosibilities.get(i).get(j).getName());
			}
		}
		
		
//		imprimir
//		for (Player player : arr2) {
//			System.out.println(player);
//		}

//		for (int i = 0; i < arrayOfPlayers.getSize(); i++) {
			
//			arrayOfPlayers.getPlayerByIndex(i) = randomNumber
//			Player p = new Player(1, "");
//			p.setId(randomNumber(1, 2));
//			arrayOfPlayers[i]=arrayOfPlayers[i];
//		}
		
//		arrayOfPosibilities.add();
		
//		Match gui = new Match(arrayOfPlayers, false, 0, 0);
//		gui.setVisible(true);
	}
	
	private int randomNumber(int maxValue, int minValue) {
		int r=(int)(Math.random()*(minValue-maxValue))+maxValue;
		return r;
	}
}
