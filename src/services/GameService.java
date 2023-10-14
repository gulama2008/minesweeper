package services;

import java.util.ArrayList;
import java.util.Scanner;

import pojo.Cell;
import pojo.EmptyGrid;
import pojo.FilledGrid;
import pojo.Grid;

public class GameService {
	
	public void initializeGame(Scanner scanner) {
		System.out.printf("-----------------------------------------%n");
		System.out.printf("******** Welcome to Minesweeper! ********%n");
		System.out.printf("***** Press Enter to start the game *****%n");
		System.out.printf("-----------------------------------------%n");
		if (scanner.hasNextLine()) {
			  scanner.nextLine();
		}
	}
	
		
	public void showGrid(Grid grid) {	
		for(int i=0;i<=10;i++) {
			for(int j=0;j<=10;j++) {
				if(i==0) {
					if (j==0) {
						System.out.print(Utils.formatString(" "));
					}else if (j==10) {
						System.out.println(Utils.formatString("_10"));
					}else {
						System.out.print(Utils.formatString("_"+j+"_"));
					}
					continue;
				}else {
					if(j==0) {
						System.out.print(Utils.formatString(i+"|"));
					}else if (j==10) {
						System.out.println(Utils.formatString(grid.getCells()[i-1][j-1].getContent()));
					}else {
						System.out.print(Utils.formatString(grid.getCells()[i-1][j-1].getContent()));
					}
				}
			}
		}
		System.out.println();
	}
	
//	public void handleInvalidInput(int coordinate,Scanner scanner) {
//		while (coordinate>10) {
//			System.out.println("Coordinate must be between 1-10, please re-enter");
//			coordinate=scanner.nextInt();
//		}
//	}
	
	public void handleUserInputXCordinate(int coordNumber,Scanner scanner,String direction) {
		System.out.println("please enter the "+direction+" coordinate: ");
		coordNumber=scanner.nextInt();
		while (coordNumber>10) {
			System.out.println("Coordinate must be between 1-10, please re-enter");
			coordNumber=scanner.nextInt();
		}
		System.out.println(coordNumber);
	}

	public void playGame(FilledGrid filledGrid,EmptyGrid emptyGrid, int xCoordNumber,int yCoordNumber,Scanner scanner) {
			ArrayList<Cell> allCells=filledGrid.getAllCells();
			int leftLengthOfFilledGrid=allCells.size();
			while (leftLengthOfFilledGrid>10) {
//				System.out.println("please enter the x coordinate: ");
//				xCoordNumber=scanner.nextInt();
				handleUserInputXCordinate(xCoordNumber, scanner, "x");
//				System.out.println("please enter the y coordinate: ");
//				yCoordNumber=scanner.nextInt();
				handleUserInputXCordinate(yCoordNumber, scanner, "y");
				System.out.println(xCoordNumber);
				System.out.println(yCoordNumber);
				String viewContent =filledGrid.getCells()[yCoordNumber-1][xCoordNumber-1].getContent();
				emptyGrid.getCells()[yCoordNumber-1][xCoordNumber-1].setContent("_"+viewContent+"|");
				if(viewContent.equals("x")) {
					System.out.println("GameService Over!");
					showGrid(filledGrid);
					return;
				}
				showGrid(emptyGrid);
				leftLengthOfFilledGrid-=1;
			}
			System.out.println("Congratulations! You Won!");
			showGrid(filledGrid);	
		}

}
