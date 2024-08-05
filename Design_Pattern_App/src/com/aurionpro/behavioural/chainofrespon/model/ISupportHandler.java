package com.aurionpro.behavioural.chainofrespon.model;

public interface ISupportHandler {
	void setNextHandler(ISupportHandler nextHandler);
	void handleRequest(Request request);
}
