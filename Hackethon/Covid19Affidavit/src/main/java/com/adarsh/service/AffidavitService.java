package com.adarsh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adarsh.dao.AffidavitDao;
import com.adarsh.service.*;
import com.adarsh.entity.*;

@Service
public class AffidavitService {
	
	@Autowired
	 private AffidavitDao affidavitDao;
	
	@Transactional
	public  void saveAffidavit(AffidavitEntity entity)
	{
		affidavitDao.save(entity);
	}
	
	@Transactional
    public List < AffidavitEntity > getAllAffidavit() {
        return affidavitDao.findAll();
    }

	public Optional<AffidavitEntity> getAffidavitId(int affidavitId) {
		
		return affidavitDao.findById(affidavitId);
	}

}
