package com.lxisoft.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class Contact {
@RequestMapping(value="/ViewAll")
public String ViewAll()
{
	return "ViewAll";
}

}