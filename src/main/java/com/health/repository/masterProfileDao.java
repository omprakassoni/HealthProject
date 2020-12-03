package com.health.repository;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.repository.CrudRepository;

import com.health.model.profileInformation;


public interface masterProfileDao extends CrudRepository<profileInformation,Integer>
{


}