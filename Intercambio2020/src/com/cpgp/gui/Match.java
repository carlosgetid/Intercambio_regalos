package com.cpgp.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cpgp.arrays.ArrayOfPlayers;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Match extends JFrame {

	private JPanel contentPane;
	private ArrayOfPlayers arrayOfPlayers;
	private int id;
//	private boolean vinoEnCadena;
//	private int primerJugadorID;
//	private int idanterior;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Match frame = new Match(null, false, 0, 0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param arrayOfPlayers 
	 */
	public Match(ArrayOfPlayers arrayOfPlayers, boolean vinoEnCadena, int primerJugadorID, int idanterior) {
//		this.vinoEnCadena = vinoEnCadena;
//		this.primerJugadorID = primerJugadorID;
//		this.arrayOfPlayers = arrayOfPlayers;
//		this.idanterior = idanterior;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 672, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEsElTurno = new JLabel("Es el turno de:");
		lblEsElTurno.setBounds(267, 62, 128, 15);
		contentPane.add(lblEsElTurno);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 45));
		lblNewLabel.setBounds(210, 118, 346, 116);
		
//		search player while he is not already played
//		do {
//			id = randomNumber(arrayOfPlayers.getSize(), 0);
//		}while(arrayOfPlayers.getPlayerByID(id).isTurn());
		
		
		lblNewLabel.setText(arrayOfPlayers.getPlayerByID(id).getName());
		arrayOfPlayers.getPlayerByID(id).setTurn(true);

