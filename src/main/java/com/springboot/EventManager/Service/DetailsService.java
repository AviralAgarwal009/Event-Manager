package com.springboot.EventManager.Service;

import java.util.List;

import com.springboot.EventManager.entity.Participants;
import com.springboot.EventManager.model.RegTypeCount;

public interface DetailsService {

	public int saveParticipants(Participants theParticipants);

	public List<Participants> getParticipants();

	public Participants getParticipants(int theId);
	
	public RegTypeCount getCount();
	
	public boolean check(int random);
}
