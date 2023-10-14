package minesweeper;

import java.util.ArrayList;
import java.util.Scanner;

import pojo.Cell;
import pojo.EmptyGrid;
import pojo.FilledGrid;
import pojo.UserInputCoords;
import services.EmptyCellsGenerator;
import services.FilledCellsGenerator;
import services.GameService;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		EmptyGrid emptyGrid=new EmptyGrid();
		FilledGrid filledGrid=new FilledGrid();
		
		Cell[][] cellsForEmptyGrid=EmptyCellsGenerator.createCells(emptyGrid);
		emptyGrid.setCells(cellsForEmptyGrid);
		
		Cell[][] cellsForFilledGrid=FilledCellsGenerator.createCells(filledGrid);
		filledGrid.setCells(cellsForFilledGrid);
		
		UserInputCoords userInputCoords=new UserInputCoords(0, 0);
		
		GameService gameService=new GameService();
		
		gameService.initializeGame(scanner);
		gameService.showGrid(emptyGrid);
		gameService.playGame(filledGrid, emptyGrid, userInputCoords, scanner);				
	
	}

}
