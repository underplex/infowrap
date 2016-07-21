package com.underplex.infowrap.test;

public class PersonInfo {

	private Person source;

	/**
	 * @param source
	 */
	public PersonInfo(Person source) {
		this.source = source;
	}

	public int getAge() {
		return source.getAge();
	}

	public String getLastName() {
		return source.getLastName();
	}
	
}
