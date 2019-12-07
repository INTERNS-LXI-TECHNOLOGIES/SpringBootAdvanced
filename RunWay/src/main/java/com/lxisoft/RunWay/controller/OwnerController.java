package com.lxisoft.RunWay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.RunWay.model.Owner;
import com.lxisoft.RunWay.service.OwnerService;

@RestController
public class OwnerController {
@Autowired
OwnerService service;
@PostMapping("/owner")
public Owner saveOwner(@RequestBody Owner owner) {
	return service.saveOwner(owner);
}
@GetMapping("/owner/{id}")
public Owner getOwnerById(@PathVariable Long id) {

  return service.getOwnerById(id);

}
}
