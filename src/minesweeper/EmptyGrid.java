package minesweeper;

import java.util.ArrayList;

public class EmptyGrid extends Grid{
	
	private Cell[][] cells=new Cell[10][10];
	private ArrayList<Cell> allCells=new ArrayList<Cell>();;
	
	public EmptyGrid() {
		super();
		setCells();
	}
	
	public EmptyGrid(int xSize, int ySize) {
		super(xSize,ySize);
		setCells();
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
	
	public void setCells() {
		this.cells=createCells();
	}

	@Override
	public Cell[][] createCells() {
		Cell[][] cells=new Cell[this.getxSize()][this.getySize()];
		for(int i=1;i<=this.getxSize();i++) {
			for(int j=1;j<=this.getySize();j++) {
				Cell cell= new Cell(i,j);
				cell.setContent("__|");
				cells[i-1][j-1]=cell;
			}	
		}
		return cells;
	}
	
}
