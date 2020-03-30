package com.lxisoft.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.JDBCType;
import com.lxisoft.Model.*;
@Repository
public class ExamDao {

	private JdbcTemplate jdbcTemplate;  
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public int insertIntoDatabase(ExamModel model){  
	    String query="insert into MockExam values('"+model.getQuestion()+"','"+model.getOpt1()+"','"+model.getOpt2()+"','"+model.getOpt3()+"','"+model.getOpt4()+"','"+model.getAnswer()+"')";  
	    return jdbcTemplate.update(query);  
	}  
}
