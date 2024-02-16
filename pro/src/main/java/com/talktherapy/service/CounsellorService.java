package com.talktherapy.service;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.talktherapy.model.Counsellor;

public interface CounsellorService {
		//for creating user
		Counsellor addCounsellor(Counsellor counsellor);
		
		//for updating user
		Counsellor updateCounsellor(Counsellor counsellor);
		
		//for deleting user
		void deleteCounsellor(long counsellorId);
		
		//to find specific user
		Counsellor getCounsellorById(long id);
		
		//list of all users
		List<Counsellor>getAllCounsellors();

}
