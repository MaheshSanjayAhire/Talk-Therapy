package com.talktherapy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talktherapy.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
}
