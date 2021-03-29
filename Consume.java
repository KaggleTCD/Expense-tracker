package com.example.codeengine.expense.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.codeengine.expense.model.Category;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/consume")
public class Consume {
	
	@RequestMapping(value = "/test",method=RequestMethod.GET)
	@ResponseBody
	ResponseEntity<String> test(){
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> exchange = rt.exchange("http://localhost:8080/api/categories",HttpMethod.GET,new HttpEntity<Object>(new HttpHeaders()), String.class);
		//Collection<Category> c = rt.getForObject("http://localhost:8080/api/categories", Collection.class);
		//System.out.println(c);
		System.out.println(exchange.getBody());
		String body = exchange.getBody();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			List<C> c =(List) objectMapper.readValue(body, C.class);
			//System.out.println(c.getName());
			//System.out.println(c.getId());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exchange;
	}
	

}
