package com.health.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.Testimonial;

import com.health.repository.traineeProfileDao;

import com.health.service.traineeInformationServic;



@Service
public class traineeInfoServiceImpl implements  traineeInformationServic {
	
	
		@Autowired
		public  traineeProfileDao traineeProfileDao;
		
		   
	


		@Override
		@Transactional
		public Boolean updateTrainingInfo(String name, String age, String mobilenumber, String address, String org,String exp, String pre, String post, String aadhar, int id) {
				
			int status=	traineeProfileDao.updateTrainingInfo(name,age,mobilenumber,address,org,exp,pre,post,aadhar,id);
			
			System.err.println(status);
			
			if(status>0) {
				return true;
			}else {
				return false;
			}

			
		}






	
	

}
