package com.junit.expectedExceptions;

import java.util.ArrayList;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class TryCatchFail {
	
	/**
	 * Always remember the fail()!
		If the line you want to test didn’t throw any exception, 
		and you forgot to put the fail(), the test will be passed (false positive).
	 * */
	
	@Test
	public void testDivisionWithException() {
		try {
			int i = 1 / 0;
			fail();
		} catch (ArithmeticException e) {
			assertThat(e.getMessage(), is("/ by zero"));
		}
	}

	@Test
	public void testEmptyList() {
		try {
			new ArrayList<>().get(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertThat(e.getMessage(), is("Index: 0, Size: 0"));
		}
	}
}
