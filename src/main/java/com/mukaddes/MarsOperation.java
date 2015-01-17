package com.mukaddes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Mukaddes Büyükkavut Ertaşs
 *
 */
public class MarsOperation {
	
	/***** BEGIN ****/
	// Data Fields
	
	/** Keep the MarsRovers*/
	private List<MarsRover> rovers;

	/** The input file name */
	private String filename = "input.txt";
	
	/** Keep the plateau */
	private Plateau pl;

	/**Logger*/
	private static final Logger log4j = LogManager
			.getLogger("MarsOperation");

	/**
	 * Initializing the required variables
	 */
	public void init() {
		rovers = new ArrayList<MarsRover>();

		try {
			inputReader();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * Starts the Mars Operation
	 */
	public void startOperation() {
		for (MarsRover mr : rovers) {
			mr.move();
		}
	}

	/**
	 * Reads the input file and fills the plateau list
	 * 
	 * @throws IOException
	 *             if an I/O error occurs
	 * */
	public void inputReader() throws IOException {
		// Keeps the file
		File file = new File(filename);

		if (!file.exists()) {
			log4j.error("File not exist!");
		}
		
		//--- Local Variables 
		
		//
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		// keeps the number of each line from input file
		Integer lineNumber = 1;
		
		// line keeper
		String line;
		
		// Divide string token
		StringTokenizer st;
		
		MarsRover mr = null;

		while ((line = reader.readLine()) != null && !line.equals("")) {

			st = new StringTokenizer(line);
			log4j.error("Line:" + line);

			if (lineNumber == 1) {
				while (st.hasMoreTokens()) {
					pl = new Plateau();
					pl.setWidth(Integer.parseInt(st.nextToken()));
					log4j.debug("Plateau boundries width:" + pl.getWidth());
					pl.setHeight(Integer.parseInt(st.nextToken()));
					log4j.debug("Plateau boundries height:" + pl.getHeight());
				}

			} else if (lineNumber % 2 == 0) {
				// if lineCount is even it is coordinate of rover
				mr = new MarsRover(pl);
				while (st.hasMoreTokens()) {

					mr.setPositionX(Integer.parseInt(st.nextToken()));
					log4j.debug("position x rover is " + mr.getPositionX());
					mr.setPositionY(Integer.parseInt(st.nextToken()));
					log4j.debug("position y rover is " + mr.getPositionY());
					mr.setDirection(st.nextToken().charAt(0));
					log4j.debug("The direction of rover " + mr.getDirection());

				}
			} else {
				// if lineCount is odd it is movements of rover
				mr.setMoves(line);
				log4j.error("The moves of rover " + mr.getMoves());

			}

			if (lineNumber > 1 && lineNumber % 2 == 1) {
				rovers.add(mr);
			}

			lineNumber++;
		}
		
		reader.close();
	}
	/** Prepare the operation output */
	public void outputOperation() {

		log4j.debug("-----OUTPUT-----");
		log4j.debug("rovers length " + rovers.size());

		for (MarsRover mr : rovers) {
			log4j.debug(mr.getPositionX() + " " + mr.getPositionY() + " "
					+ mr.getDirection());
		}

	}

	/**** END ****/
}
