package com.test.roullete.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.roullete.Entities.Bet;
import com.test.roullete.Entities.Roullete;
import com.test.roullete.Entities.RoulleteResponse;
import com.test.roullete.Services.RoulleteServices;

@RestController
@CrossOrigin
@RequestMapping("/roullete")
public class RoulleteController {
	@Autowired
	private RoulleteServices roulleteServices;
	
	@GetMapping
	public List getRoulletes() {
		return roulleteServices.getRoulletes();
	}
	
	@GetMapping("/{id}")
	public Roullete getRoulleteById(@PathVariable String id) {
		return roulleteServices.getRoulleteById(id);
	}
	
	@PostMapping
	public String createRoullete(@RequestBody Roullete roullete) {
		return roulleteServices.createRoullete(roullete);
	}
	
	@PutMapping("/{id}/open")
	public RoulleteResponse openRoullete(@PathVariable String id) {
		return roulleteServices.openRoullete(id);
	}
	
	@PutMapping("/{id}/close")
	List<Bet> closeRoullete(@PathVariable String id){
		return roulleteServices.closeRoullete(id);
	}
	@PutMapping("/{id}/bet")
	RoulleteResponse betOnRoullete(@PathVariable String id,@RequestBody Bet bet) {
		return roulleteServices.betOnRoullete(id, bet);
	}
	

}
