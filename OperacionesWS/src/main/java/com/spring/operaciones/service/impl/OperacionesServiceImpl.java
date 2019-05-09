package com.spring.operaciones.service.impl;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.spring.bean.DBUSER;
import com.spring.bean.OperaManda;
import com.spring.operaciones.service.OperacionesService;

@WebService(endpointInterface="com.spring.operaciones.service.OperacionesService")
public class OperacionesServiceImpl implements OperacionesService{
	Logger logger = Logger.getLogger("OperacionesWS");
	
	@Autowired
	OperacionLogicImpl ope;
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
    
	public OperaManda Procesar(double numA, double numB) {
		OperaManda Result = new OperaManda();
		logger.debug("Numeros de llegada: "+numA+" "+numB);
		ResultSet res = null;
		String sql = "select * from dbuser";
		List<DBUSER> usuario = new ArrayList<DBUSER>();
		try{
			List<Map> rows = jdbcTemplate.queryForList(sql);
			
			
			for (Map row : rows) {
				DBUSER customer = new DBUSER();
				customer.setUSER_ID((BigDecimal)(row.get("USER_ID")));
				customer.setUSERNAME((String)row.get("USERNAME"));
				customer.setCREATED_BY((String)row.get("CREATED_BY"));
				customer.setCREATED_DATE((Date)row.get("CREATED_DATE"));
				usuario.add(customer);
			}
			for(DBUSER resul : usuario){
				System.out.println("id: "+resul.getUSER_ID());
				System.out.println("USERNAME: "+resul.getUSERNAME());
				System.out.println("CREATED_BY: "+resul.getCREATED_BY());
				System.out.println("CREATED_DATE: "+resul.getCREATED_DATE());
			}
			Result = this.ope.calcular(numA, numB);
			logger.debug("Resultado: "+Result.getSuma()+" "+Result.getResta()+" "+Result.getMultiplicacion()+" "+Result.getDivision());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return Result;
	}
	
	class FirstColumnStringExtractor implements ResultSetExtractor {
		  public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		    if (resultSet.next()) {
		      return resultSet.getString(1);
		    }
		    return null;
		  }
		}

}
