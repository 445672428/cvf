package com.cxf.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.cxf.ws.model.Player;

/**
 * 
 *
 */
@WebService
public interface MerAccountResource 
{	
	@WebResult public List<Player> getTeam();
	
	public String getPlayers(@WebParam(name="numbers") Integer numbers);
	
	public boolean updatePlayerByNumber(@WebParam int number,@WebParam Player player);
	
	public boolean deletePlayer(@WebParam int number);
	
	public void foo();
}
