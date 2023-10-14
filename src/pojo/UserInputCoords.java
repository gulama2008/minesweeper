package pojo;

public class UserInputCoords {
	

	public UserInputCoords(int xCoordNumber, int yCoordNumber) {
		super();
		this.xCoordNumber = xCoordNumber;
		this.yCoordNumber = yCoordNumber;
	}

	int xCoordNumber;
	
	int yCoordNumber;

	public int getxCoordNumber() {
		return xCoordNumber;
	}
	
	public void setxCoordNumber(int xCoordNumber) {
		this.xCoordNumber = xCoordNumber;
	}
	
	public int getyCoordNumber() {
		return yCoordNumber;
	}
	
	public void setyCoordNumber(int yCoordNumber) {
		this.yCoordNumber = yCoordNumber;
	}
	
	@Override
	public String toString() {
		return "UserInputCoords [xCoordNumber=" + xCoordNumber + ", yCoordNumber=" + yCoordNumber + "]";
	}

}
