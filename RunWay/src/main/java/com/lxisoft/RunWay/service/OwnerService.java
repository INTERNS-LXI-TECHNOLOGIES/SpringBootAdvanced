package com.lxisoft.RunWay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.RunWay.model.Owner;
import com.lxisoft.RunWay.repository.OwnerRepository;

@Service
public class OwnerService {
@Autowired
OwnerRepository repo;
public Owner saveOwner(Owner owner)
{
	return repo.save(owner);
}
	

}
