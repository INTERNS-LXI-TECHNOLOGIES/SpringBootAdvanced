package com.lxisoft.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.lxisoft.Model.*;
@Repository
public class MockExamDao {

	private JdbcTemplate jdbcTemplate;  
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public int insertIntoDatabase(Model model){  
	    String query="insert into MockExam values('"+model.getQuestion()+"','"+model.getAnswer()+"','"+model.getOption1()+"','"+model.getOption2()+"','"+model.getOption3()+"','"+model.getOption4()+"')";  
	    return jdbcTemplate.update(query);  
	}  
}
