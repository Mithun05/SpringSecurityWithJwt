package com.room.accesser.jwt.examples.roomuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class RoomUserServiceImpl implements UserDetailsService {
	
	@Autowired
    private UserRoomAccessRepository userRoomAccessRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRoom roomUser = userRoomAccessRepository.findByUserName(username);
        if (roomUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(roomUser.getUserName(), roomUser.getUserPassword(), emptyList());
    }
}
