# Minesweeper

This is a simplified version of the game Minesweeper to be played in the java console. The game is able to randomly generate 10 mines in a 10x10 grid. The user is able to enter a command that represents a coordinate to check a location for a mine. The application will display a number from 0-8 depending on how many mines surround that location. If the user selects a mine, the game will be lost. If every non-mine square has been revealed, the game is won. Discovering an empty square will reveal all squares around it, and cascade into other nearby empty squares.

## Table of Contents

- [Snippets](#snippets)
- [Purpose](#purpose-of-project)
- [Tech Stack](#tech-stack)
- [Requirements](#requirements)
    - [MVP](#mvp)
    - [Bonus](#bonus)
- [Features](#features)
- [Known Issues](#known-issues)
- [Future Goals](#future-goals)

## Snippets
  
![grid](./src/image/2.jpg)
![cascading](./src/image/6.jpg)

## Purpose Of Project
This project is designed to reinforce my Java learnings
With this project I will practice how to:
- Design classes
- Apply OOP paradigm to code 

## Tech Stack

- Java

## Requirements

### MVP
- Recreate a simplified version of the game Minesweeper to be played in the java console
- The game should be able to randomly generate 10 mines in a 10x10 grid, the user will be able to enter a command that represents a coordinate to check a location for a mine
- The application will display a number from 0-8 depending on how many mines surround that location
- If the user selects a mine, the game will respond "boom!" and the game will be lost If every non-mine square has been revealed, the game is won 
- Render the grid to the console after every user command

### Bonus  
- Discovering an empty square should reveal all squares around it, and cascade into other nearby empty squares

## Features

- There is a welcome banner when user first enter the game, and asked user to press enter to start the game:  
![start](./src/image/1.jpg)
- After user enter the game, a 10x10 grid will be shown, and the user will be asked to enter the X and Y coordinate of the cell they want to choose:  
![grid](./src/image/2.jpg)
- The coordinate only allow integers between 1 and 10, so if the user entered an invalid coordinate, such as a string, a float or any integer not within the range, there will be hint of invalid enter in red colour and will ask the user to re-enter:  
![invalid](./src/image/3.jpg)

- If the coordinates are valid, and if it is not a mine, that particular cell will be revealed with the number of mines surrounding it:  
![valid](./src/image/4.jpg)
- And if it is a mine, that cell will be revealed with a X and all the other cells will also be revealed, with all the mines highlighted with red colour, the game then is over:  
![mine](./src/image/5.jpg)

- If the user chooses a cell which has no mine around it (has number 0 on it), all the 8 cells surrounding it will be revealed, and cascade into other nearby empty cells:  
![cascading](./src/image/6.jpg)
- When all the non-mine cells have been revealed, the game is won and there will be a congratulation message shown:  
![win](./src/image/7.jpg)
- After the game won or lost, the user will be asked if they want to play another game by enter Y or N, if they enter Y or y, there will be a new game shown; If they enter N or n, there will be a thanks for playing message shown; and if they enter anything else other than y or n, there will be a message hightlighted in red indicate that they can enter y or n only and re-asked if they want to play another game:  
![finish](./src/image/8.jpg)
- The code is desinged and structured by it's nature of pojo or business logic

## Known Issues  
- Repeating of codes. for instance, the validations of coodinate of X and Y entered by the user are quite similar, perhaps need to write one method and reuse it by passing x and y as params
- Some methods are not optimized enough, for example, the method of generating filled grid is quite big since each of the 8 surrounding cells of one cell has a if statement to check if it is a mine or not, same as the cascading method, there might be some simpler ways to achieve the same result

## Future Goals
- Simplify and optimize some methods mentioned in the Known Issues section
- Allow for the user to customize number of mines and grid size via entering numbers in the command
- Create a UI for the game
