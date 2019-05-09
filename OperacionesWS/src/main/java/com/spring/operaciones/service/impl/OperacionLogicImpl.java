package com.spring.operaciones.service.impl;

import org.springframework.stereotype.Repository;

import com.spring.bean.OperaManda;
import com.spring.operaciones.service.OperacionLogic;

@Repository
public class OperacionLogicImpl implements OperacionLogic{

	public OperaManda calcular(double numA, double numB) {
		// TODO Auto-generated method stub
		OperaManda opera = new OperaManda();
		opera.setSuma(numA + numB);
		opera.setResta(numA - numB);
		opera.setMultiplicacion(numA * numB);
		opera.setDivision(numA / numB);
		
		return opera;
	}

}
