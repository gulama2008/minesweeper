package pojo;

public class ExitGameController {

	private boolean isExitGame = false;

	public ExitGameController(boolean isExitGame) {
		super();
		this.isExitGame = isExitGame;
	}

	public boolean getIsExitGame() {
		return isExitGame;
	}

	public void setIsExitGame(boolean isExitGame) {
		this.isExitGame = isExitGame;
	}

}
