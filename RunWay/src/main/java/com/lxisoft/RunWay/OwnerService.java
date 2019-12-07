package com.lxisoft.RunWay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
@Autowired
OwnerRepository repo;
public Owner saveOwner(Owner owner)
{
	return repo.save(owner);
}
public Owner getOwnerById(Long id) {
    java.util.Optional<Owner> optionalowner = repo.findById(id);
    return optionalowner.get();
}	

}
