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
			  String s = scanner.nextLine();
		}

		EmptyGrid emptyGrid=new EmptyGrid();
		FilledGrid filledGrid=new FilledGrid();
		int x;
		int y;
		Utils.showGrid(emptyGrid);
		System.out.println();
		
		ArrayList<Cell> allCells=filledGrid.getAllCells();
		int leftLengthOfFilledGrid=allCells.size();
		
		while (leftLengthOfFilledGrid>10) {
			System.out.println("please enter the x coordinate: ");
			x=scanner.nextInt();
			while (x>10) {
				System.out.println("x coordinate has to be between 1-10, please re-enter");
				x=scanner.nextInt();
			}
			
			System.out.println("please enter the y coordinate: ");
			y=scanner.nextInt();
			while (y>10) {
				System.out.println("y coordinate has to be between 1-10, please re-enter");
				y=scanner.nextInt();
			}
			String viewContent =filledGrid.getCells()[y-1][x-1].getContent();
			emptyGrid.getCells()[y-1][x-1].setContent("_"+viewContent+"|");
			if(viewContent=="x") {
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
