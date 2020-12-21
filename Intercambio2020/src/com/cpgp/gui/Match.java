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
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Match extends JFrame {

	private JPanel contentPane;
	private int id;
	private int[] receptores;
	private int[] turnos;
	private ArrayOfPlayers arrayOfPlayers;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Match frame = new Match(null, null, null, 0);
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
	public Match(ArrayOfPlayers arrayOfPlayers, int[] turnos, int[] receptores, int id) {
		this.receptores = receptores;
		this.arrayOfPlayers = arrayOfPlayers;
		this.turnos = turnos;
		this.id = id;
		
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
		
		System.out.println("esto traje turnos : "+Arrays.toString(turnos));
		System.out.println("esto traje receptores : "+Arrays.toString(receptores));
		
		String name = arrayOfPlayers.getPlayerByID(turnos[id]).getName();
		
		lblNewLabel.setText(name);
//		arrayOfPlayers.getPlayerByID(1).setTurn(true);

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
		String name = arrayOfPlayers.getPlayerByID(receptores[id]).getName();

		JOptionPane.showMessageDialog(this, name);
		id++;
		dispose();
		if(id<arrayOfPlayers.getSize()) {
			Match gui = new Match(arrayOfPlayers, turnos, receptores, id);
			gui.setVisible(true);			
		}
		
	}
	
	
	
}
