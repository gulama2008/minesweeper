package services;

import pojo.Cell;
import pojo.FilledGrid;

public class FilledCellsGenerator {
	
	public static Cell[][] createCells(FilledGrid filledGrid) {
		Cell[][] cells=new Cell[filledGrid.getXSize()][filledGrid.getYSize()];
		for(int i=1;i<=filledGrid.getXSize();i++) {
			for(int j=1;j<=filledGrid.getYSize();j++) {
				Cell cell= new Cell(i,j);
				if(filledGrid.getBombs().contains(i+"-"+j)) {
					cell.setContent("_x|");
					cells[i-1][j-1]=cell;
					filledGrid.getAllCells().add(cell);
					continue;
				}
				int k=0;
				if(filledGrid.getBombs().contains((i-1)+"-"+(j-1))) {
					k++;
				}
				if(filledGrid.getBombs().contains(i+"-"+(j-1))) {
					k++;
				}
				if(filledGrid.getBombs().contains((i+1)+"-"+(j-1))) {
					k++;
				}
				if(filledGrid.getBombs().contains((i-1)+"-"+j)) {
					k++;
				}
				if(filledGrid.getBombs().contains((i+1)+"-"+j)) {
					k++;
				}
				if(filledGrid.getBombs().contains((i-1)+"-"+(j+1))) {
					k++;
				}
				if(filledGrid.getBombs().contains(i+"-"+(j+1))) {
					k++;
				}
				if(filledGrid.getBombs().contains((i+1)+"-"+(j+1))) {
					k++;
				}
				cell.setContent("_"+k+"|");
//				System.out.println(cell);
				cells[i-1][j-1]=cell;
				filledGrid.getAllCells().add(cell);
				
			}
		}
		return cells;
	}


}
