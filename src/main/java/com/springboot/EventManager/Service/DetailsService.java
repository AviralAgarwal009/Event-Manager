package com.springboot.EventManager.Service;

import java.util.List;

import com.springboot.EventManager.entity.Participants;

public interface DetailsService {

	public int saveParticipants(Participants theParticipants);

	public List<Participants> getParticipants();

	public Participants getParticipants(int theId);
}
