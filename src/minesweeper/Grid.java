package minesweeper;

import java.util.ArrayList;

public abstract class Grid {
		
	private int xSize=10;
	private int ySize=10;
	
	public Grid() {};
	
	public Grid(int xSize, int ySize) {
		
		this.xSize = xSize;
		this.ySize = ySize;
	}
	
	public int getxSize() {
		return xSize;
	}

	public void setxSize(int xSize) {
		this.xSize = xSize;
	}

	public int getySize() {
		return ySize;
	}

	public void setySize(int ySize) {
		this.ySize = ySize;
	}
	
	public abstract Cell[][] createCells();
	public abstract Cell[][] getCells();
	
	

}
