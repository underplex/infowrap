package com.underplex.infowrap.test;

public class MyPersonInfo {

	private Person source;

	/**
	 * @param source
	 */
	public MyPersonInfo(Person source) {
		this.source = source;
	}

	public int getAge() {
		return source.getAge();
	}

	public String getLastName() {
		return source.getLastName();
	}

	public PersonInfo getFriend() {
		return source.getFriend().info();
	}

}
