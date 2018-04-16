package com.cxf.ws;


import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.log4j.Logger;

import com.cxf.ws.model.Player;
@WebService(endpointInterface="com.cxf.ws.MerAccountResource",name="MerAccountResource",targetNamespace="http://services.web.txx.cn.com/")
public class MerAccountResourceImpl implements MerAccountResource 
{
	
	private static final Logger logger = Logger.getLogger(MerAccountResourceImpl.class);
	 
	private List<Player> team = null;	
	
	@Resource
    WebServiceContext wsContext;

	public MerAccountResourceImpl() 
	{        
	    team = new LinkedList<Player>();
	    team.add(new Player(1, "David De Gea", 22));
	    team.add(new Player(2, "Rafael", 22));
	    team.add(new Player(3, "Patrice Evra", 31));
	    team.add(new Player(4, "Phil Jones", 21));
	    team.add(new Player(5, "Rio Ferdinand", 34));
	    team.add(new Player(7, "Antonio Valencia", 27));
	    team.add(new Player(8, "Anderson", 24));
	    team.add(new Player(10, "Wayne Rooney", 27));	    
	}
	
	public List<Player> getTeam() 
	{
		logger.info("team requested");
		
		MessageContext ctx = wsContext.getMessageContext();  
        HttpServletRequest request = (HttpServletRequest)ctx.get(AbstractHTTPDestination.HTTP_REQUEST); 
        
        System.out.println(request.getRemoteAddr());
        
        Message message = PhaseInterceptorChain.getCurrentMessage();  
        HttpServletRequest httprequest = (HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);  
        System.out.println(httprequest.getRemoteAddr());
        
		return team;
	}

	


	
	public boolean updatePlayerByNumber(int number, Player player)
	{
		logger.info("updating player " + number);

		Player playerOld = findById(number);
		boolean result = false;
		if (playerOld != null)
		{
			playerOld.setAge(player.getAge());
			playerOld.setNumber(player.getNumber());
			playerOld.setName(player.getName());
			result = true;
		}
		else
		{
			logger.warn("player " + number + " not found");
		}
		return result;

	}

	
	public boolean deletePlayer(int number) 
	{
		logger.info("deleting player " + number);

		Player player = findById(number);
		boolean result = false;
		
		if (player != null)
		{
			team.remove(player);
			result = true;
		}
		else
		{
			logger.warn("player " + number + " not found");
		}
		return result;
	}

	
	public void foo() 
	{
		logger.info("Hello world!!!");
	}
	
	private Player findById(int number)
	{
		Player player = null;
		boolean found = false;
		ListIterator<Player> listIterator = team.listIterator();
		
		while (listIterator.hasNext() && !found)
		{
			player = listIterator.next();
			if (player.getNumber() == number)
			{
				found = true;
			}
		}
		if (!found)
		{
			player = null;
		}
		
		return player;
	}

	@Override
	public List<Player> getPlayers(int numbers) 
	{
		List<Player> result = new LinkedList<Player>();
		
//		if (numbers != null)
//		{
//			Player player = null;
//			for (int i =0; i< numbers.length;i++)
//			{
//				player = findById(numbers[i]);
//				if (player != null)
//				{
//					result.add(player);
//				}
//			}
//		}
		logger.info("returning " + result.size() + " players");
		
		return result;
	}

}
