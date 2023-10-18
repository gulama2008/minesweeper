package services;

public class Utils {
	
	public static final String RESET = "\u001B[0m";
	public static final String RED_TEXT = "\u001B[31m";
	public static final String GREEN_TEXT = "\u001B[32m";
	public static final String YELLOW_TEXT = "\u001B[33m";
	public static final String BLACK_BG = "\u001B[40m";
	public static final String WHITE_BG = "\u001B[47m";
	public static final String BRIGHT_BLACK_TEXT="\u001b[30;1m";
	public static final String BRIGHT_BLUE_TEXT="\u001b[34;1m"; 
	public static final String BRIGHT_GREEN_TEXT="\u001b[32;1m";
	public static final String BRIGHT_RED_TEXT="\u001b[31;1m";
	public static final String GRAY_TEXT="\u001b[38;5;242m";
    public static final String RED_BG="\u001b[41m";
    public static final String BRIGHT_YELLOW_TEXT="\u001b[33;1m";


	public static String formatString(String s) {
		return String.format("%5s", s);
	}
	
	public static String coloredString(String s,boolean isWin) {
		String coloredString="";
		if(isWin) {
			if("x".equals(s)) {
				coloredString=BRIGHT_YELLOW_TEXT+"x";
				return coloredString;
			}
		}else {
			if("x".equals(s)) {
				coloredString=RED_BG+BRIGHT_BLACK_TEXT+"x";
				return coloredString;
			}
		}
		switch (s) {
		case "0":{
			coloredString=GRAY_TEXT+"0";
			
			break;
		}
		case "1": {
			coloredString=BRIGHT_BLUE_TEXT+"1";
			break;
			
		}
		case "2":{
			coloredString=BRIGHT_GREEN_TEXT+"2";
			break;
		}
		default:
			coloredString=RED_TEXT+s;
		}
		return coloredString;
	}

}
