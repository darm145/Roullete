package com.test.roullete.Persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.test.roullete.Entities.Bet;
import com.test.roullete.Entities.Roullete;
import com.test.roullete.Entities.RoulleteResponse;
import com.test.roullete.Entities.RoulleteStatus;

@Repository
public class RoulleteRepository {
	public static final String ROULLETE_KEY = "ROULLETE";
	private HashOperations hashOperations;
	private RedisTemplate redisTemplate;
	 public RoulleteRepository(RedisTemplate redisTemplate){
	        this.redisTemplate = redisTemplate;
	        this.hashOperations = this.redisTemplate.opsForHash();
	    }
	
	public List<Roullete> getRoulletes(){
		return hashOperations.values(ROULLETE_KEY);
	}
	public Roullete getRoulleteById(String roulleteId) {
		return (Roullete) hashOperations.get(ROULLETE_KEY, roulleteId);
	}
	public String createRoullete(Roullete roullete) {
		hashOperations.put(ROULLETE_KEY, roullete.getId(), roullete);
		return roullete.getId();
	}
	public RoulleteResponse openRoullete(String id) {
		try {
			Roullete temporal = (Roullete) hashOperations.get(ROULLETE_KEY, id);
			temporal.setStatus(RoulleteStatus.OPEN);
			hashOperations.put(ROULLETE_KEY, id, temporal);
			return RoulleteResponse.ACEPTED;
		} catch (Exception e) {
			return RoulleteResponse.DENIED;
		}
		
		
	}
	public List<Bet> closeRoullete(String roulleteId){
		Roullete temporal = (Roullete) hashOperations.get(ROULLETE_KEY, roulleteId);
		temporal.setStatus(RoulleteStatus.CLOSED);
		hashOperations.put(ROULLETE_KEY, roulleteId, temporal);
		return temporal.getBets();
		
		
	}
	public RoulleteResponse betOnRoullete(String roulleteId,Bet bet) {
		try {
			Roullete temporal = (Roullete) hashOperations.get(ROULLETE_KEY, roulleteId);
			ArrayList<Bet> temporalbets= temporal.getBets();
			temporalbets.add(bet);
			temporal.setBets(temporalbets);
			hashOperations.put(ROULLETE_KEY, roulleteId, temporal);
			return RoulleteResponse.ACEPTED;
		} catch (Exception e) {
			return RoulleteResponse.DENIED;
		}
		
	}

}
