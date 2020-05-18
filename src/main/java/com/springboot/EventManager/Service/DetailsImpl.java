package com.springboot.EventManager.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.EventManager.DAO.DetailsDAO;
import com.springboot.EventManager.Model.RegTypeCount;
import com.springboot.EventManager.entity.Participants;

@Service
public class DetailsImpl implements DetailsService {

	@Autowired
	DetailsDAO detailsDao;

	@Override
	@Transactional
	public int saveParticipants(Participants theParticipants) {
		int random;
		while (true) {
			random = generateRandom();
			boolean c = detailsDao.check(random);// return true in exists
			if (!c) {
				System.out.println("Success");
				break;
			}

		}
		
		SimpleDateFormat formatter = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		theParticipants.setDateTime(formatter.format(date));
		theParticipants.setId(random);

		detailsDao.saveParticipants(theParticipants);

		return random;
	}

	public int generateRandom() {

		Random rand = new Random();
		int n = rand.nextInt(10000000) + 10000000;
		return n;
	}

	@Override
	public List<Participants> getParticipants() {

		return detailsDao.getParticipants();
	}

	@Override
	public Participants getParticipants(int theId) {

		return detailsDao.getParticipants(theId);
	}

	@Override
	public RegTypeCount getCount() {
		
		List<Participants> participants=detailsDao.getParticipants();
		
		RegTypeCount reg=new RegTypeCount();
		for(Participants p:participants) {
			
			
			if(p.getRegType().equalsIgnoreCase("self")) {
				reg.setSelf(reg.getSelf()+1);
			}
			
			if(p.getRegType().equalsIgnoreCase("corporate")) {
				reg.setCorporate(reg.getCorporate()+1);
			}
			
			if(p.getRegType().equalsIgnoreCase("others")) {
				reg.setOthers(reg.getOthers()+1);
			}
			
			if(p.getRegType().equalsIgnoreCase("group")) {
				reg.setGroup(reg.getGroup()+1);
			}
			
		}
		
		return reg;
	}

}