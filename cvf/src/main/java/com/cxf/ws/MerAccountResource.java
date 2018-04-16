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
	
	public List<Player> getPlayers(@WebParam(name="numbers",targetNamespace = "http://service.server.cxf.webservice.biz.mip.com/") int numbers);
	
	public boolean updatePlayerByNumber(@WebParam int number,@WebParam Player player);
	
	public boolean deletePlayer(@WebParam int number);
	
	public void foo();
}
