package minesweeper;

import java.util.ArrayList;
import java.util.Scanner;

import pojo.Cell;
import pojo.EmptyGrid;
import pojo.FilledGrid;
import services.CreateEmptyCells;
import services.CreateFilledCells;
import services.GameService;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		EmptyGrid emptyGrid=new EmptyGrid();
		FilledGrid filledGrid=new FilledGrid();
		
		Cell[][] cellsForEmptyGrid=CreateEmptyCells.createCells(emptyGrid);
		emptyGrid.setCells(cellsForEmptyGrid);
		
		Cell[][] cellsForFilledGrid=CreateFilledCells.createCells(filledGrid);
		filledGrid.setCells(cellsForFilledGrid);
		
		Integer xCoordNumber=0;
		Integer yCoordNumber=0;
		
		GameService gameService=new GameService();
		
		gameService.initializeGame(scanner);
		gameService.showGrid(emptyGrid);
		gameService.playGame(filledGrid, emptyGrid, xCoordNumber, yCoordNumber, scanner);				
	
	}

}
