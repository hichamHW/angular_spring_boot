package com.example.demo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api")
public class ControllerProducts {

	@Autowired
	ProductsInterfaceJPARE PIR;
	
	@RequestMapping("ALL")

	@ResponseBody
	public Collection<product> ALL(){
		
		return  PIR.findAll();
	}
	
	@RequestMapping("delete/{id}")
	 
	public void DeleteById(@PathVariable("id") int id) {
		
		  System.out.println(id );
		PIR.deleteById(id);
		
	}
	
	
	@RequestMapping("edit/{id}")
	 
	public void EditById(@PathVariable("id") int id, @RequestBody product p) {
		
		  
		PIR.deleteById(id);
		PIR.save(p);
		 
		
		
	
		
	}
	
	@RequestMapping("add")
	 @ResponseBody

	public String addProduct( @RequestBody product p) {
		  System.out.println("HELLO   "+p.getName() +" cat   "+p.getCategory() );
		PIR.save(p);
		
		return "OK";
	}
	
}
