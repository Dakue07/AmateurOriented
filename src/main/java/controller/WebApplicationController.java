package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commands.AbstractCommand;
import commands.CommandFactory;
import context.RequestContext;
import context.ResponseContext;
import context.WebRequestContext;
import context.WebResponseContext;

public class WebApplicationController implements ApplicationController {
	
	public RequestContext getRequest(Object request) {
		RequestContext reqc = new WebRequestContext();
		
		reqc.setRequest(request);
		
		return reqc;
	}
	
	public ResponseContext handleRequest(RequestContext req) {
		AbstractCommand command = CommandFactory.getCommand(req);
		command.init(req);
		
		ResponseContext resc = command.execute(new WebResponseContext());
		return resc;
	}
	
	public void handleResponse(RequestContext reqc, ResponseContext resc) {
		HttpServletRequest req = (HttpServletRequest) reqc.getRequest();
		HttpServletResponse res = (HttpServletResponse) resc.getResponse();
		
		req.setAttribute("data", resc.getResult());
		req.getRequestDispatcher(resc.getTarget()).forward(req, res);

	}

}