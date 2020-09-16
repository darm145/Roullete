package com.test.roullete.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.roullete.Entities.Bet;
import com.test.roullete.Entities.Roullete;
import com.test.roullete.Entities.RoulleteResponse;
import com.test.roullete.Persistence.RoulleteRepository;

@Component
public class RoulleteServicesImpl implements RoulleteServices{
	
	@Autowired
	private RoulleteRepository RoulleteRepository;

	@Override
	public List<Roullete> getRoulletes() {
		return RoulleteRepository.getRoulletes();
	}

	@Override
	public Roullete getRoulleteById(String roulleteId) {
		return RoulleteRepository.getRoulleteById(roulleteId);
	}

	@Override
	public String createRoullete(Roullete roullete) {
		return RoulleteRepository.createRoullete(roullete);
	}

	@Override
	public RoulleteResponse openRoullete(String id) {
		return RoulleteRepository.openRoullete(id);
	}

	@Override
	public List<Bet> closeRoullete(String roulleteId) {
		return RoulleteRepository.closeRoullete(roulleteId);
	}

	@Override
	public RoulleteResponse betOnRoullete(String Roulleteid,Bet bet) {
		return RoulleteRepository.betOnRoullete(Roulleteid, bet);
	}

}
