package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;

import com.Class.Actor;

@Component
public class ActorDao {
	
	@Autowired
	JdbcTemplate template;
	
	public int insertA(Actor act)
	{
		return template.update("insert into actor(ACTOR_ID,ACTOR_NAME,ACTOR_EMAIL,ACTOR_SALARY,ACTOR_MOVIE) values(?,?,?,?,?)", 
				new Object[] {
						act.getActor_Id(),
						act.getActor_Name(),
						act.getActor_Email(),
						act.getActor_Salary(),
						act.getActor_Movie()
				}
				);
	}
	
	public int updateA(String email,double salary,int id)
	{
		return template.update("update actor set actor_email = ?, actor_salary = ?, where actor_id = ?", email,salary,id);
	}
	
	public int deleteA(int id)
	{
		return template.update("delete from actor where actor_id = ?", id);
	}
	
	public Actor getById(int id)
	{
		return template.queryForObject("select * from actor where actor_id = ?", new BeanPropertyRowMapper<>(Actor.class), id);
	}
	
	public List<Actor> getAllActor()
	{
		return template.query("select * from actor", new BeanPropertyRowMapper<>(Actor.class)); 
	}

}
