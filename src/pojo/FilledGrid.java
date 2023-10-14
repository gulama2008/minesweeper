package pojo;

import java.util.ArrayList;

import services.GenerateRandomCoordinate;

public class FilledGrid extends Grid{

	private int numberOfBombs=10;
	private ArrayList<String> bombs;
	private ArrayList<Cell> allCells=new ArrayList<Cell>();
//	private Cell[][] cells=new Cell[10][10];
	private Cell[][] cells;
	
	public FilledGrid() {
		super();
//		this.numberOfBombs=10;
		setBombs(10,10,10);
//		setCells();
	}
	
	public FilledGrid(int xSize, int ySize, int numberOfBombs) {
		super(xSize,ySize);
		this.numberOfBombs = numberOfBombs;
		setBombs(xSize,ySize,numberOfBombs);
//		setCells();
	}
	
	
	
	public int getNumberOfBombs() {
		return numberOfBombs;
	}

	public void setNumberOfBombs(int numberOfBombs) {
		this.numberOfBombs = numberOfBombs;
	}

//	public ArrayList<String> generateRandomCoordinate(int xSize,int ySize,int numberOfBombs){
//		
//		String coordinateString;
//		ArrayList<String> coordinateList=new ArrayList<String>();
//		
//		int k=0;
//		while(k<numberOfBombs) {
//			
//			int i= (int) Math.floor(Math.random()*xSize+1);
//			int j=(int) Math.floor(Math.random()*ySize+1);
//			coordinateString=i+"-"+j;
//			if (!coordinateList.contains(coordinateString)) {
//				coordinateList.add(coordinateString);
//				k++;
//			}
//		}
//		return coordinateList;
//	}
	
	public ArrayList<String> getBombs(){
		return this.bombs;
	}
	
	public void setBombs(int xSize, int ySize, int numberOfBombs) {
		this.bombs=GenerateRandomCoordinate.generateRandomCoordinate(xSize, ySize, numberOfBombs);	
	}
	
	public Cell[][] getCells(){
		return this.cells;
	}
	
	public void setCells(Cell[][] cells) {
		this.cells=cells;
	}
	
	
//	public Cell[][] createCells() {
//		Cell[][] cells=new Cell[this.getXSize()][this.getYSize()];
//		for(int i=1;i<=this.getXSize();i++) {
//			for(int j=1;j<=this.getYSize();j++) {
//				Cell cell= new Cell(i,j);
//				if(this.bombs.contains(i+"-"+j)) {
//					cell.setContent("x");
//					cells[i-1][j-1]=cell;
//					allCells.add(cell);
//					continue;
//				}
//				int k=0;
//				if(this.bombs.contains((i-1)+"-"+(j-1))) {
//					k++;
//				}
//				if(this.bombs.contains(i+"-"+(j-1))) {
//					k++;
//				}
//				if(this.bombs.contains((i+1)+"-"+(j-1))) {
//					k++;
//				}
//				if(this.bombs.contains((i-1)+"-"+j)) {
//					k++;
//				}
//				if(this.bombs.contains((i+1)+"-"+j)) {
//					k++;
//				}
//				if(this.bombs.contains((i-1)+"-"+(j+1))) {
//					k++;
//				}
//				if(this.bombs.contains(i+"-"+(j+1))) {
//					k++;
//				}
//				if(this.bombs.contains((i+1)+"-"+(j+1))) {
//					k++;
//				}
//				cell.setContent(k+"");
////				System.out.println(cell);
//				cells[i-1][j-1]=cell;
//				this.allCells.add(cell);
//				
//			}
//		}
//		return cells;
//	}

	public ArrayList<Cell> getAllCells() {
		return this.allCells;
	}

	public void setAllCells(ArrayList<Cell> allCells) {
		this.allCells = allCells;
	}	
	
}
