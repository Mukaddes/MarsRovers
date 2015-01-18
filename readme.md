# Mars Operation 
A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, 
must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send 
back to Earth. 

A rover's position and location is represented by a combination of x and y co-ordinates and a letter representing one of 
the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might 
be 0, 0, N, which means the rover is in the bottom left corner and facing North. 

In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' 
makes the rover spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward
one grid point, and maintain the same heading. 

Assume that the square directly North from (x, y) is (x, y+1). 

## Class Diagram
-![alt text](http://i.imgur.com/B6O93pN.png README.md URL")

## Implemantation

The Mars Operation program has two main class, MarsOperation and MarsRover. The general flow of the program is as shown below.

### MarsOperation

Basic operation is performed in the class.  It starts the operation and ends the operation. 
Firstly it initializes the instant variable rovers and also fills it indirectly. 

```java
public void init() {
		rovers = new ArrayList<MarsRover>();
		try {
			inputReader();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
```
The inputReader() method reads the "input.txt" line by line, and fills this information in rovers array ."input.txt" file should be in main directory.The inputReader() skeleton is as shown below.
```java
public void inputReader() throws IOException {
	// Keeps the file
	File file = new File(filename);
 	// Keeps the number of each line from input file
	Integer lineNumber = 1;
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
	
	// Reads the input file line by line
	while ((line = reader.readLine()) != null && !line.equals("")) {

		// Get plateau info from first line
		if (lineNumber == 1) {
    ...
		} 
		// Even lines gives the rovers coordinate and direction info
		else if (lineNumber % 2 == 0) {				
		...
		} 
		// Odd lines gives the moves of the rovers 
		else {
    ...
		}
		if (lineNumber > 1 && lineNumber % 2 == 1) {
			rovers.add(mr); // add the rover in rovers list
		}
		lineNumber++;
	}
	reader.close();
}
```
startOperation() method gives the order to move by using rovers.
```java
for (MarsRover mr : rovers) {
			mr.move();
		}
```
Finally outputOperation() writes the results an "output.txt" file which is written in the desired format. It also prints the results on console.

### MarsRover

MarsRover describes a rover. A rover should have its coordination on plateau, facing directory, movements and should recognize the plateau to explore.This class responsibles for checking its own movement.
There are three commands which provides the movements, turn left , turn right and move forward.I want to talk about how this class ensure the move.

```java
switch (walk) {
		case LEFT:
			turnLeft();
			break;
		case RIGTH:
			turnRight();
			break;
		case MOVE:
			moveForward(); 
			break;

		default:
			// Invalid move
			break;
		}
	}
```
Results of the task printed on console using log4j console appander

## Missing Features
* spring framework but Spring Tool Suite is used
* Unit, Integrity and Functional test


