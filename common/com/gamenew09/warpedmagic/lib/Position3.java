package com.gamenew09.warpedmagic.lib;

public class Position3 {
	
	private int x, y, z;
	
	public Position3(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int[] getPosGrid(){
		int[] i = new int[3];
		i[0] = x;
		i[1] = y;
		i[2] = z;
		return i;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public String toString() {
		return "Position3 [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
}
