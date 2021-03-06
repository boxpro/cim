 
package com.farsunset.cim.handler;

import org.apache.log4j.Logger;

import com.farsunset.cim.server.constant.CIMConstant;
import com.farsunset.cim.server.handler.CIMRequestHandler;
import com.farsunset.cim.server.mutual.ReplyBody;
import com.farsunset.cim.server.mutual.SentBody;
import com.farsunset.cim.server.session.CIMSession;
import com.farsunset.cim.server.session.DefaultSessionManager;
import com.farsunset.cim.util.ContextHolder;

/**
 * 断开连接，清除session
 * 
 * @author
 */
public class SessionClosedHandler implements CIMRequestHandler {

	protected final Logger logger = Logger.getLogger(SessionClosedHandler.class);

	public ReplyBody process(CIMSession ios, SentBody message) {

		DefaultSessionManager sessionManager  =  ((DefaultSessionManager) ContextHolder.getBean("defaultSessionManager"));

		if(ios.getTag(CIMConstant.SESSION_KEY)==null)
		{
			return null;
		}
		
	    String account = ios.getTag(CIMConstant.SESSION_KEY).toString();
	    sessionManager.removeSession(account);
	    
		return null;
	}
	
 
	
}