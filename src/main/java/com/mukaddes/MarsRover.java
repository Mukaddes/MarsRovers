package com.mukaddes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MarsRover implements RoverInterface {

	private int positionX;

	private int positionY;

	private char direction;

	private String moves;

	private Plateau pl;

	private static final Logger log4j = LogManager.getLogger("MarsOperation");

	public MarsRover(Plateau pl) {
		this.pl = pl;
	}

	@Override
	public void move() {
		for (int index = 0; index < moves.length(); index++) {
			Character walk = moves.charAt(index);

			switch (walk) {
			case 'L':
				turnLeft();
				break;
			case 'R':
				turnRight();
				break;
			case 'M':
				goAhead();
				break;

			default:
				break;
			}
		}

	}

	private void turnLeft() {

		if (direction == 'N')
			direction ='W';
		else if (direction == 'E')
			direction = 'N';
		else if (direction == 'S')
			direction = 'E';
		else if (direction == 'W')
			direction = 'S';
		log4j.trace("-----Step " + positionX + " " + positionY + " " + direction);

	}

	private void turnRight() {
		if (direction == 'N')
			direction = 'E';
		else if (direction == 'E')
			direction = 'S';
		else if (direction == 'S')
			direction = 'W';
		else if (direction == 'W')
			direction = 'N';
	}

	private void goAhead() {
		if (direction == 'N' && pl.getHeight() >= positionY + 1)
			positionY= (positionY + 1);
		else if (direction == 'E' && pl.getWidth() >= positionX + 1)
			positionX =(positionX + 1);
		else if (direction == 'S' && positionY - 1 >= 0)
			positionY = (positionY - 1);
		else if (direction == 'W' && positionX - 1 >= 0)
			positionX = (positionX - 1);
		log4j.trace("-----Step " + positionX + " " + positionY + " " + direction);

	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public String getMoves() {
		return moves;
	}

	public void setMoves(String moves) {
		this.moves = moves;
	}

}
