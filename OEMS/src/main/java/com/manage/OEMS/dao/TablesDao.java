package com.manage.OEMS.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class TablesDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String createAllTables() {
		String query1 = "CREATE TABLE IF NOT EXISTS member("
				+ "member_id INT  NOT NULL  AUTO_INCREMENT,"
				+ "role  VARCHAR(50)  NOT NULL,"
				+ "first_name VARCHAR(50) NOT NULL,"
				+ "last_name VARCHAR(50) NOT NULL,"
				+ "email VARCHAR(50) NOT NULL UNIQUE,"
				+ "phone_number VARCHAR(50) NOT NULL UNIQUE,"
				+ "password VARCHAR(50) NOT NULL,"
				+ "PRIMARY KEY (member_id))";

				      
		
		 String query2 ="CREATE TABLE IF NOT EXISTS venue("
				+ "venue_id INT NOT NULL AUTO_INCREMENT,"
				+ "venue_name VARCHAR(50)  NOT NULL,"
				+ "venue_place VARCHAR(50) NOT NULL,"
				+ "venue_contact VARCHAR(50) NOT NULL,"
				+ "member_id INT NOT NULL ,"
				+ "PRIMARY KEY (venue_id),"
				+ "FOREIGN KEY (member_id) REFERENCES member(member_id));";
		 
		        
				
		 String query3 ="CREATE TABLE IF NOT EXISTS event("
                + "event_id  INT  NOT NULL  AUTO_INCREMENT,"
                + "event_name  VARCHAR(50)  NOT NULL,"
                + "event_cost INT NOT NULL,"
                + "venue_id INT NOT NULL,"
                + "PRIMARY KEY (event_id),"
                + "FOREIGN KEY (venue_id) REFERENCES venue(venue_id));";
                
                
                String query4 ="CREATE TABLE IF NOT EXISTS food_item("
                 + "food_item_id  INT  NOT NULL  AUTO_INCREMENT,"
                 + "food_item_name  TEXT  NOT NULL,"
                 + "food_item_cost INT NOT NULL,"
                 + "venue_id INT NOT NULL,"
                 + "PRIMARY KEY (food_item_id),"
                 + "FOREIGN KEY (venue_id) REFERENCES venue(venue_id));";
				
                 
                 String query5 ="CREATE TABLE IF NOT EXISTS equipment("
                 + "equipment_id  INT  NOT NULL  AUTO_INCREMENT,"
                 + "equipment_name  TEXT  NOT NULL,"
                 + "equipment_cost INT NOT NULL,"
                 + "venue_id INT NOT NULL,"
                 + "PRIMARY KEY (equipment_id),"
                 + "FOREIGN KEY (venue_id) REFERENCES venue(venue_id));";
                 
                 
                 String query6 ="CREATE TABLE IF NOT EXISTS notification("
                 + "notification_id  INT  NOT NULL  AUTO_INCREMENT,"
                 + "time VARCHAR(50) NOT NULL,"
                 + "date VARCHAR(50) NOT NULL,"
                 + "message VARCHAR(255) NOT NULL,"
                 + "member_id  INT  NOT NULL,"
                 + "PRIMARY KEY (notification_id),"
                 + "FOREIGN KEY (member_id) REFERENCES member(member_id));";
                 
             
                 String query7 ="CREATE TABLE IF NOT EXISTS booking("
                 + "booking_id  INT  NOT NULL  AUTO_INCREMENT,"
                 + "date DATE NOT NULL,"
                 + "guest_count INT NOT NULL,"
                 + "event_name VARCHAR(50) NOT NULL,"
                 + "equipment_name VARCHAR(50) NOT NULL,"
                 + "food_item_name VARCHAR(50) NOT NULL,"
                 + "event_cost INT NOT NULL,"
                 + "equipment_cost INT NOT NULL,"
                 + "food_item_cost INT NOT NULL,"
                 + "total_cost INT NOT NULL,"
                 + "payment_status VARCHAR(50) NOT NULL,"
                 + "member_id INT NOT NULL,"
                 + "venue_id INT NOT NULL,"
                 + "del_status INT ,"
                 + "PRIMARY KEY (booking_id),"
                 + "FOREIGN KEY (member_id) REFERENCES member(member_id),"
                 + "FOREIGN KEY (venue_id) REFERENCES venue(venue_id))";
                 
               

                this.jdbcTemplate.update(query1); 
                this.jdbcTemplate.update(query2); 
                this.jdbcTemplate.update(query3); 
                this.jdbcTemplate.update(query4); 
                this.jdbcTemplate.update(query5); 
                this.jdbcTemplate.update(query6); 
                this.jdbcTemplate.update(query7);

                return "Tables Created...";
	}

}
