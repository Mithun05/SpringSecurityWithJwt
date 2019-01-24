package com.room.accesser.jwt.examples.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class acts as a Controller component on the Presentation layer
 * @author deshp
 *
 */

@RestController
@RequestMapping("/rooms")
public class RoomController {

	@Autowired
	RoomRepository roomRepository;
	
	@PostMapping
	public void addRoom(@RequestBody Room room) {
		roomRepository.save(room);
	}
	
	@GetMapping
	public List<Room> getRooms() {
		return roomRepository.findAll();
	}
}
