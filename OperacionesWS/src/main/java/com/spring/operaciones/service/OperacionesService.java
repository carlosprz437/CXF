package com.spring.operaciones.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.spring.bean.OperaManda;




@WebService
public interface OperacionesService {
	
	@WebMethod
	public OperaManda Procesar(@WebParam (name = "NumeroA") double numA, @WebParam (name = "NumeroB")double numB);

}
