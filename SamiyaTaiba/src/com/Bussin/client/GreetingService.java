package com.Bussin.client;


import com.Bussin.shared.Event;
import com.Bussin.shared.AdminL;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String Login(String s1,String s2)throws IllegalArgumentException;
	Event[] eventdisplay(String s5) throws IllegalArgumentException;
	String Uploa(AdminL lo)throws IllegalArgumentException;
}
