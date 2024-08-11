package com.aurionpro.model;

public class Cell {
	private MarkType mark;

	public Cell(MarkType mark) {
		super();
		this.mark = mark;
	}
	
	
	public MarkType getMark() {
		return mark;
	}


	public void setMark(MarkType mark) {
		this.mark = mark;
	}


	public boolean isCellEmpty() {
		return mark == MarkType.EMPTY;
	}
	
	
}
