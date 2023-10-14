package pojo;


public class Cell {
	
	private int xCoordinate;
	private int yCoordinate;
	private String content;
	
	public Cell(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public int getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	@Override
	public String toString() {
		return "Cell [xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + ", content=" + content + "]";
	}
	
	
	

}
