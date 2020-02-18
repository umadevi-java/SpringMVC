package com.in28minutes.todo;

import java.util.Date;

import javax.validation.constraints.Size;

public class Todo {
	private int id;
	private String user;
	
	@Size(min=6,message="Enter atleast 6 characters")
	private String desc;
	
	private Date targ_date;
	private boolean isDone;
	
	public Todo() {
		super();
	}
	
	public Todo(int id, String user, String desc, Date targ_date, boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targ_date = targ_date;
		this.isDone = isDone;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getTarg_date() {
		return targ_date;
	}
	public void setTarg_date(Date targ_date) {
		this.targ_date = targ_date;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	@Override
	public String toString() {
		return String.format("Todo [id=%s, user=%s, desc=%s, targ_date=%s,"
				+ " isDone=%s]", id, user, desc, targ_date,isDone);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	

}
