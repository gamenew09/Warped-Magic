package com.gamenew09.warpedmagic.lib;

public class Box {
	
	private Position3 p1, p2, p3, p4;
	
	public Box(Position3 pos1, Position3 pos2, Position3 pos3, Position3 pos4){
		p1 = pos1;
		p2 = pos2;
		p3 = pos3;
		p4 = pos4;
	}
	
	public Position3 getP1() {
		return p1;
	}

	public void setP1(Position3 p1) {
		this.p1 = p1;
	}

	public Position3 getP2() {
		return p2;
	}

	public void setP2(Position3 p2) {
		this.p2 = p2;
	}

	public Position3 getP3() {
		return p3;
	}

	public void setP3(Position3 p3) {
		this.p3 = p3;
	}

	public Position3 getP4() {
		return p4;
	}

	public void setP4(Position3 p4) {
		this.p4 = p4;
	}

	public int[][] getPositionArray(){
		int[][] posGrid = new int[3][];
		for(int x = 0; x < 3;x++){
			switch(x){
				case 0:
					posGrid[x] = p1.getPosGrid();
				case 1:
					posGrid[x] = p2.getPosGrid();
				case 2:
					posGrid[x] = p3.getPosGrid();
				case 3:
					posGrid[x] = p4.getPosGrid();
			}
		}
		return posGrid;
	}
	
	public String toString() {
		return "Box(" + p1.toString() + ", " + p2.toString() + ", " + p3.toString() + ", " + p4.toString() + ")";
	}
	
	
}
