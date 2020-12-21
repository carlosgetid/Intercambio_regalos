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
	private int resultados;
	

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
		
//		int ba[] = new int[] {1, 2, 5, 3, 4};
//		System.out.println(Arrays.toString(ba));
//		
//		int bo[] = new int[] {1, 2, 5, 3, 4};
//		System.out.println(Arrays.toString(bo));
//		
//		if(Arrays.equals(ba, bo)) {
//			System.out.println("son iguales");
//		}
//		else
//			System.out.println("no son iguales");
			
		
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
//		int[][] k = new int[1000][arr.size()];
		int[][] k = new int[2000][arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			k[0][i] = arr.get(i).getId();			
		}
		System.out.println(Arrays.toString(k[0]));
		
		resultados = 1;
		long start = System.currentTimeMillis();
		
		long end;
		System.out.println("Cantidad : "+tblPlayers.getRowCount());
		if(tblPlayers.getRowCount()<=2) 
			end = start + 250;			
		else if(tblPlayers.getRowCount()<=4) 
			end = start + 500;			
		else
			end = start + 1000;
		
		while (true) {
//		RANDOM
			@SuppressWarnings("unchecked")
			int[] k2 = k[0].clone();
			
			do {
				
				do {
					do {
						for (int i=0;i<arr.size();i++) {
	//						shuffle
							do
							k2[i] = randomNumber(arr.size(), 0);
							while(checkPreviousNumbers(i, k2));
						}
					}while(checkFirstArrayValueByValue(arr, k2, k)); 	
					if(System.currentTimeMillis() > end) {
						System.out.println("DETENIDO POR TIEMPO");
			            break;
			        }
				}while(checkWithOthersArrays(k2, k));			
			}while(checkNotGiftEachOther(k2,k));
			
			if(System.currentTimeMillis() > end) 
				break;
			else
				k[resultados] = k2;
//		RANDOM FIN
			resultados++;
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
			System.out.println("vuelta 10: "+ Arrays.toString(k[10]));
			System.out.println("vuelta 11: "+ Arrays.toString(k[11]));
			System.out.println("vuelta 12: "+ Arrays.toString(k[12]));
			System.out.println("vuelta 13: "+ Arrays.toString(k[13]));
			System.out.println("vuelta 14: "+ Arrays.toString(k[14]));
			System.out.println("vuelta 15: "+ Arrays.toString(k[15]));
			System.out.println("vuelta 16: "+ Arrays.toString(k[16]));
			System.out.println("vuelta 17: "+ Arrays.toString(k[17]));
			System.out.println("vuelta 18: "+ Arrays.toString(k[18]));
			System.out.println("vuelta 19: "+ Arrays.toString(k[19]));
			System.out.println("vuelta 20: "+ Arrays.toString(k[20]));
			System.out.println("vuelta 21: "+ Arrays.toString(k[21]));
			System.out.println("vuelta 22: "+ Arrays.toString(k[22]));
			System.out.println("vuelta 23: "+ Arrays.toString(k[23]));
			System.out.println("vuelta 24: "+ Arrays.toString(k[24]));
			System.out.println("vuelta 25: "+ Arrays.toString(k[25]));
			System.out.println("vuelta 26: "+ Arrays.toString(k[26]));
			System.out.println("Cantidad : "+tblPlayers.getRowCount());

		System.out.println("------------------NEW VERSION FIN------------------");
		
		
		
		
		
		arrayOfPosibilities.add(arr);
		
//		clone and rotate array items
		for (int i = 0; i < arrayOfPlayers.getSize()-1; i++) {
			@SuppressWarnings("unchecked")
			ArrayList<Player> arr2 = (ArrayList<Player>) arrayOfPosibilities.get(i).clone();
			
			Collections.rotate(arr2, -1);
			
			for (Player player : arr2) {
//				System.out.println(player);
			}
			
			arrayOfPosibilities.add(arr2);
			
		}
		
		System.out.println("-----------------VER CONTENIDO------------------");
		
		for (ArrayList<Player> arreglo : arrayOfPosibilities) {
//			System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
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
	
	private boolean checkWithOthersArrays(int[] k2, int[][] k) {
		boolean x;
		for(int z=1; z < resultados; z++){
			System.out.println("RESULTADOS : "+resultados);
			if(Arrays.equals(k[z], k2)) {
				x = true;
//				System.out.println("checkWithOthersArrays : "+x);
				return x;
			}
		}
		x = false;
//		System.out.println("checkWithOthersArrays : "+x);
		return x;
	}

	private boolean checkNotGiftEachOther(int[] k2, int[][] k) {
//		System.out.println("este es el length :"+k[0].length);
//		for two players is allowed
		if(k[0].length == 2) 
			return false;
		else {
			for(int h = 0; h<k[0].length; h++){
				for(int g = 0; g<k[0].length; g++){
					if(k[0][g] == k2[h] && k[0][h] == k2[g])
						return true;
				}
			}
		}
		return false;
	}

	private boolean checkPreviousNumbers(int i, int[] k2) {
//		if(k2[i]==k[0][i]) {
//			System.out.println("coincide con el de arriba");
//			System.out.println("k2["+i+"]"+k2[i]+" vs "+"k[0]["+i+"]"+k[0][i]);
//			return true;
//		}
		for (int j = 0; j < i; j++) {
			if(k2[i]==k2[j]) {				
//				System.out.println("coincide con algun anterior");
//				System.out.println("k2["+i+"]"+k2[i]+" vs "+"k2["+j+"]"+k2[j]);
				return true;
			}
		}
		return false;
	}

	private boolean checkFirstArrayValueByValue(ArrayList<Player> arr, int[] k2, int[][] k) {
	boolean m;
	boolean n = false;
	for (int j = 0; j < arr.size(); j++) {
		m = k2[j] == k[0][j];
//		System.out.println("solo : "+m);
		if(m)
			return m;
	}
//	System.out.println(": "+ Arrays.toString(k[0]));
//	System.out.println(": "+ Arrays.toString(k2));
//	System.out.println(n);
	return n;
	}

	//	puede retornar el maxValue y el minValue
	private int randomNumber(int maxValue, int minValue) {
		int r=(int)(Math.random()*(minValue-maxValue))+maxValue;
		return r;
	}
}
