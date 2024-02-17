package com.talktherapy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="counsellors")
public class Counsellor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="fullname")
	private String fullname;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;

	@Column(name="mobile")
	private long mobile;
	
	@Column(name="specialization")
	private String specialization;
	
	@Column(name="experience")
	private int experience;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Counsellor() {
		super();
	}

	@Override
	public String toString() {
		return "Counsellor [id=" + id + ", fullname=" + fullname + ", password=" + password + ", email=" + email
				+ ", mobile=" + mobile + ", specialization=" + specialization + ", experience=" + experience + "]";
	}

	
	
	
}
