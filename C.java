package com.example.codeengine.expense.controller;

import java.io.Serializable;

public class C implements Serializable {
	
	private Long id;
	private String name;
	public C(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public C() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "C [id=" + id + ", name=" + name + "]";
	}
	

}
