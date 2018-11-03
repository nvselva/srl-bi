package com.srl.srlbi.service;

import java.io.FileReader;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opencsv.bean.CsvToBeanBuilder;

public class SRLService <T> {

	public String importData(String path, JpaRepository<T, Long> dao, Class<T> c) {
		
		String status = "";
		try {
		    List<T> beans = new CsvToBeanBuilder<T>(new FileReader(path+c.getField("FILENAME").get(null))).withType(c).build().parse();
		    
		    if (beans != null) {
		    	dao.deleteAll();
		    	beans = dao.saveAll(beans); 
			    status = c.getSimpleName() + " saved "+ beans.size() + " row(s)\n";
			}
		    
		} catch (Exception e) {
			e.printStackTrace();
			status =  c.getSimpleName() + " ERR:"+e.getMessage() + "\n";
		}
		return status;
	}

}
