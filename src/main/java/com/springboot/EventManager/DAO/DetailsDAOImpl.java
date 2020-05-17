package com.springboot.EventManager.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.EventManager.entity.Participants;



@Repository
public class DetailsDAOImpl implements DetailsDAO {

	@Autowired
	private EntityManager entityManager;


	@Override
	public void saveParticipants(Participants theParticipants) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.save(theParticipants);

	}

	@Override
	public boolean check(int random) {
		
		Session session=entityManager.unwrap(Session.class);		
		Query<Participants> q=session.createQuery("from Participants where id=:s",Participants.class);
		q.setParameter("s", random);
		List<Participants> l=q.getResultList();
		if(l.isEmpty()) {
			return false;
		}
		return true;
	}
}
