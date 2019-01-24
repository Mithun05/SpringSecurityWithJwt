package com.room.accesser.jwt.examples.room;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * An Entity Model that represents the rooms in an apartment
 * @author deshp
 *
 */
@Entity
public class Room {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roomId;
    private String roomDesc;
    
	public long getRoomId() {
		return roomId;
	}
	
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	
	public String getRoomDesc() {
		return roomDesc;
	}
	
	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}
	
	@Override
	public String toString() {
		return "Room [RoomId = " + roomId + ", RoomDesc = " + roomDesc + "]";
	}
}