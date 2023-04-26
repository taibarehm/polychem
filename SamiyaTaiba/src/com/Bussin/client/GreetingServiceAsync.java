package com.Bussin.client;



import com.Bussin.shared.AdminL;
import com.Bussin.shared.Event;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	
	void Login(String s1, String s2, AsyncCallback<String> callback)throws IllegalArgumentException;
	void eventdisplay(String s5,AsyncCallback<Event[]> asyncCallback)throws IllegalArgumentException;
	void Uploa(AdminL lo, AsyncCallback<String> asyncCallback) throws IllegalArgumentException;
	

}