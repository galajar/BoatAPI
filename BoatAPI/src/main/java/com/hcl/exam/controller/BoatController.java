/**
 * 
 */
package com.hcl.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.exam.dto.BoatDto;
import com.hcl.exam.service.BoatService;

/**
 * @author Alajar
 *
 */
@RestController
public class BoatController {

	@Autowired
	BoatService boatService;

	@RequestMapping(value = "getBoatCoordinates/{x}/{y}/{facing}/{movement}", method = RequestMethod.GET)
	public BoatDto getDto(@PathVariable int x, @PathVariable int y, @PathVariable String facing,
			@PathVariable String movement) {

		return boatService.getBoatCoordinates(x, y, facing, movement);
	}
}
