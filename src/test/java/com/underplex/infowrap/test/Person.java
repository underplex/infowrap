package com.underplex.infowrap.test;

import com.underplex.infowrap.InfoSource;
import com.underplex.infowrap.MyInfoSource;

public class Person implements InfoSource<PersonInfo>, MyInfoSource<MyPersonInfo>{

	private int age;
	private String lastName;
	private Person friend;
	private Person secretAdmirer;
	
	private PersonInfo info;
	private MyPersonInfo myInfo;
	
	/**
	 * @param age
	 * @param lastName
	 */
	public Person() {
	
		this.info = new PersonInfo(this);
		this.myInfo = new MyPersonInfo(this);
	}
	
	public MyPersonInfo myInfo() {
		return myInfo;
	}
	public PersonInfo info() {
		return info;
	}	
		
	public int getAge() {
		return age;
	}
	
	public String getLastName() {
		return lastName;
	}

	public Person getFriend() {
		return friend;
	}

	public Person getSecretAdmirer() {
		return secretAdmirer;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setFriend(Person friend) {
		this.friend = friend;
	}

	public void setSecretAdmirer(Person secretAdmirer) {
		this.secretAdmirer = secretAdmirer;
	}
	
}