//		if(this.idanterior == id) {
//			this.vinoEnCadena = true;
//		}
//		else
//			this.vinoEnCadena = false;
//		
//		
//		if(this.idanterior == 0) {
//			this.primerJugadorID = id;
//		}
		
		contentPane.add(lblNewLabel);
		
		JButton btnEmpezar = new JButton("Empezar");
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEmpezar(e);
			}
		});
		btnEmpezar.setBounds(278, 344, 117, 25);
		contentPane.add(btnEmpezar);
		
		JLabel lblRealizarSorteo = new JLabel("Realizar sorteo");
		lblRealizarSorteo.setBounds(278, 303, 210, 15);
		contentPane.add(lblRealizarSorteo);
		System.out.println("entro");
	}
	protected void actionPerformedBtnEmpezar(ActionEvent e) {
//		String receptor = "";
////		search player to be receptor
////		the receptor cannot be the current player or already be a receptor or be sender of the current player
//		int number;
//		do {
//			System.out.print("primer do while\n");
//			number = randomNumber(arrayOfPlayers.getSize(), 0);
//			System.out.print(number);
//		}
//		while(number == id || arrayOfPlayers.getPlayerByID(number).isReceptor() || arrayOfPlayers.getPlayerByID(number).getIdTarget()==id);
//		
//		System.out.println(number);
//		
//		receptor = arrayOfPlayers.getPlayerByID(number).getName(); 
//		
////		set the player to be shown as receptor
//		arrayOfPlayers.getPlayerByID(number).setReceptor(true);
//		
////		set current player his receptor id
//		arrayOfPlayers.getPlayerByID(id).setIdTarget(number);
//		
//		int counter = arrayOfPlayers.getSize();
//		System.out.println("tamaño total: "+counter);
//		System.out.println("ya jugo :"+id);
//		for (int i = 1; i <= arrayOfPlayers.getSize(); i++) {
//			if(arrayOfPlayers.getPlayerByID(i).isTurn())
//				counter--;
//		}
//		
//		System.out.println("counter : "+counter);
//		
//		
//		
//		boolean penultimojugador = (counter==1);
//		
//		if(penultimojugador) {
//			System.out.println("entro a penultimo");
//			int ultimojugadorID = 0;
//			
//			for (int i = 1; i <= arrayOfPlayers.getSize(); i++) {
//				if(arrayOfPlayers.getPlayerByID(i).isTurn()==false)
//					ultimojugadorID = i;
//			}
//			
//			int idqueda = 0;
//			for (int i = 1; i <= arrayOfPlayers.getSize(); i++) {
//				if(arrayOfPlayers.getPlayerByID(i).isReceptor())
//					idqueda = i;
//			}
//			
//			while(ultimojugadorID==idqueda ) {
//				do {
//					number = randomNumber(arrayOfPlayers.getSize(), 0);
//				}
//				while(number == id || arrayOfPlayers.getPlayerByID(number).isReceptor() || arrayOfPlayers.getPlayerByID(number).getIdTarget()==id|| arrayOfPlayers.getPlayerByID(number).getIdTarget()==ultimojugadorID);
//			}
//			receptor = arrayOfPlayers.getPlayerByID(number).getName(); 
//			
////			set the player to be shown as receptor
//			arrayOfPlayers.getPlayerByID(number).setReceptor(true);
//			
////			set current player his receptor id
//			arrayOfPlayers.getPlayerByID(id).setIdTarget(number);
//		}
//		
//		boolean noEsElUltimo = false;
//		
//			if(counter!=0)
//				noEsElUltimo = true;
//		
//		if(vinoEnCadena) {
//			System.out.println("vinooooooooo");
//			if(noEsElUltimo) {
//				System.out.println("no ultimooooooooooo");
//				if(arrayOfPlayers.getPlayerByID(id).getIdTarget()==primerJugadorID) {
//					System.out.println("entro al if");
//					do {
//						System.out.println("entro al do while");
//						number = randomNumber(arrayOfPlayers.getSize(), 0);
//						System.out.println(number);
//					}
//					while(number == id || arrayOfPlayers.getPlayerByID(number).isReceptor() || arrayOfPlayers.getPlayerByID(number).getIdTarget()==id || number == primerJugadorID);
//					System.out.println("listo");
//					receptor = arrayOfPlayers.getPlayerByID(number).getName(); 
//					
////			set the player to be shown as receptor
//					arrayOfPlayers.getPlayerByID(number).setReceptor(true);
//					
////			set current player his receptor id
//					arrayOfPlayers.getPlayerByID(id).setIdTarget(number);
//				}
//			}
//		}
//		
//		System.out.println("primer  "+primerJugadorID);
//		System.out.println("anterior  "+idanterior);
//		System.out.println("cadena  "+vinoEnCadena);
//		
//
//		
//		JOptionPane.showMessageDialog(this, receptor);
//		
////		int counter = arrayOfPlayers.getSize();
////		System.out.println("tamaño total: "+counter);
////		System.out.println("ya jugo :"+id);
////		for (int i = 1; i <= arrayOfPlayers.getSize(); i++) {
////			if(arrayOfPlayers.getPlayerByID(i).isTurn())
////				counter--;
////		}
////		
////		dispose();
////		if(counter > 0) {
//		Match gui = new Match(arrayOfPlayers, vinoEnCadena, primerJugadorID, number);
//		gui.setVisible(true);
////		}
////		else
////			dispose();
//		System.out.println("------------------------------------------------------------------");
//		System.out.println("1. "+arrayOfPlayers.getPlayerByID(1).getName()+ " ---> "+arrayOfPlayers.getPlayerByID(1).getIdTarget());
//		System.out.println("2. "+arrayOfPlayers.getPlayerByID(2).getName()+ " ---> "+arrayOfPlayers.getPlayerByID(2).getIdTarget());
//		System.out.println("3. "+arrayOfPlayers.getPlayerByID(3).getName()+ " ---> "+arrayOfPlayers.getPlayerByID(3).getIdTarget());
//		System.out.println("4. "+arrayOfPlayers.getPlayerByID(4).getName()+ " ---> "+arrayOfPlayers.getPlayerByID(4).getIdTarget());
//		System.out.println("5. "+arrayOfPlayers.getPlayerByID(5).getName()+ " ---> "+arrayOfPlayers.getPlayerByID(5).getIdTarget());
//		System.out.println("------------------------------------------------------------------");
	}
	
	private int randomNumber(int maxValue, int minValue) {
		int r=(int)(Math.random()*(minValue-maxValue))+maxValue;
		return r;
	}
	
	
}
