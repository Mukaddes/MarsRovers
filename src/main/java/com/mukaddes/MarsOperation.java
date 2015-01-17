package com.mukaddes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Mukaddes Büyükkavut Ertaş
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
		
		//--- Local Variables ---
		
		//
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		// keeps the number of each line from input file
		Integer lineNumber = 1;
	
		String line;
		StringTokenizer st;		
		MarsRover mr = null;

		while ((line = reader.readLine()) != null && !line.equals("")) {

			st = new StringTokenizer(line);
			log4j.debug("Line:" + line);

			// Get plateau info from first line
			if (lineNumber == 1) {
				while (st.hasMoreTokens()) {
					pl = new Plateau();
					pl.setWidth(Integer.parseInt(st.nextToken()));
					log4j.debug("Plateau boundries width:" + pl.getWidth());
					pl.setHeight(Integer.parseInt(st.nextToken()));
					log4j.debug("Plateau boundries height:" + pl.getHeight());
				}

			} 
			// Even lines gives the rovers coordinate and direction info
			else if (lineNumber % 2 == 0) {				
				mr = new MarsRover(pl);
				while (st.hasMoreTokens()) {

					mr.setX(Integer.parseInt(st.nextToken()));
					log4j.debug("position x rover is " + mr.getX());
					mr.setY(Integer.parseInt(st.nextToken()));
					log4j.debug("position y rover is " + mr.getY());
					mr.setDirection(st.nextToken().charAt(0));
					log4j.debug("The direction of rover " + mr.getDirection());

				}
			} 
			// Odd lines gives the moves of the rovers 
			else {
				mr.setMoves(line);
				log4j.info("The moves of rover " + mr.getMoves());
			}
			
			if (lineNumber > 1 && lineNumber % 2 == 1) {
				rovers.add(mr); // add the rover in rovers list
			}

			lineNumber++;
		}
		
		reader.close();
	}
	
	/** 
	 * Print the operation result 
	 */
	public void outputOperation() {
		
		log4j.debug("-----OUTPUT-----");
		String str;

		File file = new File("output.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fileWriter = new FileWriter(file, false);
			BufferedWriter bWriter = new BufferedWriter(fileWriter);
			bWriter.write("-----OUTPUT----- \n");
			for (MarsRover mr : rovers) {
				str = mr.getX() + " " + mr.getY() + " " + mr.getDirection();
				log4j.debug(str);
				bWriter.write(str + "\n");
				
			}
			bWriter.flush();
			bWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**** END ****/
}
