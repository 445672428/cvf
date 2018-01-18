package com.cxf.ws;

import java.util.List;

import javax.jws.WebService;

import com.cxf.ws.model.Player;

/**
 * 
 *
 */
//@WebService
public interface MerAccountResource 
{	
	List<Player> getTeam();
	
	List<Player> getPlayers(int... numbers);
	
	boolean updatePlayerByNumber(int number, Player player);
	
	boolean deletePlayer(int number);
	
	void foo();
}
