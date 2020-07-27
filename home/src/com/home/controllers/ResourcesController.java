package com.home.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourcesController {

	@ResponseBody
	@RequestMapping(name = "/water", 
					method = RequestMethod.GET, 
					value = "/water")
	public String getWaterSuppluDetails() {
		return "WATER IS LIFE";
	}
}
