package pojo;

import java.util.ArrayList;

public class EmptyGrid extends Grid{
	
//	private Cell[][] cells=new Cell[10][10];
	
	private ArrayList<Cell> allCells=new ArrayList<Cell>();;
	private Cell[][] cells;
	
	//constructor for default 10x10 empty grid
	public EmptyGrid() {
		super();
//		setCells();
	}
	
	//constructor for customized size empty grid
	public EmptyGrid(int xSize, int ySize) {
		super(xSize,ySize);
//		setCells(cells);
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
	
//	public void setCells() {
//		this.cells=createCells();
//	}
//
//	@Override
//	public Cell[][] createCells() {
//		Cell[][] cells=new Cell[this.getXSize()][this.getYSize()];
//		for(int i=1;i<=this.getXSize();i++) {
//			for(int j=1;j<=this.getYSize();j++) {
//				Cell cell= new Cell(i,j);
//				cell.setContent("__|");
//				cells[i-1][j-1]=cell;
//			}	
//		}
//		return cells;
//	}
	
}
