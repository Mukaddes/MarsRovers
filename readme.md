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

The Mars Operation program has two main class, MarsOperation and MarsRover.

### MarsOperation

This class starts the operation and ends the operation. 

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

This the inputReader skeleton
```java
public void inputReader() throws IOException {
	// Keeps the file
	File file = new File(filename);
 	// keeps the number of each line from input file
	Integer lineNumber = 1;
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

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
startOperation() method starts the movement by using rovers.
```java
for (MarsRover mr : rovers) {
			mr.move();
		}
```
### MarsRover

## Test

