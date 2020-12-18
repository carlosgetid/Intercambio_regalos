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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Match frame = new Match(null);
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
	public Match(ArrayOfPlayers arrayOfPlayers) {
		this.arrayOfPlayers = arrayOfPlayers;
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
		do {
			id = randomNumber(arrayOfPlayers.getSize(), 0);
		}while(arrayOfPlayers.getPlayerByID(id).isTurn());
		
		
		lblNewLabel.setText(arrayOfPlayers.getPlayerByID(id).getName());
		arrayOfPlayers.getPlayerByID(id).setTurn(true);
		
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
	}
	protected void actionPerformedBtnEmpezar(ActionEvent e) {
		String target = "";

		int number;
		do {
			number = randomNumber(arrayOfPlayers.getSize(), 0);
		}
		while(number == id || arrayOfPlayers.getPlayerByID(number).isReceptor() || arrayOfPlayers.getPlayerByID(number).getIdTarget()==id);
		
		target = arrayOfPlayers.getPlayerByID(number).getName(); 
		
//		set the player to be shown as receptor
		arrayOfPlayers.getPlayerByID(number).setReceptor(true);
		
//		set current player his receptor id
		arrayOfPlayers.getPlayerByID(id).setIdTarget(number);
		
		JOptionPane.showMessageDialog(this, target);
		dispose();
		
		Match gui = new Match(arrayOfPlayers);
		gui.setVisible(true);
	}
	
	private int randomNumber(int maxValue, int minValue) {
		int r=(int)(Math.random()*(minValue-maxValue))+maxValue;
		return r;
	}
}
