package com.jk.dept.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dept implements Serializable {

	private static final long serialVersionUID = -4548983602856253083L;
	private Integer dept_id;
	
	private String  dept_name;
}
