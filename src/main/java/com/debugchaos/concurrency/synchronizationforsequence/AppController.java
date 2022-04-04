package com.debugchaos.concurrency.synchronizationforsequence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app")
public class AppController {

	@Autowired
	AppService appService;

	@PostMapping("generate")
	public Long generateApplicationNo(){

		return appService.generateAppNo();
	}



}
