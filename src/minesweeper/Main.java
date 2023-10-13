package minesweeper;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.printf("-----------------------------------------%n");
		System.out.printf("******** Welcome to Minesweeper! ********%n");
		System.out.printf("***** Press Enter to start the game *****%n");
		System.out.printf("-----------------------------------------%n");

		
		Scanner scanner=new Scanner(System.in);
//		System.out.println("Press 1 for playing 10x10 or press 2 to customize game");
//		int input=scanner.nextInt();
		if (scanner.hasNextLine()) {
			  scanner.nextLine();
		}

		EmptyGrid emptyGrid=new EmptyGrid();
		FilledGrid filledGrid=new FilledGrid();
		int xCoordNumber;
		int yCoordNumber;
		Utils.showGrid(emptyGrid);
		System.out.println();
		
		ArrayList<Cell> allCells=filledGrid.getAllCells();
		int leftLengthOfFilledGrid=allCells.size();
		
		while (leftLengthOfFilledGrid>10) {
			System.out.println("please enter the x coordinate: ");
			xCoordNumber=scanner.nextInt();
			while (xCoordNumber>10) {
				System.out.println("x coordinate must be between 1-10, please re-enter");
				xCoordNumber=scanner.nextInt();
			}
			
			System.out.println("please enter the y coordinate: ");
			yCoordNumber=scanner.nextInt();
			while (yCoordNumber>10) {
				System.out.println("y coordinate must be between 1-10, please re-enter");
				yCoordNumber=scanner.nextInt();
			}
			String viewContent =filledGrid.getCells()[yCoordNumber-1][xCoordNumber-1].getContent();
			emptyGrid.getCells()[yCoordNumber-1][xCoordNumber-1].setContent("_"+viewContent+"|");
			if(viewContent.equals("x")) {
				System.out.println("Game Over!");
				Utils.showGrid(filledGrid);
				return;
			}
			Utils.showGrid(emptyGrid);
			leftLengthOfFilledGrid-=1;
		}
		System.out.println("Congratulations! You Won!");
		Utils.showGrid(filledGrid);
			
	}

}
