package com.springboot.EventManager.DAO;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import com.springboot.EventManager.entity.Participants;

public class DetailsDAOImpl implements DetailsDAO {

	private EntityManager entityManager;

	public DetailsDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public void saveParticipants(Participants theParticipants) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.save(theParticipants);

	}
}
