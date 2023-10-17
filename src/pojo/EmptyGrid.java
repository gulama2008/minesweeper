package pojo;

import java.util.ArrayList;

public class EmptyGrid extends Grid {

	private ArrayList<Cell> allCells = new ArrayList<Cell>();;
	private Cell[][] cells;

	// constructor for default 10x10 empty grid
	public EmptyGrid() {
		super();
	}

	// constructor for customized size empty grid
	public EmptyGrid(int xSize, int ySize) {
		super(xSize, ySize);
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

	public ArrayList<Cell> getAllCells() {
		return allCells;
	}

	public void setAllCells(ArrayList<Cell> allCells) {
		this.allCells = allCells;
	}

}
