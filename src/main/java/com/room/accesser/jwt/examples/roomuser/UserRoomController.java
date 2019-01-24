package com.room.accesser.jwt.examples.roomuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRoomController {

	@Autowired
	UserRoomAccessRepository userRoomAccessRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/sign-up-for-room")
	public void signUp(@RequestBody UserRoom roomUser) {
		roomUser.setUserPassword(bCryptPasswordEncoder.encode(roomUser.getUserPassword()));
		userRoomAccessRepository.save(roomUser);
	}
}
