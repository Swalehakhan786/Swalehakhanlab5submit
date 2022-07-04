package com.greatlearning.springJDBC.main;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import java.util.List;
import com.greatlearning.springJDBC.entity.Student;

public class Main {
    static JdbcTemplate jdbcTemplateOBJ;
    //configure the database

    static SimpleDriverDataSource dataSourceOBJ;
    
    //configure the database
    static String USERNAME = "root";
    static String PASSWORD ="Swalehakhan@7890";
    static String URL ="jdbc:mysql://localhost:3306/springjdbc";

    public static SimpleDriverDataSource getDatabaseConnection() {
    	dataSourceOBJ = new SimpleDriverDataSource();
    	try {
    		dataSourceOBJ.setDriver(new com.mysql.cj.jdbc.Driver());
    		dataSourceOBJ.setUrl(URL);
    		dataSourceOBJ.setUsername(USERNAME);
    		dataSourceOBJ.setPassword(PASSWORD);
    	}catch(SQLException sqlException) {
    		sqlException.printStackTrace();
    	}
    	return dataSourceOBJ;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jdbcTemplateOBJ = new JdbcTemplate(getDatabaseConnection());

		if(null!=jdbcTemplateOBJ) {
			//4. SQL INSERT Query
			String sqlInsertQuery = "Insert INTO Student(name,department.country) VALUES (?,?,?,?)";
			for(int counter = 1;counter<5;counter++) {
				jdbcTemplateOBJ.update(sqlInsertQuery,"Student"+counter,"Student"+counter+"B.tech","Canada");
			}
			//5.SQL Update Query
			String sqlUpdateQuery = "UPDATE Student set department = ? where name = ?";
			jdbcTemplateOBJ.update(sqlUpdateQuery,"B.Com","Student2");
			//6 SQL Read
			String sqlSelectQuery = "SELECT name,department,country FROM Student";
			List listStudent =jdbcTemplateOBJ.query(sqlSelectQuery,new RowMapper() {
				public Student mapRow(ResultSet result,int rowNum) throws SQLException{
					Student studentObj = new Student();
					studentObj.setName(result.getString("name"));
					studentObj.setDepartment(result.getString("department"));
					studentObj.setCountry(result.getString("country"));
					return studentObj;
					
				}
			});
			System.out.println(listStudent);
			//SQL Delete
			String sqlDeleteQuery = "DELETE from Student where name = ?";
			jdbcTemplateOBJ.update(sqlDeleteQuery,"Student1");
		}	
		else {
			System.out.println("Please check connection");
		}
		}	
		
	}		
