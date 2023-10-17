package pojo;

public abstract class Grid {

	private int xSize = 10;

	private int ySize = 10;

	public Grid() {
	};

	public Grid(int xSize, int ySize) {

		this.xSize = xSize;
		this.ySize = ySize;
	}

	public int getXSize() {
		return xSize;
	}

	public void setXSize(int xSize) {
		this.xSize = xSize;
	}

	public int getYSize() {
		return ySize;
	}

	public void setYSize(int ySize) {
		this.ySize = ySize;
	}

	public abstract Cell[][] getCells();

}
