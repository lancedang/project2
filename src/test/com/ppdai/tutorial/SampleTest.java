package com.ppdai.tutorial;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ppdai.tutorial.Sample;

public class SampleTest {

	@Test
	public void testEmptySampleConstructor() {
		Sample sample = new Sample();

		assertEquals(0, sample.getValue(), 0.01);
		assertFalse(sample.isValid());
	}

	@Test
	public void testNotEmptySampleConstructor() {
		Sample sample1 = new Sample(10.45);
		Sample sample2 = new Sample(-1000.12345);

		assertEquals(10.45, sample1.getValue(), 0.01);
		assertTrue(sample1.isValid());

		assertEquals(-1000.12345, sample2.getValue(), 0.01);
		assertFalse(sample2.isValid());
	}

	@Test
	public void testIsThan() {
		Sample sample1 = new Sample(10.45);
		Sample sample2 = new Sample(1000.12345);				
		
		
		Sample sample3 = new Sample(10.45);
		Sample sample4 = new Sample(-1000.12345);
		Sample sample5 = new Sample(-1000.12345);
		
		assertTrue(sample3.isLessThan(sample4));
		assertTrue(sample3.isGreaterThan(sample4));
		
		assertFalse(sample4.isLessThan(sample3));
		assertFalse(sample4.isGreaterThan(sample3));
		
		assertTrue(sample5.isGreaterThan(sample4));
		
		assertFalse(sample2.isLessThan(sample1));
		assertFalse(sample1.isGreaterThan(sample2));

		assertTrue(sample1.isLessThan(sample2));
		assertTrue(sample2.isGreaterThan(sample1));
	}

	@Test
	public void testToString() {
		Sample sample1 = new Sample(10.45);
		Sample sample2 = new Sample(-1000.12345);

		assertEquals("10.4500", sample1.toString());
		assertEquals("invalid", sample2.toString());
	}

}
