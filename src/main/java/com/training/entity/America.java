package com.training.entity;

public class America {

	private String capital;
	private String language;
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "America [capital=" + capital + ", language=" + language + "]";
	}
	
}
