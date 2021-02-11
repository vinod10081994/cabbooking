package com.cabbooking.cabbooking.services;

import com.cabbooking.cabbooking.strategy.CabMatchingStrategy;
import com.cabbooking.cabbooking.strategy.PricingStrategy;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cabbooking.cabbooking.Exception.CabAlreadyExistedException;
import com.cabbooking.cabbooking.Exception.CabNotFoundException;
import com.cabbooking.cabbooking.datamodel.Cab;
import com.cabbooking.cabbooking.datamodel.Location;
public class CabService {
	
	private Map<String,Cab> cabsMap=new HashMap<>();
	
	
	
	
	
	public void createCab(@NonNull final Cab cab) {
		String id=cab.getId();
		if(cabsMap.containsKey(id)) {
			 throw new CabAlreadyExistedException();
		} 
		cabsMap.put(cab.getId(),cab);
			 
	}
	
	public Cab getCab(@NonNull final String cabId) {
		if(!cabsMap.containsKey(cabId)) {
			
			throw new CabNotFoundException();
		}
		
		return cabsMap.get(cabId);
	}
    public void updateCabLocation(@NonNull final String cabId,@NonNull final Location location) {
    	Cab cab=getCab(cabId);
    	cabsMap.get(cabId).setCurrentLocation(location);
    }
    
    public void updateCabAvailability(@NonNull final String cabId,boolean isAvailable) {
    	Cab cab=getCab(cabId);
    	cabsMap.get(cabId).setAvailable(isAvailable);;
    }
    
    public List<Cab> getCabs(@NonNull Location startingLocation,final double allowabledistance){
    	List<Cab> cabs=new ArrayList<>();
    	for(Cab cab:cabsMap.values()) {
    		if(cab.isAvailable() && cab.getCurrentLocation().distance(startingLocation)<=allowabledistance) {
    			cabs.add(cab);
    		}
    	}
    	
    	return cabs;
    }
}
