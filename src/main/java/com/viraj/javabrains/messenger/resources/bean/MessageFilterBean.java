package com.viraj.javabrains.messenger.resources.bean;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {

	private @QueryParam("year") int year;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size;
	
	public final int getYear() {
		return year;
	}
	
	public final void setYear(int year) {
		this.year = year;
	}
	
	public final int getStart() {
		return start;
	}
	
	public final void setStart(int start) {
		this.start = start;
	}
	
	public final int getSize() {
		return size;
	}
	
	public final void setSize(int size) {
		this.size = size;
	}
	
	
}
