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
	
		
//	public void showGrid(Grid grid) {	
//		for(int i=0;i<=10;i++) {
//			for(int j=0;j<=10;j++) {
//				if(i==0) {
//					if (j==0) {
//						System.out.print(Utils.formatString(" "));
//					}else if (j==10) {
//						System.out.println(Utils.formatString("_10"));
//					}else {
//						System.out.print(Utils.formatString("_"+j+"_"));
//					}
//					continue;
//				}else {
//					if(j==0) {
//						System.out.print(Utils.formatString(i+"|"));
//					}else if (j==10) {
//						if (" ".equals(grid.getCells()[i-1][j-1].getContent())) {
//							System.out.println(Utils.formatString("__|"));
//							
//						}else {
//							System.out.println(Utils.formatString("_"+grid.getCells()[i-1][j-1].getContent()+"|"));
//						}
//						
//					}else {
//						if (" ".equals(grid.getCells()[i-1][j-1].getContent())) {
//							System.out.print(Utils.formatString("__|"));
//							
//						}else {
//							System.out.print(Utils.formatString("_"+grid.getCells()[i-1][j-1].getContent()+"|"));
//						}
//					}
//				}
//			}
//		}
//		System.out.println();
//	}
	
	public void showGrid(Grid grid) {	
		int rows = 10;
        int columns = 10;

        for (int i = 0; i <= rows; i++) {
        	if(i==0) {
        		System.out.print(Utils.formatString("  "));
        		for(int j=1;j<10;j++) {
        			System.out.print(" "+j+"  ");
        		}
        		System.out.println(" 10 ");
        		System.out.print(Utils.formatString("  +"));
        		for(int j=1;j<10;j++) {
        			System.out.print("---+");
        		}
        		System.out.println("---+");
        	}else {
        		System.out.print(Utils.formatString(i+" |"));
        		for(int j=1;j<10;j++) {
        			System.out.print(" "+grid.getCells()[i-1][j-1].getContent()+" |");
        		}
        		System.out.println(" "+grid.getCells()[i-1][9].getContent()+" |");
        		System.out.print(Utils.formatString("  +"));
        		for(int j=1;j<10;j++) {
        			System.out.print("---+");
        		}
        		System.out.println("---+");
        	}
        	
           
        }
        
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
//		int leftLengthOfFilledGrid=gameData.getFilledGrid().getXSize()*gameData.getFilledGrid().getYSize();
		while (gameData.getLeftLengthOfFilledGrid()>10) {
			validateUserInputCordinates(userInputCoords, scanner);
			String viewContent =gameData.getFilledGrid().getCells()[userInputCoords.getyCoordNumber()-1][userInputCoords.getxCoordNumber()-1].getContent();
			gameData.getEmptyGrid().getCells()[userInputCoords.getyCoordNumber()-1][userInputCoords.getxCoordNumber()-1].setContent(viewContent);
			if(viewContent.equals("x")) {
				System.out.println("Game Over!");
				showGrid(gameData.getFilledGrid());
				return;
			}
//				showGrid(gameData.getEmptyGrid());
//				gameData.setLeftLengthOfFilledGrid(gameData.getLeftLengthOfFilledGrid()-1);
			int currentXCoordinate=userInputCoords.getxCoordNumber();
			int currentYCoordinate=userInputCoords.getyCoordNumber();
			cascadingNoBombCell(gameData, currentXCoordinate,currentYCoordinate);
			showGrid(gameData.getEmptyGrid());
		}
		System.out.println("Congratulations! You Won!");
		showGrid(gameData.getFilledGrid());
	}
	
//	public void cascadingNoBombCell(GameData gameData, UserInputCoords userInputCoords) {
	public void cascadingNoBombCell(GameData gameData, int currentXCoordinate,int currentYCoordinate) {	
		String viewContent =gameData.getFilledGrid().getCells()[currentYCoordinate-1][currentXCoordinate-1].getContent();
		gameData.getEmptyGrid().getCells()[currentYCoordinate-1][currentXCoordinate-1].setContent(viewContent);
		gameData.setLeftLengthOfFilledGrid(gameData.getLeftLengthOfFilledGrid()-1);
//		if(viewContent.equals("x")) {
//			System.out.println("Game Over!");
//			showGrid(gameData.getFilledGrid());
//			return;
//		}
		
		if("0".equals(viewContent)) {
//			gameData.setLeftLengthOfFilledGrid(gameData.getLeftLengthOfFilledGrid()-1);
				if(currentYCoordinate-1>=0&&currentXCoordinate-2>=0&&" ".equals(gameData.getEmptyGrid().getCells()[currentYCoordinate-1][currentXCoordinate-2].getContent()) ) {
					cascadingNoBombCell(gameData, currentXCoordinate-1, currentYCoordinate);
				}
				if(currentYCoordinate-2>=0&&currentXCoordinate-2>=0&&" ".equals(gameData.getEmptyGrid().getCells()[currentYCoordinate-2][currentXCoordinate-2].getContent()) ) {
					cascadingNoBombCell(gameData, currentXCoordinate-1, currentYCoordinate-1);
				}
				if(currentYCoordinate-2>=0&&currentXCoordinate-1>=0&&" ".equals(gameData.getEmptyGrid().getCells()[currentYCoordinate-2][currentXCoordinate-1].getContent()) ) {
					cascadingNoBombCell(gameData, currentXCoordinate, currentYCoordinate-1);
				}
			
				if(currentYCoordinate-2>=0&&currentXCoordinate+1<=10&&" ".equals(gameData.getEmptyGrid().getCells()[currentYCoordinate-2][currentXCoordinate].getContent()) ) {
					cascadingNoBombCell(gameData, currentXCoordinate+1, currentYCoordinate-1);
				}
			
				if(currentYCoordinate+1<=10&&currentXCoordinate-2>=0&&" ".equals(gameData.getEmptyGrid().getCells()[currentYCoordinate][currentXCoordinate-2].getContent()) ) {
					cascadingNoBombCell(gameData, currentXCoordinate-1, currentYCoordinate+1);
				}
			
				if(currentYCoordinate+1<=10&&currentXCoordinate-1>=0&&" ".equals(gameData.getEmptyGrid().getCells()[currentYCoordinate][currentXCoordinate-1].getContent()) ) {
					cascadingNoBombCell(gameData, currentXCoordinate, currentYCoordinate+1);
				}
				if(currentYCoordinate-1>=0&&currentXCoordinate+1<=10&&" ".equals(gameData.getEmptyGrid().getCells()[currentYCoordinate-1][currentXCoordinate].getContent()) ) {
					cascadingNoBombCell(gameData, currentXCoordinate+1, currentYCoordinate);
				}
				if(currentYCoordinate+1<=10&&currentXCoordinate+1<=10&&" ".equals(gameData.getEmptyGrid().getCells()[currentYCoordinate][currentXCoordinate].getContent()) ) {
					cascadingNoBombCell(gameData, currentXCoordinate+1, currentYCoordinate+1);	
				}		

		}else {
//			gameData.setLeftLengthOfFilledGrid(gameData.getLeftLengthOfFilledGrid()-1);
			return;
			
		}
		
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
			gameData.setLeftLengthOfFilledGrid(gameData.getEmptyGrid().getXSize()*gameData.getEmptyGrid().getYSize());
			showGrid(gameData.getEmptyGrid());
			processUserInput(gameData, userInputCoords, scanner);
			continueGameOrNot(scanner, exitGameController);		
		}
		System.out.println("Thanks for playing!");
		return;
	}
			

}
