package com.example.demo.model;

public class Alien {
	private int aid;
	private String aname;
	
	public int getAid() {
		return aid;
	}
	public String getAname() {
		return aname;
		
	}
	public void setAid() {
		this.aid=aid;
	}
	public void setAname() {
		this.aname=aname;
	}
	@Override
	public String toString() {
		return  "ALien";
	}
}
