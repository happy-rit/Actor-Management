package com.Class;

public class Actor {

	private int actor_Id;
	private String actor_Name;
	private String actor_Email;
	private double actor_Salary;
	private String actor_Movie;
	
	public Actor() {}

	public int getActor_Id() {
		return actor_Id;
	}

	public void setActor_Id(int actor_Id) {
		this.actor_Id = actor_Id;
	}

	public String getActor_Name() {
		return actor_Name;
	}

	public void setActor_Name(String actor_Name) {
		this.actor_Name = actor_Name;
	}

	public String getActor_Email() {
		return actor_Email;
	}

	public void setActor_Email(String actor_Email) {
		this.actor_Email = actor_Email;
	}

	public double getActor_Salary() {
		return actor_Salary;
	}

	public void setActor_Salary(double actor_Salary) {
		this.actor_Salary = actor_Salary;
	}

	public String getActor_Movie() {
		return actor_Movie;
	}

	public void setActor_Movie(String actor_Movie) {
		this.actor_Movie = actor_Movie;
	}

	@Override
	public String toString() {
		return "Actor [actor_Id=" + actor_Id + ", actor_Name=" + actor_Name + ", actor_Email=" + actor_Email
				+ ", actor_Salary=" + actor_Salary + ", actor_Movie=" + actor_Movie + "]";
	}
	
}
