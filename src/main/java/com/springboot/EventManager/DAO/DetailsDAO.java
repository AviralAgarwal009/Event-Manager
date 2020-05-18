
package com.springboot.EventManager.DAO;

import java.util.List;

import com.springboot.EventManager.entity.Participants;

public interface DetailsDAO {
	public void saveParticipants(Participants theParticipants);

	public boolean check(int random);

	public List<Participants> getParticipants();
	
	public Participants getParticipants(int theId);
}