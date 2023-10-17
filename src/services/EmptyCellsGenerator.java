package services;

import pojo.Cell;
import pojo.EmptyGrid;

public class EmptyCellsGenerator {
	
	public static Cell[][] createCells(EmptyGrid emptyGrid) {
		Cell[][] cells=new Cell[emptyGrid.getXSize()][emptyGrid.getYSize()];
		for(int i=1;i<=emptyGrid.getXSize();i++) {
			for(int j=1;j<=emptyGrid.getYSize();j++) {
				Cell cell= new Cell(i,j);
				cell.setContent(" ");
				cells[i-1][j-1]=cell;
			}	
		}
		return cells;
	}

}
