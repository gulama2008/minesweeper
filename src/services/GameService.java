package services;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.StreamHandler;

import pojo.Cell;
import pojo.EmptyGrid;
import pojo.ExitGameController;
import pojo.FilledGrid;
import pojo.GameData;
import pojo.Grid;
import pojo.UserInputCoords;

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
	
	
	public void validateUserInputCordinates(UserInputCoords userInputCoords,Scanner scanner) {
		System.out.println("please enter the X coordinate: ");
		userInputCoords.setxCoordNumber(scanner.nextInt());
		while (userInputCoords.getxCoordNumber()>10) {
			System.out.println("Coordinate must be between 1-10, please re-enter");
			userInputCoords.setxCoordNumber(scanner.nextInt());
		}
		System.out.println("please enter the Y coordinate: ");
		userInputCoords.setyCoordNumber(scanner.nextInt());
		while (userInputCoords.getyCoordNumber()>10) {
			System.out.println("Coordinate must be between 1-10, please re-enter");
			userInputCoords.setyCoordNumber(scanner.nextInt());
		}
	}
	

	public void processUserInput(GameData gameData,UserInputCoords userInputCoords,Scanner scanner) {
		int leftLengthOfFilledGrid=gameData.getFilledGrid().getXSize()*gameData.getFilledGrid().getYSize();
		while (leftLengthOfFilledGrid>10) {
			validateUserInputCordinates(userInputCoords, scanner);
			String viewContent =gameData.getFilledGrid().getCells()[userInputCoords.getyCoordNumber()-1][userInputCoords.getxCoordNumber()-1].getContent();
			gameData.getEmptyGrid().getCells()[userInputCoords.getyCoordNumber()-1][userInputCoords.getxCoordNumber()-1].setContent("_"+viewContent+"|");
			if(viewContent.equals("x")) {
				System.out.println("Game Over!");
				showGrid(gameData.getFilledGrid());
				return;
			}
				showGrid(gameData.getEmptyGrid());
				leftLengthOfFilledGrid-=1;
		}
		System.out.println("Congratulations! You Won!");
		showGrid(gameData.getFilledGrid());
	}
	
	public void continueGameOrNot(Scanner scanner, ExitGameController exitGameController) {
		System.out.println("Do you want to play another game? Y/N");
		String userChoice=scanner.next().toUpperCase();
		if(userChoice.equals("N")){
			exitGameController.setIsExitGame(true);
		};	
	}
	
	
	public void playGame(GameData gameData, UserInputCoords userInputCoords,Scanner scanner,ExitGameController exitGameController) {
		initializeGame(scanner);		
		while (!exitGameController.getIsExitGame()) {
			gameData.setEmptyGrid(new EmptyGrid());
			gameData.setFilledGrid(new FilledGrid());
			gameData.setEmptyGridCells();
			gameData.setFilledGridCells();
			showGrid(gameData.getEmptyGrid());
			processUserInput(gameData, userInputCoords, scanner);
			continueGameOrNot(scanner, exitGameController);		
		}
		System.out.println("Thanks for playing!");
		return;
	}
			

}
