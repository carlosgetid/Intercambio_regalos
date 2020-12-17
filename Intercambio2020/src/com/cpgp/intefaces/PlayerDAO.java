package com.cpgp.intefaces;

import com.cpgp.entities.Player;

public interface PlayerDAO {
	public void insertPlayer(Player player);
	public void deletePlayer(int id);	
}
