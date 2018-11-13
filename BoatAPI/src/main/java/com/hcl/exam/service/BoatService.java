package com.hcl.exam.service;

import java.awt.Point;

import org.springframework.stereotype.Service;

import com.hcl.exam.constants.Direction;
import com.hcl.exam.dto.BoatDto;

@Service
public class BoatService {

	public BoatDto getBoatCoordinates(int x, int y, String facing, String movement) {
		BoatDto dto = new BoatDto();
		Point coordinates = new Point(x, y);
		updateCoordinates(coordinates, facing, movement);
		dto.setCoordinates(coordinates);
		return dto;
	}

	private void updateCoordinates(Point coordinates, String facing, String movement) {

		if (Direction.NORTH.getValue().equalsIgnoreCase(facing)) {
			faceNorth(coordinates, movement);
		} else if (Direction.SOUTH.getValue().equalsIgnoreCase(facing)) {
			faceSouth(coordinates, movement);
		} else if (Direction.EAST.getValue().equalsIgnoreCase(facing)) {
			faceEast(coordinates, movement);
		} else if (Direction.WEST.getValue().equalsIgnoreCase(facing)) {
			faceWest(coordinates, movement);
		}

	}

	private void faceNorth(Point coordinates, String movement) {
		for (char c : movement.toCharArray()) {
			if (Direction.RIGHT.getValue().equalsIgnoreCase(String.valueOf(c))) {
				moveForwardX(coordinates);
			} else if (Direction.LEFT.getValue().equalsIgnoreCase(String.valueOf(c))) {
				moveBackwardX(coordinates);
			} else if (Direction.FORWARD.getValue().equalsIgnoreCase(String.valueOf(c))) {
				moveForwardY(coordinates);
			} else if (Direction.BACKWARD.getValue().equalsIgnoreCase(String.valueOf(c))) {
				moveBackwardY(coordinates);
			}
		}
	}

	private void faceEast(Point coordinates, String movement) {
		for (char c : movement.toCharArray()) {
			if (Direction.RIGHT.getValue().equalsIgnoreCase(String.valueOf(c))) {
				moveBackwardY(coordinates);
			} else if (Direction.LEFT.getValue().equalsIgnoreCase(String.valueOf(c))) {
				moveForwardY(coordinates);
			} else if (Direction.FORWARD.getValue().equalsIgnoreCase(String.valueOf(c))) {
				moveForwardX(coordinates);
			} else if (Direction.BACKWARD.getValue().equalsIgnoreCase(String.valueOf(c))) {
				moveBackwardX(coordinates);
			}
		}
	}

	private void faceWest(Point coordinates, String movement) {
		for (char c : movement.toCharArray()) {
			if (Direction.RIGHT.getValue().equalsIgnoreCase(String.valueOf(c))) {
				moveForwardY(coordinates);
			} else if (Direction.LEFT.getValue().equalsIgnoreCase(String.valueOf(c))) {
				moveBackwardY(coordinates);
			} else if (Direction.FORWARD.getValue().equalsIgnoreCase(String.valueOf(c))) {
				moveBackwardX(coordinates);
			} else if (Direction.BACKWARD.getValue().equalsIgnoreCase(String.valueOf(c))) {
				moveForwardX(coordinates);
			}
		}
	}

	private void faceSouth(Point coordinates, String movement) {
		for (char c : movement.toCharArray()) {
			if (Direction.RIGHT.getValue().equalsIgnoreCase(String.valueOf(c))) {
				moveBackwardX(coordinates);
			} else if (Direction.LEFT.getValue().equalsIgnoreCase(String.valueOf(c))) {
				moveForwardX(coordinates);
			} else if (Direction.FORWARD.getValue().equalsIgnoreCase(String.valueOf(c))) {
				moveBackwardY(coordinates);
			} else if (Direction.BACKWARD.getValue().equalsIgnoreCase(String.valueOf(c))) {
				moveForwardY(coordinates);
			}
		}
	}

	private void moveForwardX(Point pt) {
		pt.x = pt.x + 1;
	}

	private void moveForwardY(Point pt) {
		pt.y = pt.y + 1;
	}

	private void moveBackwardX(Point pt) {
		pt.x = pt.x - 1;
	}

	private void moveBackwardY(Point pt) {
		pt.y = pt.y - 1;
	}
}
