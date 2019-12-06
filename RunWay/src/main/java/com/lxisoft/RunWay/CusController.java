package com.lxisoft.RunWay;

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CusController { 
	@Autowired
	VehicleController vehControl;	
	@RequestMapping("/CustomerHome")
	public String getVehicle(Model model ) {
			  
        
	    List<Vehicle> vehicleList = vehControl.readVehicleDetails();
	     
	 model.addAttribute("vehicleList", vehicleList);
	  
	 return "CustomerHome" ;
	}
	
}
