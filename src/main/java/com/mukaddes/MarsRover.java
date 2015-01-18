package com.mukaddes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class represents a Nasa robotic rover with position, direction and movements info.
 * @author Mukaddes
 *
 */
public class MarsRover implements RoverInterface {
	
	public static final char NORTH = 'N';
	public static final char SOUTH = 'S';
	public static final char EAST  = 'E';
	public static final char WEST  = 'W';
	public static final char RIGTH = 'R';
	public static final char LEFT  = 'L';
	public static final char MOVE  = 'M';

	/** The x position of rover */
	private int x;

	/** The y position of rover */
	private int y;

	/** Facing direction */
	private char direction;

	/** Movements to do*/
	private String moves;

	/** */
	private Plateau pl;

	private static final Logger log4j = LogManager.getLogger("MarsOperation");

	/**
	 * MarsRover Constructor
	 * @param pl The rover will explore this plateau
	 */
	public MarsRover(Plateau pl) {
		this.pl = pl;
	}
	
	/**
	 * Executes specified moves of the rover.
	 * Rover can turn right, turn left and move forward.
	 */
	@Override
	public void move() {
		for (int index = 0; index < moves.length(); index++) {
			Character walk = moves.charAt(index);

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

	}

	private void turnLeft() {

		switch (direction) {
		case NORTH:
			this.direction = WEST;
			break;
		case EAST:
			this.direction = NORTH;
			break;
		case SOUTH:
			this.direction = EAST;
			break;
		case WEST:
			this.direction = SOUTH;
			break;
		}
		log4j.trace("-----Step " + x + " " + y + " " + direction);

	}

	private void turnRight() {
		
		switch (direction) {
		case NORTH:
			this.direction = EAST;
			break;
		case EAST:
			this.direction = SOUTH;
			break;
		case SOUTH:
			this.direction = WEST;
			break;
		case WEST:
			this.direction = NORTH;
			break;
		}
	}

	private void moveForward() {
		
		switch (direction) {
		case NORTH:			
			if ((y+1) <= pl.getHeight()) {
				y += 1;
			}			
			break;
			
		case EAST:			
			if ((x+1) <= pl.getWidth()) {
				x += 1;
			}			
			break;
			
		case SOUTH:			
			if ((y-1) >= 0) {
				y -= 1;
			}			
			break;
			
		case WEST:			
			if ((x-1) >= 0) {
				x -= 1;
			}			
			break;
		}
		
		log4j.trace("-----Step " + x + " " + y + " " + direction);

	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public void setX(int positionX) {
		this.x = positionX;
	}

	public int getY() {
		return y;
	}

	public void setY(int positionY) {
		this.y = positionY;
	}

	public String getMoves() {
		return moves;
	}

	public void setMoves(String moves) {
		this.moves = moves;
	}

}
