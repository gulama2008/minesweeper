package services;

import java.util.ArrayList;

import pojo.FilledGrid;

public class GenerateRandomCoordinate {

	public static ArrayList<String> generateRandomCoordinate(int xSize, int ySize, int numberOfBombs) {

		String coordinateString;
		ArrayList<String> coordinateList = new ArrayList<String>();

		int k = 0;
		while (k < numberOfBombs) {
			int i = (int) Math.floor(Math.random() * xSize + 1);
			int j = (int) Math.floor(Math.random() * ySize + 1);
			coordinateString = i + "-" + j;
			if (!coordinateList.contains(coordinateString)) {
				coordinateList.add(coordinateString);
				k++;
			}
		}
		return coordinateList;
	}

}
