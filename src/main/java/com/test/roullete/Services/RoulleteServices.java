package com.test.roullete.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.roullete.Entities.Bet;
import com.test.roullete.Entities.Roullete;
import com.test.roullete.Entities.RoulleteResponse;


@Service
public interface RoulleteServices {
	List<Roullete> getRoulletes();
	Roullete getRoulleteById(String roulleteId);
	String createRoullete(Roullete roullete);
	RoulleteResponse openRoullete(String id);
	List<Bet> closeRoullete(String roulleteId);
	RoulleteResponse betOnRoullete(String Roulleteid,Bet bet);
	
}
