package com.ppdai.tutorial;

/**
 * 
 * @author CS2334. Modified by: ?????
 *         <P>
 *         Date: 2016-09-10 <BR>
 *         Project 1
 *         <P>
 *         This class represents individual, real-valued samples. This class
 *         explicitly addresses the fact that some samples are invalid.
 *
 */

public class Sample {
	/** The observed value. */
	private double value;

	/** Indicates whether the observation is a valid one */
	private boolean valid;

	// TODO: complete the implementation
	public Sample() {
		// TODO Auto-generated constructor stub
	}

	public Sample(double value) {
		super();
		this.value = value;
		if (value > -900) {
			this.valid = true;
		} else {
			this.valid = false;
		}
	}

	public double getValue() {
		return value;
	}

	public boolean isValid() {
		return valid;
	}

	/**
	 * judge current sample is less than param sample
	 * 
	 * @param s
	 *            destination sample object
	 * @return
	 */
	public boolean isLessThan(Sample s) {
		if (!this.valid && !s.valid) {
			return true;
		} else if (!this.valid) {
			return false;
		} else if (this.valid && !s.valid) {
			return true;
		} else if (this.value < s.value) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * judge current sample is greater than param sample
	 * 
	 * @param s
	 *            destination sample object
	 * @return
	 */
	public boolean isGreaterThan(Sample s) {

		if (!this.valid && !s.valid) {
			return true;
		} else if (!this.valid) {
			return false;
		} else if (this.valid && !s.valid) {
			return true;
		} else if (this.value > s.value) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = String.format("%.4f", this.value);
		return this.valid ? result : "invalid";
	}

}
