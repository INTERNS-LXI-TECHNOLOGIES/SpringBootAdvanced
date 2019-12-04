package com.lxisoft.RunWay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {
@Autowired
OwnerService service;
@PostMapping("/owner")
public Owner saveOwner(Owner owner) {
	return service.saveOwner(owner);
}

}
