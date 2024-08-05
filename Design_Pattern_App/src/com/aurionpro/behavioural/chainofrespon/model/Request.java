package com.aurionpro.behavioural.chainofrespon.model;

public class Request {
    private Priority priority;
    private boolean handled;

    public Request(Priority priority) {
        this.priority = priority;
        this.handled = false;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isHandled() {
        return handled;
    }

    public void setHandled(boolean handled) {
        this.handled = handled;
    }
}
