package minesweeper;
import java.util.Scanner;
import pojo.EmptyGrid;
import pojo.ExitGameController;
import pojo.FilledGrid;
import pojo.GameData;
import pojo.UserInputCoords;
import services.GameService;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		GameData gameData = new GameData(new EmptyGrid(), new FilledGrid());

		UserInputCoords userInputCoords = new UserInputCoords(0, 0);

		GameService gameService = new GameService();

		ExitGameController exitGameController = new ExitGameController(false);

		gameService.playGame(gameData, userInputCoords, scanner, exitGameController);
	}

}
