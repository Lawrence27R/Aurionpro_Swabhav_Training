package com.aurionpro.behavioural.chainofrespon.model;

public class ManagerLevelSupportHandler implements ISupportHandler {
	
	private ISupportHandler nextHandler;
	
	@Override
	public void setNextHandler(ISupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

	@Override
	public void handleRequest(Request request) {
        if (!request.isHandled() && request.getPriority() == Priority.CRITICAL) {
            System.out.println("Manager Support handled the request.");
            request.setHandled(true);
        }
        
        if (!request.isHandled() && nextHandler == null) {
        	System.out.println("Cannot handel the request");
        }
    }
}
