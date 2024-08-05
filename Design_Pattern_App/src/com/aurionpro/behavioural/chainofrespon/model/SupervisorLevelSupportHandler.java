package com.aurionpro.behavioural.chainofrespon.model;

public class SupervisorLevelSupportHandler implements ISupportHandler {
	
	private ISupportHandler nextHandler;
	
	@Override
	public void setNextHandler(ISupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

	@Override
	public void handleRequest(Request request) {
        if (!request.isHandled() && request.getPriority() == Priority.INTERMEDIATE) {
            System.out.println("Supervisor Support handled the request.");
            request.setHandled(true);
        }
        
        if (!request.isHandled() && nextHandler != null) {
        	nextHandler.handleRequest(request);
        }
    }
}
