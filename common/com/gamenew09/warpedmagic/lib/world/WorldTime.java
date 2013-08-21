package com.gamenew09.warpedmagic.lib.world;

public enum WorldTime {
	
	Day(0),
	Midday(1),
	Night(2);
	
	private int id;
	
	private static WorldTime[] reg = new WorldTime[256];
	
	WorldTime(int id){
		this.id = id;
		register();
	}
	
	private void register(){
		reg[id] = this;
	}
	
	public WorldTime getWorldTimeById(int i){
		return reg[i];
	}
	
}
