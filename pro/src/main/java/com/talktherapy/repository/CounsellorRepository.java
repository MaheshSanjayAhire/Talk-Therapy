package com.talktherapy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.talktherapy.model.Counsellor;

@Repository
public interface CounsellorRepository extends JpaRepository<Counsellor,Long> {

}
