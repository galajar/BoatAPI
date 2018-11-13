/**
 * 
 */
package com.hcl.exam.constants;

/**
 * @author Alajar
 *
 */
public enum Direction {

	NORTH("N"), EAST("E"), WEST("W"), SOUTH("S"), FORWARD("F"), BACKWARD("B"), LEFT("L"), RIGHT("R");

	private String value;

	private Direction(String c) {
		value = c;
	}

	public String getValue() {
		return value;
	}
}
