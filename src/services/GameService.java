package services;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
		int rows = 10;
		int columns = 10;
		String RESET = "\u001B[0m";
        String RED_TEXT = "\u001B[31m";
        String GREEN_TEXT = "\u001B[32m";
        String YELLOW_TEXT = "\u001B[33m";
        String BLACK_BG = "\u001B[40m";
        String WHITE_BG = "\u001B[47m";
        String BRIGHT_BLACK_TEXT="\u001b[30;1m";
        String bRIGHT_BLUE_TEXTString="\u001b[34;1m"; 

		for (int i = 0; i <= rows; i++) {
			if (i == 0) {
				System.out.print(GREEN_TEXT + WHITE_BG+Utils.formatString("  ")+ RESET);
				for (int j = 1; j < columns; j++) {
					System.out.print(BRIGHT_BLACK_TEXT + WHITE_BG+" " + j + "  "+ RESET);
				}
				System.out.println(BRIGHT_BLACK_TEXT + WHITE_BG+" 10  "+ RESET);
				System.out.print(BRIGHT_BLACK_TEXT + WHITE_BG+Utils.formatString("  +")+ RESET);
				for (int j = 1; j < columns; j++) {
					System.out.print(BRIGHT_BLACK_TEXT + WHITE_BG+"---+"+ RESET);
				}
				System.out.println(BRIGHT_BLACK_TEXT + WHITE_BG+"---+ "+ RESET);
			} else {
				System.out.print(BRIGHT_BLACK_TEXT+ WHITE_BG+Utils.formatString(i + " |")+ RESET);
				for (int j = 1; j < columns; j++) {
					System.out.print(GREEN_TEXT + WHITE_BG+" " + grid.getCells()[i - 1][j - 1].getContent() + BRIGHT_BLACK_TEXT+" |"+ RESET);
				}
				System.out.println(GREEN_TEXT + WHITE_BG+" " + grid.getCells()[i - 1][9].getContent() + BRIGHT_BLACK_TEXT+" | "+ RESET);
				System.out.print(BRIGHT_BLACK_TEXT+ WHITE_BG+Utils.formatString("  +")+ RESET);
				for (int j = 1; j < columns; j++) {
					System.out.print(BRIGHT_BLACK_TEXT + WHITE_BG+"---+"+ RESET);
				}
				System.out.println(BRIGHT_BLACK_TEXT + WHITE_BG+"---+ "+ RESET);
			}
		}
	}
	
	public void validateUserInputCordinates(UserInputCoords userInputCoords, Scanner scanner) {
		int xCoordinateInput;
		int yCoordinateInput;
		boolean xDone = false;
		do{
			try{
				System.out.println("please enter the X coordinate: ");
				xCoordinateInput = scanner.nextInt();
				if(xCoordinateInput<=10&&xCoordinateInput>=1) {
					userInputCoords.setxCoordNumber(xCoordinateInput);
					xDone = true;
				}else {
					System.out.println("Coordinate must be integer between 1-10");
				}
			}catch (InputMismatchException e){
				System.out.println("Coordinate must be integer between 1-10");
				scanner.next();
			}
		} while (xDone == false);
		boolean yDone = false;
		do{
			try{
				System.out.println("please enter the Y coordinate: ");
				yCoordinateInput = scanner.nextInt();
				if(yCoordinateInput<=10&&yCoordinateInput>=1) {
					userInputCoords.setyCoordNumber(yCoordinateInput);
					yDone = true;
				}else {
					System.out.println("Coordinate must be integer between 1-10");
				}
			}catch (InputMismatchException e){
				System.out.println("Coordinate must be integer between 1-10");
				scanner.next();
			}
		} while (yDone == false);
	}
	
	public void processUserInput(GameData gameData, UserInputCoords userInputCoords, Scanner scanner) {
		while (gameData.getLeftLengthOfFilledGrid() > 10) {
			validateUserInputCordinates(userInputCoords, scanner);
			String viewContent = gameData.getFilledGrid().getCells()[userInputCoords.getyCoordNumber()
					- 1][userInputCoords.getxCoordNumber() - 1].getContent();
			gameData.getEmptyGrid().getCells()[userInputCoords.getyCoordNumber() - 1][userInputCoords.getxCoordNumber()
					- 1].setContent(viewContent);
			if (viewContent.equals("x")) {
				System.out.println("Game Over!");
				showGrid(gameData.getFilledGrid());
				return;
			}
			int currentXCoordinate = userInputCoords.getxCoordNumber();
			int currentYCoordinate = userInputCoords.getyCoordNumber();
			cascadingNoBombCell(gameData, currentXCoordinate, currentYCoordinate);
			showGrid(gameData.getEmptyGrid());
		}
		System.out.println("Congratulations! You Won!");
		showGrid(gameData.getFilledGrid());
	}

	public void cascadingNoBombCell(GameData gameData, int currentXCoordinate, int currentYCoordinate) {
		String viewContent = gameData.getFilledGrid().getCells()[currentYCoordinate - 1][currentXCoordinate - 1]
				.getContent();
		gameData.getEmptyGrid().getCells()[currentYCoordinate - 1][currentXCoordinate - 1].setContent(viewContent);
		gameData.setLeftLengthOfFilledGrid(gameData.getLeftLengthOfFilledGrid() - 1);
		if ("0".equals(viewContent)) {
			if (currentYCoordinate - 1 >= 0 && currentXCoordinate - 2 >= 0 && " ".equals(
					gameData.getEmptyGrid().getCells()[currentYCoordinate - 1][currentXCoordinate - 2].getContent())) {
				cascadingNoBombCell(gameData, currentXCoordinate - 1, currentYCoordinate);
			}
			if (currentYCoordinate - 2 >= 0 && currentXCoordinate - 2 >= 0 && " ".equals(
					gameData.getEmptyGrid().getCells()[currentYCoordinate - 2][currentXCoordinate - 2].getContent())) {
				cascadingNoBombCell(gameData, currentXCoordinate - 1, currentYCoordinate - 1);
			}
			if (currentYCoordinate - 2 >= 0 && currentXCoordinate - 1 >= 0 && " ".equals(
					gameData.getEmptyGrid().getCells()[currentYCoordinate - 2][currentXCoordinate - 1].getContent())) {
				cascadingNoBombCell(gameData, currentXCoordinate, currentYCoordinate - 1);
			}

			if (currentYCoordinate - 2 >= 0 && currentXCoordinate + 1 <= 10 && " ".equals(
					gameData.getEmptyGrid().getCells()[currentYCoordinate - 2][currentXCoordinate].getContent())) {
				cascadingNoBombCell(gameData, currentXCoordinate + 1, currentYCoordinate - 1);
			}

			if (currentYCoordinate + 1 <= 10 && currentXCoordinate - 2 >= 0 && " ".equals(
					gameData.getEmptyGrid().getCells()[currentYCoordinate][currentXCoordinate - 2].getContent())) {
				cascadingNoBombCell(gameData, currentXCoordinate - 1, currentYCoordinate + 1);
			}

			if (currentYCoordinate + 1 <= 10 && currentXCoordinate - 1 >= 0 && " ".equals(
					gameData.getEmptyGrid().getCells()[currentYCoordinate][currentXCoordinate - 1].getContent())) {
				cascadingNoBombCell(gameData, currentXCoordinate, currentYCoordinate + 1);
			}
			if (currentYCoordinate - 1 >= 0 && currentXCoordinate + 1 <= 10 && " ".equals(
					gameData.getEmptyGrid().getCells()[currentYCoordinate - 1][currentXCoordinate].getContent())) {
				cascadingNoBombCell(gameData, currentXCoordinate + 1, currentYCoordinate);
			}
			if (currentYCoordinate + 1 <= 10 && currentXCoordinate + 1 <= 10 && " "
					.equals(gameData.getEmptyGrid().getCells()[currentYCoordinate][currentXCoordinate].getContent())) {
				cascadingNoBombCell(gameData, currentXCoordinate + 1, currentYCoordinate + 1);
			}

		} else {
			return;
		}

	}

	public void continueGameOrNot(Scanner scanner, ExitGameController exitGameController) {
		System.out.println("Do you want to play another game? Y/N");
		String userChoice = scanner.next().toUpperCase();
		if (userChoice.equals("N")) {
			exitGameController.setIsExitGame(true);
		}
	}

	public void playGame(GameData gameData, UserInputCoords userInputCoords, Scanner scanner,
			ExitGameController exitGameController) {
		initializeGame(scanner);
		while (!exitGameController.getIsExitGame()) {
			gameData.setEmptyGrid(new EmptyGrid());
			gameData.setFilledGrid(new FilledGrid());
			gameData.setEmptyGridCells();
			gameData.setFilledGridCells();
			gameData.setLeftLengthOfFilledGrid(gameData.getEmptyGrid().getXSize() * gameData.getEmptyGrid().getYSize());
			showGrid(gameData.getEmptyGrid());
			processUserInput(gameData, userInputCoords, scanner);
			continueGameOrNot(scanner, exitGameController);
		}
		System.out.println("Thanks for playing!");
		return;
	}

}
