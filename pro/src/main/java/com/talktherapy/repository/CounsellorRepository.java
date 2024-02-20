package com.talktherapy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.talktherapy.model.Appointment;
import com.talktherapy.model.Counsellor;

@Repository
public interface CounsellorRepository extends JpaRepository<Counsellor,Long> {
	
	Counsellor findByEmail(String email);

//	@Query("select * from counsellor c leftjoin appointment a where c.fullname=a.counsellor")
//	List<Appointment> findAllByEmail(String email);
}
