package pojo;

import java.util.ArrayList;

import services.EmptyCellsGenerator;
import services.FilledCellsGenerator;

public class GameData {
	
	private EmptyGrid emptyGrid;
	private FilledGrid filledGrid;
	private ArrayList<Cell> allCells;
	

	public GameData(EmptyGrid emptyGrid, FilledGrid filledGrid) {
	this.emptyGrid = emptyGrid;
	Cell[][] cellsForEmptyGrid=EmptyCellsGenerator.createCells(this.emptyGrid);
	this.emptyGrid.setCells(cellsForEmptyGrid);
	
	this.filledGrid = filledGrid;
	Cell[][] cellsForFilledGrid=FilledCellsGenerator.createCells(this.filledGrid);
	this.filledGrid.setCells(cellsForFilledGrid);
	
}

	public EmptyGrid getEmptyGrid() {
		return emptyGrid;
	}

	public void setEmptyGrid(EmptyGrid emptyGrid) {
		this.emptyGrid = emptyGrid;
	}

	public FilledGrid getFilledGrid() {
		return filledGrid;
	}

	public void setFilledGrid(FilledGrid filledGrid) {
		this.filledGrid = filledGrid;
	}
	
	public ArrayList<Cell> getAllCells() {
		return this.filledGrid.getAllCells();
	}

	public void setAllCells(ArrayList<Cell> allCells) {
		this.allCells = allCells;
	}

	
	public void setEmptyGridCells() {
		Cell[][] cellsForEmptyGrid=EmptyCellsGenerator.createCells(this.emptyGrid);
		this.emptyGrid.setCells(cellsForEmptyGrid);
	}

	public void setFilledGridCells() {
		Cell[][] cellsForFilledGrid=FilledCellsGenerator.createCells(this.filledGrid);
		this.filledGrid.setCells(cellsForFilledGrid);
//		this.allCells=filledGrid.getAllCells();
	}

}
