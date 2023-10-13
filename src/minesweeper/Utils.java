package minesweeper;


public class Utils {
	public static void showGrid(Grid grid) {
		
		for(int i=0;i<=10;i++) {
			
			for(int j=0;j<=10;j++) {
				if(i==0) {
					if (j==0) {
						System.out.print(formatString(" "));
					}else if (j==10) {
						System.out.println(formatString("_10"));
					}else {
						System.out.print(formatString("_"+j+"_"));
					}
					continue;
				}else {
					if(j==0) {
						System.out.print(formatString(i+"|"));
						
					}else if (j==10) {
						System.out.println(formatString(grid.getCells()[i-1][j-1].getContent()));
					}else {
						System.out.print(formatString(grid.getCells()[i-1][j-1].getContent()));
					}
				}
				
				
			}
		}
	}
	
	public static String formatString(String s) {
		return String.format("%3s", s);
	}
	
}

