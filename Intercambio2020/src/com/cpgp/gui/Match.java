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
import javax.swing.SwingConstants;
import java.awt.Color;

public class Match extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5218405165854727866L;
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
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEsElTurno = new JLabel("Es el turno de:");
		lblEsElTurno.setForeground(Color.WHITE);
		lblEsElTurno.setBounds(12, 62, 648, 15);
		lblEsElTurno.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblEsElTurno);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 80));
		lblNewLabel.setBounds(12, 124, 648, 116);
		
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
		btnEmpezar.setBackground(new Color(255, 215, 0));
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEmpezar(e);
			}
		});
		btnEmpezar.setBounds(278, 344, 117, 25);
		contentPane.add(btnEmpezar);
		
		JLabel lblRealizarSorteo = new JLabel("Realizar sorteo");
		lblRealizarSorteo.setForeground(Color.WHITE);
		lblRealizarSorteo.setBounds(12, 301, 648, 15);
		lblRealizarSorteo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblRealizarSorteo);
		System.out.println("entro");
	}
	protected void actionPerformedBtnEmpezar(ActionEvent e) {
		String name = arrayOfPlayers.getPlayerByID(receptores[id]).getName();
		JOptionPane.showMessageDialog(this, name, "Te ha tocado con : ", JOptionPane.INFORMATION_MESSAGE);
		
		id++;
		dispose();
		if(id<arrayOfPlayers.getSize()) {
			Match gui = new Match(arrayOfPlayers, turnos, receptores, id);
			gui.setVisible(true);			
		}
		
	}
	
	
	
}
