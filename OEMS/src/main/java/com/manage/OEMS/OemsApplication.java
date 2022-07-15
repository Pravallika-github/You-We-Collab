package com.manage.OEMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.manage.OEMS.dao.TablesDao;

@SpringBootApplication
public class OemsApplication implements CommandLineRunner {

	@Autowired
	TablesDao tablesDao;

	public static void main(String[] args) {
		SpringApplication.run(OemsApplication.class, args);
	}

	 //Creating All tables in database
	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.tablesDao.createAllTables());
	}

}
