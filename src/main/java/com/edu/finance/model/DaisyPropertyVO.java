package com.edu.finance.model;

import java.io.Serializable;

public class DaisyPropertyVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

    private String sName;

    private String sValue;
    
    private String sDescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsValue() {
		return sValue;
	}

	public void setsValue(String sValue) {
		this.sValue = sValue;
	}

	public String getsDescription() {
		return sDescription;
	}

	public void setsDescription(String sDescription) {
		this.sDescription = sDescription;
	}
    
    
}
