package com.room.accesser.jwt.examples.roomuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRoomAccessRepository")
public interface UserRoomAccessRepository extends JpaRepository<UserRoom, Long> {
		UserRoom findByUserName(String userName);
}
