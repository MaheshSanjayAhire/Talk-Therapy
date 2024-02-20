package com.talktherapy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talktherapy.model.Appointment;
import com.talktherapy.model.Counsellor;
import com.talktherapy.repository.CounsellorRepository;

@Service
public class CounsellorServiceImp implements CounsellorService {
	@Autowired
	private CounsellorRepository cr;
	@Override
	public Counsellor addCounsellor(Counsellor counsellor) {
		return cr.save(counsellor);
	}

	@Override
	public Counsellor updateCounsellor(Counsellor counsellor) {
		return cr.save(counsellor);
	}

	@Override
	public void deleteCounsellor(long id) {
		cr.deleteById(id);
	}

	@Override
	public Counsellor getCounsellorById(long id) {
		Optional<Counsellor>counsellor=cr.findById(id);
		 if(counsellor.isPresent())
		 {
			 return counsellor.get();
		 }
		 return null;
	}

	@Override
	public List<Counsellor> getAllCounsellors() {
		return cr.findAll();
	}

//	public List<Appointment> getUserByEmail(String email) {
//		List<Appointment> appt=cr.findAllByEmail(email);
//		return appt;
//	}
}
