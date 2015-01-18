package com.mukaddes;

import org.junit.Test;

/**
 * This class contains test routines for testing MArsOperation class.
 * @author Mukaddes
 *
 */
public class TestMarsOperation {

	@Test
	public void testOperation() {
		MarsOperation mo = new MarsOperation();
		mo.init();
		mo.startOperation();
		mo.outputOperation();
	}

}
