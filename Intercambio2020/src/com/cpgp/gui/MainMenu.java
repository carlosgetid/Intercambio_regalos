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
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
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
		
		System.out.println("------------------NEW VERSION------------------");
		int[][] k = new int[10][arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			k[0][i] = arr.get(i).getId();			
		}
		
		int p = 1;
		while (p < 10) {
			System.out.println("vuelta : "+p);
//		RANDOM
			@SuppressWarnings("unchecked")
			int[] k2 = k[0].clone();
			
			
			System.out.println("------------------TAMANNNNIO------------------");
			System.out.println(arr.size());
//			shuffle
			for (int i=0;i<arr.size();i++) {
				int swap;
				do {
					System.out.println("en el while");	
			    	swap = randomNumber(arr.size()-1, -1);
			    	System.out.println("swap : "+swap);	
			    	System.out.println("i : "+i);	
			    	int temp = k2[swap];
			    	k2[swap] = k2[i];
			    	k2[i]=temp;			    	
			    System.out.println("primero : "+k[0][i]);	
			    System.out.println("nuevo :" +k2[i]);	
			    }while(
			    		k2[0] == k[0][0] 
			    		|| k2[1] == k[0][1] 
			    				|| k2[2] == k[0][2] 
			    						|| k2[3] == k[0][3]
			    								|| k2[4] == k[0][4]
			    										); 
			}
			
			k[p] = k2;
//		RANDOM FIN
			 p++;
		}
			System.out.println("------------------RESULTADO-------------------");
			System.out.println(Arrays.toString(k[0]));
			System.out.println("vuelta 1: "+ Arrays.toString(k[1]));
			System.out.println("vuelta 2: "+ Arrays.toString(k[2]));
			System.out.println("vuelta 3: "+ Arrays.toString(k[3]));
			System.out.println("vuelta 4: "+ Arrays.toString(k[4]));
			System.out.println("vuelta 5: "+ Arrays.toString(k[5]));
			System.out.println("vuelta 6: "+ Arrays.toString(k[6]));
			System.out.println("vuelta 7: "+ Arrays.toString(k[7]));
			System.out.println("vuelta 8: "+ Arrays.toString(k[8]));
			System.out.println("vuelta 9: "+ Arrays.toString(k[9]));
		System.out.println("------------------NEW VERSION FIN------------------");
		
		
		
		
		
		arrayOfPosibilities.add(arr);
		
//		clone and rotate array items
		for (int i = 0; i < arrayOfPlayers.getSize()-1; i++) {
			@SuppressWarnings("unchecked")
			ArrayList<Player> arr2 = (ArrayList<Player>) arrayOfPosibilities.get(i).clone();
			
			Collections.rotate(arr2, -1);
			
			for (Player player : arr2) {
				System.out.println(player);
			}
			
			arrayOfPosibilities.add(arr2);
			
		}
		
		System.out.println("-----------------VER CONTENIDO------------------");
		
		for (ArrayList<Player> arreglo : arrayOfPosibilities) {
			System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
			for (Player player : arreglo) {
				System.out.println(player);
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
	
//	puede retornar el maxValue y el minValue
	private int randomNumber(int maxValue, int minValue) {
		int r=(int)(Math.random()*(minValue-maxValue))+maxValue;
		return r;
	}
}
