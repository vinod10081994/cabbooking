package com.cabbooking.cabbooking.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cabbooking.cabbooking.Exception.CabNotFoundException;
import com.cabbooking.cabbooking.Exception.RiderAlreadyExistedException;
import com.cabbooking.cabbooking.Exception.RiderNotFoundException;
import com.cabbooking.cabbooking.datamodel.Rider;
import com.cabbooking.cabbooking.datamodel.Trip;
import lombok.NonNull;
public class RiderService {
	
	Map<String,Rider> riderMap=new HashMap<>();
	
	
	public void createRider(@NonNull final Rider newRider) {
	    if(riderMap.containsKey(newRider.getId())) {
	    	
	    	throw new RiderAlreadyExistedException();
	    }
	    	 
	    riderMap.put(newRider.getId(),newRider);
		
	}
	
	public Rider getRider(@NonNull final String riderId){
	    if(!riderMap.containsKey(riderId)) {
	    	
	    	throw new RiderNotFoundException();
	    }
	    	return riderMap.get(riderId);
	}

}
