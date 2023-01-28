package com.garagePlus.exception;

import java.time.LocalDate;

import lombok.Data;
@Data
public class MyErrorDetails {
	
	private String name;
	private LocalDate timeStamp;
	private String desc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	

}
