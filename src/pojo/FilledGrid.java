package pojo;

import java.util.ArrayList;

import services.GenerateRandomCoordinate;

public class FilledGrid extends Grid {

	private int numberOfBombs = 10;
	private ArrayList<String> bombs;
	private ArrayList<Cell> allCells = new ArrayList<Cell>();
	private Cell[][] cells;

	public FilledGrid() {
		super();
		setBombs(10, 10, 10);
	}

	public FilledGrid(int xSize, int ySize, int numberOfBombs) {
		super(xSize, ySize);
		this.numberOfBombs = numberOfBombs;
		setBombs(xSize, ySize, numberOfBombs);
	}

	public int getNumberOfBombs() {
		return numberOfBombs;
	}

	public void setNumberOfBombs(int numberOfBombs) {
		this.numberOfBombs = numberOfBombs;
	}

	public ArrayList<String> getBombs() {
		return this.bombs;
	}

	public void setBombs(int xSize, int ySize, int numberOfBombs) {
		this.bombs = GenerateRandomCoordinate.generateRandomCoordinate(xSize, ySize, numberOfBombs);
	}

	public Cell[][] getCells() {
		return this.cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

	public ArrayList<Cell> getAllCells() {
		return this.allCells;
	}

	public void setAllCells(ArrayList<Cell> allCells) {
		this.allCells = allCells;
	}

}
