package com.cxf.ws;

import javax.jws.WebService;

@WebService(endpointInterface="com.cxf.ws.TestCxf",name="TestCxfImp")
public class TestCxfImp implements TestCxf{

	@Override
	public void say() {
		
	}

}
