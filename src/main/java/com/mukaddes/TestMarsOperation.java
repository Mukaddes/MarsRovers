package com.mukaddes;

import org.junit.Test;

public class TestMarsOperation {

	@Test
	public void testOperation() {
		MarsOperation mo = new MarsOperation();
		mo.init();
		mo.startOperation();
		mo.outputOperation();
	}

}
