package com.springboot.EventManager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.EventManager.DAO.DetailsDAO;
import com.springboot.EventManager.entity.Participants;

@Service
public class DetailsImpl implements DetailsService {

	DetailsDAO detailsDao;

	@Autowired
	public DetailsImpl(DetailsDAO thedetailsDao) {
		detailsDao = thedetailsDao;
	}

	@Override
	public void saveParticipants(Participants theParticipants) {
		detailsDao.saveParticipants(theParticipants);
	}

}
