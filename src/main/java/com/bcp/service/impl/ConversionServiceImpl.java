package com.bcp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.model.Conversion;

import com.bcp.repo.IConversionRepo;
import com.bcp.repo.IGenericRepo;

import com.bcp.service.IConversionService;


@Service
public class ConversionServiceImpl extends CRUDImpl<Conversion, Integer> implements IConversionService {

	@Autowired
	private IConversionRepo repo;
	
	
	@Override
	protected IGenericRepo<Conversion, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}


	

}
